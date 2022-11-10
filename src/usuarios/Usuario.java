package usuarios;

import enums.Genero;

public abstract class Usuario {
    protected int id;
    public String nombre;
    public String apellido;
    public String cuit;
    public int idEntidadDeFinanciacion;

    public Contacto contacto;



    public abstract int getId();
}
