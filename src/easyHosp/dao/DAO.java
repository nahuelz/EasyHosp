package easyHosp.dao;

import java.util.List;

public interface DAO<T, K> {
	
	void insertar (T c) throws DAOException;
	
	void modificar (T c) throws DAOException;
	
	void eliminar (T c) throws DAOException;
	
	List<T> obtenerTodos() throws DAOException;
	
	T obtener(int id)  throws DAOException;
}
