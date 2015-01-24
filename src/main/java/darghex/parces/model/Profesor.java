/**
 */
package darghex.parces.model;

import java.util.Collection;
import java.util.List;

import darghex.parces.clients.ProfesorClient;
import darghex.parces.clients.TutorClient;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profesor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Profesor extends Usuario
{
  /**
   * The cached value of the '{@link #getCursos() <em>Cursos</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCursos()
   * @generated
   * @ordered
   */
  protected List<Curso> cursos;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Profesor( int id)
  {
    super();
      this.setId(id);
  }

    public Profesor( )
    {
        super();
    }

 /**
   * Returns the value of the '<em><b>Cursos</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cursos</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cursos</em>' reference list.
   * @generated
   */
  public List<Curso> getCursos()
  {
    if (cursos == null)
    {
        ProfesorClient c = new ProfesorClient();
        cursos  = c.get_cursos(this.id);
    }
    return cursos;
  }



} // Profesor
