package crudmvc;

import Controlador.Servicio;
import Modelo.ConsultasClientes;
import Modelo.Cliente;
import Modelo.Servicios;
import Vista.frmClientes;

/**
 *
 * @author JEB0826
 */
public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cliente mod = new Cliente();
        Servicios ser = new Servicios();
        ConsultasClientes modC = new ConsultasClientes();
        frmClientes frm = new frmClientes();

        Servicio ctrl = new Servicio(mod, ser, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
