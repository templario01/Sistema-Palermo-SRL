package Controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import Modelo.ConsultasPostulante;
import Modelo.Postulante;
import Vista.FormDeuda;
import Vista.FormIntegrantes;
import Vista.FormPostulante;


public class CtrlPostulante implements ActionListener{
	private Postulante mod;      // definimos objeto mod de tipo Postulante
	private ConsultasPostulante modC;   // definimos objeto modC de tipo ConsultasPostulante
	private FormPostulante form; // definimos objeto form de tipo FormPostulante
	
	public CtrlPostulante(Postulante mod, ConsultasPostulante modC, FormPostulante form) {
		this.mod=mod;
		this.modC=modC;
		this.form=form;
		this.form.btnDeudas.addActionListener(this);
		this.form.btnIntegrantes.addActionListener(this);
		
		this.form.btnGuardar.addActionListener(this);
		this.form.btnModificar.addActionListener(this);
		this.form.btnEliminar.addActionListener(this);
		this.form.btnLimpiar.addActionListener(this);
		this.form.btnBuscar.addActionListener(this);
	}
	public void iniciar() {
		form.setTitle("Registro de postulantes");
		form.setSize(800,600);
		form.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == form.btnDeudas) {
			FormDeuda formdeud = new FormDeuda();
			formdeud.setVisible(true);
		}
		if(e.getSource() == form.btnIntegrantes) {
			FormIntegrantes integrantes = new FormIntegrantes();
			integrantes.setVisible(true);
			
		}
		if(e.getSource() == form.btnGuardar) {
			if(form.txtDNI.getText().equals("") || form.txtNombre.getText().equals("") || form.cbxTipo.getSelectedItem().equals("Selecciona") || form.cbxInfocorp.getSelectedItem().equals("Selecciona")){
				JOptionPane.showMessageDialog(null,"Debe llenar obligatoriamente el DNI, Nombre, Tipo e Infocorp");
			}else {
				if(validarDni(form.txtDNI.getText())==false) {
					JOptionPane.showMessageDialog(null,"Debe ingresar un DNI valido");
				}else {
					mod.setNombre(form.txtNombre.getText());
					mod.setCodigo(form.txtCodigo.getText());
					mod.setDNI(form.txtDNI.getText());
					mod.setTipoPostulante((String) form.cbxTipo.getSelectedItem());
					mod.setInfocorp((String) form.cbxInfocorp.getSelectedItem());
					mod.setNroRechazos((int) form.cbxRechazos.getSelectedItem());
					mod.setGrupo(form.txtGrupo.getText());
					mod.setObservaciones(form.txtObservaciones.getText());
					
					try {
						if(modC.registrar(mod)) {
							JOptionPane.showMessageDialog(null,"Registro guardado");
							limpiar();
						}else {
							JOptionPane.showMessageDialog(null,"Error al guardar");
							limpiar();
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == form.btnModificar) {
			if(form.txtDNI.getText().equals("") || form.txtNombre.getText().equals("") || form.cbxTipo.getSelectedItem().equals("Selecciona") || form.cbxInfocorp.getSelectedItem().equals("Selecciona")){
				JOptionPane.showMessageDialog(null,"Debe llenar obligatoriamente el DNI, Nombre, Tipo e Infocorp");
			}else {
				if(validarDni(form.txtDNI.getText())==false) {
					JOptionPane.showMessageDialog(null,"Debe ingresar un DNI valido");
				}else {
					mod.setCodigo(form.txtCodigo.getText());
					mod.setNombre(form.txtNombre.getText());
					mod.setDNI(form.txtDNI.getText());
					mod.setTipoPostulante((String) form.cbxTipo.getSelectedItem());
					mod.setInfocorp((String) form.cbxInfocorp.getSelectedItem());
					mod.setNroRechazos((int) form.cbxRechazos.getSelectedItem());
					mod.setGrupo(form.txtGrupo.getText());
					mod.setObservaciones(form.txtObservaciones.getText());
					
					try {
						if(modC.modificar(mod)) {
							JOptionPane.showMessageDialog(null,"Registro Modificado");
							limpiar();
						}else {
							JOptionPane.showMessageDialog(null,"Error al modificar");
							limpiar();
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == form.btnEliminar) {
			if(form.txtDNI.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Por favor Ingresa el DNI");
			}else {
				mod.setDNI(form.txtDNI.getText());
				if(modC.eliminar(mod)) {
					JOptionPane.showMessageDialog(null,"Registro eliminado");
					limpiar();
				}else {
					JOptionPane.showMessageDialog(null,"Error al eliminar");
					limpiar();
				}
			}
		}
		if(e.getSource() == form.btnBuscar) {
			if(form.txtDNI.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Por favor Ingresa el DNI");
			}else {
				mod.setDNI(form.txtDNI.getText());
				if(modC.buscar(mod)) {
					form.txtCodigo.setText(mod.getCodigo());
					form.txtNombre.setText(mod.getNombre());
					form.cbxTipo.setSelectedItem(mod.getTipoPostulante());	
					form.cbxRechazos.setSelectedItem(mod.getNroRechazos());
					form.cbxInfocorp.setSelectedItem(mod.getInfocorp());
					form.txtGrupo.setText(mod.getGrupo());
					form.txtObservaciones.setText(mod.getObservaciones());
					/*
					form.txtTipo.setText(mod.getTipoPostulante());
					form.txtInfocorp.setText(mod.getInfocorp());
					form.txtRechazos.setText(String.valueOf(mod.getNroRechazos()));*/
					
				
				}else {
					JOptionPane.showMessageDialog(null,"No se encontro registro");
					limpiar();
				}
			}
		}
		if(e.getSource() == form.btnLimpiar) {
			limpiar();
		}
	}
	public void limpiar() {
		int a=0;
		form.txtCodigo.setText(null);
		form.txtDNI.setText(null);
		form.txtNombre.setText(null);
		form.txtGrupo.setText(null);
		form.cbxTipo.setSelectedIndex(a);
		form.cbxInfocorp.setSelectedIndex(a);
		form.cbxRechazos.setSelectedIndex(a);
		form.txtObservaciones.setText(null);
	}
    public static boolean validarDni(String dni) {
    	try {
    		int numEntero = Integer.parseInt(dni);
    		numEntero = numEntero+1-1; 
    		return true;
    	}catch(Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
}
