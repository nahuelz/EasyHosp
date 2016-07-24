package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.modelo.Persona;
import interfaces.DAOPersona;
import interfaces.DAOPersonaImpl;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPersona dao = new DAOPersonaImpl();
		Persona per = new Persona();
		per.setApellido(request.getParameter("apellido"));
		per.setNombre(request.getParameter("nombre"));
		per.setEmail(request.getParameter("email"));
		per.setPassword(request.getParameter("password"));
		per.setProvincia(request.getParameter("provincia").toLowerCase());
		per.setCiudad(request.getParameter("ciudad").toLowerCase());
		try {
			dao.registrar(per);
			System.out.println("Registrado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("http://localhost:8080/EasyHosp/");
		
	}
	
			

}
