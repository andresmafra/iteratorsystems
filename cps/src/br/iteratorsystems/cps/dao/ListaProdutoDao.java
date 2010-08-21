package br.iteratorsystems.cps.dao;

import org.hibernate.Session;

import br.iteratorsystems.cps.entities.ListaProduto;

/**
 * Classe Dao de lista de produto.
 * @author Andr�
 *
 */
public class ListaProdutoDao extends DaoGeneric<ListaProduto, Integer> {

	/**
	 * Construtor padr�o
	 * @param persistentClass - persistentClass
	 * @param session - session
	 */
	public ListaProdutoDao(Class<ListaProduto> persistentClass, Session session) {
		super(persistentClass, session);
	}
}
