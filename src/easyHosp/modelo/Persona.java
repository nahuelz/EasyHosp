package easyHosp.modelo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UserModel
 */
@Stateless
@LocalBean

public class Persona {

	Long id;
	String nombre;
	String apellido;
	String email;
	String password;
	String provincia;
	String ciudad;
	String telefono;	
	int isAdmin;
	Long casa;
	
	public Persona(){
		isAdmin = 0;
		casa = null;
	}


	public Persona(String nombre, String apellido, String telefono, String provincia, String ciudad,
			String password, String email, int isAdmin, Long casa) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.isAdmin = isAdmin;
		this.casa = casa;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getisAdmin() {
		return isAdmin;
	}
	public void setAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}


	public Long getCasa() {
		return casa;
	}


	public void setCasa(Long casa) {
		this.casa = casa;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", provincia=" + provincia + ", ciudad=" + ciudad + ", telefono="
				+ telefono + ", isAdmin=" + isAdmin + ", casa=" + casa + "]";
	}


	
	
}
