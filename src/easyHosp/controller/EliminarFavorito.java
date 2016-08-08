package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.servicio.FavoritoServicio;

/**
 * Servlet implementation class EliminarFavorito
 */
@WebServlet("/EliminarFavorito")
public class EliminarFavorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoritoServicio servicio = new FavoritoServicio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarFavorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFav = Integer.parseInt(request.getParameter("id"));
		System.out.println(idFav);
		servicio.eliminarFavorito(idFav);
		request.setAttribute("tipo", 1);
		request.setAttribute("msj", "Favorito eliminado!");		
		request.getRequestDispatcher("FavoritoController").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
