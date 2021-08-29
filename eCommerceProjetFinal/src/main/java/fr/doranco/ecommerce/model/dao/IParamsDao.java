package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.Params;

public interface IParamsDao {
	Params getParams(Integer id) throws Exception;
;
	Params addParams(Params params) throws Exception;
	
	void updatParams(Params params) throws Exception;
	void removeParams(Integer id) throws Exception;


}
