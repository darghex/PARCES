package darghex.parces;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.Dialogs;

/**
 * Activiy principal del proyecto
 */

public class IntroActivity extends Activity {

    Button btnEstudiante, btnTutor, btnProfesor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);



        btnEstudiante = (Button) findViewById(R.id.btnEstudiante);
        btnTutor = (Button) findViewById(R.id.btnTutor);
        btnProfesor = (Button) findViewById(R.id.btnProfesor);

        btnEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_perfil_click(Perfil.ESTUDIANTE);
            }
        });

        btnTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_perfil_click(Perfil.TUTOR);
            }
        });


        btnProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_perfil_click(Perfil.PROFESOR);
            }
        });

    }

    public void btn_perfil_click(Perfil profile){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        i.putExtra("profile", profile.getValue() );
        startActivity(i);
    }


}
