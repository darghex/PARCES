/**
 */
package darghex.parces.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import darghex.parces.clients.Client;
import darghex.parces.helpers.ConvertidorCadena;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usuario</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public abstract class Usuario
{
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
   * The default value of the '{@link #getNombres() <em>Nombres</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNombres()
   * @generated
   * @ordered
   */
  protected static final String NOMBRES_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNombres() <em>Nombres</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNombres()
   * @generated
   * @ordered
   */
  protected String nombres = NOMBRES_EDEFAULT;

  /**
   * The default value of the '{@link #getApellidos() <em>Apellidos</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApellidos()
   * @generated
   * @ordered
   */
  protected static final String APELLIDOS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getApellidos() <em>Apellidos</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApellidos()
   * @generated
   * @ordered
   */
  protected String apellidos = APELLIDOS_EDEFAULT;

  /**
   * The default value of the '{@link #getTelefono() <em>Telefono</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTelefono()
   * @generated
   * @ordered
   */
  protected static final String TELEFONO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTelefono() <em>Telefono</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTelefono()
   * @generated
   * @ordered
   */
  protected String telefono = TELEFONO_EDEFAULT;

  /**
   * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected static final String EMAIL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected String email = EMAIL_EDEFAULT;

  /**
   * The default value of the '{@link #getDni() <em>Dni</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDni()
   * @generated
   * @ordered
   */
  protected static final String DNI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDni() <em>Dni</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDni()
   * @generated
   * @ordered
   */
  protected String dni = DNI_EDEFAULT;

  /**
   * The default value of the '{@link #getFoto() <em>Foto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoto()
   * @generated
   * @ordered
   */
  protected static final String FOTO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFoto() <em>Foto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoto()
   * @generated
   * @ordered
   */
  protected String foto = FOTO_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Usuario()
  {
    super();
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
   *
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   */
  public void setId(int newId)
  {
    id = newId;
  }

  /**
   * Returns the value of the '<em><b>Nombres</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nombres</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nombres</em>' attribute.
   * @see #setNombres(String)
   * @generated
   */
  public String getNombres()
  {
    return nombres;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNombres()
   * @generated
   */
  public void setNombres(String newNombres)
  {
    nombres = newNombres;
  }

  /**
   * Returns the value of the '<em><b>Apellidos</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Apellidos</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Apellidos</em>' attribute.
   * @see #setApellidos(String)
   * @generated
   */
  public String getApellidos()
  {
    return apellidos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApellidos()
   * @generated
   */
  public void setApellidos(String newApellidos)
  {
    apellidos = newApellidos;
  }

  /**
   * Returns the value of the '<em><b>Telefono</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Telefono</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Telefono</em>' attribute.
   * @see #setTelefono(String)
   * @generated
   */
  public String getTelefono()
  {
    return telefono;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTelefono()
   * @generated
   */
  public void setTelefono(String newTelefono)
  {
    telefono = newTelefono;
  }

  /**
   * Returns the value of the '<em><b>Email</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Email</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Email</em>' attribute.
   * @see #setEmail(String)
   * @generated
   */
  public String getEmail()
  {
    return email;
  }

  /**

   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   */
  public void setEmail(String newEmail)
  {
    email = newEmail;
  }

  /**
   * Returns the value of the '<em><b>Dni</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dni</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dni</em>' attribute.
   * @see #setDni(String)
   * @generated
   */
  public String getDni()
  {
    return dni;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDni()
   * @generated
   */
  public void setDni(String newDni)
  {
    dni = newDni;
  }

  /**
   * Returns the value of the '<em><b>Foto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foto</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foto</em>' attribute.
   * @see #setFoto(String)
   * @generated
   */
  public String getFoto()
  {
    return foto;
  }

    /**
     * Retorna un mapa de bits de la foto de la url indicada atributo foto
     * @return Bitmap
     */
  public Bitmap getImageFoto()  {
      Bitmap imagen = null;
      Client c = new Client();
      try {
          imagen =c.HTTPImage(this.getFoto());
      } catch (Exception e) {
          imagen = null;
      }
      return imagen;

  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoto()
   * @generated
   */
  public void setFoto(String newFoto)
  {
    foto = newFoto;
  }

  /**
    * Retorna el nombre compleeto del usuario
    * @return String
  */
  public String getFullName(){
    return ConvertidorCadena.a_minuscula(getNombres() +  " " + getApellidos());
  }


} // Usuario
