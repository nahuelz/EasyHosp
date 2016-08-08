package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.servicio.PersonaServicio;

/**
 * Servlet implementation class RegistroController
 */
@SuppressWarnings("serial")
public class RegistroController extends HttpServlet {
	
	PersonaServicio servicio = new PersonaServicio();
       
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
		//VERIFICO QUE NO EXISTA EL EMAIL
		String email = request.getParameter("email");
		if (!servicio.existeEmail(email)){
			//DATOS PERSONA
			String apellido = request.getParameter("apellido");
			String nombre =  request.getParameter("nombre");
			String password = request.getParameter("password");
			String provincia = request.getParameter("provincia");
			String ciudad = request.getParameter("ciudad");
			int disponible = Integer.parseInt(request.getParameter("disponible"));
			
			//DATOS CASA
			String lugar = request.getParameter("lugar");
			String chicos = request.getParameter("chicos");
			String mascota = request.getParameter("mascota");
			String fumar = request.getParameter("fumar");
			String compartida = request.getParameter("compartida");	
			servicio.registrar(nombre, apellido, email, password, disponible, lugar, chicos, mascota, fumar, compartida, provincia, ciudad);

			request.setAttribute("msj", "Cuenta creada exitosamente");
			request.setAttribute("tipo", 1);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}else{
			request.setAttribute("msj", "Ya existe un usuario registrado con este email");
			request.setAttribute("tipo", 2);
			request.getRequestDispatcher("registro.jsp").forward(request,response);
		
		}
	}
			

}
