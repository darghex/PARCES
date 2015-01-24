/**
 */
package darghex.parces.model;

import java.util.Collection;
import java.util.List;

import darghex.parces.clients.TutorClient;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tutor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class Tutor extends Usuario
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public List<Estudiante> estudiantes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tutor(int id)
  {
      super();
      this.setId(id);

  }

    public Tutor()
    {
        super();
    }



  /**
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Estudiante</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Estudiante</em>' reference list.
   * @generated
   */
  public List<Estudiante> getEstudiantes()
  {
    if (estudiantes == null)
    {
        TutorClient c = new TutorClient();
        estudiantes  = c.get_estudiantes(this.id);
  
    }
    return estudiantes;
  }

  

} // Tutor
