package base_de_datos;

//import java.lang.System.Logger;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import domain.Clinica;
import domain.Dueño;
import domain.MedicamentosAnimales;


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
	
	public static void crearTablaDueños(Connection conn) {
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
	public static void crearTablaMedicamentos(Connection conn) {
		String sql = "CREATE TABLE IF NOT EXISTS medicamentos(Nombre String, ID int)";
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			insertarMedicamentos(conn);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	  private static void insertarMedicamentos(Connection conn) {
	        String sql = "INSERT INTO medicamentos (nombre) VALUES (?)";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            for (MedicamentosAnimales medicamento : MedicamentosAnimales.values()) {
	                ps.setString(1, medicamento.name()); 
	                ps.executeUpdate();
	            }
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
			Statement st = con.createStatement();
			st.executeUpdate(s);
			cerrarBD(con);
			
			return true;
		} catch (SQLException e) {
			System.out.println("Error al insertar el dueño"+ e.getMessage());
			return false;
		}
	}
	
	public static Dueño buscarDueño(Connection con, String dni) {
		String sql = String.format("SELECT * FROM dueños WHERE dni = '%s'", dni);
		Dueño dueño = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				String NombreDueño = rs.getString("NombreDueño");
				String apellidos = rs.getString("apellidos");
				String dniStr = rs.getString("dni");
				String fNac = rs.getString("fNac");
				int numeroTlf = Integer.parseInt(rs.getString("numeroTlf"));
				String correo = rs.getString("correo");
				String contraseña = rs.getString("contraseña");
				
				dueño = new Dueño(NombreDueño, apellidos, dniStr, null, fNac, numeroTlf, correo, contraseña);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dueño;
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
