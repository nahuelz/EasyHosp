package easyHosp.dao;

import easyHosp.modelo.Persona;

public interface PersonaDAO extends DAO<Persona, Long> {
	
	boolean login (String email, String password) throws DAOException;
	
	Persona obtener (String email) throws DAOException;

}

