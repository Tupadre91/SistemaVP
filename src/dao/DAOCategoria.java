/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import uml.Categoria;
import uml.Empresa;

/**
 *
 * @author bob_1
 */
public class DAOCategoria implements Operaciones {

    Categoria emp = new Categoria();
    Credenciales bd = new Credenciales();
    List<Categoria> data = new ArrayList<>();
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
    public List<Categoria> Seleccionar() {
        this.sql = "SELECT * FROM categoria";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                data.add(new Categoria(this.rs.getInt("id_categoria"),
                        this.rs.getString("nombre_cate")));
            }
            this.con.close();
            this.rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.data;
    }

    public void LlenarCmb(JComboBox cmb_categoria) {
        try {
            Conectar();
            this.sql = "select id_categoria, nombre_cate from categoria";
            this.rs = sentencia.executeQuery(this.sql);
            cmb_categoria.addItem("Seleccione una categoria");
            while (this.rs.next()) {
                cmb_categoria.addItem(new Categoria(Integer.parseInt(this.rs.getString("id_categoria")),this.rs.getString("nombre_cate")));
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
