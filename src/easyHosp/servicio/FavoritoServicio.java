package easyHosp.servicio;

import java.util.List;

import easyHosp.dao.DAOException;
import easyHosp.dao.FavoritoDAO;
import easyHosp.dao.PersonaDAO;
import easyHosp.dao.mysql.MySQLFavoritoDAO;
import easyHosp.dao.mysql.MySQLPersonaDAO;
import easyHosp.modelo.Favorito;
import easyHosp.modelo.Persona;

public class FavoritoServicio {
	
	public void agregarFavorito (int idPersona, int idPersonaFav){
		FavoritoDAO fdao = new MySQLFavoritoDAO();
		PersonaDAO pdao = new MySQLPersonaDAO();
		Persona persona = null;
		try {
			persona = pdao.obtener(idPersona);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Persona personaFav= null;
		try {
			personaFav = pdao.obtener(idPersonaFav);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Favorito fav = new Favorito();
		fav.setPersona(persona);
		fav.setPersonaFav(personaFav);
		try {
			fdao.insertar(fav);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Favorito> obtenerTodosById(int id) {
		FavoritoDAO fdao = new MySQLFavoritoDAO();
		List<Favorito> favoritos = null;
		try {
			favoritos = fdao.obtenerTodosById(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return favoritos;
	}

	public boolean obtenerFavorito(int idPersona, int idPersonaFav) {
		FavoritoDAO fdao = new MySQLFavoritoDAO();
		try {
			if (fdao.obtener(idPersona, idPersonaFav)){
				return true;
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
			return false;
	}

	public void eliminarFavorito(int idFav) {
		FavoritoDAO fdao = new MySQLFavoritoDAO();
		try {
			fdao.eliminar(idFav);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public List<Favorito> obtenerTodos() {
		FavoritoDAO fdao = new MySQLFavoritoDAO();
		List<Favorito> favoritos = null;
		try {
			favoritos = fdao.obtenerTodos();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return favoritos;
	}
}
