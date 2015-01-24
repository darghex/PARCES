package darghex.parces.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;

import darghex.parces.ActividadGestionActivity;


/**
 * Helper para la generacion de cuadros de dialogos
 */

public abstract class Dialogs {


    public static EditText input ;

    /**
     * Genera una ventana de error
     * @param msg mensaje a mostrar
     * @param activity contenedor
     */
    public static void  error( String msg , Activity activity){
        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(msg);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();
    }

    /**
     * Genera una ventana de error y relaciona un evento al boton cuando se hace click sobre él
     * @param msg mensaje a mostrar
     * @param activity contenedor
     */
    public static void  error( String msg , Activity activity,DialogInterface.OnClickListener handler ){
        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(msg);
        alertDialog.setButton("OK", handler);

        alertDialog.show();
    }

    /**
     * Genera una ventana de información y relaciona un evento al boton cuando se hace click sobre él
     * @param msg mensaje a mostrar
     * @param activity contenedor
     */
    public static void  information( String msg , Activity activity,DialogInterface.OnClickListener handler ){
        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("Información");
        alertDialog.setMessage(msg);
        alertDialog.setButton("OK", handler);
        alertDialog.show();
    }


    /**
     * Genera un menu emergente
     * @param activity  contenederor
     * @param view
     * @param menu  Menu
     * @param callback Listener para cada item del menú
     */
    public static void showPopupMenu(Activity activity, View view, int menu, final PopupMenu.OnMenuItemClickListener callback)
    {
        PopupMenu popupMenu = new PopupMenu(activity, view);
        popupMenu.getMenuInflater().inflate(menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(callback);
        popupMenu.show();
    }

    /**
     * Genera un cuadro de dialogo para entrada de datos
     * @param title Titulo de la ventana
     * @param msg   Mensaje informativo
     * @param activity contenedor
     * @param okClick Listener para la acción de Ok
     * @param cancelClick Listener para la acción de Cancel
     */
    private static void inputDialog(String title, String msg, Activity activity, DialogInterface.OnClickListener okClick, DialogInterface.OnClickListener cancelClick, int inputtype){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity );


        alert.setTitle(title);
        alert.setMessage(msg);

        input = new EditText(activity);
        input.setInputType(inputtype);
        alert.setView(input);


        alert.setPositiveButton("Ok", okClick);

        alert.setNegativeButton("Cancel", cancelClick);

        alert.show();

    }


    public static void textDialog(String title, String msg, Activity activity, DialogInterface.OnClickListener okClick, DialogInterface.OnClickListener cancelClick){
        inputDialog(title, msg, activity, okClick, cancelClick, InputType.TYPE_CLASS_TEXT);
    }

    public static void numericDialog(String title, String msg, Activity activity, DialogInterface.OnClickListener okClick, DialogInterface.OnClickListener cancelClick){
        inputDialog(title, msg, activity, okClick, cancelClick, InputType.TYPE_CLASS_NUMBER);
    }

    public static void decimalDialog(String title, String msg, Activity activity, DialogInterface.OnClickListener okClick, DialogInterface.OnClickListener cancelClick){
        inputDialog(title, msg, activity, okClick, cancelClick, InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    public static void dateDialog(String title, String msg, Activity activity, DialogInterface.OnClickListener okClick, DialogInterface.OnClickListener cancelClick){
        inputDialog(title, msg, activity, okClick, cancelClick, InputType.TYPE_CLASS_DATETIME);
    }



}