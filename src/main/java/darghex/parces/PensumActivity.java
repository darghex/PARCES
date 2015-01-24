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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.Dialogs;
import darghex.parces.model.*;
import darghex.parces.model.Estudiante;

/**
 * Actitivy para visualizar el plan de estudios del estudiante
 */

public class PensumActivity extends ActivityBase {
    List<Asignaturas> datos = new ArrayList<Asignaturas>();
    AdaptadorAsignatura adaptador;
    ListView lst_detalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensum);



        Bundle bundle = getIntent().getExtras();
        PensumTask task = new PensumTask(this, bundle.getString("pensum") );
        task.execute();


        lst_detalle = (ListView) findViewById(R.id.lst_detalle_propuesta);


    }

    // Adaptador para las asignaturas
    class AdaptadorAsignatura extends ArrayAdapter<Asignaturas> {
        Activity context;

        public AdaptadorAsignatura(Activity context) {
            super(context, R.layout.detallepropuesta_listview_layout, datos);
            this.context = context;
        }

        public View getView(int position, View converView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.detallepropuesta_listview_layout, null);

            TextView lblAsignatura = (TextView) item.findViewById(R.id.txtAsignatura);
            lblAsignatura.setText(datos.get(position).getNombre());


            TextView lblCreditos = (TextView) item.findViewById(R.id.txtCreditos);
            lblCreditos.setText( "Créditos: " + String.valueOf(datos.get(position).getCreditos() ));

            TextView lblSemestre = (TextView) item.findViewById(R.id.txtSemestre);
            lblSemestre.setText( "Semestre: " + String.valueOf(datos.get(position).getUbicacion_semestral() ));

            return item;


        }


    }

    // Tarea asincrona para cargar el plan de estudios
    private class PensumTask extends TaskAsyncBase {
        List<Asignaturas> asignaturas = null;
        String pensum = "";

        public PensumTask(Context context, String new_pensum){
            super(context);
            pensum = new_pensum;
        }


        protected Boolean doInBackground(Void... params) {
            try {

                Estudiante e = new Estudiante();
                e.setPlan_estudios(pensum);
                asignaturas = e.getAsignaturas();

                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {

            if (result){

                datos.addAll(asignaturas);


                adaptador = new AdaptadorAsignatura(PensumActivity.this);
                lst_detalle.setAdapter(adaptador);

            }else{
                Client cliente = null;
                Dialogs.error(cliente.get_message_error(), PensumActivity.this);
            }
            super.onPostExecute(result);
        }


    }
}
