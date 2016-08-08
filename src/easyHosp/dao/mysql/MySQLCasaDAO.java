package easyHosp.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easyHosp.dao.CasaDAO;
import easyHosp.dao.DAOException;
import easyHosp.modelo.Casa;
import easyHosp.modelo.Conexion;

public class MySQLCasaDAO extends Conexion implements CasaDAO {
	
	final String INSERT = "INSERT INTO casa(lugar, chicos, permitidoFumar, habitacionCompartida, mascota, contacto) VALUES (?, ?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE casa SET lugar = ?, chicos = ?, permitidoFumar = ?, habitacionCompartida = ?, mascota = ? WHERE id = ?";
	final String DELETE = "DELETE FROM casa WHERE id = ?";
	final String GETALL = "SELECT * FROM casa";
	final String GETONE = "SELECT * FROM casa WHERE id = ?";
	final String GETONEBYCONTACTO = "SELECT * FROM casa WHERE contacto = ?";
	
	
	public MySQLCasaDAO(){
		try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insertar(Casa c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(INSERT);
			statement.setString(1, c.getLugar());
			statement.setString(2, c.getChicos());
			statement.setString(3, c.getPermitidoFumar());
			statement.setString(4, c.getHabitacionCompartida());
			statement.setString(5, c.getMascota());
			statement.setString(6, c.getContacto());
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
	public void modificar(Casa c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(UPDATE);
			statement.setString(1, c.getLugar());
			statement.setString(2, c.getChicos());
			statement.setString(3, c.getPermitidoFumar());
			statement.setString(4, c.getHabitacionCompartida());
			statement.setString(5, c.getMascota());
			statement.setInt(6, c.getId());
			
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
		try {
			statement = conexion.prepareStatement(UPDATE);
			statement.setInt(1, id);
			if (statement.executeUpdate()== 0){
				throw new DAOException("Puede que la casa no se haya borrado.");
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
	
	private Casa convertir (ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String lugar = rs.getString("lugar");
		String chicos = rs.getString("chicos");
		String permitidoFumar = rs.getString("permitidoFumar");
		String habitacionCompartida = rs.getString("habitacionCompartida");
		String mascota = rs.getString("mascota");
		String contacto = rs.getString("contacto");
		Casa casa = new Casa (id, lugar, chicos, permitidoFumar, habitacionCompartida, mascota, contacto);
		return casa;
	}

	@Override
	public List<Casa> obtenerTodos() throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Casa> casa = new ArrayList<Casa>();
		try{
			statement = conexion.prepareStatement(GETALL);
			statement.setString(1, "Si");
			rs = statement.executeQuery();
			while (rs.next()){
				casa.add(convertir(rs));		
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
		return casa;
	}

	@Override
	public Casa obtener(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Casa casa = null;
		try{
			statement = conexion.prepareStatement(GETONE);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if (rs.next()){
				casa = convertir(rs);
			}else{
				throw new DAOException("No se encontro ninguna casa.");
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
		return casa;
	}

	
	@Override
	public Casa obeterPorContacto(String email) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Casa casa = null;
		try{
			statement = conexion.prepareStatement(GETONEBYCONTACTO);
			statement.setString(1, email);
			rs = statement.executeQuery();
			if (rs.next()){
				casa = convertir(rs);
			}else{
				throw new DAOException("No se encontro ninguna casa.");
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
		return casa;
	}



}
