/**
 * Cliente Rest para el perfil del Estudiante
 */
package darghex.parces.clients;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import darghex.parces.helpers.ConvertidorCadena;
import darghex.parces.model.Actividad;
import darghex.parces.model.Asignaturas;
import darghex.parces.model.CalificacionParcial;
import darghex.parces.model.Curso;
import darghex.parces.model.Estudiante;
import darghex.parces.model.InstanciaCurso;
import darghex.parces.model.PropuestaMatricula;
import darghex.parces.model.Tutor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Estudiante Client</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class EstudianteClient extends Client
{

    /**
     * <!-- begin-user-doc -->
     *     Constructutor
     * <!-- end-user-doc -->
     * @generated
     */
    public EstudianteClient()
    {
        super();
    }


    /**
     * <!-- begin-user-doc -->
     *     Retorna la propuesta de matricula de un estudiante enviado como parámetro
     *
     * <!-- end-user-doc -->
     * @param estudiante codigo del estudiante
     * @return PropuestaMatricula
     * @generated
     */
    public PropuestaMatricula get_propuesta(String estudiante)
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.IES_REST_URL+"/estudiante/"+ estudiante +"/prematricula?token="+ Client.Token);
        PropuestaMatricula propuesta = new PropuestaMatricula();

        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_materias = respJSON.getJSONObject("prematricula").getJSONArray("materias");

            for ( int i = 0; i < j_materias.length(); i++){
                JSONObject obj  = j_materias.getJSONObject(i).getJSONObject("materia");
                Asignaturas new_asignatura = new Asignaturas();
                new_asignatura.setCodigo( obj.getString("id"));
                new_asignatura.setNombre(ConvertidorCadena.primera_a_mayuscula(obj.getString("materia")));
                new_asignatura.setCreditos(  (byte) obj.getInt("creditos"));
                new_asignatura.setUbicacion_semestral(  (byte) obj.getInt("semestre"));
                propuesta.addAsignatura(new_asignatura);
            }
            propuesta.setCodigo(respJSON.getJSONObject("prematricula").getInt("id"));
            propuesta.setPeriodo(respJSON.getJSONObject("prematricula").getString("periodo"));


        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con al servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return propuesta;
    }

    /**
     * <!-- begin-user-doc -->
     *    Retorna una lista de cursos matriculados por el estudiante
     * <!-- end-user-doc -->
     * @param estudiante codigo del estudiante
     * @return List<Curso>
     * @generated
     */
    public List<Curso> get_cursos(String estudiante)
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.IES_REST_URL+"/estudiante/"+ estudiante +"/matricula?token="+ Client.Token);
        List<Curso> cursos = new ArrayList<Curso>();
        JSONObject dato = new JSONObject();
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_cursos = respJSON.getJSONObject("matricula").getJSONArray("materias");

            for ( int i = 0; i < j_cursos.length(); i++){
                JSONObject obj  = j_cursos.getJSONObject(i).getJSONObject("materia");
                Curso new_curso = new Curso();
                new_curso.setId( obj.getInt("id_curso"));
                new_curso.setGrupo( ConvertidorCadena.primera_a_mayuscula( obj.getString("curso")));
                Asignaturas new_asignatura  = new Asignaturas();
                new_asignatura.setCodigo( obj.getString("id") );
                new_asignatura.setCreditos( (byte) obj.getInt("creditos") );
                new_asignatura.setNombre(  ConvertidorCadena.primera_a_mayuscula( obj.getString("materia") ));
                new_asignatura.setUbicacion_semestral( (byte) obj.getInt("semestre"));
                cursos.add(new_curso);
            }

        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con al servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return cursos;

    }

    /**
     * <!-- begin-user-doc -->
     *     Retorna un perfil del tutor a cargo del estudiante enviado como parametro
     * <!-- end-user-doc -->
     * @param estudiante codigo del estudiante
     * @return Tutor
     * @generated
     */
    public Tutor get_Tutor(String estudiante){
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.PARCES_REST_URL+"/estudiantes/"+ estudiante +"/tutor?token="+ Client.Token);
        Tutor t = new Tutor();

        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONObject j_tutor = respJSON.getJSONObject("profesor");
            t.setFoto( j_tutor.getString("foto") );
            t.setNombres( j_tutor.getString("nombres") );
            t.setApellidos( j_tutor.getString("apellidos") );
            t.setTelefono( j_tutor.getString("telefono") );
            t.setEmail( j_tutor.getString("email") );


        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con al servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return t;
    }


    /**
     * <!-- begin-user-doc -->
     *     indica si se encuentra aprobada o no una propuesta de matricula
     * <!-- end-user-doc -->
     * @param estudiante codigo del estudiante
     * @return boolean
     */
    public boolean get_estado_propuesta( String estudiante)
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.PARCES_REST_URL+"/estudiantes/"+estudiante+"/propuesta");
        get.setHeader("Content-Type", "application/json; charset=utf-8");

        JSONObject dato = new JSONObject();

        boolean estado = false;
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_propuesta = respJSON.getJSONArray("propuesta");



            for ( int i = 0; i < j_propuesta.length(); i++){
                estado = j_propuesta.getJSONObject(i).getBoolean("estado");

            }

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
     *     Retorna las instancias de un curso matriculado de un estudiante
     * <!-- end-user-doc -->
     * @param estudiante codigo del estudiante
     * @return boolean
     */

    public List<InstanciaCurso> get_instanciasCurso(String estudiante, int curso){
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.PARCES_REST_URL+"/estudiantes/"+ estudiante +"/curso/"+ curso+"/actividades");
        List<InstanciaCurso> instancias = new ArrayList<InstanciaCurso>();

        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_instancias = respJSON.getJSONObject("instancias_curso").getJSONArray("instancia");

            for ( int i = 0; i < j_instancias.length(); i++){

                InstanciaCurso new_instancia = new InstanciaCurso();
                new_instancia.setId( j_instancias.getJSONObject(i).getInt("id"));
                new_instancia.setTema( j_instancias.getJSONObject(i).getString("tema"));
                new_instancia.setFecha(j_instancias.getJSONObject(i).getString("fecha"));
                new_instancia.setCorte((short) j_instancias.getJSONObject(i).getInt("corte"));
                Actividad new_actividad ;

                JSONArray j_actividades  = j_instancias.getJSONObject(i).getJSONArray("actividades");
                for ( int j = 0 ; j  < j_actividades.length(); j++){
                    new_actividad = new Actividad();
                    new_actividad.setDescripcion( j_actividades.getJSONObject(j).getString("actividad"));
                    new_instancia.addActividad(new_actividad);
                }


                instancias.add(new_instancia);
            }

        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con al servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return instancias;

    }


    /**
     * <!-- begin-user-doc -->
     *    Retorna una lista de cursos del plan de estudios
     * <!-- end-user-doc -->
     * @param pensum codigo del pensum
     * @return List<Curso>
     * @generated
     */
    public List<Asignaturas> get_asignaturas(String pensum)
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.IES_REST_URL+"/pensums/"+ pensum +"?token="+ Client.Token);
        List<Asignaturas> asignaturas = new ArrayList<Asignaturas>();
        JSONObject dato = new JSONObject();
        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);
            JSONArray j_cursos = respJSON.getJSONObject("pensum").getJSONArray("materias");

            for ( int i = 0; i < j_cursos.length(); i++){
                JSONObject obj  = j_cursos.getJSONObject(i).getJSONObject("materia");
                Asignaturas new_asigntura = new Asignaturas();
                new_asigntura.setCodigo( obj.getString("id"));
                new_asigntura.setNombre( ConvertidorCadena.primera_a_mayuscula( obj.getString("materia")));
                new_asigntura.setUbicacion_semestral( (byte) obj.getInt("semestre"));
                new_asigntura.setCreditos( (byte) obj.getInt("creditos"));
                asignaturas.add(new_asigntura);
            }

        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con el servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return asignaturas;

    }


    /**
     * <!-- begin-user-doc -->
     *     Retorna las actividades y calificaciones de un estudiante respecto a una instancia de curso
     * <!-- end-user-doc -->
     * @param estudiante codigo del estudiante
     * @param instancia_curso codigo de la instancia
     * @return boolean
     */

    public List<Actividad> get_actividades(String estudiante, int instancia_curso){
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get =
                new HttpGet(Client.PARCES_REST_URL+"/instancia_curso/"+ instancia_curso +"/actividades/"+ estudiante);
        List<Actividad> actividades = new ArrayList<Actividad>();

        try {
            HttpResponse resp = httpClient.execute(get);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONObject respJSON = new JSONObject(respStr);

                JSONArray j_actividades  = respJSON.getJSONObject("instancias_curso").getJSONArray("actividades");
                Actividad new_actividad;
                for ( int j = 0 ; j  < j_actividades.length(); j++){
                    new_actividad = new Actividad();
                    new_actividad.setDescripcion(j_actividades.getJSONObject(j).getString("actividad"));
                    CalificacionParcial c = new CalificacionParcial();
                    if ( !j_actividades.getJSONObject(j).getString("calificacion").equals("null")) {
                        c.setCalificacion((float) j_actividades.getJSONObject(j).getDouble("calificacion"));
                        c.setEstudiante(new Estudiante(estudiante));
                        new_actividad.setCalificacionParcial(c);
                    }
                    actividades.add(new_actividad);
                }

        }catch (HttpHostConnectException e){
            this.error = true;
            this.message_error = "No se ha podido conectar con al servidor.";
        }
        catch (Exception e) {
            this.error = true;
            this.message_error = e.getMessage();
        }
        return actividades;

    }





} // EstudianteClient
