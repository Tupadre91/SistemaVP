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
import uml.Empresa;

/**
 *
 * @author bob_1
 */
public class DAOEmpresa implements Operaciones {

    Empresa emp = new Empresa();
    Credenciales bd = new Credenciales();
    List<Empresa> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    public Statement sentencia;

    @Override
    public boolean Insertar(Object obj) {
        this.emp = (Empresa) obj;
        this.sql = "INSERT INTO empresa(nombre_emp, correo_emp, contrasena_emp, idcategoria_emp, idestado_emp) values (?,?,?,?,?)";

        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            
            this.pst.setString(1, this.emp.getNombre_emp());
            this.pst.setString(2, this.emp.getCorreo_emp());
            this.pst.setString(3, this.emp.getContrasena_emp());
            this.pst.setInt(4, this.emp.getIdcategoria_emp());
            this.pst.setInt(5, this.emp.getIdestad_emp());
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            if (filas>0) {
                return true;
            }else{
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
    public List<Empresa> Seleccionar() {
        this.sql = "SELECT * FROM empresa";
        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while (this.rs.next()) {
                data.add(new Empresa(this.rs.getInt("id_empresa"),
                        this.rs.getString("nombre_emp"),
                        this.rs.getString("correo_emp"),
                        this.rs.getString("contrasena_emp"),
                        this.rs.getInt("idcategorai_emp"),
                        this.rs.getInt("idestado_emp")));
            }
            this.con.close();
            this.rs.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.data;
    }

    public void LlenarCmb(JComboBox cmb_empresa) {
        try {
            Conectar();
            this.sql = "select id_empresa, nombre_emp from empresa";
            this.rs = sentencia.executeQuery(this.sql);
            cmb_empresa.addItem("Seleccione una empresa");
            while (this.rs.next()) {
                cmb_empresa.addItem(new Empresa(Integer.parseInt(this.rs.getString("id_empresa")), this.rs.getString("nombre_emp")));
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
    
    public boolean Login(Empresa emp) {

        this.emp = (Empresa) emp;
        this.sql = "Select correo_emp, contrasena_emp, idcategoria_emp from empresa where correo_emp = ?";

        try {
            Class.forName(bd.getDriver());
            this.con = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPassword());
            this.pst = this.con.prepareStatement(sql);
            this.pst.setString(1, this.emp.getCorreo_emp());
            this.rs = pst.executeQuery();

            
            if (rs.next()) {
                if (this.emp.getContrasena_emp().equals(this.rs.getString(2))) {
                    this.emp.setIdcategoria_emp(rs.getInt(3));
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
