package easyHosp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyHosp.modelo.Solicitud;
import easyHosp.servicio.SolicitudServicio;

/**
 * Servlet implementation class SolicitudController
 */
@SuppressWarnings("serial")
public class MisSolicitudesController extends HttpServlet {
	
	SolicitudServicio servicio = new SolicitudServicio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MisSolicitudesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tipo = request.getParameter("tipo");
		int idUsu = (int) session.getAttribute("id");
		List<Solicitud> sol = null;
		if (!tipo.equals("1")){
			sol = servicio.buscarRecibidas(idUsu);
			if (!sol.isEmpty()){
				request.setAttribute("solicitudes", sol);
			}else{
				request.setAttribute("tipo", 2);
				request.setAttribute("msj", "No se encontraron solicitudes recibidas");
			}
			request.getRequestDispatcher("solicitudesRecibidas.jsp").forward(request,response);
		}else{
			sol = servicio.buscarEnviadas(idUsu);
			if (!sol.isEmpty()){
				request.setAttribute("solicitudes", sol);				
			}else{
				request.setAttribute("tipo", 2);
				request.setAttribute("msj", "No se encontraron solicitudes enviadas");
			}
			request.getRequestDispatcher("solicitudesEnviadas.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
