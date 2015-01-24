package darghex.parces;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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

/**
 * Actitivy que carga los cursos matriculados por un estudiante */

public class ActividadGestionActivity extends ActivityBase  {

    List<Actividad> datos = new ArrayList<Actividad>();
    ListView lst_actividades;
    int instancia = 0;
    int curso;
    String fecha = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_actividad);


        Bundle bundle = getIntent().getExtras();
        instancia = bundle.getInt("id_instancia");
        curso = bundle.getInt("curso");
        fecha = bundle.getString("fecha");

        ActividadesTask task =  new  ActividadesTask(this);
        task.execute();

        lst_actividades = (ListView) findViewById(R.id.lst_actividades);
        TextView lblTitle =  (TextView) findViewById(R.id.lblInstancia);
        lblTitle.setText("Actividades " + bundle.getString("tema"));



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
            View item = inflater.inflate(R.layout.actividades_listview_layout, null);
            TextView lblActividad = (TextView) item.findViewById(R.id.txtActividad);
            lblActividad.setText(datos.get(position).getDescripcion());
            return item;
        }

    }

    public void onAsistencia(View view) {
        Intent i = new Intent( ActividadGestionActivity.this, AsistenciaActivity.class);
        i.putExtra("id_instancia", instancia);
        i.putExtra("fecha", fecha);
        i.putExtra("curso", curso );
        startActivity(i);

    }

    public void onNewActividad(View view) {
        Dialogs.textDialog("Nueva actividad","Ingrese el nombre de la nueva actividad para esta clase", this, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        },null );

        Dialogs.decimalDialog("Nueva actividad","Ingrese la proporcion de calificación respecto al corte", this, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        },null );

    }



    private class ActividadesTask extends TaskAsyncBase {

        public ActividadesTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {
            try {
               datos.addAll(Actividad.getActividades( instancia));
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                AdaptadorAsignatura adaptador = new AdaptadorAsignatura(ActividadGestionActivity.this);
                lst_actividades.setAdapter(adaptador);
                lst_actividades.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(getApplicationContext(), CalificacionActivity.class);
                        i.putExtra("id_actividad", datos.get( position).getId() );
                        i.putExtra("actividad", datos.get( position).getDescripcion() );
                        i.putExtra("curso", curso );
                        startActivity(i);
                    }
                });
                pDialog.dismiss();
            }else{

                Dialogs.error("Ha ocurrido un error, intente mas tarde", ActividadGestionActivity.this);
            }
            super.onPostExecute(result);

        }




    }

}
