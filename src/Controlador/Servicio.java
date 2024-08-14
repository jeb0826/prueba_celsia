package Controlador;

import Modelo.ConsultasClientes;
import Modelo.Cliente;
import Modelo.Servicios;
import Vista.frmClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jeb0826
 */
public class Servicio implements ActionListener {

    private final Cliente cliente_celsia;
    private final Servicios servicios_celsia;
    private final ConsultasClientes consultas;
    private final frmClientes vista;

    public Servicio(Cliente cliente_celsia, Servicios servicios_celsia, ConsultasClientes consultas, frmClientes vista) {
        this.cliente_celsia = cliente_celsia;
        this.servicios_celsia = servicios_celsia;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Clientes");
        vista.setLocationRelativeTo(null);
        vista.txtCodigo.setVisible(true);
        vista.jComboBox2.setVisible(false);
        vista.jTextField1.setVisible(false);
        vista.jTextField2.setVisible(false);
        vista.jTextField3.setVisible(false);
        vista.jLabel3.setVisible(false);
        vista.jLabel4.setVisible(false);
        vista.jLabel10.setVisible(false);
        vista.jLabel11.setVisible(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnGuardar) {
            cliente_celsia.setId(vista.txtCodigo.getText());
            cliente_celsia.setNombres(vista.txtNombre.getText());
            cliente_celsia.setApellidos(vista.txtNombre1.getText());
            cliente_celsia.setTipoIdentificacion(vista.jComboBox1.getName());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaIns = null; 
            String text = vista.txtNombre3.getText();
            try {
                fechaIns = dateFormat.parse(text);
            } catch (ParseException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date fechaFinal = new java.sql.Date(fechaIns.getTime());
            
           cliente_celsia.setFechaNacimiento(fechaFinal);
           cliente_celsia.setNumeroCelular(vista.txtNombre4.getText());
           cliente_celsia.setCorreoElectronico(vista.txtNombre5.getText());
            

            if (consultas.registrar(cliente_celsia)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnModificar) {
            cliente_celsia.setNombres(vista.txtNombre.getText());
            cliente_celsia.setApellidos(vista.txtNombre1.getText());
            cliente_celsia.setTipoIdentificacion(vista.jComboBox1.getName());
            
            
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaIns = null; 
            String text = vista.txtNombre3.getText();
            try {
                fechaIns = dateFormat.parse(text);
            } catch (ParseException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date fechaFinal = new java.sql.Date(fechaIns.getTime());
            
           cliente_celsia.setFechaNacimiento(fechaFinal);
            
            cliente_celsia.setNumeroCelular(vista.txtNombre4.getText());
            cliente_celsia.setCorreoElectronico(vista.txtNombre5.getText());

            if (consultas.modificar(cliente_celsia)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            cliente_celsia.setId(vista.txtCodigo.getText());

            if (consultas.eliminar(cliente_celsia)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            cliente_celsia.setId(vista.txtCodigo.getText());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            if (consultas.buscar(cliente_celsia)) {
                vista.txtCodigo.setText(cliente_celsia.getId());
                vista.txtNombre.setText(cliente_celsia.getNombres());
                vista.txtNombre1.setText(cliente_celsia.getApellidos());
                vista.jComboBox1.setName(cliente_celsia.getTipoIdentificacion());
                
                String dateFinal = formato.format(cliente_celsia.getFechaNacimiento());
                vista.txtNombre3.setText(dateFinal);
                vista.txtNombre4.setText(cliente_celsia.getNumeroCelular());
                vista.txtNombre5.setText(cliente_celsia.getCorreoElectronico());
                
                if (consultas.servicios(servicios_celsia, cliente_celsia)) {
                    vista.jComboBox2.setVisible(true);
                    vista.jTextField1.setVisible(true);
                    vista.jTextField2.setVisible(true);
                    vista.jTextField3.setVisible(true);
                    vista.jLabel3.setVisible(true);
                    vista.jLabel4.setVisible(true);
                    vista.jLabel10.setVisible(true);
                    vista.jLabel11.setVisible(true);
                   
                   vista.jComboBox2.setSelectedIndex((servicios_celsia.getServicio()-1));
                  
                   String dateInit = formato.format(servicios_celsia.getFechaInicio());
                   vista.jTextField1.setText(dateInit);
                   
                   String datePay = formato.format(servicios_celsia.getUltimaFacturacion());
                   vista.jTextField2.setText(datePay);
                   
                   vista.jTextField3.setText(String.valueOf(servicios_celsia.getUltimoPago()));
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtCodigo.setText(null);
        vista.txtNombre.setText(null);
        vista.txtNombre1.setText(null);
        vista.jComboBox1.setSelectedIndex(1);
        vista.txtNombre3.setText(null);
        vista.txtNombre4.setText(null);
        vista.txtNombre5.setText(null);
        vista.jComboBox2.setVisible(false);
        vista.jTextField1.setVisible(false);
        vista.jTextField2.setVisible(false);
        vista.jTextField3.setVisible(false);
        vista.jLabel3.setVisible(false);
        vista.jLabel4.setVisible(false);
        vista.jLabel10.setVisible(false);
        vista.jLabel11.setVisible(false);
        
        
    }
}
