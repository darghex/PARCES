package darghex.parces;

import android.view.View;

/**
 * Created by darghex on 3/12/14.
 */
public interface TitleBarEvents {
    /**
     * Eventos para la opcion de salir
     * @param view
     */
    public void onClose(View view);

    /**
     * Eventos para el boton de Inicio
     * @param view
     */
    public void onHome(View view);


    /**
     * Eventos para el boton de atras
     * @param view
     */
    public void onBack(View view);


}
