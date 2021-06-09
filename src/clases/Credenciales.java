package clases;

/**
 * Nombre de la clase: Credenciales
 * version: 1.0
 * fecha: 4/06/2021
 * Copyright: ITCA-FEPADE
 * @author Ivan Alexander Osorio Tobar 020320
 * @author Jose Roberto Aragón Lopez 022120
 * @author Jonathan Cunza 
 */
public class Credenciales {
    String driver;
    String url;
    String user;
    String password;

    public Credenciales() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/base_svp";
        this.user = "root";
        this.password = "";
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
