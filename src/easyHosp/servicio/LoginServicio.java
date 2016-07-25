package easyHosp.servicio;

import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.dao.mysql.MySQLPersonaDAO;
import easyHosp.modelo.Persona;


public class LoginServicio {

	public Persona login(String email, String password) throws ClassNotFoundException {
		Persona per = null;
		PersonaDAO dao = new MySQLPersonaDAO();
		try {
			if (dao.login(email, password)){
				per = dao.obtener(email);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return per;

	}

}
