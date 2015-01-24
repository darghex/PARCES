/**
 */
package darghex.parces.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.clients.EstudianteClient;
import darghex.parces.clients.ProfesorClient;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instancia Curso</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class InstanciaCurso
{
 protected int id;
  /**
   * The default value of the '{@link #getTema() <em>Tema</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTema()
   * @generated
   * @ordered
   */
  protected static final String TEMA_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTema() <em>Tema</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTema()
   * @generated
   * @ordered
   */
  protected String tema = TEMA_EDEFAULT;

  /**
   * The default value of the '{@link #getFecha() <em>Fecha</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFecha()
   * @generated
   * @ordered
   */
  protected static final String FECHA_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFecha() <em>Fecha</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFecha()
   * @generated
   * @ordered
   */
  //FixMe: cambiar por Date
  protected String fecha = FECHA_EDEFAULT;

  /**
   * The default value of the '{@link #getCorte() <em>Corte</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorte()
   * @generated
   * @ordered
   */
  protected static final short CORTE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCorte() <em>Corte</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorte()
   * @generated
   * @ordered
   */
  protected short corte = CORTE_EDEFAULT;

  /**
   * The cached value of the '{@link #getActividades() <em>Actividades</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActividades()
   * @generated
   * @ordered
   */
  protected List<Actividad> actividades;


  protected List<Boolean> asistencia;

  private static List<InstanciaCurso> instancias_curso;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanciaCurso()
  {
    super();
  }

  /**
   * Returns the value of the '<em><b>Tema</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tema</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tema</em>' attribute.
   * @see #setTema(String)
   * @generated
   */
  public String getTema()
  {
    return tema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newTema the new value of the '<em>Tema</em>' attribute.
   * @see #getTema()
   * @generated
   */
  public void setTema(String newTema)
  {
    tema = newTema;
  }

  /**
   * Returns the value of the '<em><b>Fecha</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fecha</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fecha</em>' attribute.
   * @see #setFecha(String)
   * @generated
   */
  public String getFecha()
  {
    return fecha;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newFecha the new value of the '<em>Fecha</em>' attribute.
   * @see #getFecha()
   * @generated
   */
  public void setFecha(String newFecha)
  {
    fecha = newFecha;
  }

  /**
   * Returns the value of the '<em><b>Corte</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Corte</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Corte</em>' attribute.
   * @see #setCorte(short)
   * @generated
   */
  public short getCorte()
  {
    return corte;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.InstanciaCurso#getCorte <em>Corte</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newCorte the new value of the '<em>Corte</em>' attribute.
   * @see #getCorte()
   * @generated
   */
  public void setCorte(short newCorte)
  {
   corte = newCorte;
  }

  /**
   * Returns the value of the '<em><b>Actividades</b></em>' reference list.
   * The list contents are of type {@link darghex.parces.model.Actividad}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actividades</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actividades</em>' reference list.
   * @generated
   */
  public List<Actividad> getActividades()
  {

    return actividades;
  }

  public void addActividad(Actividad new_actividad){
      if (actividades == null){
          actividades = new ArrayList<Actividad>();
      }
      actividades.add(new_actividad);
  }


  private static void  load(String estudiante, int curso){
     // if (instancias_curso == null) {
          EstudianteClient c = new EstudianteClient();
          instancias_curso = c.get_instanciasCurso(estudiante, curso);
      //}
  }

    /**
     *
     * @param estudiante
     * @param curso
     * @return
     */
  public static List<InstanciaCurso> getInstancias_curso (String estudiante, int curso){
    load(estudiante, curso);
    return instancias_curso;
   }



  /**
   * Returns the value of the '<em><b>Asistencia</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asistencia</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asistencia</em>' reference.
   * @generated
   */
  public List<Boolean> getAsistencia(List<Estudiante> listado)
  {
    if (asistencia == null )
    {
        ProfesorClient c = new ProfesorClient();
        registrar_asistencia( c.get_asistencia(Client.logged.getId(),this.id, listado));
    }
    return asistencia;
  }

   public void setAsistencia(List<Estudiante> listado, List<Boolean> asistencia)
    {
            ProfesorClient c = new ProfesorClient();
            c.set_asistencia(Client.logged.getId(),this.id, listado, asistencia);
    }


  /**
   * <!-- begin-user-doc -->
   *     Registra la asistencia de una lista de estudiantes
   * <!-- end-user-doc -->
   * @generated
   */
  public void registrar_asistencia(List<Boolean> estudiantes)
  {
    if ( estudiantes.size() > 0 ) {
        asistencia = new ArrayList<Boolean>();
        asistencia.addAll(estudiantes);
    }
  }

  public void setId(int new_id){ this.id = new_id;}

  public Integer getId(){ return this.id;}

 
} // InstanciaCurso