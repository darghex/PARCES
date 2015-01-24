/**
 */
package darghex.parces.model;

import java.util.List;

import darghex.parces.enumerators.CaracteristicasAsignatura;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asignaturas</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class Asignaturas
{
  /**
   * The default value of the '{@link #getCodigo() <em>Codigo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodigo()
   * @generated
   * @ordered
   */
  protected static final String CODIGO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCodigo() <em>Codigo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodigo()
   * @generated
   * @ordered
   */
  protected String codigo = CODIGO_EDEFAULT;

  /**
   * The default value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNombre()
   * @generated
   * @ordered
   */
  protected static final String NOMBRE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNombre() <em>Nombre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNombre()
   * @generated
   * @ordered
   */
  protected String nombre = NOMBRE_EDEFAULT;

  /**
   * The default value of the '{@link #getCreditos() <em>Creditos</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreditos()
   * @generated
   * @ordered
   */
  protected static final byte CREDITOS_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getCreditos() <em>Creditos</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreditos()
   * @generated
   * @ordered
   */
  protected byte creditos = CREDITOS_EDEFAULT;

  /**
   * The default value of the '{@link #getUbicacion_semestral() <em>Ubicacion semestral</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUbicacion_semestral()
   * @generated
   * @ordered
   */
  protected static final byte UBICACION_SEMESTRAL_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getUbicacion_semestral() <em>Ubicacion semestral</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUbicacion_semestral()
   * @generated
   * @ordered
   */
  protected byte ubicacion_semestral = UBICACION_SEMESTRAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getAsignaturas() <em>Asignaturas</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsignaturas()
   * @generated
   * @ordered
   */
  protected List<Asignaturas> asignaturas;

  /**
   * The cached value of the '{@link #getCaracteristicas() <em>Caracteristicas</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCaracteristicas()
   * @generated
   * @ordered
   */
  protected List<CaracteristicasAsignatura> caracteristicas;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Asignaturas()
  {
    super();
  }

  /**
   * Returns the value of the '<em><b>Codigo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Codigo</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Codigo</em>' attribute.
   * @see #setCodigo(String)
   * @generated
   */
  public String getCodigo()
  {
    return codigo;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Asignaturas#getCodigo <em>Codigo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newCodigo the new value of the '<em>Codigo</em>' attribute.
   * @see #getCodigo()
   * @generated
   */
  public void setCodigo(String newCodigo)
  {
    codigo = newCodigo;
  }

  /**
   * Returns the value of the '<em><b>Nombre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nombre</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nombre</em>' attribute.
   * @see #setNombre(String)
   * @generated
   */
  public String getNombre()
  {
    return nombre;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Asignaturas#getNombre <em>Nombre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newNombre the new value of the '<em>Nombre</em>' attribute.
   * @see #getNombre()
   * @generated
   */
  public void setNombre(String newNombre)
  {
    nombre = newNombre;
  }

  /**
   * Returns the value of the '<em><b>Creditos</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Creditos</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Creditos</em>' attribute.
   * @see #setCreditos(byte)
   * @generated
   */
  public byte getCreditos()
  {
    return creditos;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Asignaturas#getCreditos <em>Creditos</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newCreditos the new value of the '<em>Creditos</em>' attribute.
   * @see #getCreditos()
   * @generated
   */
  public void setCreditos(byte newCreditos)
  {
    creditos = newCreditos;
  }

  /**
   * Returns the value of the '<em><b>Ubicacion semestral</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ubicacion semestral</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ubicacion semestral</em>' attribute.
   * @see #setUbicacion_semestral(byte)
   * @generated
   */
  public byte getUbicacion_semestral()
  {
    return ubicacion_semestral;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Asignaturas#getUbicacion_semestral <em>Ubicacion semestral</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newUbicacion_semestral the new value of the '<em>Ubicacion semestral</em>' attribute.
   * @see #getUbicacion_semestral()
   * @generated
   */
  public void setUbicacion_semestral(byte newUbicacion_semestral)
  {
    ubicacion_semestral = newUbicacion_semestral;
  }

  /**
   * Returns the value of the '<em><b>Asignaturas</b></em>' reference list.
   * The list contents are of type {@link darghex.parces.model.Asignaturas}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asignaturas</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asignaturas</em>' reference list.
   * @generated
   */
  public List<Asignaturas> getAsignaturas()
  {
    if (asignaturas == null)
    {
     
    }
    return asignaturas;
  }

  /**
   * Returns the value of the '<em><b>Caracteristicas</b></em>' attribute list.
   * The list contents are of type {@link darghex.parces.enumerators.CaracteristicasAsignatura}.
   * The literals are from the enumeration {@link darghex.parces.enumerators.CaracteristicasAsignatura}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caracteristicas</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Caracteristicas</em>' attribute list.
   * @see darghex.parces.enumerators.CaracteristicasAsignatura
   * @generated
   */
  public List<CaracteristicasAsignatura> getCaracteristicas()
  {
    if (caracteristicas == null)
    {
    
    }
    return caracteristicas;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void tiene_predecesoras()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }



} // Asignaturas
