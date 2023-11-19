package base_de_datos;

//import java.lang.System.Logger;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import domain.Clinica;


public class BD {
	
	
	
	protected Connection con;
	
	public BD (String nomBD) {
		con = initBD(nomBD);
		if(con != null) {
			System.out.println("Conexion a la base de datos establecida");
		}else {
			System.out.println("Error al conectar a la base de datoss");
		}
	}
	
	public static Connection initBD(String nomBD) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite" + nomBD);
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
	
	
	
	
	public boolean insertarDueño(String NombreDueño, String apellidos, String dni, Clinica clinica_asociada,
			 String fNac, int numeroTlf, String correo, String contraseña) {
		String sql = "INSERT INTO dueños(NombreDueño, apellidos, dni, clinica_asociada, fNac, numeroTlf, correo, contraseña)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, NombreDueño);
			pstmt.setString(2, apellidos);
			pstmt.setString(3, dni);
			pstmt.setString(4, Integer.toString(clinica_asociada.getId()));
			pstmt.setString(5, fNac);
			pstmt.setString(6, Integer.toString(numeroTlf));
			pstmt.setString(7, correo);
			pstmt.setString(8, contraseña);
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
