package uml;

/**
 *
 * @author bob_1
 */
public class Categoria {

    int id_categoria;
    String nombre_cate;

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre_cate) {
        this.id_categoria = id_categoria;
        this.nombre_cate = nombre_cate;
    }

    public Categoria(int idcate) {
       this.id_categoria = idcate;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_cate() {
        return nombre_cate;
    }

    public void setNombre_cate(String nombre_cate) {
        this.nombre_cate = nombre_cate;
    }

    @Override
    public String toString() {
        return nombre_cate;
    }
}
