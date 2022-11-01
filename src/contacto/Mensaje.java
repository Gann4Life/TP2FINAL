package contacto;

import java.util.Date;

public class Mensaje {
    private String titulo;
    private String descripcion;
    private Date fechaEnvio;

    public Mensaje(String titulo, String description) {
        this.titulo = titulo;
        this.descripcion = description;
        fechaEnvio = new Date();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }
}
