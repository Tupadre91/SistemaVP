package uml;

/**
 *
 * @author bob_1
 */
public class Empresa {
    int id_empresa;
    String nombre_emp;
    String correo_emp;
    String contrasena_emp;
    int idcategoria_emp;
    int idestad_emp;

    public Empresa() {
    }

    public Empresa(int id_empresa, String nombre_emp, String correo_emp, String contrasena_emp, int idcategoria_emp, int idestad_emp) {
        this.id_empresa = id_empresa;
        this.nombre_emp = nombre_emp;
        this.correo_emp = correo_emp;
        this.contrasena_emp = contrasena_emp;
        this.idcategoria_emp = idcategoria_emp;
        this.idestad_emp = idestad_emp;
    }
    
    public Empresa(int parseInt, String string){
        this.id_empresa = id_empresa;
        this.nombre_emp = nombre_emp;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public String getCorreo_emp() {
        return correo_emp;
    }

    public void setCorreo_emp(String correo_emp) {
        this.correo_emp = correo_emp;
    }

    public String getContrasena_emp() {
        return contrasena_emp;
    }

    public void setContrasena_emp(String contrasena_emp) {
        this.contrasena_emp = contrasena_emp;
    }

    public int getIdcategoria_emp() {
        return idcategoria_emp;
    }

    public void setIdcategoria_emp(int idcategoria_emp) {
        this.idcategoria_emp = idcategoria_emp;
    }

    public int getIdestad_emp() {
        return idestad_emp;
    }

    public void setIdestad_emp(int idestad_emp) {
        this.idestad_emp = idestad_emp;
    }
    
    
    
}
