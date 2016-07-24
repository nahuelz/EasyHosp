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
		try{
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Persona where (email = ? and password = ?)");
			st.setString(1, per.getEmail());
			st.setString(2, per.getPassword());			
			ResultSet r = st.executeQuery();
			if (r.next()){
				return true;
			}else
				return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.cerrar();
		}
			
			
	}
	
	// REGISTRAR NUEVA PERSONA
	@Override
	public void registrar(Persona per) throws Exception {
		try{
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Persona (nombre, apellido, email, password, provincia, ciudad, telefono, isAdmin ) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, per.getNombre());
			st.setString(2, per.getApellido());
			st.setString(3, per.getEmail());
			st.setString(4, per.getPassword());
			st.setString(5, per.getProvincia());
			st.setString(6, per.getCiudad());
			st.setString(7, per.getTelefono());
			st.setInt(8, per.getisAdmin());
			st.executeUpdate();
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
			PreparedStatement st = this.conexion.prepareStatement("UPDATE Persona set nombre = ? where id = ?");
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
