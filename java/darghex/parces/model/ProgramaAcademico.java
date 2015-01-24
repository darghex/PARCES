/**
 */
package darghex.parces.model;



import java.util.List;

import darghex.parces.clients.Client;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Programa Academico</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @generated
 */
public class ProgramaAcademico
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private int id ;
  private String name;

  private static List<ProgramaAcademico> programas;

    /**
     * Carga una lista de programas mediante un cliente de webService
     */
  public static void load(){
    if (programas == null) {
        Client c = new Client();
        programas = c.get_programas();
    }
  }

  public static List<ProgramaAcademico> getProgramas(){
     load();
     return programas;
  }

    @Override
    public String toString() {
        return this.name;
    }

    public int getId() {
        return id;
    }

  public void setId(int id){
      this.id = id;
  }

  public void setName(String name){
        this.name = name;
  }

}
