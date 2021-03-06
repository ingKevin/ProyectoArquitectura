package arqSw.proyecto.Hibernate;
// Generated 3/03/2017 01:29:57 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int idCliente;
     private String usuario;
     private String password;
     private String ubicacion;
     private String formaPago;
     private Set<Venta> ventas = new HashSet<Venta>(0);

    public Cliente() {
    }

	
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public Cliente(int idCliente, String usuario, String password, String ubicacion, String formaPago, Set<Venta> ventas) {
       this.idCliente = idCliente;
       this.usuario = usuario;
       this.password = password;
       this.ubicacion = ubicacion;
       this.formaPago = formaPago;
       this.ventas = ventas;
    }
   
    public int getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public Set<Venta> getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }




}


