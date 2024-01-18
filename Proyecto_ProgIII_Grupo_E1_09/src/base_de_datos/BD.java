package base_de_datos;

//import java.lang.System.Logger;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import domain.Compra;
import domain.Dueño;
import domain.Medicamento;
import domain.Paciente;
import domain.TipoPaciente;





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
	
	public static List<Paciente> obtenerListaPacientes(Connection con, String duenio){
		String sql = "SELECT * FROM Paciente WHERE Dueño = '" + duenio + "'";
		List<Paciente> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("ID");
				
				String tipo = rs.getString("TipoAnimal");
				Paciente p = new Paciente(id, "", 0, "", 0,TipoPaciente.valueOf(tipo), null);
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static void insertarPaciente(Connection con, String duenio, Paciente p) {
		String sql = String.format("INSERT INTO Paciente VALUES(%d,'%s',%d,'%s','%s','%s')", p.getId(),p.getNombrePaciente(),p.getMicroChip(),p.getEnfermedad(),p.getTipoPaciente().toString(),duenio);
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void crearTablas(Connection conn) {
		String sql = "CREATE TABLE IF NOT EXISTS dueños (NombreDueño String, apellidos String, dni String"
			+ ", clinica_asociada Clinica, fNac String, numeroTlf int, correo String, contraseña String)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Medicamento (Nombre String, ID int ,Precio double)";
		
		String sql3 = "CREATE TABLE IF NOT EXISTS Paciente(ID int, Nombre String, MicroChip int, "
				+ "Enfermedad String, TipoAnimal String, Dueño String )";
		String sql4 = "CREATE TABLE IF NOT EXISTS Compra(NombreMedicamento String, ID int, Precio Double, "
				+ "FechaDeCompra Date, paciente Paciente)";
		
			Statement st;
			try {
				st = conn.createStatement();
				st.executeUpdate(sql);
				st.executeUpdate(sql2);
				st.executeUpdate(sql4);
				st.executeUpdate(sql3);
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
	}
	
	 
	
	public static boolean insertarDueño(String NombreDueño, String apellidos, String dni,
			 String fNac, int numeroTlf, String correo, String contraseña) {
		
		
		String s = "";
		
		
			s = String.format("INSERT INTO dueños VALUES('%s','%s','%s','%s','%s','%s','%s')", NombreDueño, apellidos,dni,fNac,numeroTlf,correo, contraseña );
		
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
	//ID int, Nombre String, MicroChip int, " + "Enfermedad String, TipoAnimal String, Dueño String
	/*public static List<Paciente> volcarTablaPacienteALista(Connection con, List<Paciente> lPaciente){
		String sql = "select *from Paciente";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				int microchip = rs.getInt("MicroChip");
				String enfermedad = rs.getString("Enfermedad");
				String tipoAnimal = rs.getString("TipoAnimal");
				String duenio = rs.getString("Dueño");
				Paciente p = new Paciente();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
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
	
		public static void insertarCompra(Connection con, Compra c) {
			
			
			String sql = String.format("INSERT INTO Compra VALUES('%s','%d', '%s', '%s', '%s')", c.getNombreMedicamento(), c.getId(), c.getPrecio().toString(), c.getFechaDeCompra().toString(), c.getPaciente().toString());
				try {					
					Statement st = con.createStatement();
					st.executeUpdate(sql);
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
				}
		
		/*public static void buscarCompra(Connection con, String nombre) {
			String sql = String.format("SELECT * FROM Compra WHERE nombre = '%s'",nombre);
			Compra c = null;
			Date fecha = new Date();

			
			String formato = "yyyy-MM-dd HH:mm:ss"; 
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			String fechaComoString = sdf.format(fecha);
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
					String nombreMed = rs.getString("NombreMedicamento");
					int id = Integer.parseInt(rs.getString("ID"));
					double precio = Double.parseDouble(rs.getString("Precio"));
					fechaComoString = rs.getString("FechaDeCompra");
					
					c = new Compra(nombreMed, id, precio,fechaComoString);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	
		public static List<Compra> cogerCompra(Connection con) {
		String sql = "SELECT * FROM Compra";
		List<Compra> lc = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) { 
				String nom = rs.getString("NombreMedicamento");
				String idTabla = rs.getString("ID");
				String precio = rs.getString("Precio");
				String fechaDeCompra = rs.getString("FechaDeCompra");
				SimpleDateFormat sdf = new SimpleDateFormat();
				Date d;
				try{
					d = (Date) sdf.parse(fechaDeCompra);
				}catch(ParseException e){
					d = new Date(0);
				}
				String paciente = rs.getString("paciente");
				String[] partes = paciente.split(" ");
				String nombre = partes[1];
				TipoPaciente tipoPaciente = TipoPaciente.valueOf(partes[0]);
				
				Paciente p = new Paciente(0, nombre, 0, "", 0, tipoPaciente, null);
				Compra c = new Compra(nom, Double.parseDouble(precio), Integer.parseInt(idTabla), d, p);
				lc.add(c); 
				for (Compra compra : lc) {
					System.out.println(compra);
				}
				
				
				
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lc;
	
	}
			
		}
		

	
