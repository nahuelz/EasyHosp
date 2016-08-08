 package easyHosp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyHosp.modelo.Favorito;
import easyHosp.modelo.Persona;
import easyHosp.servicio.FavoritoServicio;
import easyHosp.servicio.HospedajeServicio;

/**
 * Servlet implementation class HospedajeController
 */
@SuppressWarnings("serial")
public class HospedajeController extends HttpServlet {
       HospedajeServicio servicio = new HospedajeServicio();
       FavoritoServicio serviciof = new FavoritoServicio();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospedajeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boton = request.getParameter("boton");
		String provincia = request.getParameter("provincia");
		List<Persona> personas = null;
		String msj2 = "";
		if (boton.equals("porProvincia") & (!provincia.equals("todos"))){
			msj2 = "en la provincia de " + provincia;
			personas = servicio.buscarPorProvincia(provincia);
		}else{
			personas = servicio.buscarTodos();		
		}
		if (!personas.isEmpty()){
			HttpSession session = request.getSession();
			if (session.getAttribute("id") != null){
				int id = (int) session.getAttribute("id");			
				List<Favorito> favoritos = serviciof.obtenerTodosById(id);
				request.setAttribute("favoritos", favoritos);
			}
			request.setAttribute("personas", personas);
			request.setAttribute("tipo", 1);
			request.setAttribute("msj", "Se encontraron los siguientes hospedajes disponibles " + msj2 + "!");
			request.getRequestDispatcher("hospedajes.jsp").forward(request,response);
		}else{
			request.setAttribute("tipo", 2);
			request.setAttribute("msj", "Lo sentimos, no hay hospedajes diponible en la provincia de " + provincia);
			request.getRequestDispatcher("hospedajes.jsp").forward(request,response);
		}
	}

}
