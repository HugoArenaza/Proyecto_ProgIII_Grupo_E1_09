package base_de_datos;

//import java.lang.System.Logger;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import domain.Clinica;


public class BD {
	
	public static Connection initBD(String nomBD) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:datos/" + nomBD);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void crearTabla(Connection conn) {
		String sql = "CREATE TABLE IF NOT EXISTS dueños (NombreDueño String, apellidos String, dni String"
			+ ", clinica_asociada Clinica, fNac String, numeroTlf int, correo String, contraseña String)";
			Statement st;
			try {
				st = conn.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
	}
	
	
	
	
	public static boolean insertarDueño(String NombreDueño, String apellidos, String dni, Clinica clinica_asociada,
			 String fNac, int numeroTlf, String correo, String contraseña) {
		String sql = "INSERT INTO dueños(NombreDueño, apellidos, dni, clinica_asociada, fNac, numeroTlf, correo, contraseña)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		String s = "";
		String clinica = "";
		if(clinica_asociada!=null)
			s = String.format("INSERT INTO dueños VALUES('%s','%s','%s','%s','%s','%s','%s','%s')", NombreDueño, apellidos,dni,Integer.toString(clinica_asociada.getId()),fNac,numeroTlf,correo, contraseña );
		else
			s = String.format("INSERT INTO dueños VALUES('%s','%s','%s','%s','%s','%s','%s','%s')", NombreDueño, apellidos,dni,clinica,fNac,numeroTlf,correo, contraseña );
		
		try {
			Connection con = initBD("clinicaFurwell.db");
			/*PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, NombreDueño);
			pstmt.setString(2, apellidos);
			pstmt.setString(3, dni);
			if(clinica_asociada!=null)
				pstmt.setString(4, Integer.toString(clinica_asociada.getId()));
			else
				pstmt.setString(4, "");
			pstmt.setString(5, fNac);
			pstmt.setString(6, Integer.toString(numeroTlf));
			pstmt.setString(7, correo);
			pstmt.setString(8, contraseña);*/
			Statement st = con.createStatement();
			st.executeUpdate(s);
			cerrarBD(con);
			
			return true;
		} catch (SQLException e) {
			System.out.println("Error al insertar el dueño"+ e.getMessage());
			return false;
		}
	}
	
	
	public static void cerrarBD(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
