package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {
    private static final String SQL_SELECT = "SELECT * FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM cliente WHERE id_cliente = ?";
    private static final String SQL_INSERT  = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";
    
    public List<Cliente> listar(){
        Connection conn =null;
        PreparedStatement stmt= null;
        ResultSet rs= null;        
        List<Cliente> clientes = new ArrayList();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);  
            rs = stmt.executeQuery();        
            while(rs.next()){
                Cliente cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), 
                        rs.getString("email"), rs.getString("telefono"), rs.getDouble("saldo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return clientes;
    }
    
    public Cliente encontrar(Cliente cliente){
        Connection conn =null;
        PreparedStatement stmt= null;
        ResultSet rs= null; 
         try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);  
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();                    
            rs.absolute(1);//nos pocionamos en el primer registro devuelto
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setSaldo(rs.getDouble("saldo"));            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }         
        return cliente;
    }
    
    public int insert(Cliente cliente){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
         try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
         return rows;
    }
    
    public int update(Cliente cliente){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
         return rows;
    }
    
    public int delete(Cliente cliente){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
         try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);                        
            stmt.setInt(1, cliente.getIdCliente());
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
         return rows;
    }
}
