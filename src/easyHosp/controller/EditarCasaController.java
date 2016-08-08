package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.servicio.PersonaServicio;

/**
 * Servlet implementation class EditarCasaController
 */
@WebServlet("/EditarCasaController")
public class EditarCasaController extends HttpServlet {
	PersonaServicio servicio = new PersonaServicio();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCasaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwordAct = request.getParameter("passwordAct");
		String password = request.getParameter("password");
		if (passwordAct.equals(password)){
			//DATOS PERSONA
			int id = Integer.parseInt(request.getParameter("id"));
			String lugar = request.getParameter("lugar");
			String chicos =  request.getParameter("chicos");
			String mascota = request.getParameter("mascota");
			String fumar = request.getParameter("fumar");
			String compartida = request.getParameter("compartida");
			
			servicio.modificarCasa(id, lugar, chicos, mascota, fumar, compartida);
	
			request.setAttribute("msj", "Datos guardados exitosamente");
			request.setAttribute("tipo", 1);
		}else{
			request.setAttribute("msj", "Password incorrecto");
			request.setAttribute("tipo", 2);
		}
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
