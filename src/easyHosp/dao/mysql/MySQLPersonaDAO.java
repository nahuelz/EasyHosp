package easyHosp.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easyHosp.dao.CasaDAO;
import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.modelo.Casa;
import easyHosp.modelo.Conexion;
import easyHosp.modelo.Persona;


public class MySQLPersonaDAO extends Conexion implements PersonaDAO {

	final String INSERT = "INSERT INTO persona(nombre, apellido, email, password, isAdmin, provincia, ciudad, casa, disponible) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, password = ?, isAdmin = ?, provincia = ?, ciudad = ?, casa = ?, disponible = ?, dni = ?, telefono = ?, sexo = ? WHERE id = ?";
	final String DELETE = "DELETE FROM persona WHERE id = ?";
	final String GETALL = "SELECT * FROM persona WHERE disponible = ?";
	final String GETONE = "SELECT * FROM persona WHERE id = ?";
	final String GETONEBYEMAIL = "SELECT * FROM persona WHERE email = ?";
	final String LOGIN = "SELECT * FROM persona WHERE email = ? and password = ?";
	final String GETPROVINCIA = "SELECT * FROM persona WHERE provincia = ? and disponible = ?";
	final String SETDISPONIBLE = "UPDATE persona SET disponible = ? WHERE ID = ?";

	
	
	public MySQLPersonaDAO(){
		try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Persona c) throws DAOException{
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(INSERT);
			statement.setString(1, c.getNombre());
			statement.setString(2, c.getApellido());
			statement.setString(3, c.getEmail());
			statement.setString(4, c.getPassword());
			statement.setInt(5, c.getIsAdmin());
			statement.setString(6, c.getProvincia());
			statement.setString(7, c.getCiudad());
			statement.setInt(8, c.getCasa().getId());
			statement.setInt(9, c.getDisponible());
			if (statement.executeUpdate() == 0){
				throw new DAOException("Puede que no se haya guardado. :D");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		} finally{
			if (statement != null){
				try {
					statement.close();  
				} catch (SQLException e) {
					throw new DAOException("Error en SQL", e);
				}
			}
			
			try {
				this.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void modificar(Persona c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(UPDATE);
			statement.setString(1, c.getNombre());
			statement.setString(2, c.getApellido());
			statement.setString(3, c.getEmail());
			statement.setString(4, c.getPassword());
			statement.setInt(5, c.getIsAdmin());
			statement.setString(6, c.getProvincia());
			statement.setString(7, c.getCiudad());
			statement.setInt(8, c.getCasa().getId());
			statement.setInt(9, c.getDisponible());
			statement.setString(10,c.getDni());
			statement.setString(11, c.getTelefono());
			statement.setString(12, c.getSexo());
			statement.setLong(13, c.getId());
			if (statement.executeUpdate() == 0){
				throw new DAOException("Puede que no se haya guardado. :D");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		} finally{
			if (statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					throw new DAOException("Error en SQL", e);
				}
			}
			
			try {
				this.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void eliminar(int id) throws DAOException {
		PreparedStatement statement = null;
		try{
			statement = conexion.prepareStatement(DELETE);
			statement.setLong(1, id);
			if (statement.executeUpdate()== 0){
				throw new DAOException("Puede que el alumno no se haya borrado.");
			}
		}catch (SQLException e){
			throw new DAOException("Error de SQL", e);
		} finally {
			if (statement != null){
				try{
					statement.close();
				} catch (SQLException e){
					throw new DAOException("Error de SQL", e);
				}
			}
		}
		
	}
	
	private Persona convertir (ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		String password = rs.getString("password");
		String email = rs.getString("email");
		String provincia = rs.getString("provincia");
		String ciudad = rs.getString("ciudad");
		int isAdmin = rs.getInt("isAdmin");
		String sexo = rs.getString("sexo");
		String telefono = rs.getString("telefono");
		String dni = rs.getString("dni");
		int disponible = rs.getInt("disponible");
	
		CasaDAO daoc = new MySQLCasaDAO();
		Casa casa=null;
		try {
			casa = daoc.obtener(rs.getInt("casa"));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		Persona per = new Persona(id,nombre,apellido, email, password, isAdmin, provincia,
				 ciudad, telefono, dni, sexo, casa, disponible);
		return per;
	}

	@Override
	public List<Persona> obtenerTodos() throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Persona> personas = new ArrayList<Persona>();
		try{
			statement = conexion.prepareStatement(GETALL);
			statement.setInt(1, 1);
			rs = statement.executeQuery();
			while (rs.next()){
				personas.add(convertir(rs));		
			}
		} catch (SQLException e){
			throw new DAOException("Error en SQL", e);
		} finally {
			if (rs != null){
				try{
					rs.close();
				} catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
			if (statement != null){
				try{
					statement.close();
				}catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
		}
		return personas;
	}

	@Override
	public Persona obtener(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Persona persona = null;
		try{
			statement = conexion.prepareStatement(GETONE);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if (rs.next()){
				persona = convertir(rs);
			}else{
				throw new DAOException("No se encontro ninguna persona.");
			}
		} catch (SQLException e){
			throw new DAOException("Error en SQL", e);
		} finally {
			if (rs != null){
				try{
					rs.close();
				} catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
		}
		return persona;
	}

	@Override
	public boolean login(String email, String password) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean resultado = false;
		try{
			statement = conexion.prepareStatement(LOGIN);
			statement.setString(1, email);
			statement.setString(2, password);
			rs = statement.executeQuery();
			if (rs.next()){
				resultado = true;
				System.out.println("logeado");
			}else{
				throw new DAOException("Email o contraseña incorrecta");
			}
		} catch (SQLException e){
			throw new DAOException("Error en SQL", e);
		} finally {
			if (rs != null){
				try{
					rs.close();
				} catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
			if (statement != null){
				try{
					statement.close();
				}catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
		}
		return resultado;
	}

	@Override
	public Persona obtener(String email) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Persona persona = null;
		try{
			statement = conexion.prepareStatement(GETONEBYEMAIL);
			statement.setString(1, email);
			rs = statement.executeQuery();
			if (rs.next()){
				persona = convertir(rs);
			}else{
				throw new DAOException("No se encontro ninguna persona.");
			}
		} catch (SQLException e){
			throw new DAOException("Error en SQL", e);
		} finally {
			if (rs != null){
				try{
					rs.close();
				} catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
			if (statement != null){
				try{
					statement.close();
				}catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
		}
		return persona;
	}

	@Override
	public List<Persona> obtenerProvincia(String provincia) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Persona> personas = new ArrayList<Persona>();
		try{
			statement = conexion.prepareStatement(GETPROVINCIA);
			statement.setString(1, provincia);
			statement.setInt(2, 1);
			rs = statement.executeQuery();
			while (rs.next()){
				personas.add(convertir(rs));			
			}
		} catch (SQLException e){
			throw new DAOException("Error en SQL", e);
		} finally {
			if (rs != null){
				try{
					rs.close();
				} catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
			if (statement != null){
				try{
					statement.close();
				}catch (SQLException e){
					new DAOException("Error en SQL", e);
				}
			}
			
		}
		return personas;
	}

	@Override
	public void setearDisponibilidad(int id, int disponible) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(SETDISPONIBLE);
			statement.setInt(1, disponible);
			statement.setLong(2, id);
			if (statement.executeUpdate() == 0){
				throw new DAOException("Puede que no se haya guardado. :D");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		} finally{
			if (statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					throw new DAOException("Error en SQL", e);
				}
			}
			
			try {
				this.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


}
