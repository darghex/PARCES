package darghex.parces;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.clients.TutorClient;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.ConvertidorCadena;
import darghex.parces.helpers.Dialogs;
import darghex.parces.helpers.ImageAdapter;
import darghex.parces.model.Curso;
import darghex.parces.model.Estudiante;
import darghex.parces.model.LauncherIcon;
import darghex.parces.model.Profesor;
import darghex.parces.model.PropuestaMatricula;
import darghex.parces.model.Tutor;

/**
 * ACtitity que carga el dashboard dependiendo del perfil del usuario
 */
public class DashBoardActivity extends ActivityBase {

   
    TextView txtLogged;
    Client cliente;
    String estudiante_seleccionado = null;
    String pensum = null;



	 @Override
     public void onCreate(Bundle savedInstanceState) {

	     super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_dash_board);

         Bundle bundle = getIntent().getExtras();
         DashBoardTask task = new  DashBoardTask(this);
         final TextView txtNombre = (TextView) findViewById(R.id.lblEstudiante);

         // Si no recibio parametros ingreso por el rol de estudiante
         if (bundle == null){
             task.execute();
             ViewGroup parent = (ViewGroup) txtNombre.getParent();
             parent.removeView( txtNombre);
         }else{
            // En caso contrario ingreso como tutor y puede observar el dashboard de sus estudiantes
             estudiante_seleccionado = bundle.getString("id_estudiante");
             pensum = bundle.getString("pensum");
             txtNombre.setText(ConvertidorCadena.primera_a_mayuscula(bundle.getString("name_estudiante")));
             task.execute();
         }

     }

    private class DashBoardTask extends  TaskAsyncBase    {
        List<Estudiante> estudiantes = null;
        List<Curso> cursos = null;

        public DashBoardTask(Context context) {
            super(context);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {

                if ( LoginActivity.profile == Perfil.TUTOR ){
                    if ( estudiante_seleccionado == null ) { // Si ingresamos al menu del tutor
                        Tutor t = new Tutor(Client.logged.getId());
                        estudiantes = t.getEstudiantes();
                    }// sino cargamos el menu del estudiante seleccionado
                    else{

                        Estudiante e = new Estudiante( estudiante_seleccionado );
                        cursos = e.getCursos();
                    }

                }
                // rol de estudiante
                else if ( LoginActivity.profile == Perfil.ESTUDIANTE){
                    String codigo = ((Estudiante) Client.logged).getCodigo();
                    Estudiante e = new Estudiante( codigo );
                    cursos = e.getCursos();
                }
                // rol de profesor
                else if ( LoginActivity.profile == Perfil.PROFESOR ){
                    Profesor p = new Profesor(Client.logged.getId());
                    cursos = p.getCursos();
                }

                return true;
            }catch(Exception e){
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {

            if (result) {

                //Cargar los dashboard de los diferentes roles
                if (LoginActivity.profile == Perfil.TUTOR) {
                    if( estudiante_seleccionado == null ) {
                        load_dashboard_tutor();
                    }else{
                        load_dashboard_estudiante(estudiante_seleccionado);
                    }

                } else if (LoginActivity.profile == Perfil.ESTUDIANTE) {
                    load_dashboard_estudiante(( (Estudiante) Client.logged).getCodigo());
                } else if (LoginActivity.profile == Perfil.PROFESOR) {
                    load_dashboard_profesor();
                }
            } else{

                Dialogs.error(cliente.get_message_error(), DashBoardActivity.this);
            }

           super.onPostExecute(result);

        }





        /**
         * Procedimiento que carga el menu de opciones para el usuario con el rol de tutor
         */
        public void load_dashboard_tutor(  )        {

            GridView dashboard  = (GridView) findViewById(R.id.dashboard_grid);
            List<LauncherIcon> launcher = new ArrayList<LauncherIcon>();


            launcher.add( new LauncherIcon(R.drawable.tutorizar,"Tutorizar",new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: Implementar
                    //Toast.makeText(getApplicationContext(), "Por implementar", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), BuscarEstudianteActivity.class );
                    startActivity(i);

                }
            }));


            for (Estudiante estudiante : estudiantes) {
                final String codigo = estudiante.getCodigo();
                final String name = ConvertidorCadena.primera_a_mayuscula(estudiante.getFullName());
                final String pensum = estudiante.getPlan_estudios();
                launcher.add( new LauncherIcon( estudiante.getId(), R.drawable.estudiantes ,name, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), DashBoardActivity.class);
                        i.putExtra("id_estudiante", codigo);// enviamos el codigo del estudiante
                        i.putExtra("name_estudiante", name);
                        i.putExtra("pensum", pensum);
                        startActivity(i);
                    }
                }));
            }
            ImageAdapter.ICONS = launcher;
            dashboard.setAdapter( new ImageAdapter(DashBoardActivity.this));

        }

        /**
         * Procedimiento que carga el menu de opciones para el usuario con el rol de estudiante
         */
        public void load_dashboard_estudiante( final String codigo )        {

            GridView dashboard  = (GridView) findViewById(R.id.dashboard_grid);
            List<LauncherIcon> launcher = new ArrayList<LauncherIcon>();
            //Cargo en launcher para mostrar la propuesta de matricula del estudiante logueado

            launcher.add( new LauncherIcon(R.drawable.propuesta, "Propuesta matricula", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), PropuestaMatriculaActivity.class);
                    i.putExtra("codigo_estudiante",  codigo);
                    startActivity(i);

                }
            }));
            //si la sesion que cargo fue la del estudiante mostrar solo la info del tutor
            if ( LoginActivity.profile == Perfil.ESTUDIANTE ) {
                //Cargo en launcher para mostrar el tutor asignado del estudiante logueado
                launcher.add(new LauncherIcon(R.drawable.tutor, "Tutor", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(i);

                    }
                }));
            }else{
                // en caso de que sea el tutor que ingrese a ver el perfil de un estudiante pueda observar pensum y rendimiento académico
                launcher.add(new LauncherIcon(R.drawable.pensum, "Plan de estudios", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getApplicationContext(), PensumActivity.class);
                        i.putExtra("pensum", pensum);
                        startActivity(i);

                    }
                }));

                launcher.add(new LauncherIcon(R.drawable.cv, "Historia académica", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    //TODO: Implementar
                        Toast.makeText(getApplicationContext(), "Por implementar", Toast.LENGTH_SHORT).show();
                    }
                }));

            }
            // Enviamos el id del curso para cargar las respectivas actividades
            for (Curso curso : cursos) {
                // FixMe: cambiar por el nombre de la asginatura y no del grupo
                final String descripcion = curso.getGrupo();
                launcher.add( new LauncherIcon(curso.getId(), R.drawable.curso,curso.getGrupo(), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), AsignaturaActivity.class);
                        i.putExtra("id_curso", v.getId());
                        i.putExtra("curso", descripcion);
                        i.putExtra("id_estudiante",  codigo );
                        startActivity(i);
                    }
                }));
            }

            ImageAdapter.ICONS = launcher;
            dashboard.setAdapter( new ImageAdapter(DashBoardActivity.this));
        }

        /**
         * Procedimiento que carga el menu de opciones para el usuario con el rol de profesor
         */
        public void load_dashboard_profesor(  )        {

            GridView dashboard  = (GridView) findViewById(R.id.dashboard_grid);
            List<LauncherIcon> launcher = new ArrayList<LauncherIcon>();

            for (Curso curso : cursos) {
                final String descripcion = ConvertidorCadena.a_mayuscula(curso.getGrupo());
                launcher.add( new LauncherIcon(curso.getId(), R.drawable.curso,curso.getGrupo(), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), CursoActivity.class);
                        i.putExtra("id_curso", v.getId());
                        i.putExtra("curso", descripcion);
                        startActivity(i);
                    }
                }));
            }
            ImageAdapter.ICONS = launcher;
            dashboard.setAdapter( new ImageAdapter(DashBoardActivity.this));

        }



    }
}