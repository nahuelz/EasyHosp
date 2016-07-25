package easyHosp.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.modelo.Persona;

public class Prueba {

	public static void main(String[] args) throws DAOException, SQLException{
		 Connection conn = null;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","");
			PersonaDAO dao = new MySQLPersonaDAO(conn);
			List<Persona> personas = dao.obtenerTodos();
			for (Persona p: personas){
				System.out.println(p.toString());
			}
			
		}finally{
			if (conn != null){
				conn.close();
			}
		}
		
		
	}

}
