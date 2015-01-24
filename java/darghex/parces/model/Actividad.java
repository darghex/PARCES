/**
 */
package darghex.parces.model;

import java.lang.Object;
import java.util.Date;
import java.util.List;

import darghex.parces.clients.EstudianteClient;
import darghex.parces.clients.ProfesorClient;

/**
 * <!-- begin-user-doc -->
 * Representacion del modelo '<em><b>Actividad</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class Actividad
{
  /**
   * The default value of the '{@link #getDescripcion() <em>Descripcion</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescripcion()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPCION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescripcion() <em>Descripcion</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescripcion()
   * @generated
   * @ordered
   */
  protected String descripcion = DESCRIPCION_EDEFAULT;

  protected int id = 0;

  /**
   * The cached value of the '{@link #getCalificacionParcial() <em>Calificacion Parcial</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalificacionParcial()
   * @generated
   * @ordered
   */
  protected CalificacionParcial calificacionParcial;




    private static List<Actividad> actividades;


    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Actividad()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
 

  /**
   * Returns the value of the '<em><b>Descripcion</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Descripcion</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Descripcion</em>' attribute.
   * @see #setDescripcion(String)
   * @generated
   */
  public String getDescripcion()
  {
    return descripcion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newDescripcion nuevo valor para el atributo '<em>Descripcion</em>'
   * @see #getDescripcion()
   * @generated
   */
  public void setDescripcion(String newDescripcion)
  {
    descripcion = newDescripcion;
  }

  /**
   * Returns the value of the '<em><b>Calificacion Parcial</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Calificacion Parcial</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Calificacion Parcial</em>' reference.
   * @see #setCalificacionParcial(CalificacionParcial)
   * @generated
   */
  public CalificacionParcial getCalificacionParcial()
  {
    if (calificacionParcial != null )
    {
      Object oldCalificacionParcial = (Object)calificacionParcial;
      calificacionParcial = (CalificacionParcial)oldCalificacionParcial;
      if (calificacionParcial != oldCalificacionParcial)
      {
      }
    }
    return calificacionParcial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CalificacionParcial basicGetCalificacionParcial()
  {
    return calificacionParcial;
  }

  /**
   * Sets the value of the '{@link darghex.parces.model.Actividad#getCalificacionParcial <em>Calificacion Parcial</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param newCalificacionParcial the new value of the '<em>Calificacion Parcial</em>' reference.
   * @see #getCalificacionParcial()
   * @generated
   */
  public void setCalificacionParcial(CalificacionParcial newCalificacionParcial)
  {
    calificacionParcial = newCalificacionParcial;
  }


    private static void  load(String estudiante, int instancia){

        EstudianteClient c = new EstudianteClient();
        actividades = c.get_actividades(estudiante, instancia);

    }


    public static List<Actividad> getActividades (String estudiante, int instancia){
        load(estudiante, instancia);
        return actividades;
    }

    public static List<Actividad> getActividades ( int instancia){
        ProfesorClient c = new ProfesorClient();
        return c.get_actividades( instancia);

    }

    public int getId(){
        return this.id;
    }

    public void setId(int new_id){
        this.id = new_id;
    }


} // Actividad
