package darghex.parces;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import darghex.parces.clients.Client;
import darghex.parces.helpers.Dialogs;

/**
 * Superclase para las tareas asincronas, se encarga de controlar el Dialogo de Proceso
 */
public class TaskAsyncBase extends AsyncTask<Void, Integer, Boolean> {
    public ProgressDialog pDialog;

    public TaskAsyncBase(Context context){
        pDialog = new ProgressDialog(context);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setMessage("Procesando...");
        pDialog.setMax(100);
        pDialog.setCancelable(false);


    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        int progreso = values[0].intValue();
        pDialog.setProgress(progreso);
    }

    @Override
    protected void onPreExecute() {

        pDialog.setProgress(0);
        pDialog.show();
    }

    protected void onPostExecute(Boolean result) {
      pDialog.dismiss();
    }
}
