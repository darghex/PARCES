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
 * Activity para gestionar la propuesta de matricula
 */
public class DetallePropuestaActivity extends ActivityBase {
    List<Asignaturas> datos = new ArrayList<Asignaturas>();
    AdaptadorAsignatura adaptador;
    ListView lst_detalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_propuesta);

        // Obtenemos el estudiante a consultar la propuesta
        Bundle bundle = getIntent().getExtras();
        PropuestaTask task = new PropuestaTask(this, bundle.getString("codigo_estudiante") );
        task.execute();


        lst_detalle = (ListView) findViewById(R.id.lst_detalle_propuesta);


    }

    // Adaptador para la lista de asignaturas
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


    private class PropuestaTask extends TaskAsyncBase {
        PropuestaMatricula propuesta = null;
        String estudiante = "";



        public PropuestaTask(Context context, String new_estudiante){
            super(context);
            estudiante = new_estudiante;

        }

        protected Boolean doInBackground(Void... params) {
            try {

                Estudiante e = new Estudiante(estudiante);
                propuesta = e.getPropuestaMatricula();

                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {

            if (result){
                // Cargar las asignaturas de la propuesta de matricula
                for ( Asignaturas asignatura: propuesta.getAsignaturas()){
                    datos.add(asignatura);
                }

                adaptador = new AdaptadorAsignatura(DetallePropuestaActivity.this);
                lst_detalle.setAdapter(adaptador);

            }else{
                Client cliente = null;
                Dialogs.error(cliente.get_message_error(), DetallePropuestaActivity.this);
            }
            super.onPostExecute(result);
        }


    }
}
