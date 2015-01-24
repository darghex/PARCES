/**
 */
package darghex.parces.enumerators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Servicios Bienestar</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @generated
 */
public enum ServiciosBienestar
{
  /**
   * The '<em><b>PSICOLOGIA</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PSICOLOGIA_VALUE
   * @generated
   * @ordered
   */
  PSICOLOGIA(0, "PSICOLOGIA", "PSICOLOGIA"),

  /**
   * The '<em><b>MEDICINA GENERAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MEDICINA_GENERAL_VALUE
   * @generated
   * @ordered
   */
  MEDICINA_GENERAL(1, "MEDICINA_GENERAL", "MEDICINA_GENERAL"),

  /**
   * The '<em><b>ODONTOLOGIA</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ODONTOLOGIA_VALUE
   * @generated
   * @ordered
   */
  ODONTOLOGIA(2, "ODONTOLOGIA", "ODONTOLOGIA"),

  /**
   * The '<em><b>ESPIRITUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ESPIRITUAL_VALUE
   * @generated
   * @ordered
   */
  ESPIRITUAL(3, "ESPIRITUAL", "ESPIRITUAL");

  /**
   * The '<em><b>PSICOLOGIA</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PSICOLOGIA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PSICOLOGIA
   * @generated
   * @ordered
   */
  public static final int PSICOLOGIA_VALUE = 0;

  /**
   * The '<em><b>MEDICINA GENERAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MEDICINA GENERAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MEDICINA_GENERAL
   * @generated
   * @ordered
   */
  public static final int MEDICINA_GENERAL_VALUE = 1;

  /**
   * The '<em><b>ODONTOLOGIA</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ODONTOLOGIA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ODONTOLOGIA
   * @generated
   * @ordered
   */
  public static final int ODONTOLOGIA_VALUE = 2;

  /**
   * The '<em><b>ESPIRITUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ESPIRITUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ESPIRITUAL
   * @generated
   * @ordered
   */
  public static final int ESPIRITUAL_VALUE = 3;

  /**
   * An array of all the '<em><b>Servicios Bienestar</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ServiciosBienestar[] VALUES_ARRAY =
    new ServiciosBienestar[]
    {
      PSICOLOGIA,
      MEDICINA_GENERAL,
      ODONTOLOGIA,
      ESPIRITUAL,
    };

  /**
   * A public read-only list of all the '<em><b>Servicios Bienestar</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ServiciosBienestar> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Servicios Bienestar</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ServiciosBienestar get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ServiciosBienestar result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Servicios Bienestar</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ServiciosBienestar getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ServiciosBienestar result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Servicios Bienestar</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ServiciosBienestar get(int value)
  {
    switch (value)
    {
      case PSICOLOGIA_VALUE: return PSICOLOGIA;
      case MEDICINA_GENERAL_VALUE: return MEDICINA_GENERAL;
      case ODONTOLOGIA_VALUE: return ODONTOLOGIA;
      case ESPIRITUAL_VALUE: return ESPIRITUAL;
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
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ServiciosBienestar(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //ServiciosBienestar
