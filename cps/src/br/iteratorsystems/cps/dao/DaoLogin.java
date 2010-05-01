package br.iteratorsystems.cps.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.iteratorsystems.cps.entities.ENDERECO;
import br.iteratorsystems.cps.entities.LOGIN;
import br.iteratorsystems.cps.entities.USUARIO;
import br.iteratorsystems.cps.exceptions.CpsDaoException;
import br.iteratorsystems.cps.interfaces.EntityAble;

public class DaoLogin extends Dao<EntityAble> {
	
	//TODO melhorar este metodo similar ao da classe pai!
	public LOGIN get(final String username,final String password) throws CpsDaoException{
		Criteria criteria = getSession().createCriteria(LOGIN.class);
		criteria.add(Restrictions.eq("nomeLogin", username));
		criteria.add(Restrictions.eq("senha",password));
		return (LOGIN) criteria.uniqueResult();
	}
	
	//TODO melhorar este metodo similar ao da classe pai!
	public USUARIO getUsuarioRelated(final Integer idLogin) throws CpsDaoException{
		Criteria criteria = getSession().createCriteria(USUARIO.class);
		criteria.add(Restrictions.eq("idUsuario",idLogin));
		return (USUARIO) criteria.uniqueResult();
	}
	
	//TODO melhorar este metodo similar ao da classe pai!
	public ENDERECO getEnderecoRelated(final Integer idUsuario) throws CpsDaoException {
		Criteria criteria = getSession().createCriteria(ENDERECO.class);
		criteria.add(Restrictions.eq("idUsuario",idUsuario));
		return (ENDERECO) criteria.uniqueResult();
	}
}