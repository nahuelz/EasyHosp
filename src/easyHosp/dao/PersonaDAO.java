package easyHosp.dao;



import java.util.List;

import easyHosp.modelo.Persona;

public interface PersonaDAO extends DAO<Persona, Long> {
	
	boolean login (String email, String password) throws DAOException;
	
	Persona obtener (String email) throws DAOException;

	List<Persona> obtenerProvincia(String provincia) throws DAOException;

	void setearDisponibilidad (int id, int disponible) throws DAOException;

}

