package interfaces;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import easyHosp.modelo.Conexion;
import easyHosp.modelo.Persona;

/*
 * Connection = Conexion
 * PrepareStatement = Consuta
 * ResultSet = Datos
 */
public class DAOPersonaImpl extends Conexion implements DAOPersona{
	
	// LOGEAR PERSONA
	@Override
	public boolean login(Persona per) throws Exception {
		this.conectar();
		String query = "SELECT * FROM Persona where (email = ? and password = ?)";
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement statement = null;
		try{
			statement = this.conexion.prepareStatement(query);
			statement.setString(1, per.getEmail());
			statement.setString(2, per.getPassword());			
			rs = statement.executeQuery();
		}catch(Exception e){
			throw e;
		}finally{
			if (statement != null){
				statement.close();
			}
			if (rs != null){
				rs.close();
				result = true;
			}
			this.cerrar();
		}
		return result;
	}
	
	// REGISTRAR NUEVA PERSONA
	@Override
	public void registrar(Persona per) throws Exception {
		try{
			this.conectar();
			String query= "INSERT INTO Persona (nombre, apellido, email, password, provincia, ciudad, telefono, isAdmin ) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = this.conexion.prepareStatement(query);
			statement.setString(1, per.getNombre());
			statement.setString(2, per.getApellido());
			statement.setString(3, per.getEmail());
			statement.setString(4, per.getPassword());
			statement.setString(5, per.getProvincia());
			statement.setString(6, per.getCiudad());
			statement.setString(7, per.getTelefono());
			statement.setInt(8, per.getisAdmin());
			statement.executeUpdate();
			statement.close();
		}catch(Exception e){
			throw e;
		}finally{
			this.cerrar();
		}
		
	}

	@Override
	public void modificar(Persona per) throws Exception {
		try{
			this.conectar();
			String query = "UPDATE Persona set nombre = ? where id = ?";
			PreparedStatement st = this.conexion.prepareStatement(query);
			st.setString(1, per.getNombre());
			st.setInt(2, per.getId());
			st.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			this.cerrar();
		}
		
	}

	@Override
	public void eliminar(Persona per) throws Exception {
		try{
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Perosna WHERE id = ?");
			st.setInt(1, per.getId());
			st.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			this.cerrar();
		}
		
	}

	@Override
	public List<Persona> listar() throws Exception {
		List<Persona> lista = null;
		try{
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Persona");
			
			lista = new ArrayList<Persona>();
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				Persona per = new Persona();
				per.setId(rs.getInt("id"));
				per.setNombre(rs.getString("nombre"));
				lista.add(per);
			}
			rs.close();
			st.close();
		}catch(Exception e){
			throw e;
		}finally{
			this.cerrar();
		}
		return lista;
	}

	

}
