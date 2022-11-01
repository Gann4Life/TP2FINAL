package usuarios;

import java.util.List;

public abstract class Usuario {
    private int id;
    public List<String> nombres;
    public List<String> apellidos;
    public Genero genero;
    public String cuit;
    public int idEntidadDeFinanciacion;

    public Contacto contacto;



    public int getId() {
        return id;
    }

    /*
    -id: int
    +nombres List<String>
    +apellidos: List<String>
    +genero: Genero
    +cuit: int

    +idEntidadDeFinanciacion: int

    +contacto: Contacto
    +getId(): int
 */
}
