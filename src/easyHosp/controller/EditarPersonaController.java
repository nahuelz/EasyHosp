package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.servicio.PersonaServicio;

/**
 * Servlet implementation class EditarPersonaController
 */
@WebServlet("/EditarPersonaController")
public class EditarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PersonaServicio servicio = new PersonaServicio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPersonaController() {
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
		String passwordAct = request.getParameter("passwordAct");
		String password = request.getParameter("password");
		if (passwordAct.equals(password)){
			//DATOS PERSONA
			int id = Integer.parseInt(request.getParameter("id"));
			String apellido = request.getParameter("apellido");
			String nombre =  request.getParameter("nombre");
			String provincia = request.getParameter("provincia");
			String ciudad = request.getParameter("ciudad");
			String sexo = request.getParameter("sexo");
			String dni = request.getParameter("dni");
			String telefono = request.getParameter("tel");
			
			servicio.modificarPersona(id, nombre, apellido, password, provincia, ciudad, sexo, dni, telefono);
	
			request.setAttribute("msj", "Datos guardados exitosamente");
			request.setAttribute("tipo", 1);
		}else{
			request.setAttribute("msj", "Password incorrecto");
			request.setAttribute("tipo", 2);
		}
		request.getRequestDispatcher("MiCuentaController").forward(request,response);

	}

}
