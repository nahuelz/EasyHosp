package easyHosp.servicio;

import java.util.List;

import easyHosp.dao.CasaDAO;
import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.dao.mysql.MySQLCasaDAO;
import easyHosp.dao.mysql.MySQLPersonaDAO;
import easyHosp.modelo.Casa;
import easyHosp.modelo.Persona;

public class PersonaServicio {
	
	public Persona login(String email, String password) throws ClassNotFoundException {
		Persona per = null;
		PersonaDAO dao = new MySQLPersonaDAO();
		try {
			if (dao.login(email, password)){
				per = dao.obtener(email);
			}else{
				return null;
			}
		} catch (DAOException e) {
			System.out.println("No se pudo conectar a la base de datos");
		}
		
		return per;

	}
	
	public Persona registrar (String nombre, String apellido, String email, String password, int disponible, String lugar, 
			String chicos, String mascota, String permitidoFumar, String habitacionCompartida, String provincia, String ciudad){
		
		boolean agregoCasa = false;
		Persona per = new Persona();
		Casa casa = new Casa();
		
		//AGREGO LA CASA A LA BASE DE DATOS
		casa.setChicos(chicos);
		casa.setLugar(lugar);
		casa.setMascota(mascota);
		casa.setPermitidoFumar(permitidoFumar);
		casa.setHabitacionCompartida(habitacionCompartida);
		casa.setContacto(email);

		CasaDAO dao = new MySQLCasaDAO();
		try {
			dao.insertar(casa);
			agregoCasa = true;
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		
		dao = null;
		dao = new MySQLCasaDAO();
		try {
			casa = dao.obeterPorContacto(email);
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		
		// SI PUDE AGREGAR LA CASA, AGREGO LA PERSONA TAMBIEN 
		if (agregoCasa){
			per.setNombre(nombre);
			per.setApellido(apellido);
			per.setEmail(email);
			per.setPassword(password);
			per.setCasa(casa);
			per.setProvincia(provincia);
			per.setCiudad(ciudad);
			per.setDisponible(disponible);
			
				PersonaDAO daso = new MySQLPersonaDAO();
				try {
					daso.insertar(per);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	return per;
	}

	public boolean existeEmail(String email) {
		boolean result = false;
		Persona p = null;
		try {
			PersonaDAO daso = new MySQLPersonaDAO();
			p = daso.obtener(email);
			if (p != null){
				result = true;
			}
		}catch(Exception e){
			System.out.println("El email NO esta en uso");
		}
		return result;
	}

	public Persona obtener(int id) {
		Persona per = null;
		try {
			PersonaDAO pdao = new MySQLPersonaDAO();
			per = pdao.obtener(id);
		}catch(Exception e){
			System.out.println("Error");
		}
		return per;
	}


	public void setearDisponibilidad(int id, int setDisp) {
		try {
			PersonaDAO pdao = new MySQLPersonaDAO();
			pdao.setearDisponibilidad(id, setDisp);
		}catch(Exception e){
			System.out.println("Error");
		}
	}

	public void modificarPersona(int id, String nombre, String apellido, String password,
			String provincia, String ciudad, String sexo, String dni, String telefono) {
		Persona per = null;
		PersonaDAO pdao = new MySQLPersonaDAO();
		try {
			per = pdao.obtener(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setPassword(password);
		per.setProvincia(provincia);
		per.setCiudad(ciudad);
		per.setDni(dni);
		per.setTelefono(telefono);
		per.setSexo(sexo);
	
		PersonaDAO dao = new MySQLPersonaDAO();
		try {
			dao.modificar(per);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

	public void modificarCasa(int id, String lugar, String chicos, String mascota, String fumar, String compartida) {
		Casa casa = null;
		CasaDAO cdao = new MySQLCasaDAO();
		try {
			casa = cdao.obtener(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		casa.setLugar(lugar);
		casa.setChicos(chicos);
		casa.setMascota(mascota);
		casa.setPermitidoFumar(fumar);
		casa.setHabitacionCompartida(compartida);
		
	
		CasaDAO dao = new MySQLCasaDAO();
		try {
			dao.modificar(casa);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}
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
