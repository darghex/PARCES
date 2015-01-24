package darghex.parces;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Superclase para las activities y definir los eventos por defecto de los botones de la barra te titulo
 */
public class ActivityBase extends Activity implements TitleBarEvents {


    /**
     * Eventos para la opcion de salir
     *
     * @param view
     */
    @Override
    public void onClose(View view) {
        Intent i = new Intent(getApplicationContext(), IntroActivity.class ) ;
        startActivity(i);

    }

    /**
     * Eventos para el boton de Inicio
     *
     * @param view
     */
    @Override
    public void onHome(View view) {
        Intent i = new Intent(getApplicationContext(), DashBoardActivity.class ) ;
        startActivity(i);
    }

    /**
     * Eventos para el boton de atras
     *
     * @param view
     */
    @Override
    public void onBack(View view) {
        super.onBackPressed();

    }

    public void onWrite(View view){

    }
}
