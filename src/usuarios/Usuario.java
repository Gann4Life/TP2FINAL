package usuarios;

public abstract class Usuario {
    private int id;
    public String[] nombres;
    public String[] apellidos;
    public Genero genero;
    public String cuit;
    public int idEntidadDeFinanciacion;

    public Contacto contacto;



    public int getId() {
        return id;
    }
}
