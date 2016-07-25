package easyHosp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.modelo.Persona;
import interfaces.DAOPersona;
import interfaces.DAOPersonaImpl;

/**
 * Servlet implementation class UserController
 */

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
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
		boolean logeado = false;
		DAOPersona dao = new DAOPersonaImpl();
		Persona per = new Persona();
		per.setEmail(request.getParameter("email"));
		per.setPassword(request.getParameter("password"));
		try {
			dao.login(per);
			logeado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logeado){
			request.setAttribute("per", per);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}else{
			request.setAttribute("per", per);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

}
