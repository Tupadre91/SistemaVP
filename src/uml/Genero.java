package uml;

/**
 *
 * @author bob_1
 */
public class Genero {
    int id_genero;
    String nombre_genero;

    public Genero() {
    }

    public Genero(int id_genero, String nombre_genero) {
        this.id_genero = id_genero;
        this.nombre_genero = nombre_genero;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }

    @Override
    public String toString() {
        return nombre_genero;
    }
}
