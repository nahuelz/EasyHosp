package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.servicio.RegistroServicio;

/**
 * Servlet implementation class RegistroController
 */
@SuppressWarnings("serial")
public class RegistroController extends HttpServlet {
	
	RegistroServicio servicio = new RegistroServicio();
       
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
		//DATOS PERSONA
		String apellido = request.getParameter("apellido");
		String nombre =  request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//DATOS CASA
		String disponible = request.getParameter("disponible");
		String lugar = request.getParameter("lugar");
		String chicos = request.getParameter("chicos");
		String mascota = request.getParameter("mascota");
		String fumar = request.getParameter("fumar");
		String compartida = request.getParameter("compartida");	
		String provincia = request.getParameter("provincia");
		String ciudad = request.getParameter("ciudad");
		servicio.registrar(nombre, apellido, email, password, disponible, lugar, chicos, mascota, fumar, compartida, provincia, ciudad);
	
		request.getRequestDispatcher("login.jsp").forward(request,response);
		
	}
			

}
