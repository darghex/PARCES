package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import darghex.parces.clients.Client;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.Dialogs;
import darghex.parces.model.*;
import darghex.parces.model.Estudiante;

/**
 * Activity para realizar el llamado de asistencia a clase
 */

public class AsistenciaActivity extends ActivityBase  {

    List<Estudiante> datos = new ArrayList<Estudiante>();
    ListView lst_Estudiante;
    List<Boolean> asistencia = new ArrayList<Boolean>();

    private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();

    int instancia;
    int curso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);


        Bundle bundle = getIntent().getExtras();
        // recibimos los datos del curso
        curso = bundle.getInt("curso");
        instancia = bundle.getInt("id_instancia");


        EstudiantesTask task =  new  EstudiantesTask(this);
        task.execute();

        lst_Estudiante = (ListView) findViewById(R.id.lst_estudiantes);
        TextView lblTitle =  (TextView) findViewById(R.id.lblInstancia);
        lblTitle.setText( "Asistencia " + bundle.getString("fecha"));
        Button btn_asistencia = ( Button) findViewById(R.id.btn_reg_asistencia);

        btn_asistencia.setText("Registrar asistencia");
        btn_asistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar_asistencia_click();
            }
        });



    }

    /**
     * Evento para registrar la asistencia de los estudiantes seleccionados
     */
    private void registrar_asistencia_click() {
        //recorremos la lista de estudiantes seleccionados
       for (Map.Entry<Integer, Boolean> entry : mSelection.entrySet()){
           asistencia.set(entry.getKey(), entry.getValue());
       }
        EstudiantesTask task = new EstudiantesTask(this);
        task.execute();

    }


    /**
     * Adaptador para la lista estudiantes
     */
    class AdaptadorEstudiante extends ArrayAdapter<Estudiante> {
        Activity context;


        public AdaptadorEstudiante(Activity context) {
            super(context, R.layout.asistencia_listview_layout, datos);
            this.context = context;
        }

        public View getView(final int position, View converView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.asistencia_listview_layout, null);

            CheckBox chkEstudiante = (CheckBox) item.findViewById(R.id.chkEstudiante);
            chkEstudiante.setText(datos.get(position).getApellidos() +  " " + datos.get(position).getNombres() );

            if(  asistencia.get(position)) {
                mSelection.put(position, true );
            }

            chkEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if (isChecked) {
                        mSelection.put(position, true);
                    }
                }
            });




            if (mSelection.get(position) != null) {
                if (mSelection.get(position))
                    chkEstudiante.setChecked(true);
                else
                    chkEstudiante.setChecked(false);
            }

            return item;
        }


    }

    // Tarea asincrona para cargar la lista de estudiantes de un curso
    private class EstudiantesTask extends TaskAsyncBase {

        private boolean save = false;

        public EstudiantesTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {
            try {
                if (datos.size() ==  0 ) {
                    Curso c = new Curso();
                    c.setId(curso);
                    datos.addAll(c.getEstudiante(Client.logged.getId()));
                }
                InstanciaCurso i = new InstanciaCurso();
                i.setId(instancia);

                if(asistencia.size() > 0){
                    i.setAsistencia(datos, asistencia);
                    save = true;
                }

                asistencia = i.getAsistencia(datos);


                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                AdaptadorEstudiante adaptador = new AdaptadorEstudiante(AsistenciaActivity.this);
                lst_Estudiante.setAdapter(adaptador);
                if (save) {
                    Dialogs.information("Asistencia guardada", AsistenciaActivity.this, null);
                }
                pDialog.dismiss();
            }else{

                Dialogs.error("Ha ocurrido un error, intente mas tarde", AsistenciaActivity.this);
            }
            super.onPostExecute(result);

        }

    }

}
