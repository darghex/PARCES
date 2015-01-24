package darghex.parces.model;

import android.content.DialogInterface;
import android.view.View;

/**
 * Estructura para almacenar los datos de cada Launcher del dashboard
 */
public class LauncherIcon {
    public String text;
    public int imgId;
    public View.OnClickListener callback;
    public int id;

    public LauncherIcon(int imgId, String text, View.OnClickListener callback) {
        super();
        this.imgId = imgId;
        this.text = text;
        this.callback = callback;
    }

    public LauncherIcon( Integer id, int imgId, String text, View.OnClickListener callback ) {
        super();
        this.imgId = imgId;
        this.text = text;
        this.callback = callback;
        this.id = id;
    }

}
