/**
 */
package darghex.parces.enumerators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Caracteristicas Asignatura</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @generated
 */
public enum CaracteristicasAsignatura 
{
  /**
   * The '<em><b>HABILITABLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HABILITABLE_VALUE
   * @generated
   * @ordered
   */
  HABILITABLE(0),

  /**
   * The '<em><b>VALIDABLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VALIDABLE_VALUE
   * @generated
   * @ordered
   */
  VALIDABLE(1),

  /**
   * The '<em><b>HOMOLOGABLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HOMOLOGABLE_VALUE
   * @generated
   * @ordered
   */
  HOMOLOGABLE(2);

  /**
   * The '<em><b>HABILITABLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HABILITABLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HABILITABLE
   * @generated
   * @ordered
   */
  public static final int HABILITABLE_VALUE = 0;

  /**
   * The '<em><b>VALIDABLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VALIDABLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VALIDABLE
   * @generated
   * @ordered
   */
  public static final int VALIDABLE_VALUE = 1;

  /**
   * The '<em><b>HOMOLOGABLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HOMOLOGABLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HOMOLOGABLE
   * @generated
   * @ordered
   */
  public static final int HOMOLOGABLE_VALUE = 2;

  /**
   * An array of all the '<em><b>Caracteristicas Asignatura</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final CaracteristicasAsignatura[] VALUES_ARRAY =
    new CaracteristicasAsignatura[]
    {
      HABILITABLE,
      VALIDABLE,
      HOMOLOGABLE,
    };

  /**
   * A public read-only list of all the '<em><b>Caracteristicas Asignatura</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<CaracteristicasAsignatura> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Caracteristicas Asignatura</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CaracteristicasAsignatura get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CaracteristicasAsignatura result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Caracteristicas Asignatura</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CaracteristicasAsignatura get(int value)
  {
    switch (value)
    {
      case HABILITABLE_VALUE: return HABILITABLE;
      case VALIDABLE_VALUE: return VALIDABLE;
      case HOMOLOGABLE_VALUE: return HOMOLOGABLE;
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final boolean activo = true;

  
  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private CaracteristicasAsignatura(int value)
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

  
    
} //CaracteristicasAsignatura
