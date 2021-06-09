package dao;

import clases.Credenciales;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import uml.Usuarios;

/**
 *
 * @author bob_1
 */
public class DAOUsuarios implements Operaciones {

    Usuarios usr = new Usuarios();
    Credenciales bd = new Credenciales();
    List<Usuarios> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    public Statement sentencia;

    @Override
    public boolean Insertar(Object obj) {
        this.usr = (Usuarios) obj;
        this.sql = "insert into usuario (nombre_usu, edad_usu, correo_usu, contrasena_usu, genero_usu, idtipo_usu, idestado_usu, idprofesion_usu)"
                + "values(?,?,?,?,?,?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, this.usr.getNombre_usu());
            this.pst.setInt(2, this.usr.getEdad_usu());
            this.pst.setString(3, this.usr.getCorreo_usu());
            this.pst.setString(4, this.usr.getContrasena_usu());
            this.pst.setInt(5, this.usr.getGenero_usu());
            this.pst.setInt(6, this.usr.getIdtipo_usu());
            this.pst.setInt(7, this.usr.getIdestado_usu());
            this.pst.setInt(8, this.usr.getIdprofesion_usu());
            int filas = this.pst.executeUpdate();
            this.con.close();
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuarios> Seleccionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Login(Usuarios usr) {

        this.usr = (Usuarios) usr;
        this.sql = "Select correo_usu, contrasena_usu, idtipo_usu from usuario where correo_usu = ?";

        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, this.usr.getCorreo_usu());
            this.rs = pst.executeQuery();

            if (rs.next()) {
                if (this.usr.getContrasena_usu().equals(this.rs.getString(2))) {
                    this.usr.setIdtipo_usu(rs.getInt(3));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
