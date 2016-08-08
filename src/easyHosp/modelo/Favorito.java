package easyHosp.modelo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UserModel
 */
@Stateless
@LocalBean

public class Favorito {
	int id;
	Persona Persona;
	Persona PersonaFav;
	
	public Favorito (){
		
	}
	
	public Favorito(int id, Persona persona, Persona personaFav) {
		this.id = id;
		Persona = persona;
		PersonaFav = personaFav;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Persona getPersona() {
		return Persona;
	}
	public void setPersona(Persona persona) {
		Persona = persona;
	}
	public Persona getPersonaFav() {
		return PersonaFav;
	}
	public void setPersonaFav(Persona personaFav) {
		PersonaFav = personaFav;
	}
}
