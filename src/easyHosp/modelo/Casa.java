package easyHosp.modelo;

public class Casa {
	int id;
	String lugar;
	String chicos;
	String mascota;
	String permitidoFumar;
	String habitacionCompartida;
	String contacto;
	

	public Casa(){
		
	}
	
	public Casa(int id, String lugar, String chicos, String permitidoFumar, String habitacionCompartida,
			String mascota, String contacto) {
		this.id = id;
		this.lugar = lugar;
		this.chicos = chicos;
		this.mascota = mascota;
		this.permitidoFumar = permitidoFumar;
		this.habitacionCompartida = habitacionCompartida;
		this.contacto = contacto;
	}

	public int getId() {
		return id;
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
	
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	

}
