/**
 * Interfaz para el envio de mensajes
 */
package darghex.parces.helpers;


import java.util.List;

import darghex.parces.model.Mensaje;
import darghex.parces.model.Usuario;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IMessage Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public interface IMessageManager
{
  /**
   * <!-- begin-user-doc -->
   *     Metodo para escribir un mensaje
   * <!-- end-user-doc -->
   * @param mensaje Cuerpo del mensaje
   * @param user Nombre del usuario emisor
   * @param id identificador del mensaje
   * @generated
   */
  boolean escribir(String mensaje, String user, int id);

  /**
   * <!-- begin-user-doc -->
   *  Obtiene los mensajes
   * <!-- end-user-doc -->
   * @param id identificador del mensaje
   * @generated
   */
  List<Mensaje> leer(int id);

} // IMessageManager
