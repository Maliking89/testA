package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.Params;
import fr.doranco.ecommerce.model.dao.IParamsDao;

import fr.doranco.ecommerce.model.dao.ParamsDao;


public class ParamsMetier implements IParamsMetier {
	private final IParamsDao paramsDao = new ParamsDao();

	@Override
	public Params addParams(Params params) throws Exception {
		
		return paramsDao.addParams(params);
	}

	@Override
	public List<Params> getParamss() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) throws Exception {
		paramsDao.removeParams(id);
		
	}

	@Override
	public void update(Params params) throws Exception {
		paramsDao.updatParams(params);
		
	}

}
