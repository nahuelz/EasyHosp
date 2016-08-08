package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyHosp.servicio.PersonaServicio;

/**
 * Servlet implementation class SetearDisponibilidad
 */
@WebServlet("/SetearDisponibilidad")
public class SetearDisponibilidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PersonaServicio servicio = new PersonaServicio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetearDisponibilidad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		int setDisp = Integer.parseInt(request.getParameter("setDisp"));
		servicio.setearDisponibilidad(id, setDisp);
		request.getRequestDispatcher("MiCasaController").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
