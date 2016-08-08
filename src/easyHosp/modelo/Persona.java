package easyHosp.modelo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UserModel
 */
@Stateless
@LocalBean

public class Persona {
	int id;
	String nombre;
	String apellido;
	String email;
	String password;	
	int isAdmin;
	String provincia;
	String ciudad;
	String telefono;
	String dni;
	String sexo;
	Casa casa;
	int disponible;

	public Persona(){
		isAdmin = 0;
		telefono = "";
		dni = "";
		sexo = "";
	}
	public Persona(int id, String nombre, String apellido, String email, String password, int isAdmin, String provincia,
			String ciudad, String telefono, String dni, String sexo, Casa casa, int disponible) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.dni = dni;
		this.sexo = sexo;
		this.casa = casa;
		this.disponible = disponible;
	}
	
	public Persona(int id, String nombre, String apellido, String password, String email, int isAdmin, String provincia, String ciudad, Casa casa) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
		this.provincia = provincia;
		this.ciudad = ciudad;
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
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}


	public Casa getCasa() {
		return casa;
	}


	public void setCasa(Casa casa) {
		this.casa = casa;
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
	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
