package easyHosp.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easyHosp.dao.DAOException;
import easyHosp.dao.FavoritoDAO;
import easyHosp.dao.PersonaDAO;
import easyHosp.modelo.Conexion;
import easyHosp.modelo.Favorito;
import easyHosp.modelo.Persona;

public class MySQLFavoritoDAO extends Conexion implements FavoritoDAO {
	
	final String INSERT = "INSERT INTO favorito(idPersona, idPersonaFav) VALUES (?, ?)";
	final String DELETE = "DELETE FROM favorito WHERE id = ?";
	final String GETONE = "SELECT * FROM favorito WHERE id = ?";
	final String GETALL = "SELECT * FROM favorito";
	final String GETONEBYID = "SELECT * FROM favorito WHERE idPersona = ? and idPersonaFav = ?";
	final String GETALLBYID = "SELECT * FROM favorito WHERE idPersona = ?";
	
	public MySQLFavoritoDAO(){
		try {
			this.conectar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertar(Favorito c) throws DAOException {
		PreparedStatement statement = null;
		try {
			statement = conexion.prepareStatement(INSERT);
			statement.setInt(1, c.getPersona().getId());
			statement.setInt(2, c.getPersonaFav().getId());
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
	public void modificar(Favorito c) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int c) throws DAOException {
		PreparedStatement statement = null;
		try{
			statement = conexion.prepareStatement(DELETE);
			statement.setLong(1, c);
			if (statement.executeUpdate()== 0){
				throw new DAOException("Puede que el favorito no se haya borrado.");
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
	public List<Favorito> obtenerTodos() throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Favorito> favoritos = new  ArrayList<Favorito>();
		try{
			statement = conexion.prepareStatement(GETALL);
			rs = statement.executeQuery();
			while (rs.next()){
				favoritos.add(convertir(rs));
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
		return favoritos;
	}

	@Override
	public Favorito obtener(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Favorito favorito = null;
		try{
			statement = conexion.prepareStatement(GETONE);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if (rs.next()){
				favorito = convertir(rs);
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
		return favorito;
	}

	private Favorito convertir(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
				
		PersonaDAO pdao = new MySQLPersonaDAO();
		Persona Persona=null;
		Persona PersonaFav=null;
		try {
			Persona = pdao.obtener(rs.getInt("idPersona"));
			PersonaFav = pdao.obtener(rs.getInt("idPersonaFav"));
		} catch (DAOException e) {
			e.printStackTrace();
		}	
		Favorito fav = new Favorito(id, Persona, PersonaFav);
		return fav;
	}

	@Override
	public List<Favorito> obtenerTodosById(int id) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Favorito> favoritos = new ArrayList<Favorito>();
		try{
			statement = conexion.prepareStatement(GETALLBYID);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			while (rs.next()){
				favoritos.add(convertir(rs));
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
		return favoritos;
	}

	@Override
	public boolean obtener(int idPersona, int idPersonaFav) throws DAOException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try{
			statement = conexion.prepareStatement(GETONEBYID);
			statement.setInt(1, idPersona);
			statement.setInt(2, idPersonaFav);
			rs = statement.executeQuery();
			if (rs.next()){
				return true;
			}else{
				return false;
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
	}
}