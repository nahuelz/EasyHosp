package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyHosp.modelo.Persona;
import easyHosp.servicio.PersonaServicio;

/**
 * Servlet implementation class MiCasaController
 */
@WebServlet("/MiCasaController")
public class MiCasaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonaServicio servicio = new PersonaServicio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiCasaController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		Persona per = null;
		per = servicio.obtener(id);
		request.setAttribute("persona", per);
		request.getRequestDispatcher("miCasa.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
