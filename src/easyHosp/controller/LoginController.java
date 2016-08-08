package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyHosp.modelo.Persona;
import easyHosp.servicio.PersonaServicio;

/**
 * Servlet implementation class LoginController
 */

@SuppressWarnings("serial")
public class LoginController extends HttpServlet {
	
	PersonaServicio servicio = new PersonaServicio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Persona per = null;
		try {
			per = servicio.login(email, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		if (per != null){
			HttpSession session = request.getSession();
			session.setAttribute("id", per.getId());
			session.setAttribute("pass", per.getPassword());
			session.setAttribute("nombre", per.getNombre());
			session.setAttribute("apellido", per.getApellido());
			session.setAttribute("email", per.getEmail());
			session.setAttribute("isAdmin", per.getIsAdmin());
			session.setAttribute("provincia", per.getProvincia());
			session.setAttribute("ciudad", per.getCiudad());
			request.setAttribute("per", per);
			request.getRequestDispatcher("home.jsp").forward(request,response);
		}else{
			request.setAttribute("msj", "Email o password incorrecto");
			request.setAttribute("tipo", 2);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
	}

}
