/**
 */
package darghex.parces.model;

import java.util.Collection;
import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.clients.ProfesorClient;
import darghex.parces.helpers.ConvertidorCadena;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Curso</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class Curso
{
  /**
   * The cached value of the '{@link #getAsignaturas() <em>Asignaturas</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsignaturas()
   * @generated
   * @ordered
   */
  protected Asignaturas asignaturas;

  /**
   * The cached value of the '{@link #getEstudiante() <em>Estudiante</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEstudiante()
   * @generated
   * @ordered
   */
  protected List<Estudiante> estudiante;

  /**
   * The default value of the '{@link #getGrupo() <em>Grupo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrupo()
   * @generated
   * @ordered
   */
  protected static final String GRUPO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGrupo() <em>Grupo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrupo()
   * @generated
   * @ordered
   */
  protected String grupo = GRUPO_EDEFAULT;

  /**
   * The default value of the '{@link #getPeriodo() <em>Periodo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriodo()
   * @generated
   * @ordered
   */
  protected static final String PERIODO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPeriodo() <em>Periodo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriodo()
   * @generated
   * @ordered
   */
  protected String periodo = PERIODO_EDEFAULT;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final int ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected int id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getInstanciaCurso() <em>Instancia Curso</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanciaCurso()
   * @generated
   * @ordered
   */
  protected List<InstanciaCurso> instanciaCurso;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Curso()
  {
    super();
  }

  

  /**
   * Returns the value of the '<em><b>Asignaturas</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asignaturas</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asignaturas</em>' reference.
   * @see #setAsignaturas(Asignaturas)
   * @generated
   */
  public Asignaturas getAsignaturas()
  {
  
    return asignaturas;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Asignaturas basicGetAsignaturas()
  {
    return asignaturas;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Curso#getAsignaturas <em>Asignaturas</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newAsignaturas the new value of the '<em>Asignaturas</em>' reference.
   * @see #getAsignaturas()
   * @generated
   */
  public void setAsignaturas(Asignaturas newAsignaturas)
  {
    asignaturas = newAsignaturas;
  }

  /**
   * Returns the value of the '<em><b>Estudiante</b></em>' reference list.
   * The list contents are of type {@link darghex.parces.model.Estudiante}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Estudiante</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Estudiante</em>' reference list.
   * @generated
   */
  public List<Estudiante> getEstudiante(int profesor)
  {
    if (estudiante == null)
    {
        ProfesorClient c = new ProfesorClient();
        estudiante = c.get_estudiantes(profesor, this.id);
    }
    return estudiante;
  }

  /**
   * Returns the value of the '<em><b>Grupo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Grupo</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Grupo</em>' attribute.
   * @see #setGrupo(String)
   * @generated
   */
  public String getGrupo()
  {
    return grupo;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Curso#getGrupo <em>Grupo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newGrupo the new value of the '<em>Grupo</em>' attribute.
   * @see #getGrupo()
   * @generated
   */
  public void setGrupo(String newGrupo)
  {
    grupo = newGrupo;
  }

  /**
   * Returns the value of the '<em><b>Periodo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Periodo</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Periodo</em>' attribute.
   * @see #setPeriodo(String)
   * @generated
   */
  public String getPeriodo()
  {
    return periodo;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Curso#getPeriodo <em>Periodo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newPeriodo the new value of the '<em>Periodo</em>' attribute.
   * @see #getPeriodo()
   * @generated
   */
  public void setPeriodo(String newPeriodo)
  {
    periodo = newPeriodo;
  }

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(int)
   * @generated
   */
  public int getId()
  {
    return id;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Curso#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newId the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  public void setId(int newId)
  {
    id = newId;
  }

  /**
   * Returns the value of the '<em><b>Instancia Curso</b></em>' reference list.
   * The list contents are of type {@link darghex.parces.model.InstanciaCurso}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instancia Curso</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instancia Curso</em>' reference list.
   * @generated
   */
  public List<InstanciaCurso> getInstanciaCurso()
  {
    if (instanciaCurso == null)
    {
     
    }
    return instanciaCurso;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int fallas_corte(Estudiante estudiante, short corte)
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
  public float promedio_corte(Estudiante estudiante, short corte)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

 
 
} // Curso
