package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jeb0826
 */
public class ConsultasClientes extends Conexion {

    public boolean registrar(Cliente pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO clientes (id, nombres, apellidos , tipoIdentificacion, fechaNacimiento, numeroCelular, correoElectronico) VALUES(?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getId());
            ps.setString(2, pro.getNombres());
            ps.setString(3, pro.getApellidos());
            ps.setString(4, pro.getTipoIdentificacion());
            ps.setDate(5, pro.getFechaNacimiento());
            ps.setString(6, pro.getNumeroCelular());
            ps.setString(7, pro.getCorreoElectronico());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Cliente pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE clientes SET nombres=?, apellidos=? , tipoIdentificacion=?, fechaNacimiento=?, numeroCelular=?, correoElectronico=? WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombres());
            ps.setString(2, pro.getApellidos());
            ps.setString(3, pro.getTipoIdentificacion());
            ps.setDate(4, pro.getFechaNacimiento());
            ps.setString(5, pro.getNumeroCelular());
            ps.setString(6, pro.getCorreoElectronico());
            ps.setString(7, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Cliente pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM clientes WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Cliente pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM clientes WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(rs.getString("id"));
                pro.setNombres(rs.getString("nombres"));
                pro.setApellidos(rs.getString("apellidos"));
                pro.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                pro.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                pro.setNumeroCelular(rs.getString("numeroCelular"));
                pro.setCorreoElectronico(rs.getString("correoElectronico"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean tiposDocumentos(Tipos_documentos ts) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM tipos_documentos";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ts.setId(rs.getString("id"));
                ts.setTipos(rs.getString("tipos"));
                ts.setSiglas(rs.getString("siglas"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
        
     public boolean servicios(Servicios ts, Cliente pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM servicios where id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                ts.setId(rs.getString("id"));
                ts.setServicios(rs.getInt("servicio"));
                ts.setFechaInicio(rs.getDate("fechaInicio"));
                ts.setUltimaFacturacion(rs.getDate("ultimaFacturacion"));
                ts.setUltimoPago(rs.getInt("ultimoPago"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }   
        
}
