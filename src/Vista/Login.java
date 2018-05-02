package Vista;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CtrlPostulante;
import Modelo.ConsultasPostulante;
import Modelo.Postulante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import Vista.FormPostulante;
import java.awt.Point;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtuser;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void initComponents() {
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconopalermo.jpg")).getImage());
		setTitle("Login Palermo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(39, 65, 75, 20);
		contentPane.add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 126, 114, 20);
		contentPane.add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(39, 127, 75, 14);
		contentPane.add(lblContrasea);
		
		txtuser = new JTextField();
		txtuser.setBounds(124, 67, 114, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = txtuser.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				if(user.equals("admin") && pass.equals("admin")) {
					iniciarFormulario();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos");
				}
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.setBounds(272, 185, 114, 38);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Candado.png")));
		lblNewLabel.setBounds(282, 30, 104, 144);
		contentPane.add(lblNewLabel);
	}

	public Login() {
		setLocation(new Point(800, 600));
		initComponents();
	}
	public void iniciarFormulario() {
		Postulante mod = new Postulante(null, null, null, null, null, 0, null,null);
		ConsultasPostulante modC = new ConsultasPostulante();
		FormPostulante form = new FormPostulante();
		CtrlPostulante ctrl = new CtrlPostulante(mod,modC,form);
		ctrl.iniciar();
		form.setVisible(true);
	}
}
