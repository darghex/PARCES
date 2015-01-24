package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
 * Actitivy que carga los cursos matriculados por un estudiante */

public class CursoActivity extends ActivityBase  {

    List<InstanciaCurso> datos = new ArrayList<InstanciaCurso>();
    ListView lst_actividades;

    int curso;
    String estudiante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);


        Bundle bundle = getIntent().getExtras();
        curso = bundle.getInt("id_curso");

        ActividadesTask task =  new  ActividadesTask(this);
        task.execute();

        lst_actividades = (ListView) findViewById(R.id.lst_instancias);
        TextView lblTitle =  (TextView) findViewById(R.id.lblAsignatura);
        lblTitle.setText( bundle.getString("curso"));

        lst_actividades.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent( CursoActivity.this, ActividadGestionActivity.class);
                i.putExtra("id_instancia", datos.get(position).getId());
                i.putExtra("tema", datos.get(position).getTema() );
                i.putExtra("fecha", datos.get(position).getFecha() );
                i.putExtra("curso", curso );
                startActivity(i);


            }
        });

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


            TextView lblFecha = (TextView) item.findViewById(R.id.txtFecha);
            lblFecha.setText("Fecha: " + String.valueOf(datos.get(position).getFecha()));

            TextView lblCalificacion = (TextView) item.findViewById(R.id.txtCalificacion);
            lblCalificacion.setText( "Corte: " + String.valueOf(datos.get(position).getCorte() ));

            TextView lblCorte = (TextView) item.findViewById(R.id.txtCorte);
            lblCorte.setText("");


            return item;

        }

    }

    public void onNewInstancia(View view){
        Dialogs.textDialog("Nueva Instancia","Ingrese la temática para esta clase", this, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addCorte();
            }
        },null );


    }

    private void addCorte(){
        Dialogs.numericDialog("Nueva actividad","Ingrese el corte al que pertenece", this, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addFecha();
            }
        },null );
    }

    private void addFecha(){
        Dialogs.dateDialog("Nueva actividad","Ingrese la fecha que programa la clase", this, new DialogInterface.OnClickListener() {
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
                datos.addAll(InstanciaCurso.getInstancias_curso(estudiante,curso));
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                AdaptadorAsignatura adaptador = new AdaptadorAsignatura(CursoActivity.this);
                lst_actividades.setAdapter(adaptador);

                pDialog.dismiss();
            }else{

                Dialogs.error("Ha ocurrido un error, intente mas tarde", CursoActivity.this);
            }
            super.onPostExecute(result);

        }




    }

}
