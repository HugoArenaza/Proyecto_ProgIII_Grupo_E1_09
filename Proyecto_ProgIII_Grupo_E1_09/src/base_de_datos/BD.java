package base_de_datos;

//import java.lang.System.Logger;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Clinica;
import domain.Dueño;
import domain.Medicamento;




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
	
	public static void crearTablas(Connection conn) {
		String sql = "CREATE TABLE IF NOT EXISTS dueños (NombreDueño String, apellidos String, dni String"
			+ ", clinica_asociada Clinica, fNac String, numeroTlf int, correo String, contraseña String)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Medicamento (Nombre String, ID int ,Precio double)";
			Statement st;
			try {
				st = conn.createStatement();
				st.executeUpdate(sql);
				st.executeUpdate(sql2);
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
	

	public static void insertarMedicamento(Connection con, Medicamento m) {
		
		if(buscarMedicamento(con, m.getNombreMedicamento()) == null) {
		String sql = String.format("INSERT INTO medicamento VALUES('%s','%s', '%s')", m.getNombreMedicamento(),m.getId(),m.getPrecioMedicamento());
			try {					
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				}
			}
		}
	public static List<Medicamento> volcarTablaMedicamentosALista(Connection conn, List<Medicamento> lMedicamentos){
		String sql = "select * from Medicamento";
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			while(rs.next()) {
				String nombreMedicamento = rs.getString("Nombre");
				String id = rs.getString("ID");
				String precioMedicamento = rs.getString("Precio");
				
				
				Medicamento m = new Medicamento(nombreMedicamento, Integer.parseInt(id), Double.parseDouble(precioMedicamento));
				lMedicamentos.add(m);
				
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lMedicamentos;
	}
		
	public static Medicamento buscarMedicamento(Connection con, String nombre) {
		String sql = String.format("SELECT * FROM medicamento WHERE Nombre = '%s'", nombre);
		Medicamento m = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) { 
				String nom = rs.getString("Nombre");
				String idTabla = rs.getString("ID");
				String precio = rs.getString("PRECIO");
				
				m = new Medicamento(nom, Integer.parseInt(idTabla), Double.parseDouble(precio));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
		
	}

