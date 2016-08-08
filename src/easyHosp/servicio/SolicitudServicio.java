package easyHosp.servicio;

import java.util.List;

import easyHosp.dao.DAOException;
import easyHosp.dao.PersonaDAO;
import easyHosp.dao.SolicitudDAO;
import easyHosp.dao.mysql.MySQLPersonaDAO;
import easyHosp.dao.mysql.MySQLSolicitudDAO;
import easyHosp.modelo.Persona;
import easyHosp.modelo.Solicitud;

public class SolicitudServicio {

	
	public Persona altaSolicitud(String desde, String hasta, String comentario, int idDueño, int idSolicitador){
		Persona dueño = null;
		PersonaDAO ddao = new MySQLPersonaDAO();
		try{
			dueño = ddao.obtener(idDueño);
		}catch(DAOException e1){
			e1.printStackTrace();
		}
		
		Persona solicitador = null;
		PersonaDAO sodao = new MySQLPersonaDAO();
		try{
			solicitador = sodao.obtener(idSolicitador);
		}catch(DAOException e1){
			e1.printStackTrace();
		}
		
		Solicitud sol = new Solicitud();
		sol.setDesde(desde);
		sol.setHasta(hasta);
		sol.setComentario(comentario);
		sol.setDueño(dueño);
		sol.setEstado(0);
		sol.setSolicitador(solicitador);
				
		SolicitudDAO sdao = new MySQLSolicitudDAO();
		try {
			sdao.insertar(sol);
		} catch (DAOException e) {
			e.printStackTrace();
		}finally{
			sdao.cerrar();	
		}
		
		return dueño;
	}
	

	public List<Solicitud> buscarRecibidas (int id){
		SolicitudDAO sdao = new MySQLSolicitudDAO();
		List<Solicitud> sol = null;
		try {
			sol = sdao.obtenerRecibidas(id);
		} catch (DAOException e) {
			e.printStackTrace();
		} finally{
			sdao.cerrar();	
		}
		return sol;
	}
	
	public List<Solicitud> buscarEnviadas (int id){
		SolicitudDAO sdao = new MySQLSolicitudDAO();
		List<Solicitud> sol = null;
		try {
			sol = sdao.obtenerEnviadas(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		finally{
			sdao.cerrar();	
		}
		return sol;
	}


	public void bajaSolicitud(int idSolicitud) {
		SolicitudDAO sdao = new MySQLSolicitudDAO();
		try {
			sdao.eliminar(idSolicitud);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		finally{
			sdao.cerrar();	
		}
	}


	public void aceptarSolicitud(int idSolicitud) {
		SolicitudDAO sdao = new MySQLSolicitudDAO();
		Solicitud sol = null;
		try {
			sol = sdao.obtener(idSolicitud);
			sol.setEstado(1);
			sdao = null;
			sdao = new MySQLSolicitudDAO();
			sdao.modificar(sol);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		finally{
			sdao.cerrar();	
		}
		
	}


	public void rechazarSolicitud(int idSolicitud) {
		SolicitudDAO sdao = new MySQLSolicitudDAO();
		Solicitud sol = null;
		try {
			sol = sdao.obtener(idSolicitud);
			sol.setEstado(2);
			sdao = null;
			sdao = new MySQLSolicitudDAO();
			sdao.modificar(sol);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		finally{
			sdao.cerrar();	
		}
		
	}
		
		
}
