package easyHosp.modelo;

public class Solicitud {
	int id;
	Persona due�o;
	Persona solicitador;
	String desde;
	String hasta;
	int estado;
	String comentario;
	
	
	public Solicitud(){
		
	}
	
	public Solicitud(int id, Persona due�o, String desde, String hasta, int estado, String comentario, Persona solicitador) {
		this.id = id;
		this.due�o = due�o;
		this.solicitador = solicitador;
		this.desde = desde;
		this.hasta = hasta;
		this.estado = estado;
		this.comentario = comentario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Persona getDue�o() {
		return due�o;
	}

	public void setDue�o(Persona due�o) {
		this.due�o = due�o;
	}

	public Persona getSolicitador() {
		return solicitador;
	}

	public void setSolicitador(Persona solicitador) {
		this.solicitador = solicitador;
	}

}
