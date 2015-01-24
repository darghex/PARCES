/**
 */
package darghex.parces.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import darghex.parces.clients.Client;
import darghex.parces.clients.EstudianteClient;
import darghex.parces.helpers.MessageManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propuesta Matricula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Permite almacenar las propuestas de matricula indicadas por el estudiante
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link darghex.parces.model.PropuestaMatricula#getAsignaturas <em>Asignaturas</em>}</li>
 *   <li>{@link darghex.parces.model.PropuestaMatricula#isAprobado <em>Aprobado</em>}</li>
 *   <li>{@link darghex.parces.model.PropuestaMatricula#getPeriodo <em>Periodo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropuestaMatricula
{
    /**
     * The cached value of the '{@link #getAsignaturas() <em>Asignaturas</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAsignaturas()
     * @generated
     * @ordered
     */
    protected List<Asignaturas> asignaturas;

    /**
     * The default value of the '{@link #isAprobado() <em>Aprobado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAprobado()
     * @generated
     * @ordered
     */
    protected static final boolean APROBADO_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAprobado() <em>Aprobado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAprobado()
     * @generated
     * @ordered
     */
    protected boolean aprobado = APROBADO_EDEFAULT;

    /**
     * The default value of the '{@link #getPeriodo() <em>Periodo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriodo()
     * @generated
     * @ordered
     */
    protected static final String PERIODO_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     *     Codigo de la propuesta de matricula
     * <!-- end-user-doc -->
     * @generated
     */
    private int codigo;

    /**
     * The cached value of the '{@link #getPeriodo() <em>Periodo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriodo()
     * @generated
     * @ordered
     */
    protected String periodo = PERIODO_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PropuestaMatricula()
    {
        super();
    }



    /**
     * Returns the value of the '<em><b>Asignaturas</b></em>' reference list.
     * The list contents are of type {@link darghex.parces.model.Asignaturas}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Asignaturas</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Asignaturas</em>' reference list.
     * @generated
     */
    public List<Asignaturas> getAsignaturas()
    {
        return asignaturas;
    }




    /**
     * Agrega una asignatura a la propuesta de matricula
     * @param new_asignatura Asignatura
     */
    public void addAsignatura( Asignaturas new_asignatura)
    {
        if (asignaturas == null)
        {
            asignaturas = new ArrayList<Asignaturas>();
        }
        asignaturas.add(new_asignatura);

    }

    /**
     * Returns the value of the '<em><b>Aprobado</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * Indica si el estudiante tiene  aprobado la propuesta de matricula
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aprobado</em>' attribute.
     * @see #setAprobado(boolean)
     * @generated
     */
    public boolean isAprobado()
    {
        return aprobado;
    }

    public static boolean isAprobado(String estudiante)
    {
        EstudianteClient c = new EstudianteClient();
        return c.get_estado_propuesta(estudiante);
    }

    /**
     * Sets the value of the '{@link darghex.parces.model.PropuestaMatricula#isAprobado <em>Aprobado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param newAprobado the new value of the '<em>Aprobado</em>' attribute.
     * @see #isAprobado()
     * @generated
     */
    public void setAprobado(boolean newAprobado)
    {
        aprobado = newAprobado;
    }

    /**
     * Returns the value of the '<em><b>Periodo</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Periodo</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Periodo</em>' attribute.
     * @see #setPeriodo(String)
     * @generated
     */
    public String getPeriodo()
    {
        return periodo;
    }

    /**
     * Sets the value of the '{@link darghex.parces.model.PropuestaMatricula#getPeriodo <em>Periodo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param newPeriodo the new value of the '<em>Periodo</em>' attribute.
     * @see #getPeriodo()
     * @generated
     */
    public void setPeriodo(String newPeriodo)
    {
        periodo = newPeriodo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int cargaAcademica()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    public void setCodigo(int new_codigo){
        this.codigo = new_codigo;
    }

    public int getCodigo(){
        return this.codigo;
    }

} // PropuestaMatricula