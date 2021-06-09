package dao;

import clases.Credenciales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import uml.Genero;

/**
 *
 * @author bob_1
 */
public class DAOGenero implements Operaciones {

    Genero usr = new Genero();
    Credenciales bd = new Credenciales();
    List<Genero> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    public Statement sentencia;

    @Override
    public boolean Insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Genero> Seleccionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void LlenarCmb(JComboBox cmb_genero) {
        try {
            Conectar();
            this.sql = "select id_genero, nombre_gen from genero";
            this.rs = sentencia.executeQuery(this.sql);
            cmb_genero.addItem("Seleccione un genero");
            while (this.rs.next()) {
                cmb_genero.addItem(new Genero(Integer.parseInt(this.rs.getString("id_genero")), this.rs.getString("nombre_gen")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void Conectar() {
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            sentencia = this.con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
