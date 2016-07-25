package easyHosp.modelo;

public class Casa {
	int id;
	Persona dueño;
	String lugar;
	String chicos;
	String mascota;
	String permitidoFumar;
	String habitacionCompartida;
	String provincia;
	String ciudad;
	String disponible;
	
	public Casa(){
		
	}
	
	public Casa(String lugar, String chicos, String permitidoFumar, String habitacionCompartida, String disponible,
			String provincia, String ciudad, String mascota) {
		this.lugar = lugar;
		this.chicos = chicos;
		this.mascota = mascota;
		this.permitidoFumar = permitidoFumar;
		this.habitacionCompartida = habitacionCompartida;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.disponible = disponible;
	}

	public int getId() {
		return id;
	}
	public Persona getDueño() {
		return dueño;
	}
	public void setDueño(Persona per) {
		this.dueño = per;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getChicos() {
		return chicos;
	}
	public void setChicos(String chicos2) {
		this.chicos = chicos2;
	}
	public String getMascota() {
		return mascota;
	}
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	public String getPermitidoFumar() {
		return permitidoFumar;
	}
	public void setPermitidoFumar(String permitidoFumar) {
		this.permitidoFumar = permitidoFumar;
	}
	public String getHabitacionCompartida() {
		return habitacionCompartida;
	}
	public void setHabitacionCompartida(String piezaCompartida) {
		this.habitacionCompartida = piezaCompartida;
	}
	public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
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

}
