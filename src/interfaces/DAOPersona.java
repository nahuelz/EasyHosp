package interfaces;

import java.util.List;
import easyHosp.modelo.Persona;

public interface DAOPersona {
	
	public boolean login (Persona per) throws Exception;
 	public void registrar(Persona per) throws Exception;
	public void modificar(Persona per) throws Exception;
	public void eliminar(Persona per) throws Exception;
	public List<Persona> listar() throws Exception;

}
