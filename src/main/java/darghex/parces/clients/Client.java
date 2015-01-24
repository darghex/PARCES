/**
 * Superclase. Cliente REST para las peticiones generales del proyecto
 */
package darghex.parces.clients;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import darghex.parces.LoginActivity;
import darghex.parces.enumerators.Perfil;
import darghex.parces.helpers.ConvertidorCadena;
import darghex.parces.helpers.Dialogs;
import darghex.parces.model.Estudiante;
import darghex.parces.model.Profesor;
import darghex.parces.model.ProgramaAcademico;
import darghex.parces.model.PropuestaMatricula;
import darghex.parces.model.Tutor;
import darghex.parces.model.Usuario;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * </p>
 *
 * @generated
 */
public class Client
{

   public static final String  PARCES_REST_URL = "http://200.14.47.82:8000";
   public static final String  IES_REST_URL = "http://ryca.itfip.edu.co:8888";

   public static String Token = null;
   public static Usuario logged = null;

   protected boolean error= false;
   protected String message_error;

  /**
   * <!-- begin-user-doc -->
   *     Constructor
   * <!-- end-user-doc -->
   * @generated
   */
  public Client()
  {
    super();
  }


    /**
   * <!-- begin-user-doc -->
     *     Valida los datos de sesion de un usuario en la plataforma institucional
     *
   * <!-- end-user-doc -->
   * @param user nombre de usuario
   * @param password contraseña
   * @return boolean
   * @generated
   */
  public boolean login(String user, String password, Activity activity, int... programa) {


      HttpClient httpClient = new DefaultHttpClient();
      String url = Client.IES_REST_URL;

      // Cargamos la url según el rol indicado en el layout de perfil
      if ( LoginActivity.profile == Perfil.ESTUDIANTE){
          url += "/estudiante/login";
      }
      else if ( LoginActivity.profile == Perfil.PROFESOR || LoginActivity.profile == Perfil.TUTOR ){
          url += "/profesor/login";
      }


      HttpPost post = new HttpPost(url);
      post.setHeader("Content-Type", "application/json; charset=utf-8");
      JSONObject dato = new JSONObject();

      try {
          // enviamos los datos de usuario y contraseña
          dato.put("usuario", user);
          dato.put("clave", password);

          if ( LoginActivity.profile == Perfil.ESTUDIANTE){
              dato.put("programa", programa[0]);
          }

          StringEntity entity = new StringEntity(dato.toString());
          post.setEntity(entity);
          HttpResponse resp = httpClient.execute(post);
          String respStr = EntityUtils.toString(resp.getEntity());
          JSONObject respJSON = new JSONObject(respStr);
          boolean error = respJSON.getBoolean("error");

          // si no obtenemos error cargamos los datos de usuario autenticado junto con el token
          if(!error) {
              String token = respJSON.getString("token");
              Client.Token = token;
              JSONObject usuario = respJSON.getJSONObject("user");

              // Creamos un objeto Usuario dependiendo del cliente usuado
              if ( LoginActivity.profile == Perfil.ESTUDIANTE){
                  logged = new Estudiante();
                  ( (Estudiante) logged).setCodigo(usuario.getString("codigo"));
                  //( (Estudiante) logged).setPlan_estudios();
              }else if ( LoginActivity.profile == Perfil.PROFESOR){
                  logged = new Profesor();
              }else {
                  logged = new Tutor();
              }
              logged.setNombres(usuario.getString("nombres"));
              logged.setApellidos(usuario.getString("apellidos"));
              logged.setDni(usuario.getString("dni"));
              logged.setId(usuario.getInt("id"));
              logged.setEmail(usuario.getString("email"));
              logged.setTelefono(usuario.getString("telefono"));
              //FixMe: Cargar fotografia
              logged.setFoto(usuario.getString("foto"));
              return true;
          }else{
              this.error = true;
              this.message_error = "Usuario o Contraseña incorrecto";
          }

      }catch (HttpHostConnectException e){
          this.error = true;
          this.message_error = "No se ha podido conectar con el servidor.";
      }
      catch (Exception e) {
          this.error = true;
          this.message_error = e.getMessage();
      }
      return false;
  }

  /**
   * <!-- begin-user-doc -->
   *  Método que retorna una lista de programas ofertados por la IES
   *
   * <!-- end-user-doc -->
   * @return  List<ProgramaAcademico>
   * @generated
   */
  public List<ProgramaAcademico> get_programas()
  {
      HttpClient httpClient = new DefaultHttpClient();
      HttpGet get =
              new HttpGet(Client.IES_REST_URL+"/programas");
      get.setHeader("Content-Type", "application/json; charset=utf-8");

      JSONObject dato = new JSONObject();
      List<ProgramaAcademico> programas = new ArrayList<ProgramaAcademico>();
      try {
          HttpResponse resp = httpClient.execute(get);
          String respStr = EntityUtils.toString(resp.getEntity());
          JSONObject respJSON = new JSONObject(respStr);
          JSONArray j_programas = respJSON.getJSONArray("programas");



          for ( int i = 0; i < j_programas.length(); i++){
              JSONObject obj  = j_programas.getJSONObject(i).getJSONObject("programa");
              ProgramaAcademico new_programa = new ProgramaAcademico();
              new_programa.setId( obj.getInt("id"));
              new_programa.setName(ConvertidorCadena.primera_a_mayuscula(obj.getString("programa")));
              programas.add(new_programa);
          }

      }catch (HttpHostConnectException e){
          this.error = true;
          this.message_error = "No se ha podido conectar con el servidor.";
      }
      catch (Exception e) {
          this.error = true;
          this.message_error = e.getMessage();
      }
      return programas;
  }

  /**
   * <!-- begin-user-doc -->
   *     Indica si se genero un error al usar el cliente
   * <!-- end-user-doc -->
   * @return boolean
   * @generated
   */
   public boolean isError(){
       return this.error;
   }

    /**
     * <!-- begin-user-doc -->
     *     Retorna una cadena de texto con la descripcion del error
     *
     * <!-- end-user-doc -->
     * @return String
     * @generated
     *
     */
   public String get_message_error(){
       return  this.message_error;
   }



    public android.graphics.Bitmap HTTPImage(String uri1) throws Exception {

        HttpURLConnection conn = null;
        URL imageUrl = null;
        Bitmap imagen;
        try {

            imageUrl = new URL(uri1);
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();

            /*options.inJustDecodeBounds = true;

            int scale = 1;
            if (options.outHeight > IMAGE_MAX_SIZE || options.outWidth > IMAGE_MAX_SIZE) {
                scale = (int)Math.pow(2, (int) Math.ceil(Math.log(IMAGE_MAX_SIZE /
                        (double) Math.max(options.outHeight, options.outWidth)) / Math.log(0.5)));
            }
            */
            options.inSampleSize =1 ;

            imagen = BitmapFactory.decodeStream(conn.getInputStream(),null, options);

            int h =  (int) (imagen.getHeight() * 1.2); // height in pixels
            int w = (int) (imagen.getWidth() * 1.2); // width in pixels
            if (h < 200) h =200;
            if (w < 200) w =200;
            imagen = Bitmap.createScaledBitmap(imagen, h, w, true);





        }
        catch (Exception e){

               imagen = null;
        }
        return imagen ;
    }




} // Client