package darghex.parces.helpers;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import darghex.parces.LoginActivity;
import darghex.parces.clients.Client;
import darghex.parces.enumerators.Perfil;
import darghex.parces.model.Estudiante;
import darghex.parces.model.Mensaje;
import darghex.parces.model.Profesor;
import darghex.parces.model.ProgramaAcademico;
import darghex.parces.model.Tutor;
import darghex.parces.model.Usuario;

/**
 * Created by darghex on 6/12/14.
 */
public class MessageManager implements IMessageManager{

    public boolean error;
    public String message_error;
    String url ="";

    /**
     * <!-- begin-user-doc -->
     * Metodo para escribir un mensaje de una propuesta academica
     * <!-- end-user-doc -->
     *
     * @param mensaje cadena del mensaje
     * @param user nombre completo del autor
     * @param id_propuesta propuesta de matricula
     * @generated
     */
    public boolean escribir_to_propuesta(String mensaje, String user, int id_propuesta) {
        url = Client.PARCES_REST_URL+"/prematricula/"+id_propuesta+"/comentarios";
        return escribir(mensaje,user, id_propuesta);


    }

    /**
     * <!-- begin-user-doc -->
     *  Obtiene los mensaje de una propuesta de matricula
     * <!-- end-user-doc -->
     * @param id_propuesta codigo de la propuesta de matricula
     * @generated
     */

    public List<Mensaje> leer_to_propuesta(int id_propuesta) {
        url = Client.PARCES_REST_URL+"/prematricula/"+id_propuesta+"/comentarios";
        return leer(id_propuesta);
    }


    /**
     * <!-- begin-user-doc -->
     * Metodo para escribir un mensaje de una propuesta academica
     * <!-- end-user-doc -->
     *
     * @param mensaje cadena del mensaje
     * @param user nombre completo del autor
     * @param id_instancia Instancia del curso
     * @generated
     */
    public boolean escribir_to_instancia(String mensaje, String user, int id_instancia) {
        url = Client.PARCES_REST_URL+"/instancia_curso/"+id_instancia+"/comentarios";
        return escribir(mensaje,user, id_instancia);


    }

    /**
     * <!-- begin-user-doc -->
     *  Obtiene los mensaje de una instancia de curso
     * <!-- end-user-doc -->
     * @param id_instancia codigo de la propuesta de matricula
     * @generated
     */

    public List<Mensaje> leer_to_instancia(int id_instancia) {
        url = Client.PARCES_REST_URL+"/instancia_curso/"+id_instancia+"/comentarios";
        return leer(id_instancia);
    }

    /**
     * <!-- begin-user-doc -->
     * Metodo para escribir un mensaje de una propuesta academica
     * <!-- end-user-doc -->
     *
     * @param mensaje Cuerpo del mensaje
     * @param user    Nombre del usuario emisor
     * @param id      identificador del mensaje
     * @generated
     */
    @Override
    public boolean escribir(String mensaje, String user, int id) {
        HttpClient httpClient = new DefaultHttpClient();


        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json; charset=utf-8");
        JSONObject dato = new JSONObject();

        try {
            // enviamos los datos de usuario y mensaje
            dato.put("com_usuario", user);
            dato.put("com_mensaje",mensaje);


            StringEntity entity = new StringEntity(dato.toString());
            post.setEntity(entity);
            HttpResponse resp = httpClient.execute(post);

            String respStr = EntityUtils.toString(resp.getEntity());

            return true;


        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con al servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * Obtiene los mensaje
     * <!-- end-user-doc -->
     *
     * @param id identificador del mensaje
     * @generated
     */
    @Override
    public List<Mensaje> leer(int id) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(url);
        get.setHeader("Content-Type", "application/json; charset=utf-8");

        List<Mensaje> mensajes = new ArrayList<Mensaje>();
        JSONObject dato = new JSONObject();
        String responseText="";
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_mensajes = respJSON.getJSONObject("response").getJSONArray("comentarios");


            for ( int i = 0; i < j_mensajes.length(); i++){

                Mensaje new_mensaje = new Mensaje();
                new_mensaje.setMensaje(j_mensajes.getJSONObject(i).getString("mensaje"));
                new_mensaje.setAutor(j_mensajes.getJSONObject(i).getString("autor"));
                new_mensaje.setFecha(j_mensajes.getJSONObject(i).getString("fecha"));

                mensajes.add(new_mensaje);
            }


        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con al servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return mensajes;
    }
}
