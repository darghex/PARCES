/**
 */
package darghex.parces.enumerators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>TIpo Nota</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @generated
 */
public enum TIpoNota 
{
  /**
   * The '<em><b>REGULAR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REGULAR_VALUE
   * @generated
   * @ordered
   */
  REGULAR(0, "REGULAR", "REGULAR"),

  /**
   * The '<em><b>HABILITACION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HABILITACION_VALUE
   * @generated
   * @ordered
   */
  HABILITACION(1, "HABILITACION", "HABILITACION"),

  /**
   * The '<em><b>VALIDACION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VALIDACION_VALUE
   * @generated
   * @ordered
   */
  VALIDACION(2, "VALIDACION", "VALIDACION"),

  /**
   * The '<em><b>HOMOLOGACION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HOMOLOGACION_VALUE
   * @generated
   * @ordered
   */
  HOMOLOGACION(3, "HOMOLOGACION", "HOMOLOGACION"),

  /**
   * The '<em><b>CURSO VACACIONAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CURSO_VACACIONAL_VALUE
   * @generated
   * @ordered
   */
  CURSO_VACACIONAL(4, "CURSO_VACACIONAL", "CURSO_VACACIONAL");

  /**
   * The '<em><b>REGULAR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REGULAR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REGULAR
   * @generated
   * @ordered
   */
  public static final int REGULAR_VALUE = 0;

  /**
   * The '<em><b>HABILITACION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HABILITACION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HABILITACION
   * @generated
   * @ordered
   */
  public static final int HABILITACION_VALUE = 1;

  /**
   * The '<em><b>VALIDACION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VALIDACION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VALIDACION
   * @generated
   * @ordered
   */
  public static final int VALIDACION_VALUE = 2;

  /**
   * The '<em><b>HOMOLOGACION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HOMOLOGACION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HOMOLOGACION
   * @generated
   * @ordered
   */
  public static final int HOMOLOGACION_VALUE = 3;

  /**
   * The '<em><b>CURSO VACACIONAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CURSO VACACIONAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CURSO_VACACIONAL
   * @generated
   * @ordered
   */
  public static final int CURSO_VACACIONAL_VALUE = 4;

  /**
   * An array of all the '<em><b>TIpo Nota</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final TIpoNota[] VALUES_ARRAY =
    new TIpoNota[]
    {
      REGULAR,
      HABILITACION,
      VALIDACION,
      HOMOLOGACION,
      CURSO_VACACIONAL,
    };

  /**
   * A public read-only list of all the '<em><b>TIpo Nota</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<TIpoNota> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>TIpo Nota</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TIpoNota get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TIpoNota result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>TIpo Nota</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TIpoNota getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      TIpoNota result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>TIpo Nota</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TIpoNota get(int value)
  {
    switch (value)
    {
      case REGULAR_VALUE: return REGULAR;
      case HABILITACION_VALUE: return HABILITACION;
      case VALIDACION_VALUE: return VALIDACION;
      case HOMOLOGACION_VALUE: return HOMOLOGACION;
      case CURSO_VACACIONAL_VALUE: return CURSO_VACACIONAL;
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
  private TIpoNota(int value, String name, String literal)
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
  
} //TIpoNota
