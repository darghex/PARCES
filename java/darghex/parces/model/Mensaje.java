package darghex.parces.model;

import java.util.Date;

/**
 * Estructura de un Mensaje para el envio y recepcion del mismo
 */
public class Mensaje {

    private String autor;
    private String mensaje;
    private String fecha;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }
}
