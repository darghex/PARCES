package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import darghex.parces.clients.Client;
import darghex.parces.clients.TutorClient;
import darghex.parces.clients.ProfesorClient;
import darghex.parces.clients.EstudianteClient;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.Dialogs;
import darghex.parces.model.ProgramaAcademico;


public class LoginActivity extends Activity {

    EditText txtUser ;
    EditText txtPassword ;
    TextView txtProfile ;
    TextView txtPrograma ;

    public static Perfil profile;
    Client cliente ;

    Spinner lst_programas;
    int programa_seleccionado;
    ImageView logo_ies;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
        // Referenciar Controles
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtProfile = (TextView) findViewById(R.id.txtProfile);

        lst_programas = (Spinner) findViewById(R.id.lst_programas);
        txtPrograma= (TextView) findViewById(R.id.txt_programa);
        logo_ies = (ImageView) findViewById(R.id.img_ies);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogin_click();
            }
        });
        // recibimos el rol del cual se hizo el llamado
        Bundle bundle = getIntent().getExtras();
        int perfil =  bundle.getInt("profile");


        cliente = new Client();

        // Dependiendo del tipo de rol seleccionado cargamos los componentes del login
        if ( perfil == Perfil.ESTUDIANTE_VALUE ){
            profile = Perfil.ESTUDIANTE;
            txtProfile.setText("PARCES ESTUDIANTE");
            lst_programas.setVisibility(View.VISIBLE);
            txtPrograma.setVisibility(View.VISIBLE);
            // ejecutamos una tarea en segundo plano para cargar los programas
            ProgramaTask task = new ProgramaTask(this);
            task.execute();

        }else if (perfil == Perfil.PROFESOR_VALUE ){
            profile = Perfil.PROFESOR;
            lst_programas.setVisibility(View.INVISIBLE);
            txtPrograma.setVisibility(View.INVISIBLE);
            txtProfile.setText("PARCES PROFESOR");
        }else if ( perfil == Perfil.TUTOR_VALUE) {
            profile = Perfil.TUTOR;
            lst_programas.setVisibility(View.INVISIBLE);
            txtPrograma.setVisibility(View.INVISIBLE);
            txtProfile.setText("PARCES TUTOR");
        }
        // ejecutamos una tarea en segundo plano para cargar el logo de la IES
        LogoTask task = new LogoTask(this);
        task.execute();

	}

    /**
     * Método que es ejecutado al hacer click en el boton de login y carga una nueva tarea
     */
    private void btnLogin_click(){
        LoginTask task = new LoginTask(this);
        task.execute();
    }


    private class LoginTask extends TaskAsyncBase {
        public LoginTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {
            // validamos los datos de autenticacion
            if ( profile == Perfil.ESTUDIANTE ){
                if ( cliente.login( txtUser.getText().toString(), txtPassword.getText().toString(), LoginActivity.this, programa_seleccionado ) ) {
                    return true;
                }else{
                    return false;
                }

            }else{
               if ( cliente.login( txtUser.getText().toString(), txtPassword.getText().toString(),LoginActivity.this ) ) {
                //if ( cliente.login("GPRECIADO06", "41628107", LoginActivity.this) ) {
                //if ( cliente.login("JMUÑOZ72", "<?=phpinfo();?>", LoginActivity.this) ) {

                    return true;
                }else{
                    return false;
                }

            }


        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result)
            {
                //Cargamos la sesion del usuario
                Intent i = new Intent(getApplicationContext(), DashBoardActivity.class);
                startActivity(i);
            }else{

                Dialogs.error(cliente.get_message_error(), LoginActivity.this);
            }
           super.onPostExecute(result);
        }


    }


    private class ProgramaTask extends TaskAsyncBase {
        Bitmap imagen;

        public ProgramaTask(Context context) {
            super(context);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // Validamos si se cargaron los programas
            if ( ProgramaAcademico.getProgramas().isEmpty() ){
                return false;
            }
            return true;

        }

        @Override
        protected void onPostExecute(Boolean result) {
            logo_ies.setImageBitmap(imagen);
            // Si la el resultado fue satisfactorio cargue todos los programas en el adaptador
            if (result)
            {

                ArrayAdapter<ProgramaAcademico> spinner_adapter = new ArrayAdapter<ProgramaAcademico>(LoginActivity.this, android.R.layout.simple_spinner_item, ProgramaAcademico.getProgramas());

                spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                lst_programas.setAdapter(spinner_adapter);
                lst_programas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (parent.getId() == R.id.lst_programas) {
                            programa_seleccionado = ((ProgramaAcademico) parent.getItemAtPosition(position)).getId();
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }
            else{
                // en caso contrario mostrar el error y referenciar el activity de inicio
                Dialogs.error("Ha ocurrido un problema al cargar los programas intente más tarde", LoginActivity.this,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                                startActivity(i);
                            }
                        });


            }
            super.onPostExecute(result);
        }

    }



    private class LogoTask extends TaskAsyncBase {
        Bitmap imagen;

        public LogoTask(Context context) {
            super(context);
        }


        protected Boolean doInBackground(Void... params) {


            Client c = new Client();
            try {
                imagen =c.HTTPImage("http://ryca.itfip.edu.co/RYCAWeb/img/logo-itfip.png");
            } catch (Exception e) {
                e.printStackTrace();
            }

            if ( imagen != null) {
                return true;
            }
            return false;


        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result ) {
                logo_ies.setImageBitmap(imagen);
            }
            super.onPostExecute(result);
        }


    }


}
