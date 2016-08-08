package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyHosp.servicio.FavoritoServicio;

/**
 * Servlet implementation class AgregarFavorito
 */
@WebServlet("/AgregarFavorito")
public class AgregarFavorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoritoServicio servicio = new FavoritoServicio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarFavorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idPersonaFav = Integer.parseInt(request.getParameter("id"));
		int idPersona = (int) session.getAttribute("id");
		if (servicio.obtenerFavorito(idPersona,idPersonaFav)){
			request.setAttribute("tipo", 2);
			request.setAttribute("msj", "La persona ya se encontraba en favoritos!");
		}else{
			servicio.agregarFavorito(idPersona, idPersonaFav);
			request.setAttribute("tipo", 1);
			request.setAttribute("msj", "Favorito agregado!");		
		}
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
