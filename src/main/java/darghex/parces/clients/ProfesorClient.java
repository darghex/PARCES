/**
 * Cliente Rest para el perfil profesor
 */
package darghex.parces.clients;

import android.util.Log;

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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import darghex.parces.LoginActivity;
import darghex.parces.helpers.ConvertidorCadena;
import darghex.parces.model.Actividad;
import darghex.parces.model.Curso;
import darghex.parces.model.Estudiante;
import darghex.parces.model.InstanciaCurso;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profesor Client</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class ProfesorClient extends Client {

    private Estudiante est;

    /**
     * <!-- begin-user-doc -->
     * Construtor de la clase
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public ProfesorClient() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * Retorna un listado de cursos del docente enviado como parametro.
     * <p/>
     * <!-- end-user-doc -->
     *
     * @param profesor codigo del docente
     * @return List<Curso>
     * @generated
     */
    public List<Curso> get_cursos(int profesor) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.IES_REST_URL + "/profesor/" + String.valueOf(profesor) + "/cursos?token=" + Client.Token);
        List<Curso> cursos = new ArrayList<Curso>();
        JSONObject dato = new JSONObject();
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_cursos = respJSON.getJSONArray("cursos");

            for (int i = 0; i < j_cursos.length(); i++) {
                JSONObject obj = j_cursos.getJSONObject(i).getJSONObject("curso");
                Curso new_curso = new Curso();
                new_curso.setId(obj.getInt("id"));
                new_curso.setGrupo(ConvertidorCadena.a_minuscula(obj.getString("nombre")));
                cursos.add(new_curso);
            }

        } catch (HttpHostConnectException e) {
            this.error = true;
            this.message_error = "No se ha podido conectar con el servidor.";
        } catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return cursos;
    }

    /**
     * <!-- begin-user-doc -->
     * Registra una clase (instancia curso) en el servidor
     * <!-- end-user-doc -->
     *
     * @param new_instancia Instancia curso a alamacenar
     * @generated
     */
    public void set_instancia_curso(InstanciaCurso new_instancia) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * Registra una actividad en el servidor
     * <!-- end-user-doc -->
     *
     * @param new_actividad Actividad a almacenar
     * @generated
     */
    public void set_actividad(Actividad new_actividad) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    public List<Actividad> get_actividades(int instancia) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.PARCES_REST_URL + "/profesor/" + Client.logged.getId() + "/instanciascurso/"+ instancia+"/actividad");
        List<Actividad> actividades = new ArrayList<Actividad>();
        JSONObject dato = new JSONObject();
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_actividades = respJSON.getJSONObject("instanciacurso").getJSONArray("actividades");

            for (int i = 0; i < j_actividades.length(); i++) {

                Actividad new_actividad = new Actividad();
                new_actividad.setId(j_actividades.getJSONObject(i).getInt("id"));
                new_actividad.setDescripcion(j_actividades.getJSONObject(i).getString("actividad"));

                actividades.add(new_actividad);
            }

        } catch (HttpHostConnectException e) {
            this.error = true;
            this.message_error = "No se ha podido conectar con el servidor.";
        } catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return actividades;
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void set_calificacion(String json) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }


    /**
     * <!-- begin-user-doc -->
     * Retorna un listado estudiantes de un curso
     * <p/>
     * <!-- end-user-doc -->
     *
     * @param curso codigo del curso
     * @return List<Curso>
     * @generated
     */
    public List<Estudiante> get_estudiantes(int profesor, int curso) {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet get =
                new HttpGet(Client.IES_REST_URL + "/profesor/" + String.valueOf(profesor) + "/cursos/" + String.valueOf(curso) + "?token=" + Client.Token);
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        JSONObject dato = new JSONObject();
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_estudiantes = respJSON.getJSONArray("cursos");
            j_estudiantes = j_estudiantes.getJSONObject(0).getJSONArray("estudiantes");

            for (int i = 0; i < j_estudiantes.length(); i++) {
                JSONObject obj = j_estudiantes.getJSONObject(i).getJSONObject("estudiante");
                Estudiante new_estudiante = new Estudiante();
                new_estudiante.setCodigo(obj.getString("id"));
                new_estudiante.setNombres(obj.getString("nombres"));
                new_estudiante.setApellidos(obj.getString("apellidos"));
                estudiantes.add(new_estudiante);
            }

        } catch (HttpHostConnectException e) {
            this.error = true;
            this.message_error = "No se ha podido conectar con el servidor.";
        } catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return estudiantes;
    }


    public List<Boolean> get_asistencia(int profesor, int instancia, List<Estudiante> listado) {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet get =
                new HttpGet(Client.PARCES_REST_URL + "/profesor/" + String.valueOf(profesor) + "/instancia/" + String.valueOf(instancia) + "/asistencia");
        List<Boolean> estudiantes = new ArrayList<Boolean>();
        JSONObject dato = new JSONObject();
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_estudiantes = respJSON.getJSONObject("asistencia").getJSONArray("estudiantes");

            int j = 0;
            for (Estudiante est : listado){
                Boolean asistio = false;
                asistencia:

                for (int i = j; i < j_estudiantes.length(); i++) {
                    if ( est.getCodigo().equals(j_estudiantes.getJSONObject(i).getString("estudiante"))){
                        asistio = true;
                        j +=1;
                        break asistencia;
                    }
                }
                if (asistio){
                    estudiantes.add(true);
                }else{
                    estudiantes.add(false);
                }
            }


        } catch (HttpHostConnectException e) {
            this.error = true;
            this.message_error = "No se ha podido conectar con el servidor.";
        } catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return estudiantes;
    }

    /**
     * <!-- begin-user-doc -->
     * Registra la asistancia de un estudiante en una clase
     * <!-- end-user-doc -->
     * @param profesor
     * @param instancia  Instancia de curso a registrar la asistencia
     * @param listado Estudiante que asisitio
     * @param asistencia
     * @generated
     */
    public Boolean set_asistencia(int profesor, int instancia, List<Estudiante> listado, List<Boolean> asistencia) {
        HttpClient httpClient = new DefaultHttpClient();


        HttpPost post = new HttpPost( Client.PARCES_REST_URL + "/profesor/" + String.valueOf(profesor) + "/instancia/" + String.valueOf(instancia) + "/asistencia");
        post.setHeader("Content-Type", "application/json; charset=utf-8");
        JSONArray dato = new JSONArray();


        try {
            // enviamos los datos de usuario y mensaje
            List<String> asistentes = new ArrayList<String>();

            for ( int i = 0; i < listado.size(); i ++){
                if (asistencia.get(i)){
                    dato.put(listado.get(i).getCodigo());
                }
            }

            JSONObject d = new JSONObject();
            d.put("estudiantes", dato);
            StringEntity entity = new StringEntity( d.toString());
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



}//ProfesorClient