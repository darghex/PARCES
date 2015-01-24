package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.clients.EstudianteClient;
import darghex.parces.clients.TutorClient;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.Dialogs;
import darghex.parces.helpers.MessageManager;
import darghex.parces.model.*;


public class PropuestaMatriculaActivity extends ActivityBase  {

    Switch swaprobado ;
    String codigo_estudiante;
    List<Mensaje> datos;
    ListView lst_mensajes;

    EditText    txt ;
    int propuesta = 0; // Codigo de la propuesta de matricula
    String msg="";
    boolean load = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta_matricula);
        swaprobado =  (Switch) findViewById(R.id.swAprobacion);
        lst_mensajes =  (ListView) findViewById(R.id.lst_conversacion);

        if ( LoginActivity.profile == Perfil.ESTUDIANTE ) {
            swaprobado.setEnabled(false);

        }else{
            swaprobado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (load) {
                        EstadoPropuestaTask task = new EstadoPropuestaTask(getApplicationContext());
                        task.execute();
                    }
                }
            });
        }


        txt = (EditText) findViewById(R.id.txtMensaje);
        Bundle bundle = getIntent().getExtras();
        codigo_estudiante = bundle.getString("codigo_estudiante");

        MensajePropuestaTask task = new MensajePropuestaTask(this);
        task.execute();

    }



    /***
     * Cargamos el detalle de la propuesta de matricula
     * @param view
     */

    public void onDetail(View view) {
        Intent i = new Intent(PropuestaMatriculaActivity.this, DetallePropuestaActivity.class ) ;
        i.putExtra("codigo_estudiante", codigo_estudiante);
        startActivity(i);

    }

    public void onWrite(View view) {
            MensajePropuestaTask task = new MensajePropuestaTask(this);
            if ( txt.getText().toString().equals("")){
                return;
            }
            msg =  txt.getText().toString();
            task.execute( );
            txt.getText().clear();

        }


        private class EstadoPropuestaTask extends TaskAsyncBase {

            boolean estado = false;
            TutorClient c = null;

            public EstadoPropuestaTask(Context context) {
                super(context);
            }


            protected Boolean doInBackground(Void... params) {
                try {

                c = new TutorClient();
                estado = c.set_estado_propuesta( propuesta, swaprobado.isChecked());

                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {

            swaprobado.setChecked( estado);

            if (!result) {

                Dialogs.error(c.get_message_error(), PropuestaMatriculaActivity.this);
            }
            super.onPostExecute(result);

        }



    }



    private class MensajePropuestaTask extends TaskAsyncBase {

        boolean estado = false;
        EstudianteClient c = null;

        public MensajePropuestaTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {
            try {
                darghex.parces.model.Estudiante e = new Estudiante(codigo_estudiante);
                propuesta = e.getPropuestaMatricula().getCodigo();


                MessageManager m = new MessageManager();
                // Enviamos el mensaje
                if (!msg.equals("") ){
                    m.escribir_to_propuesta(msg,Client.logged.getFullName(), propuesta);
                }

                c = new EstudianteClient();
                estado = c.get_estado_propuesta(codigo_estudiante);
                datos = m.leer_to_propuesta(propuesta);

                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {


            swaprobado.setChecked( estado);

            if (result) {
                AdaptadorMensaje adaptador = new AdaptadorMensaje(PropuestaMatriculaActivity.this);

                lst_mensajes.setAdapter(adaptador);
            }

            if ( c.isError() ){
                Dialogs.error(c.get_message_error(), PropuestaMatriculaActivity.this);

            }

           super.onPostExecute(result);
            load = true;
        }



    }



    class AdaptadorMensaje extends ArrayAdapter<Mensaje>
    {
        Activity context;

        public AdaptadorMensaje(Activity context) {
            super(context, R.layout.mensaje_propuesta_listview_layout, datos);
            this.context  = context;
        }

        public View getView(int position, View converView, ViewGroup parent ){

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.mensaje_propuesta_listview_layout, null);

            TextView lblMensaje = (TextView) item.findViewById(R.id.txtMensaje);
            lblMensaje.setText( datos.get(position).getMensaje() );


            TextView lblAutor = (TextView) item.findViewById(R.id.txtAutor);
            lblAutor.setText( datos.get(position).getAutor() );

            TextView lblFecha = (TextView) item.findViewById(R.id.txtFecha);
            lblFecha.setText( datos.get(position).getFecha( ));


            return item;


        }


    }



    }
