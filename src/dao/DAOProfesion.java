
package dao;

import clases.Credenciales;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import uml.Empresa;
import uml.Profesion;

/**
 * Nombre de la clase: Credenciales
 * version: 1.0
 * fecha: 4/06/2021
 * Copyright: ITCA-FEPADE
 * @author Ivan Alexander Osorio Tobar 020320
 * @author Jose Roberto Aragón Lopez 022120
 * @author Jonathan Cunza 
 */
public class DAOProfesion implements Operaciones{
    
    Profesion prf = new Profesion();
    Credenciales bd = new Credenciales();
    List<Profesion> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    public Statement sentencia;

    @Override
    public boolean Insertar(Object obj) {
        this.prf = (Profesion)obj;
        this.sql = "INSERT INTO profesion(nombre_prof) values (?)";
        try{
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, this.prf.getNombre_prof());
            int filas = this.pst.executeUpdate();
            this.con.close();
            if (filas>0) {
                return true;
            }else{
                return false;
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean Eliminar(Object obj) {
        this.prf = (Profesion)obj;
        this.sql = "delete from profesion where id_profesion = ?";
        try{
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, this.prf.getId_profesion());
            int filas = this.pst.executeUpdate();
            this.con.close();
            if (filas>0) {
                return true;
            }else{
                return false;
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean Modificar(Object obj) {
        this.prf = (Profesion)obj;
        this.sql = "update profesion set nombre_prof = ? where id_profesion = ?";
        try{
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, this.prf.getNombre_prof());
            this.pst.setInt(2, this.prf.getId_profesion());
            int filas = this.pst.executeUpdate();
            this.con.close();
            if (filas>0) {
                return true;
            }else{
                return false;
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public List<Profesion> Seleccionar() {
        this.sql = "select * from profesion";
        try{
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                data.add(new Profesion(this.rs.getInt("id_profesion"),
                        this.rs.getString("nombre_prof"),
                        this.rs.getInt("demanda_prof")));
            }
            this.con.close();
            this.rs.close();
            
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        return this.data;
    }
    
     public void LlenarCmb(JComboBox cmb_profesion) {
        try {
            Conectar();
            this.sql = "select id_profesion, nombre_prof from profesion";
            this.rs = sentencia.executeQuery(this.sql);
            cmb_profesion.addItem("Seleccione una profesion");
            while (this.rs.next()) {
                cmb_profesion.addItem(new Profesion(Integer.parseInt(this.rs.getString("id_profesion")), this.rs.getString("nombre_prof")));
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
