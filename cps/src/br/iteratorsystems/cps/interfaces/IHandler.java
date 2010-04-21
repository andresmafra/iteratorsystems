package br.iteratorsystems.cps.interfaces;

import java.util.Collection;

import br.iteratorsystems.cps.exceptions.CpsHandlerException;

/**
 * Interface para as opera��es b�sicas de um handler, as demais ter�o seus
 * m�todos particulares.
 * 
 * @author Andr�
 * 
 */
public interface IHandler {

	/**
	 * M�todo utilizado para incluir um registro no banco.
	 * @param instance Objeto a ser excluido.
	 * @throws CpsHandlerException Se algum erro ocorrer na camada handler da aplica��o.
	 */
	void save(Object instance) throws CpsHandlerException;

	/**
	 * M�todo utilizado para recuperar um registro do banco com base em um param�tro.
	 * @param instance - Parametro a ser passado ao banco.
	 * @return Objeto a ser recuperado do banco.
	 * @throws CpsHandlerException Se algum erro ocorrer na camada handler da aplica��o.
	 */
	Object get(Object instance) throws CpsHandlerException;

	/**
	 * M�todo utilizado para recuperar objetos do banco com base em um par�metro.
	 * @return - Uma cole��o de objetos encontrados.
	 * @throws CpsHandlerException Se algum erro ocorrer na camada handler da aplica��o.
	 */
	Collection<Object> getAll() throws CpsHandlerException;

	/**
	 * M�todo utilizado para persistir um objeto no banco.
	 * @param instance Objeto a ser persistido no banco
	 * @throws CpsHandlerException Se algum erro ocorrer na camada handler da aplica��o.
	 */
	void update(Object instance) throws CpsHandlerException;

	/**
	 * M�todo utilizado para excluir um registro do banco
	 * @param instance Objeto a ser excluido do banco.
	 * @throws CpsHandlerException Se algum erro ocorrer na camada handler da aplica��o.
	 */
	void delete(Object instance) throws CpsHandlerException;
}
