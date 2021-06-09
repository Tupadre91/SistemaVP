package uml;

/**
 * Nombre de la clase: Credenciales version: 1.0 fecha: 4/06/2021 Copyright:
 * ITCA-FEPADE
 *
 * @author Ivan Alexander Osorio Tobar 020320
 * @author Jose Roberto Aragón Lopez 022120
 * @author Jonathan Cunza
 */
public class Profesion {

    int id_profesion;
    String nombre_prof;
    int demanda_prof;

    public Profesion() {
    }

    public Profesion(int id_profesion, String nombre_prof, int demanda_prof) {
        this.id_profesion = id_profesion;
        this.nombre_prof = nombre_prof;
        this.demanda_prof = demanda_prof;
    }

    public Profesion(int parseInt, String string) {
        this.id_profesion = id_profesion;
        this.nombre_prof = nombre_prof;
    }

    public int getId_profesion() {
        return id_profesion;
    }

    public void setId_profesion(int id_profesion) {
        this.id_profesion = id_profesion;
    }

    public String getNombre_prof() {
        return nombre_prof;
    }

    public void setNombre_prof(String nombre_prof) {
        this.nombre_prof = nombre_prof;
    }

    public int getDemanda_prof() {
        return demanda_prof;
    }

    public void setDemanda_prof(int demanda_prof) {
        this.demanda_prof = demanda_prof;
    }

}
