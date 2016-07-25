package easyHosp.servicio;

import easyHosp.dao.CasaDAO;
import easyHosp.dao.PersonaDAO;
import easyHosp.dao.mysql.MySQLCasaDAO;
import easyHosp.dao.mysql.MySQLPersonaDAO;
import easyHosp.modelo.Casa;
import easyHosp.modelo.Persona;

public class RegistroServicio {
	
	public Persona registrar (String nombre, String apellido, String email, String password, String disponible, String lugar, 
			String chicos, String mascota, String permitidoFumar, String habitacionCompartida, String provincia, String ciudad){
		
		Casa casa = new Casa();
		casa.setChicos(chicos);
		casa.setDisponible(disponible);
		casa.setLugar(lugar);
		casa.setMascota(mascota);
		casa.setPermitidoFumar(permitidoFumar);
		casa.setHabitacionCompartida(habitacionCompartida);
		casa.setProvincia(provincia);
		casa.setCiudad(ciudad);
		try {
			CasaDAO dao = new MySQLCasaDAO();
			dao.insertar(casa);
		}catch(Exception e){
			System.out.println("No se pudo registrar la casa");
		}
		
		Persona per = new Persona();
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setEmail(email);
		per.setPassword(password);
		per.setCasa(casa);
		try {
			PersonaDAO dao = new MySQLPersonaDAO();
			dao.insertar(per);
		}catch(Exception e){
			System.out.println("No se pudo registrar el usuario");
		}
		return per;
	}

}
