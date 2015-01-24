package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.Dialogs;
import darghex.parces.model.*;
import darghex.parces.model.Estudiante;

/**
 * CLase encargada de administrar las asignaturas vistas por un estudiante
 */
public class AsignaturaActivity extends ActivityBase {

    List<InstanciaCurso> datos = new ArrayList<InstanciaCurso>();
    ListView lst_actividades;
    int curso;
    String estudiante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        // recibimos el estudiante y el codigo del curso para su cargue de informacion
        Bundle bundle = getIntent().getExtras();
        estudiante = bundle.getString("id_estudiante");
        curso = bundle.getInt("id_curso");

        //Tareas en segundo plano para cargas las actividades de la asignatura
        ActividadesTask task =  new  ActividadesTask(this);
        task.execute();

        lst_actividades = (ListView) findViewById(R.id.lst_actividades);
        TextView lblTitle =  (TextView) findViewById(R.id.lblAsignatura);
        lblTitle.setText( bundle.getString("curso"));





    }

    /**
     * Adaptador para la lista de Calificaciones
     */
    class AdaptadorAsignatura extends ArrayAdapter<InstanciaCurso> {
        Activity context;

        public AdaptadorAsignatura(Activity context) {
            super(context, R.layout.actividad_listview_layout, datos);
            this.context = context;
        }

        public View getView(int position, View converView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.actividad_listview_layout, null);

            TextView lblActividad = (TextView) item.findViewById(R.id.txtActividad);
            lblActividad.setText(datos.get(position).getTema());


            TextView lblCalificacion = (TextView) item.findViewById(R.id.txtCalificacion);
            short num = 0;
            if ( datos.get(position).getActividades() != null ) {
                num = (short )datos.get(position).getActividades().size();
            }
            lblCalificacion.setText("Actividades: " + String.valueOf(num));


            TextView lblFecha = (TextView) item.findViewById(R.id.txtFecha);
            lblFecha.setText("Fecha: " + String.valueOf(datos.get(position).getFecha()));

            TextView lblCorte = (TextView) item.findViewById(R.id.txtCorte);
            lblCorte.setText( "Corte: " + String.valueOf(datos.get(position).getCorte() ));

            return item;


        }


    }


    private class ActividadesTask extends TaskAsyncBase {

        public ActividadesTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {
            try {
                // Cargar las instancias del curso seleccionado
                datos.addAll(InstanciaCurso.getInstancias_curso(estudiante,curso));
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {

                AdaptadorAsignatura adaptador = new AdaptadorAsignatura(AsignaturaActivity.this);
                lst_actividades.setAdapter(adaptador);
                lst_actividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i = new Intent(AsignaturaActivity.this, ActividadComentariosActivity.class ) ;
                        i.putExtra("codigo_instancia", datos.get( position).getId() );
                        i.putExtra("instancia", datos.get( position).getTema() );
                        i.putExtra("estudiante", estudiante );
                        startActivity(i);

                    }
                });


            }
            super.onPostExecute(result);
            if (datos.isEmpty()) {
                Toast.makeText(getApplicationContext(), "No existen clases registradas por el docente de la asignatura", Toast.LENGTH_SHORT).show();
            }
           

        }


    }

}
