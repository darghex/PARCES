/**
 */
package darghex.parces.clients;


import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import darghex.parces.model.Estudiante;
import darghex.parces.model.Profesor;
import darghex.parces.model.Tutor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tutor Client</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class TutorClient extends Client
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TutorClient()
  {

  }


 
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<Estudiante> get_estudiantes(int tutor)
  {
      HttpClient httpClient = new DefaultHttpClient();
      HttpGet get =
              new HttpGet(Client.PARCES_REST_URL+"/tutor/"+ String.valueOf(tutor) +"/estudiantes?token="+ Client.Token);
      get.setHeader("Content-Type", "application/json; charset=utf-8");
      List<Estudiante> estudiantes = new ArrayList<Estudiante>();
      JSONObject dato = new JSONObject();
      try {
          HttpResponse resp = httpClient.execute(get);
          String respStr = EntityUtils.toString(resp.getEntity());
          JSONObject respJSON = new JSONObject(respStr);
          JSONArray j_estudiantes = respJSON.getJSONArray("estudiantes");


          for ( int i = 0; i < j_estudiantes.length(); i++){
              JSONObject obj  = j_estudiantes.getJSONObject(i).getJSONObject("estudiante");
              Estudiante new_estudiante = new Estudiante();
              new_estudiante.setCodigo( obj.getString("id"));
              new_estudiante.setNombres( obj.getString("nombres"));
              new_estudiante.setApellidos(obj.getString("apellidos"));
              new_estudiante.setFoto( obj.getString("foto"));
              new_estudiante.setPlan_estudios(obj.getString("pensum"));
              estudiantes.add(new_estudiante);
          }

      }catch (HttpHostConnectException e){
          this.error = true;
          this.message_error = "No se ha podido conectar con el servidor.";
      }
      catch (Exception e) {
          this.error = true;
          this.message_error = e.getMessage();
      }
      return estudiantes;
  }


    /**
     * <!-- begin-user-doc -->
     *     indica si se encuentra aprobada o no una propuesta de matricula
     * <!-- end-user-doc -->
     * @param propuesta codigo de la propuesta
     * @param estado estado de la propuesta a actualizar
     * @return boolean
     */
    public boolean set_estado_propuesta( Integer propuesta, Boolean estado)
    {
        HttpClient httpClient = new DefaultHttpClient();
        //FixMe: verificar modificacion
        HttpPut put =
                new HttpPut(Client.PARCES_REST_URL+"/propuesta/"+propuesta.toString());
        put.setHeader("Content-Type", "application/json; charset=utf-8");
        JSONObject dato = new JSONObject();


        try {
            dato.put("pm_aprobado", estado);


            StringEntity entity = new StringEntity(dato.toString());
            put.setEntity(entity);
            HttpResponse resp = httpClient.execute(put);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            return true;


        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con el servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return estado;
    }



    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String buscar_estudiantes(String json)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void tutorizar(String json)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String get_estudiante_data(String estudiante)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

} // TutorClient