package easyHosp.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.dao.SolicitudDAO;
import easyHosp.modelo.Conexion;
import easyHosp.modelo.Persona;
import easyHosp.modelo.Solicitud;

public class MySQLSolicitudDAO extends Conexion implements SolicitudDAO{
	final String INSERT = "INSERT INTO solicitud(desde, hasta, estado, idDueño, comentario, idSolicitador) VALUES (?, ?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE solicitud SET desde = ?, hasta = ?, estado = ?, idDueño = ?, comentario = ?, idSolicitador = ? WHERE id = ?";
	final String DELETE = "DELETE FROM solicitud WHERE id = ?";
	final String GETALL = "SELECT * FROM solicitud";
	final String GETALLRECIBIDAS = "SELECT * FROM solicitud WHERE idDueño = ?";
	final String GETALLENVIADAS = "SELECT * FROM solicitud WHERE idSolicitador = ?";
	final String GETONE = "SELECT * FROM solicitud WHERE id = ?";
	
	public MySQLSolicitudDAO(){
		try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar(){

	}
	
	@Override
	public void insertar(Solicitud c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(INSERT);
			statement.setString(1, c.getDesde());
			statement.setString(2, c.getHasta());
			statement.setInt(3, c.getEstado());
			statement.setInt(4, c.getDueño().getId());
			statement.setString(5, c.getComentario());
			statement.setInt(6, c.getSolicitador().getId());
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
			
		}		
	}

	@Override
	public void modificar(Solicitud c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(UPDATE);
			statement.setString(1, c.getDesde());
			statement.setString(2, c.getHasta());
			statement.setInt(3, c.getEstado());
			statement.setInt(4, c.getDueño().getId());
			statement.setString(5, c.getComentario());
			statement.setInt(6, c.getSolicitador().getId());
			statement.setInt(7, c.getId());
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

	@Override
	public List<Solicitud> obtenerTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solicitud obtener(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Solicitud solicitud = null;
		try{
			statement = conexion.prepareStatement(GETONE);
			statement.setLong(1, id);
			rs = statement.executeQuery();
			if (rs.next()){
				solicitud = convertir(rs);
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
		return solicitud;
	}

	@Override
	public List<Solicitud> obtenerRecibidas(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		try{
			statement = conexion.prepareStatement(GETALLRECIBIDAS);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()){
				solicitudes.add(convertir(rs));		
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
			return solicitudes;
		}

	private Solicitud convertir(ResultSet rs) throws DAOException, SQLException {
		int id = rs.getInt("id");
		String desde = rs.getString("desde");
		String hasta = rs.getString("hasta");
		int estado = rs.getInt("estado");
		String comentario = rs.getString("comentario");
				
		PersonaDAO ddao = new MySQLPersonaDAO();
		Persona solicitador=null;
		Persona dueño=null;
		try {
			dueño = ddao.obtener(rs.getInt("idDueño"));
			solicitador = ddao.obtener(rs.getInt("idSolicitador"));
		} catch (DAOException e) {
			e.printStackTrace();
		}	
		Solicitud sol = new Solicitud (id, dueño, desde, hasta, estado, comentario, solicitador);
		return sol;
	}

	@Override
	public List<Solicitud> obtenerEnviadas(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		try{
			statement = conexion.prepareStatement(GETALLENVIADAS);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()){
				solicitudes.add(convertir(rs));		
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
			return solicitudes;

	}

}
