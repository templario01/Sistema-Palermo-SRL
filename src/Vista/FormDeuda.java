package Vista;

import com.mysql.jdbc.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Modelo.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class FormDeuda extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    
    private javax.swing.JScrollPane jScrollPane1;
    
    private javax.swing.JTable jtDeudas;
    
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEntidadFinanciera;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtFecha;
    DefaultTableModel modelo = new DefaultTableModel();
    private JTextField txtDeudatotal;

    public FormDeuda() {
    	setMinimumSize(new Dimension(830, 400));
    	setPreferredSize(new Dimension(800, 400));
        initComponents();

        try {
            jtDeudas.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT dni, entidad_financiera, monto, fecha FROM deuda;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("dni");
            modelo.addColumn("entidad_financiera");
            modelo.addColumn("monto");
            modelo.addColumn("fecha");

            int[] anchos = {50, 200, 50, 50};
            for (int i = 0; i < jtDeudas.getColumnCount(); i++) {
                jtDeudas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDeudas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEntidadFinanciera = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtCampo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtDeudas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "dni", "entidad_financiera", "monto", "fecha"
            }
        ));
        jtDeudas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtDeudas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("dni");

        txtDni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("entidad_financiera");

        txtEntidadFinanciera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("monto");

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("fecha");

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("dni:");
        JButton btnDeudaTotal = new JButton("Deuda total");
        btnDeudaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sumarDeudas();

			}
		});
        
        txtDeudatotal = new JTextField();
        txtDeudatotal.setColumns(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(jLabel5)
        						.addGap(18)
        						.addComponent(txtCampo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        						.addGap(18)
        						.addComponent(btnBuscar))
        					.addGroup(layout.createSequentialGroup()
        						.addGap(261)
        						.addComponent(btnDeudaTotal)
        						.addGap(18)
        						.addComponent(txtDeudatotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jLabel4)
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jLabel2)
        							.addComponent(jLabel1)
        							.addComponent(jLabel3))
        						.addGap(22)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        							.addComponent(txtEntidadFinanciera, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        							.addComponent(txtMonto, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        							.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(btnGuardar)
        					.addGap(18)
        					.addComponent(btnModificar)
        					.addGap(18)
        					.addComponent(btnEliminar)))
        			.addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtCampo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel5)
        						.addComponent(btnBuscar))
        					.addGap(29)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        					.addGap(6))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel1)
        						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(txtEntidadFinanciera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel3)
        						.addComponent(txtMonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel4)
        						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(71)))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnGuardar)
        					.addComponent(btnModificar)
        					.addComponent(btnEliminar))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtDeudatotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnDeudaTotal))))
        			.addGap(25))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    	
    	if(txtDni.getText().equals("") || txtEntidadFinanciera.getText().equals("") || txtMonto.getText().equals("") || txtFecha.getText().equals("")) {
    		JOptionPane.showMessageDialog(null,"Los campos estan vacios'");
    	}else {
    		if(validarDni(txtDni.getText())==false) {
    			JOptionPane.showMessageDialog(null,"El DNI debe ser valido");
    		}else {
    			if(validarFecha(txtFecha.getText())==false) {
    				JOptionPane.showMessageDialog(null,"Debe escribir una fecha valida 'aaaa-MM-dd'");
    			}else {
			        PreparedStatement ps = null;
			        try {
			            Conexion objCon = new Conexion();
			            Connection conn = objCon.getConexion();
			            ps = conn.prepareStatement("INSERT INTO deuda (dni,entidad_financiera,monto,fecha) VALUES (?,?,?,?);");
			            ps.setString(1, txtDni.getText());
			            ps.setString(2, txtEntidadFinanciera.getText());
			            ps.setString(3, txtMonto.getText());
			            ps.setString(4, txtFecha.getText());
			
			            ps.execute();
			
			            JOptionPane.showMessageDialog(null, "Deuda Guardado");
			            Object[] fila = new Object[4];
			            fila[0] = txtDni.getText();
			            fila[1] = txtEntidadFinanciera.getText();
			            fila[2] = txtMonto.getText();
			            fila[3] = txtFecha.getText();
			            modelo.addRow(fila);
			
			            limpiar();
			
			        } catch (SQLException ex) {
			            JOptionPane.showMessageDialog(null, "Error al Guardar Deuda");
			            System.out.println(ex);
			        }
    			}
    		}
    	}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = jtDeudas.getSelectedRow();
            String dni = jtDeudas.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT dni, entidad_financiera, monto, fecha FROM deuda WHERE dni=?;");
            ps.setString(1, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtDni.setText(rs.getString("dni"));
                txtEntidadFinanciera.setText(rs.getString("entidad_financiera"));
                txtMonto.setText(rs.getString("monto"));
                txtFecha.setText(rs.getString("fecha"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtProductosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    	if(txtDni.getText().equals("") || txtEntidadFinanciera.getText().equals("") || txtMonto.getText().equals("") || txtFecha.getText().equals("")) {
    		JOptionPane.showMessageDialog(null,"Los campos estan vacios'");
    	}else {
	        PreparedStatement ps = null;
	        try {
	
	            Conexion objCon = new Conexion();
	            Connection conn = objCon.getConexion();
	
	            int Fila = jtDeudas.getSelectedRow();
	            String dni = jtDeudas.getValueAt(Fila, 0).toString();
	
	            ps = conn.prepareStatement("DELETE FROM deuda WHERE dni=?;");
	            ps.setString(1, dni);
	            ps.execute();
	
	            modelo.removeRow(Fila);
	            JOptionPane.showMessageDialog(null, "Deuda Eliminada");
	            limpiar();
	
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error al Eliminar Deuda");
	            System.out.println(ex.toString());
	        }
    	}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    	if(txtDni.getText().equals("") || txtEntidadFinanciera.getText().equals("") || txtMonto.getText().equals("") || txtFecha.getText().equals("")) {
    		JOptionPane.showMessageDialog(null,"Los campos estan vacios'");
    	}else {
    		if(validarDni(txtDni.getText())==false) {
    			JOptionPane.showMessageDialog(null,"El DNI debe ser valido");
    		}else {
    			if(validarFecha(txtFecha.getText())==false) {
    				JOptionPane.showMessageDialog(null,"Debe escribir una fecha valida 'aaaa-MM-dd'");
    			}else {
			        int Fila = jtDeudas.getSelectedRow();
			
			        PreparedStatement ps = null;
			        try {
			            Conexion objCon = new Conexion();
			            Connection conn = objCon.getConexion();
			            ps = conn.prepareStatement("UPDATE deuda SET entidad_financiera=?, monto=?, fecha=? WHERE dni=?;");
			
			            ps.setString(1, txtEntidadFinanciera.getText());
			            ps.setString(2, txtMonto.getText());
			            ps.setString(3, txtFecha.getText());
			            ps.setString(4, txtDni.getText());
			
			            ps.execute();
			
			            JOptionPane.showMessageDialog(null, "Deuda modificada");
			            jtDeudas.setValueAt(txtDni.getText(), Fila, 0);
			            jtDeudas.setValueAt(txtEntidadFinanciera.getText(), Fila, 1);
			            jtDeudas.setValueAt(txtMonto.getText(), Fila, 2);
			            jtDeudas.setValueAt(txtFecha.getText(), Fila, 3);
			
			            limpiar();
			
			        } catch (SQLException ex) {
			            JOptionPane.showMessageDialog(null, "Error al Modificar Deuda");
			            System.out.println(ex);
			        }
    			}
    		}
    	}
    }//GEN-LAST:event_btnModificarActionPerformed
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    	if(txtCampo.getText().equals("") ) {
    		JOptionPane.showMessageDialog(null,"Ingrese el DNI'");
    	}else {
	        String campo = txtCampo.getText();
	        String where = "";
	        if (!"".equals(campo)) {
	            where = "WHERE dni = '" + campo + "'";
	        }
	
	        try {
	            DefaultTableModel modelo = new DefaultTableModel();
	            jtDeudas.setModel(modelo);
	
	            PreparedStatement ps = null;
	            ResultSet rs = null;
	            Conexion conn = new Conexion();
	            Connection con = conn.getConexion();
	
	            String sql = "SELECT dni, entidad_financiera, monto, fecha FROM deuda " + where;
	            System.out.println(sql);
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	
	            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
	            int cantidadColumnas = rsMd.getColumnCount();
	
	            modelo.addColumn("dni");
	            modelo.addColumn("entidad financiera");
	            modelo.addColumn("monto");
	            modelo.addColumn("fecha");
	            int[] anchos = {50, 200, 50, 50};
	            for (int i = 0; i < jtDeudas.getColumnCount(); i++) {
	                jtDeudas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
	            }
	
	            while (rs.next()) {
	                Object[] filas = new Object[cantidadColumnas];
	                for (int i = 0; i < cantidadColumnas; i++) {
	                    filas[i] = rs.getObject(i + 1);
	                }
	                modelo.addRow(filas);
	            }
	
	        } catch (Exception ex) {
	            System.err.println(ex.toString());
	        }
    	}
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    private void limpiar() {
        txtDni.setText("");
        txtEntidadFinanciera.setText("");
        txtMonto.setText("");
        txtFecha.setText("");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDeuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDeuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDeuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDeuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new FormDeuda().setVisible(true);}});
    }
    
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
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
    public void sumarDeudas() {
    	double sum = 0;
    	for(int i=0;i<jtDeudas.getRowCount();i++) {
    		sum = sum+Double.parseDouble(jtDeudas.getValueAt(i, 2).toString());
    	}
    	double roundOff = (double) Math.round(sum * 100.0) / 100.0;
    	txtDeudatotal.setText(Double.toString(roundOff));
    }
}
