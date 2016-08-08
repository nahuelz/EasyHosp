package easyHosp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyHosp.modelo.Favorito;
import easyHosp.servicio.FavoritoServicio;

/**
 * Servlet implementation class FavoritoController
 */
@WebServlet("/FavoritoController")
public class FavoritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FavoritoServicio servicio = new FavoritoServicio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoritoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		List<Favorito> favoritos = null;
		favoritos = servicio.obtenerTodosById(id);
		if (!favoritos.isEmpty()){
			request.setAttribute("favoritos", favoritos);
			request.getRequestDispatcher("favoritos.jsp").forward(request,response);
		}else{
			request.setAttribute("tipo", 2);
			request.setAttribute("msj", "Todavia no has agregado ningun favorito!");
			request.setAttribute("favoritos", favoritos);
			request.getRequestDispatcher("favoritos.jsp").forward(request,response);
		}
	}

}
