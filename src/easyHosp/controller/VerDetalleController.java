package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.modelo.Persona;
import easyHosp.servicio.HospedajeServicio;

/**
 * Servlet implementation class VerDetalleController
 */
@SuppressWarnings("serial")
@WebServlet("/VerDetalleController")
public class VerDetalleController extends HttpServlet {
	
	HospedajeServicio servicio = new HospedajeServicio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerDetalleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int numId = Integer.parseInt(id);
		Persona persona = null;
		persona = servicio.buscarPorId(numId);
		request.setAttribute("persona", persona);
		request.getRequestDispatcher("detalle.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
