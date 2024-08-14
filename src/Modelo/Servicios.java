package Modelo;

import java.sql.Date;

/**
 *
 * @author JEB0826
 */
public class Servicios {
    private String id;
    private int servicio;
    private Date fechaInicio;
    private Date ultimaFacturacion;
    private int ultimoPago;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicios(int servicio) {
        this.servicio = servicio;
    }

     public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
     public Date getUltimaFacturacion() {
        return ultimaFacturacion;
    }

    public void setUltimaFacturacion(Date ultimaFacturacion) {
        this.ultimaFacturacion = ultimaFacturacion;
    }
    
     public int getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(int ultimoPago) {
        this.ultimoPago = ultimoPago;
    }
}
