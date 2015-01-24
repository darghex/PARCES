/**
 */
package darghex.parces.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calificacion Parcial</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link darghex.parces.model.CalificacionParcial#getEstudiante <em>Estudiante</em>}</li>
 *   <li>{@link darghex.parces.model.CalificacionParcial#getCalificacion <em>Calificacion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalificacionParcial
{
  /**
   * The cached value of the '{@link #getEstudiante() <em>Estudiante</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEstudiante()
   * @generated
   * @ordered
   */
  protected Estudiante estudiante;

  /**
   * The default value of the '{@link #getCalificacion() <em>Calificacion</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalificacion()
   * @generated
   * @ordered
   */
  protected static final float CALIFICACION_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getCalificacion() <em>Calificacion</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalificacion()
   * @generated
   * @ordered
   */
  protected float calificacion = CALIFICACION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CalificacionParcial()
  {
    super();
  }

  /**
   * Returns the value of the '<em><b>Estudiante</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Estudiante</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Estudiante</em>' reference.
   * @see #setEstudiante(Estudiante)
   * @generated
   */
  public Estudiante getEstudiante()
  {
    if (estudiante != null )
    {
      
    }
    return estudiante;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Estudiante basicGetEstudiante()
  {
    return estudiante;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.CalificacionParcial#getEstudiante <em>Estudiante</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newEstudiante the new value of the '<em>Estudiante</em>' reference.
   * @see #getEstudiante()
   * @generated
   */
  public void setEstudiante(Estudiante newEstudiante)
  {
    estudiante = newEstudiante;
  }

  /**
   * Returns the value of the '<em><b>Calificacion</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Calificacion</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Calificacion</em>' attribute.
   * @see #setCalificacion(float)
   * @generated
   */
  public float getCalificacion()
  {
    return calificacion;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.CalificacionParcial#getCalificacion <em>Calificacion</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newCalificacion the new value of the '<em>Calificacion</em>' attribute.
   * @see #getCalificacion()
   * @generated
   */
  public void setCalificacion(float newCalificacion)
  {
    calificacion = newCalificacion;
  }

  
} // CalificacionParcial
