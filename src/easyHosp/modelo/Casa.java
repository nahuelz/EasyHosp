package easyHosp.modelo;

public class Casa {
	Long id;
	Long dueño;
	int huesped;
	boolean chicos;
	boolean mascota;
	boolean permitidoFumar;
	boolean piesaCompartida;
	String ubicacion;
	boolean disponible;
	
	public Casa(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDueño() {
		return dueño;
	}
	public void setDueño(Long dueño) {
		this.dueño = dueño;
	}
	public int getHuesped() {
		return huesped;
	}
	public void setHuesped(int huesped) {
		this.huesped = huesped;
	}
	public boolean isChicos() {
		return chicos;
	}
	public void setChicos(boolean chicos) {
		this.chicos = chicos;
	}
	public boolean isMascota() {
		return mascota;
	}
	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}
	public boolean isPermitidoFumar() {
		return permitidoFumar;
	}
	public void setPermitidoFumar(boolean permitidoFumar) {
		this.permitidoFumar = permitidoFumar;
	}
	public boolean isPiesaCompartida() {
		return piesaCompartida;
	}
	public void setPiesaCompartida(boolean piesaCompartida) {
		this.piesaCompartida = piesaCompartida;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
