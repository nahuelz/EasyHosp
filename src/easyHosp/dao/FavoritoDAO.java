package easyHosp.dao;

import java.util.List;

import easyHosp.modelo.Favorito;

public interface FavoritoDAO extends DAO<Favorito, Long> {

	List<Favorito> obtenerTodosById(int id) throws DAOException;

	boolean obtener(int idPersona, int idPersonaFav) throws DAOException;

}
