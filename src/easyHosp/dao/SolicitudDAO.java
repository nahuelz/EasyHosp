package easyHosp.dao;

import java.util.List;

import easyHosp.modelo.Solicitud;

public interface SolicitudDAO extends DAO<Solicitud, Long> {

	List<Solicitud> obtenerRecibidas(int id) throws DAOException;
	List<Solicitud> obtenerEnviadas(int id) throws DAOException;
	void cerrar();
}
