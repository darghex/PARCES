/**
 */
package darghex.parces.model;

import java.util.Collection;
import java.util.List;

import darghex.parces.clients.EstudianteClient;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Estudiante</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class Estudiante extends Usuario
{
  /**
   * The default value of the '{@link #getEdad() <em>Edad</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEdad()
   * @generated
   * @ordered
   */
  protected static final byte EDAD_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getEdad() <em>Edad</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEdad()
   * @generated
   * @ordered
   */
  protected static final String CODIGO_EDEFAULT = "";


  protected String codigo = CODIGO_EDEFAULT;




    /**
     * The cached value of the '{@link #getEdad() <em>Edad</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEdad()
     * @generated
     * @ordered
     */
    protected byte edad = EDAD_EDEFAULT;



  /**
   * The default value of the '{@link #getPlan_estudios() <em>Plan estudios</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlan_estudios()
   * @generated
   * @ordered
   */
  protected static final String PLAN_ESTUDIOS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPlan_estudios() <em>Plan estudios</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlan_estudios()
   * @generated
   * @ordered
   */
  protected String plan_estudios = PLAN_ESTUDIOS_EDEFAULT;

  /**
   * The cached value of the '{@link #getCursos()} () <em>Curso</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCursos()
   * @generated
   * @ordered
   */
  protected List<Curso> cursos;
  protected List<Asignaturas> asignaturas;

  /**
   * The cached value of the '{@link #getPropuestaMatricula() <em>Propuesta Matricula</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropuestaMatricula()
   * @generated
   * @ordered
   */
  protected PropuestaMatricula propuestaMatricula;

  /**
   * The cached value of the '{@link #getCalificacionAsignatura() <em>Calificacion Asignatura</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalificacionAsignatura()
   * @generated
   * @ordered
   */
  protected List<CalificacionAsignatura> calificacionAsignatura;

  /**
   * The cached value of the '{@link #getPromedios() <em>Promedios</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPromedios()
   * @generated
   * @ordered
   */
  protected List<Promedios> promedios;

  /**
   * The cached value of the '{@link #getTutor() <em>Tutor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTutor()
   * @generated
   * @ordered
   */
  protected Tutor tutor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Estudiante()
  {
    super();
  }

    public Estudiante(String new_codigo)
    {
        super();
        this.setCodigo(new_codigo);
    }

  /**
   * Returns the value of the '<em><b>Edad</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Edad</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Edad</em>' attribute.
   * @see #setEdad(byte)
   * @generated
   */
  public byte getEdad()
  {
    return edad;
  }

  /**
   *
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEdad(byte newEdad)
  {
    edad = newEdad;
  }

  /**
   * Returns the value of the '<em><b>Plan estudios</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plan estudios</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plan estudios</em>' attribute.
   * @see #setPlan_estudios(String)
   * @generated
   */
  public String getPlan_estudios()
  {
    return plan_estudios;
  }

  /**

   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlan_estudios(String newPlan_estudios)
  {
    plan_estudios = newPlan_estudios;
  }

  /**
   *
   * <!-- begin-user-doc -->
   * Retorna una lista de asignaturas matriculadas por el estudiante
   * <!-- end-user-doc -->
   * @return List<Asignaturas>
   * @generated
   */
  public List<Curso> getCursos( )
  {
    if (cursos == null)
    {
     EstudianteClient c = new EstudianteClient();
     cursos  = c.get_cursos(this.getCodigo());
    }
    return cursos;
  }

    /**
     * Retorna una lista de Asignaturas del plan de estudios del estudiante
     * @return
     */
    public List<Asignaturas> getAsignaturas( )
    {
        if (asignaturas == null)
        {
            EstudianteClient c = new EstudianteClient();
            asignaturas  = c.get_asignaturas(this.getPlan_estudios());
        }
        return asignaturas;
    }



  /**
   * Returns el valor de '<em><b>Propuesta Matricula</b></em>'.
   * <!-- begin-user-doc -->
   * <p>
   * Retorna la propuesta de matricula de un estudiante enviado como parametro
   * </p>
   * <!-- end-user-doc -->
   * @return  '<em>Propuesta Matricula</em>'
   * @generated
   */
  public PropuestaMatricula getPropuestaMatricula()
  {
    if (propuestaMatricula == null)
    {
        EstudianteClient c = new EstudianteClient();
        propuestaMatricula  = c.get_propuesta(this.getCodigo());

    }
    return propuestaMatricula;
  }


  /**
   * Returns the value of the '<em><b>Calificacion Asignatura</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Calificacion Asignatura</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Calificacion Asignatura</em>' reference list.
   * @generated
   */
  public List<CalificacionAsignatura> getCalificacionAsignatura()
  {
    if (calificacionAsignatura == null)
    {
     
    }
    return calificacionAsignatura;
  }

  /**
   * Returns the value of the '<em><b>Promedios</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Promedios</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Promedios</em>' reference list.
   * @generated
   */
  public List<Promedios> getPromedios()
  {
    if (promedios == null)
    {
     
    }
    return promedios;
  }

  /**
   * Returns the value of the '<em><b>Tutor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tutor</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tutor</em>' reference.
   * @see #setTutor(Tutor)
   * @generated
   */
  public Tutor getTutor()
  {
    if (tutor == null )
    {
        EstudianteClient c = new EstudianteClient();
        tutor  = c.get_Tutor(this.getCodigo());
    }
    return tutor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tutor basicGetTutor()
  {
    return tutor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTutor(Tutor newTutor)
  {
    tutor = newTutor;
  }

  /**
   * <!-- begin-user-doc -->
   *     Cambia el estado de la propuesta de matricula del
   *     estudiante
   * <!-- end-user-doc -->
   * @generated
   * @param estado
   */
  public void aprobar_propuesta(boolean estado)
  {
   this.propuestaMatricula.aprobado = estado;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void tutorizar(Tutor tutor)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }


    public String getCodigo()
    {
       return this.codigo;
    }

    public void setCodigo(String new_codigo)
    {
        this.codigo = new_codigo;
    }
  


} // Estudiante
