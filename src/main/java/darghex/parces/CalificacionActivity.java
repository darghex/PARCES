package darghex.parces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import darghex.parces.clients.Client;
import darghex.parces.helpers.Dialogs;
import darghex.parces.model.Curso;
import darghex.parces.model.Estudiante;
import darghex.parces.model.InstanciaCurso;

/**
 * Activity para realizar el llamado de asistencia a clase
 */

public class CalificacionActivity extends ActivityBase  {

    List<Estudiante> datos = new ArrayList<Estudiante>();
    ListView lst_Estudiante;


    private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();

    int actividad;
    int curso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);


        Bundle bundle = getIntent().getExtras();
        // recibimos los datos del curso
        curso = bundle.getInt("curso");
        actividad = bundle.getInt("id_actividad");


        EstudiantesTask task =  new  EstudiantesTask(this);
        task.execute();

        lst_Estudiante = (ListView) findViewById(R.id.lst_estudiantes);
        TextView lblTitle =  (TextView) findViewById(R.id.lblInstancia);
        lblTitle.setText( "Calificacion " + bundle.getString("actividad"));
        final Button btnguardar = (Button) findViewById(R.id.btn_reg_asistencia) ;
        btnguardar.setText("Guardar calificación");


    }


    /**
     * Adaptador para la lista estudiantes
     */
    class AdaptadorEstudiante extends ArrayAdapter<Estudiante> {
        Activity context;


        public AdaptadorEstudiante(Activity context) {
            super(context, R.layout.calificaciones_listview_layout, datos);
            this.context = context;
        }

        public View getView(final int position, View converView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.calificaciones_listview_layout, null);

            TextView txtEstudiante = (TextView) item.findViewById(R.id.txtEstudiante);
            txtEstudiante.setText(datos.get(position).getApellidos() +  " " + datos.get(position).getNombres() );

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


                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                AdaptadorEstudiante adaptador = new AdaptadorEstudiante(CalificacionActivity.this);
                lst_Estudiante.setAdapter(adaptador);
                if (save) {
                    Dialogs.information("Calificación guardada", CalificacionActivity.this, null);
                }
                pDialog.dismiss();
            }else{

                Dialogs.error("Ha ocurrido un error, intente mas tarde", CalificacionActivity.this);
            }
            super.onPostExecute(result);

        }

    }

}
