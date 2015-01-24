package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import darghex.parces.clients.Client;
import darghex.parces.clients.EstudianteClient;
import darghex.parces.helpers.ConvertidorCadena;
import darghex.parces.helpers.Dialogs;
import darghex.parces.model.*;
import darghex.parces.model.Estudiante;

/**
 * Activity para mostrar el perfil de un usuario
 */
public class ProfileActivity extends ActivityBase {


    Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        UsuarioTask task =  new  UsuarioTask(this);
        task.execute();
    }


    private class UsuarioTask extends TaskAsyncBase {
        Bitmap image = null;

        public UsuarioTask(Context context) {
            super(context);
        }

        protected Boolean doInBackground(Void... params) {



            try {
                Estudiante e = new Estudiante( ((Estudiante) Client.logged).getCodigo()  );

                usuario = e.getTutor();
                if (usuario == null) return false;
                image = usuario.getImageFoto();
                return true;
            } catch (Exception e) {
                return false;
            }

        }

        @Override
        protected void onPostExecute(Boolean result) {

            if (result) {

                final TextView txtNombre = (TextView) findViewById(R.id.txtNombre);
                txtNombre.setText(ConvertidorCadena.a_mayuscula(usuario.getFullName()));

                final TextView txtTelefono = (TextView) findViewById(R.id.txtTelefono);
                txtTelefono.setText("Teléfono: "+ usuario.getTelefono());

                final TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
                txtEmail.setText("Email: "+ ConvertidorCadena.a_minuscula(usuario.getEmail()));

                if (image != null){
                    final ImageView foto = (ImageView) findViewById(R.id.photo);
                    foto.setImageBitmap( image );
                }

            }else{

                Dialogs.error("Ha ocurrido un error. Intente mas tarde", ProfileActivity.this );
            }

            super.onPostExecute(result);

        }




    }

    /**
     * Metodo para realizar una llamada al contacto
     * @param view
     */
    public void  onCall(View view){
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:" + usuario.getTelefono().trim()));
        startActivity(call);

    }

    /**
     * Metodo para enviar un sms  al contacto
     * @param view
     */
    public void  onSMS(View view){
        Intent sms = new Intent(Intent.ACTION_SENDTO);
        sms.addCategory(Intent.CATEGORY_DEFAULT);
        sms.setType("vnd.android-dir/mms-sms");
        sms.setData(Uri.parse("sms:" + usuario.getTelefono().trim()));
        startActivity(sms);
    }


    /**
     * Metodo para enviar un email  al contacto
     * @param view
     */
    public void  onMail(View view){
        Intent sms = new Intent(Intent.ACTION_SENDTO);
        sms.addCategory(Intent.CATEGORY_DEFAULT);
        sms.setType("vnd.android-dir/mms-sms");
        sms.setData(Uri.parse("mailto:" + usuario.getEmail().trim()));
        startActivity(sms);
    }


}
