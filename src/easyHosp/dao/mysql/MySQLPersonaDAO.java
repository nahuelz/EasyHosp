package easyHosp.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.modelo.Conexion;
import easyHosp.modelo.Persona;

public class MySQLPersonaDAO extends Conexion implements PersonaDAO {

	final String INSERT = "INSERT INTO persona(nombre, apellido, email, telefono, password, provincia, ciudad, isAdmin";
	final String UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ?, password = ?, provincia = ?, ciudad = ?, isAdmin = ? WHERE id = ?";
	final String DELETE = "DELETE FROM persona WHERE id = ?";
	final String GETALL = "SELECT * FROM persona";
	final String GETONE = "SELECT * FROM persona WHERE id = ?";
	
	private Connection conn;
	
	public MySQLPersonaDAO(Connection conn){
		this.conexion = conn;
	}
	
	@Override
	public void insertar(Persona c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(INSERT);
			statement.setString(1, c.getNombre());
			statement.setString(2, c.getApellido());
			statement.setString(3, c.getEmail());
			statement.setString(4, c.getTelefono());
			statement.setString(5, c.getPassword());
			statement.setString(6, c.getProvincia());
			statement.setString(7, c.getCiudad());
			statement.setInt(8, c.getIsAdmin());
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
			statement = conn.prepareStatement(INSERT);
			statement.setString(1, c.getNombre());
			statement.setString(2, c.getApellido());
			statement.setString(3, c.getEmail());
			statement.setString(4, c.getTelefono());
			statement.setString(5, c.getPassword());
			statement.setString(6, c.getProvincia());
			statement.setString(7, c.getCiudad());
			statement.setInt(8, c.getIsAdmin());
			statement.setLong(9, c.getId());
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
			statement = conn.prepareStatement(DELETE);
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
		String apellido = rs.getString("apelldio");
		String telefono = rs.getString("telefono");
		String provincia = rs.getString("provincia");
		String ciudad = rs.getString("ciudad");
		String password = rs.getString("password");
		String email = rs.getString("email");
		int esAdmin = rs.getInt("isAdmin");
		Long casa = rs.getLong("casa");
		Persona per = new Persona (nombre, apellido, telefono, provincia, ciudad, password, email, esAdmin, casa);
		return per;
	}

	@SuppressWarnings("null")
	@Override
	public List<Persona> obtenerTodos() throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Persona> persona = null;
		try{
			statement = conn.prepareStatement(GETALL);
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
	public Persona obtener(Long id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Persona persona = null;
		try{
			statement = conn.prepareStatement(GETONE);
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
}
