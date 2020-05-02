package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{         
        String accion = request.getParameter("accion");
        if(accion != null){
            switch (accion){
                case "editar":
                    editarCliente(request, response);
                    break;
                case "eliminar":
                    eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }                
        }else{
            this.accionDefault(request, response);                    
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if(accion != null){
            switch (accion){
                case "insertar":
                    insertarCliente(request, response);
                    break;
                case "modificar":
                    modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }                
        }else{
            this.accionDefault(request, response);                    
        }
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        List <Cliente> clientes = new ClienteDaoJDBC().listar();                    
        System.out.println("clientes: "+ clientes);
        sesion.setAttribute("clientes", clientes); 
        sesion.setAttribute("totalClientes", clientes.size()); 
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }
    
    private double calcularSaldoTotal(List <Cliente> clientes){
        double saldoTotal=0;
        for(Cliente cliente: clientes){
            saldoTotal+=cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        if(request.getParameter("saldo")!=null && !request.getParameter("saldo").equals("")){
            saldo = Double.parseDouble(request.getParameter("saldo"));            
        }        
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        int rows = new ClienteDaoJDBC().insert(cliente);
        System.out.println("resgistro modificados: " + rows);
        
        this.accionDefault(request, response);
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        if(request.getParameter("saldo")!=null && !request.getParameter("saldo").equals("")){
            saldo = Double.parseDouble(request.getParameter("saldo"));            
        }        
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        int rows = new ClienteDaoJDBC().update(cliente);
        System.out.println("resgistro modificados: " + rows);
        
        this.accionDefault(request, response);
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));        
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);        
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));        
        int rows = new ClienteDaoJDBC().delete(new Cliente(idCliente));
        this.accionDefault(request, response);
    }     
}

