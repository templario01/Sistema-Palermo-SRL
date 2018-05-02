package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;

public class ConsultasPostulante extends Conexion{
	public boolean registrar(Postulante post) throws SQLException {
		Connection con = getConexion();
		String sql ="{CALL REGISTRAR_POSTULANTE(?,?,?,?,?,?,?)}";
		try {
			CallableStatement cs = (CallableStatement) con.prepareCall(sql);
			cs.setString(1, post.getDNI());
			cs.setString(2, post.getNombre());
			cs.setString(3, post.getTipoPostulante());
			cs.setString(4, post.getInfocorp());
			cs.setInt(5, post.getNroRechazos());
			cs.setString(6, post.getGrupo());
			cs.setString(7, post.getObservaciones());
			cs.execute();
			return true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}
		/*
		PreparedStatement ps = null;
		Connection con = getConexion();
		cst = (CallableStatement) con.prepareCall("{call REGISTRAR_POSTULANTE(?,?,?,?,?,?,?) }");
		String sql = "INSERT INTO postulante (dni, codigo, nombre, tipo, infocorp, rechazos, grupo, observaciones) VALUES (?,?,?,?,?,?,?,?)";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, post.getDNI()); 
			ps.setString(2, post.getCodigo());
			ps.setString(3, post.getNombre());
			ps.setString(4, post.getTipoPostulante());
			ps.setString(5, post.getInfocorp());
			ps.setInt(6, post.getNroRechazos());
			ps.setString(7, post.getGrupo());
			ps.setString(8, post.getObservaciones());
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}*/
	}
	public boolean modificar(Postulante post) throws SQLException {
		Connection con = getConexion();
		String sql ="{CALL MODIFICAR_POSTULANTE(?,?,?,?,?,?,?,?)}";
		try {
			CallableStatement cs = (CallableStatement) con.prepareCall(sql);
			cs.setString(1, post.getDNI());
			cs.setString(2, post.getCodigo());
			cs.setString(3, post.getNombre());
			cs.setString(4, post.getTipoPostulante());
			cs.setString(5, post.getInfocorp());
			cs.setInt(6, post.getNroRechazos());
			cs.setString(7, post.getGrupo());
			cs.setString(8, post.getObservaciones());
			cs.execute();
			return true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}
		/*
		PreparedStatement ps = null;
		Connection con = getConexion();
		cst = (CallableStatement) con.prepareCall("{call REGISTRAR_POSTULANTE(?,?,?,?,?,?,?) }");
		String sql = "INSERT INTO postulante (dni, codigo, nombre, tipo, infocorp, rechazos, grupo, observaciones) VALUES (?,?,?,?,?,?,?,?)";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, post.getDNI()); 
			ps.setString(2, post.getCodigo());
			ps.setString(3, post.getNombre());
			ps.setString(4, post.getTipoPostulante());
			ps.setString(5, post.getInfocorp());
			ps.setInt(6, post.getNroRechazos());
			ps.setString(7, post.getGrupo());
			ps.setString(8, post.getObservaciones());
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}*/
	}
	/*
	public boolean modificar(Postulante post) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "UPDATE postulante SET dni=?, nombre=?, tipo=?, infocorf=?, rechazos=?, grupo=? , observaciones=? WHERE dni=?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, post.getDNI());
			ps.setString(2, post.getNombre());
			ps.setString(3, post.getTipoPostulante());
			ps.setString(4, post.getInfocorp());
			ps.setInt(5, post.getNroRechazos());
			ps.setString(6, post.getGrupo());
			ps.setString(7, post.getObservaciones());
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}
	}*/
	public boolean eliminar(Postulante post) {

		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "DELETE FROM postulante WHERE dni=?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, post.getDNI());
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}
	}
	public boolean buscar(Postulante post) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		String sql = "SELECT * FROM postulante WHERE dni=?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, post.getDNI());
			rs = ps.executeQuery();
			if(rs.next()) {
				post.setDNI(rs.getString("dni"));
				post.setCodigo(rs.getString("codigo"));
				post.setNombre(rs.getString("nombre"));
				post.setTipoPostulante(rs.getString("tipo"));
				post.setInfocorp(rs.getString("infocorp"));
				post.setNroRechazos(Integer.parseInt(rs.getString("rechazos")));
				post.setGrupo(rs.getString("grupo"));
				post.setObservaciones(rs.getString("observaciones"));
				return true;
			}
			
			return false;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				System.err.println(e);
			}
		}
	}
}
