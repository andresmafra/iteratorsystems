package br.iteratorsystems.cps.interfaces;

import java.util.Collection;

import br.iteratorsystems.cps.exceptions.CpsConstraintException;
import br.iteratorsystems.cps.exceptions.CpsDaoException;

public interface IDao<T extends EntityAble> {
	
	Integer save(T instance) throws CpsDaoException,CpsConstraintException;
	T get(T instance) throws CpsDaoException;
	Collection<T> getAll() throws CpsDaoException;
	void update(T instance) throws CpsDaoException,CpsConstraintException;
	void delete(T instance) throws CpsDaoException,CpsConstraintException;
}
