/**
 */
package darghex.parces.enumerators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Corte</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @generated
 */
public enum Perfil
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  ESTUDIANTE(1),

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  PROFESOR(2),

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  TUTOR(3);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ESTUDIANTE_VALUE = 1;

  /**
   * @generated
   * @ordered
   */
  public static final int PROFESOR_VALUE = 2;

  /**
   * @generated
   * @ordered
   */
  public static final int TUTOR_VALUE = 3;


  /**
   * Returns the '<em><b>Corte</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Perfil get(int value)
  {
    switch (value)
    {
      case ESTUDIANTE_VALUE: return ESTUDIANTE;
      case PROFESOR_VALUE: return PROFESOR;
      case TUTOR_VALUE: return TUTOR;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;


  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private Perfil(int value)
  {
    this.value = value;

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }


  
} //Corte
