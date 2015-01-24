package darghex.parces;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import darghex.parces.helpers.Dialogs;
import darghex.parces.model.Actividad;
import darghex.parces.model.InstanciaCurso;

/**
 * Actitivy que carga los cursos matriculados por un estudiante */

public class ActividadActivity extends ActivityBase  {

    List<Actividad> datos = new ArrayList<Actividad>();
    ListView lst_actividades;
    String estudiante = "";
    int instancia = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);


        Bundle bundle = getIntent().getExtras();
        instancia = bundle.getInt("codigo_instancia");
        estudiante = bundle.getString("estudiante");

        ActividadesTask task =  new  ActividadesTask(this);
        task.execute();

        lst_actividades = (ListView) findViewById(R.id.lst_instancias);
        TextView lblTitle =  (TextView) findViewById(R.id.lblAsignatura);
        lblTitle.setText("Actividades " + bundle.getString("descripcion_instancia"));


    }



    /**
     * Adaptador para la lista de Calificaciones
     */
    class AdaptadorAsignatura extends ArrayAdapter<Actividad> {
        Activity context;

        public AdaptadorAsignatura(Activity context) {
            super(context, R.layout.actividad_listview_layout, datos);
            this.context = context;
        }

        public View getView(int position, View converView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.actividad_listview_layout, null);

            TextView lblActividad = (TextView) item.findViewById(R.id.txtActividad);
            lblActividad.setText(datos.get(position).getDescripcion());


            TextView lblFecha = (TextView) item.findViewById(R.id.txtFecha);
            lblFecha.setVisibility(View.INVISIBLE);

            TextView lblCalificacion = (TextView) item.findViewById(R.id.txtCalificacion);
            if (datos.get(position).getCalificacionParcial()  == null) {
                lblCalificacion.setText("Calificación: sin nota" );
            }else{
                lblCalificacion.setText("Calificación: " + String.valueOf(datos.get(position).getCalificacionParcial().getCalificacion()));
            }

            TextView lblCorte = (TextView) item.findViewById(R.id.txtCorte);
            lblCorte.setVisibility(View.INVISIBLE);

            return item;

        }

    }


    private class ActividadesTask extends TaskAsyncBase {

        public ActividadesTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {
            try {
                datos.addAll(Actividad.getActividades(estudiante, instancia));
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                AdaptadorAsignatura adaptador = new AdaptadorAsignatura(ActividadActivity.this);
                lst_actividades.setAdapter(adaptador);

                pDialog.dismiss();
            }else{

                Dialogs.error("Ha ocurrido un error, intente mas tarde", ActividadActivity.this);
            }
            super.onPostExecute(result);

        }




    }

}
