package Modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
	int port = 3306;
	public final String BASE="palermo";
	public final String USER="root";
	public final String PASSWORD="admin";
	public final String URL="jdbc:mysql://localhost:3306/"+BASE;
	private Connection con = null;
	
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
			
		}catch(SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
