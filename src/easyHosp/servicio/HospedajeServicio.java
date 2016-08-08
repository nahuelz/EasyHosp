package easyHosp.servicio;

import java.util.List;

import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.dao.mysql.MySQLPersonaDAO;
import easyHosp.modelo.Persona;

public class HospedajeServicio {
	
	public List<Persona> buscarTodos (){
		PersonaDAO pdao = null;
		List<Persona> personas = null;
		try {
			pdao = new MySQLPersonaDAO();
			personas = pdao.obtenerTodos();
		}catch (DAOException e) {
			e.printStackTrace();
		}
		return personas;
	}

	public List<Persona> buscarPorProvincia(String provincia) {
		PersonaDAO pdao = null;
		List<Persona> personas = null;
		pdao = new MySQLPersonaDAO();		
		try {
			personas = pdao.obtenerProvincia(provincia);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return personas;
	}

	public Persona buscarPorId(int numId) {
		PersonaDAO pdao = null;
		Persona persona = null;
		pdao = new MySQLPersonaDAO();		
		try {
			persona = pdao.obtener(numId);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return persona;
	}
	
}
