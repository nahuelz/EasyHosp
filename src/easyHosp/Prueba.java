package easyHosp;

import java.util.ArrayList;
import java.util.List;

import easyHosp.modelo.Persona;
import interfaces.DAOPersona;
import interfaces.DAOPersonaImpl;

public class Prueba {

	public static void main(String[] args) throws Exception {
		
		DAOPersona dao = new DAOPersonaImpl();
		
		// REGISTRAR UNA PERSONA
				Persona per = new Persona();
				per.setNombre("Nahuel2");
				per.setApellido("Zanelli2");
				per.setEmail("nahuelz123@hotmail.com");
				per.setPassword("123456123");
				dao.registrar(per);
				
		// LOGEAR
				Persona per2 = new Persona();
				per2.setEmail("nahuelz1423@hotmail.com");
				per2.setPassword("123456123");
				boolean rs = dao.login(per2);
				System.out.println("Logeado: "+rs);
				
		// LISTAR TODOS LOS USUARIOS CON SU NOMBRE E ID
		try{
			List<Persona> lista = new ArrayList<Persona>();
			lista = dao.listar();
			
			for (int i = 0; i<lista.size(); i++){
				System.out.println(lista.get(i).getNombre()+ " " + lista.get(i).getId());
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		// MODIFICAR UNA PERSONA
			Persona pers = new Persona();
			pers.setId(1);
			pers.setNombre("joseito");
			dao.modificar(pers);
		
		
	
	}

}
