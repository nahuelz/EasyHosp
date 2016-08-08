package easyHosp.dao;

import easyHosp.modelo.Casa;

public interface CasaDAO extends DAO<Casa, Long> {

	Casa obeterPorContacto(String email) throws DAOException;	
}
