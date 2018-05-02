package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FormPostulante extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtDNI;
	public JTextField txtCodigo;
	public JTextField txtNombre;
	public JTextField txtGrupo;
	public JTextField txtObservaciones;
	
	public JButton btnBuscar;
	public JButton btnGuardar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnLimpiar;
	
	public JButton btnDeudas;
	public JButton btnIntegrantes;
	
	public JComboBox<String> cbxTipo;
	public JComboBox<String> cbxInfocorp;
	public JComboBox<Integer> cbxRechazos;
	private JLabel lblNewLabel_8;
	
/*	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPostulante frame = new FormPostulante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

*/
	public FormPostulante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(48, 82, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(48, 122, 61, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(48, 164, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(48, 202, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Infocorp:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(48, 239, 61, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rechazos:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(48, 276, 61, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Grupo:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(48, 313, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Observaciones:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(48, 351, 92, 14);
		contentPane.add(lblNewLabel_7);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDNI.setBounds(148, 79, 245, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCodigo.setBounds(148, 122, 245, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setEnabled(false);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBounds(148, 161, 245, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtGrupo = new JTextField();
		txtGrupo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtGrupo.setBounds(148, 310, 245, 20);
		contentPane.add(txtGrupo);
		txtGrupo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setBounds(514, 50, 155, 74);
		contentPane.add(btnBuscar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardar.setBounds(68, 459, 142, 57);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(305, 471, 105, 45);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(462, 471, 105, 45);
		contentPane.add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(623, 471, 105, 45);
		contentPane.add(btnLimpiar);
		
		cbxTipo = new JComboBox<String>();
		cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecciona", "INDIVIDUAL", "GRUPAL"}));
		cbxTipo.setBounds(148, 200, 105, 20);
		contentPane.add(cbxTipo);
		
		cbxInfocorp = new JComboBox<String>();
		cbxInfocorp.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecciona", "NORMAL", "GRIS", "PERDIDA", "CPP","DEFICIENTE"}));
		cbxInfocorp.setBounds(148, 237, 105, 20);
		contentPane.add(cbxInfocorp);
		
		cbxRechazos = new JComboBox<Integer>();
		cbxRechazos.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0,1,2,3}));
		cbxRechazos.setBounds(148, 274, 46, 20);
		contentPane.add(cbxRechazos);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(148, 349, 245, 65);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		btnDeudas = new JButton("Deudas Infocorp");
		btnDeudas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeudas.setBounds(514, 141, 155, 37);
		contentPane.add(btnDeudas);
		
		btnIntegrantes = new JButton("Integrantes del grupo");
		btnIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIntegrantes.setBounds(514, 302, 168, 37);
		contentPane.add(btnIntegrantes);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(FormPostulante.class.getResource("/imagenes/LOGOYLETRA.png")));
		lblNewLabel_8.setBounds(93, 0, 253, 71);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(FormPostulante.class.getResource("/imagenes/PALERMOOK.jpg")));
		lblFondo.setBounds(58, 0, 650, 562);
		contentPane.add(lblFondo);
	}
}
