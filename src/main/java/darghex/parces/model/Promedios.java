/**
 */
package darghex.parces.model;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Promedios</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link darghex.parces.model.Promedios#getCalificacion <em>Calificacion</em>}</li>
 *   <li>{@link darghex.parces.model.Promedios#getPeriodo <em>Periodo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Promedios
{
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Promedios()
  {
    super();
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
   * Sets the value of the '{@link darghex.parces.model.Promedios#getCalificacion <em>Calificacion</em>}' attribute.
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
   * Sets the value of the '{@link darghex.parces.model.Promedios#getPeriodo <em>Periodo</em>}' attribute.
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void promedio_acumulado()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }



} // Promedios
