package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.modelo.Persona;
import easyHosp.servicio.SolicitudServicio;

/**
 * Servlet implementation class SolicitarHospedajeController
 */
@SuppressWarnings("serial")
public class SolicitarHospedajeController extends HttpServlet {
	
	SolicitudServicio servicio = new SolicitudServicio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarHospedajeController() {
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
		String desde = request.getParameter("desde");
		String hasta = request.getParameter("hasta");
		String comentario = request.getParameter("comentario");
		int idDueño = Integer.parseInt(request.getParameter("idDueño"));	
		int idSolicitador = Integer.parseInt(request.getParameter("idSolicitador"));
		
		Persona persona = servicio.altaSolicitud(desde, hasta, comentario, idDueño, idSolicitador);
		if (persona!= null){
			request.setAttribute("persona", persona);
			request.setAttribute("msj", "Solicitud enviada exitosamente");
			request.setAttribute("tipo", 1);
			request.getRequestDispatcher("MisSolicitudesController?tipo=1").forward(request,response);
		}else{
			request.setAttribute("persona", persona);
			request.setAttribute("msj", "Error al enviar la solicitud");
			request.setAttribute("tipo", 2);
			request.getRequestDispatcher("MisSolicitudesController?tipo=1").forward(request,response);
		}
	}
}
