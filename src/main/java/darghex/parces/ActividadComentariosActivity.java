package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.clients.EstudianteClient;
import darghex.parces.clients.TutorClient;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.Dialogs;
import darghex.parces.helpers.MessageManager;
import darghex.parces.model.Estudiante;
import darghex.parces.model.Mensaje;


public class ActividadComentariosActivity extends ActivityBase  {

    String estudiante;
    int codigo_instancia;
    String desc_instancia;
    List<Mensaje> datos;
    ListView lst_mensajes;

    String msg="";
    EditText    txt ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_actividades);
        lst_mensajes =  (ListView) findViewById(R.id.lst_conversacion);

        txt = (EditText) findViewById(R.id.txtMensaje);
        Bundle bundle = getIntent().getExtras();
        codigo_instancia = bundle.getInt("codigo_instancia");
        estudiante = bundle.getString("estudiante");

        TextView txtTitle = (TextView) findViewById(R.id.txtTema);
        desc_instancia =  bundle.getString("instancia");
        txtTitle.setText("Comentarios " + desc_instancia);



        MensajeTask task = new MensajeTask(this);
        task.execute();

    }



    /***
     * Cargamos el detalle de la propuesta de matricula
     * @param view
     */

    public void onDetail(View view) {
        Intent i = new Intent( ActividadComentariosActivity.this, ActividadActivity.class);
        i.putExtra("codigo_instancia", codigo_instancia);
        i.putExtra("estudiante", estudiante );
        i.putExtra("descripcion_instancia", desc_instancia );
        startActivity(i);

    }

    public void onWrite(View view) {
            MensajeTask task = new MensajeTask(this);
            if ( txt.getText().toString().equals("")){
                return;
            }
            msg =  txt.getText().toString();
            task.execute( );
            txt.getText().clear();

        }


    private class MensajeTask extends TaskAsyncBase {



        public MensajeTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {
            try {



                MessageManager m = new MessageManager();
                // enviamos el mensaje
                if ( !msg.equals("") ){
                  m.escribir_to_instancia(msg, Client.logged.getFullName(), codigo_instancia);
                }

                datos = m.leer_to_instancia(codigo_instancia);

                return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {

            if (result) {
                AdaptadorMensaje adaptador = new AdaptadorMensaje(ActividadComentariosActivity.this);

                lst_mensajes.setAdapter(adaptador);
            }
            else{
                Dialogs.error("Se ha generado un error. Intente mas tarde", ActividadComentariosActivity.this);

            }

           super.onPostExecute(result);
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
