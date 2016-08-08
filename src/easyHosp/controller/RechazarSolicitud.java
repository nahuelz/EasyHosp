package easyHosp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyHosp.servicio.SolicitudServicio;

/**
 * Servlet implementation class RechazarSolicitud
 */
@WebServlet("/RechazarSolicitud")
public class RechazarSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SolicitudServicio servicio = new SolicitudServicio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechazarSolicitud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idSolicitud = Integer.parseInt(request.getParameter("id"));
		System.out.println(idSolicitud);
		servicio.rechazarSolicitud(idSolicitud);
		request.setAttribute("msj", "Solicitud Rechazada");
		request.setAttribute("tipo", 1);
		request.getRequestDispatcher("MisSolicitudesController?tipo=1").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}