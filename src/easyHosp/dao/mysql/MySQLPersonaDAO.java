package easyHosp.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.modelo.Casa;
import easyHosp.modelo.Conexion;
import easyHosp.modelo.Persona;

public class MySQLPersonaDAO extends Conexion implements PersonaDAO {

	final String INSERT = "INSERT INTO persona(nombre, apellido, email, password, isAdmin) VALUES (?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, password = ?, isAdmin = ? WHERE id = ?";
	final String DELETE = "DELETE FROM persona WHERE id = ?";
	final String GETALL = "SELECT * FROM persona";
	final String GETONE = "SELECT * FROM persona WHERE id = ?";
	final String GETONEBYEMAIL = "SELECT * FROM persona WHERE email = ?";
	final String LOGIN = "SELECT * FROM persona WHERE email = ? and password = ?";

	
	
	public MySQLPersonaDAO() throws ClassNotFoundException{
		this.conectar();
	}
	
	@Override
	public void insertar(Persona c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(INSERT);
			statement.setString(1, c.getNombre());
			statement.setString(2, c.getApellido());
			statement.setString(3, c.getEmail());
			statement.setString(4, c.getPassword());
			statement.setInt(5, c.getIsAdmin());
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
			statement.setLong(6, c.getId());
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
	public void eliminar(Persona c) throws DAOException {
		PreparedStatement statement = null;
		try{
			statement = conexion.prepareStatement(DELETE);
			statement.setLong(1, c.getId());
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
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		String password = rs.getString("password");
		String email = rs.getString("email");
		int esAdmin = rs.getInt("isAdmin");
		Casa casa = (Casa) rs.getObject("casa");
		Persona per = new Persona (nombre, apellido, password, email, esAdmin, casa);
		return per;
	}

	@SuppressWarnings("null")
	@Override
	public List<Persona> obtenerTodos() throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Persona> persona = null;
		try{
			statement = conexion.prepareStatement(GETALL);
			rs = statement.executeQuery();
			while (rs.next()){
				persona.add(convertir(rs));
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
	public Persona obtener(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Persona persona = null;
		try{
			statement = conexion.prepareStatement(GETONE);
			statement.setLong(1, id);
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
	public boolean login(String email, String password) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		boolean resultado = false;
		try{
			System.out.println(email);
			System.out.println(password);
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
}
