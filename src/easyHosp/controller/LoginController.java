package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.modelo.Persona;
import easyHosp.servicio.LoginServicio;

/**
 * Servlet implementation class LoginController
 */

@SuppressWarnings("serial")
public class LoginController extends HttpServlet {
	
	LoginServicio servicio = new LoginServicio();
       
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
			request.setAttribute("per", per);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}else{
			request.setAttribute("per", per);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

}
