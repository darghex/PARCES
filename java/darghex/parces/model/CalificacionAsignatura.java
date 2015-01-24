/**
 */
package darghex.parces.model;

import darghex.parces.enumerators.TIpoNota;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calificacion Asignatura</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link darghex.parces.model.CalificacionAsignatura#getAsignaturas <em>Asignaturas</em>}</li>
 *   <li>{@link darghex.parces.model.CalificacionAsignatura#getCalificacion <em>Calificacion</em>}</li>
 *   <li>{@link darghex.parces.model.CalificacionAsignatura#getPeriodo <em>Periodo</em>}</li>
 *   <li>{@link darghex.parces.model.CalificacionAsignatura#getTipo_nota <em>Tipo nota</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalificacionAsignatura
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
   * The default value of the '{@link #getTipo_nota() <em>Tipo nota</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTipo_nota()
   * @generated
   * @ordered
   */
  protected static final TIpoNota TIPO_NOTA_EDEFAULT = TIpoNota.REGULAR;

  /**
   * The cached value of the '{@link #getTipo_nota() <em>Tipo nota</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTipo_nota()
   * @generated
   * @ordered
   */
  protected TIpoNota tipo_nota = TIPO_NOTA_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CalificacionAsignatura()
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
    if (asignaturas != null )
    {
      
    }
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
   * Sets the value of the '{@link darghex.parces.model.CalificacionAsignatura#getAsignaturas <em>Asignaturas</em>}' reference.
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
   * Sets the value of the '{@link darghex.parces.model.CalificacionAsignatura#getCalificacion <em>Calificacion</em>}' attribute.
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
   * Sets the value of the '{@link darghex.parces.model.CalificacionAsignatura#getPeriodo <em>Periodo</em>}' attribute.
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
   * Returns the value of the '<em><b>Tipo nota</b></em>' attribute.
   * The literals are from the enumeration {@link darghex.parces.enumerators.TIpoNota}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tipo nota</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tipo nota</em>' attribute.
   * @see darghex.parces.enumerators.TIpoNota
   * @see #setTipo_nota(TIpoNota)
   * @generated
   */
  public TIpoNota getTipo_nota()
  {
    return tipo_nota;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.CalificacionAsignatura#getTipo_nota <em>Tipo nota</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newTipo_nota the new value of the '<em>Tipo nota</em>' attribute.
   * @see darghex.parces.enumerators.TIpoNota
   * @see #getTipo_nota()
   * @generated
   */
  public void setTipo_nota(TIpoNota newTipo_nota)
  {
    tipo_nota = newTipo_nota == null ? TIPO_NOTA_EDEFAULT : newTipo_nota;
  }

 
} // CalificacionAsignatura
