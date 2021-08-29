package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Params;

public interface IParamsMetier {
	Params addParams(Params params) throws Exception;
	List<Params> getParamss() throws Exception;
	void remove(Integer id) throws Exception;
	void update(Params params) throws Exception;

}
