package br.iteratorsystems.cps.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.iteratorsystems.cps.config.HibernateConfig;
import br.iteratorsystems.cps.dao.ItensListaProdutoDao;
import br.iteratorsystems.cps.dao.ListaProdutoDao;
import br.iteratorsystems.cps.entities.ListaProduto;
import br.iteratorsystems.cps.entities.ListaProdutoItem;
import br.iteratorsystems.cps.entities.ProdutoGeral;
import br.iteratorsystems.cps.exceptions.CpsDaoException;
import br.iteratorsystems.cps.exceptions.CpsHandlerException;
import br.iteratorsystems.cps.helper.ListaProdutoTOHelper;

public class ListaProdutoService {

	private Session session = HibernateConfig.getSession();
	private ListaProdutoDao listaProdutoDao = new ListaProdutoDao(ListaProduto.class, session);
	private ItensListaProdutoDao itemListaDao = new ItensListaProdutoDao(ListaProdutoItem.class, session) ;
	
	public List<ListaProdutoItem> popularItemDaListaDeProduto(Integer idItensLista, ListaProduto listaProduto, List<ProdutoGeral> produtosGerais, HashMap<String, Integer> quantidadePorProduto){
		
		List<ListaProdutoItem> listaProdutosItens = new ArrayList<ListaProdutoItem>();
		for (ProdutoGeral produtogeral : produtosGerais) {
			ListaProdutoItem itemProduto = new ListaProdutoItem();
			itemProduto.setIdItensLista(idItensLista);
			itemProduto.setListaProduto(listaProduto);
			itemProduto.setProdutogeral(produtogeral);
			itemProduto.setQuantidade(quantidadePorProduto.get(produtogeral.getCodigoBarras()));

			listaProdutosItens.add(itemProduto);
		}
		
		return listaProdutosItens;
	}
	
	/**
	 * Atualiza uma lista de produto.
	 * @param listaProduto - Lista de produto.
	 * @throws CpsHandlerException Se alguma exce��o ocorrer nas camadas abaixo.
	 */
	public void atualizarListaDeProdutos(final ListaProduto listaProduto) throws CpsHandlerException {
		Transaction transaction = HibernateConfig.getSession().getTransaction();
		try{
			transaction.begin();
			ListaProdutoTOHelper.atualizaObjetoItemLista(
					listaProduto, listaProduto.getListaProdutoItems());
			atualizarItensListaProduto(new ArrayList<ListaProdutoItem>(
													listaProduto.getListaProdutoItems()));
			
			Set<ListaProdutoItem> temp = new HashSet<ListaProdutoItem>(listaProduto.getListaProdutoItems()); 
			listaProduto.getListaProdutoItems().clear();
			
			listaProdutoDao.update(listaProduto);
			session.flush();
			transaction.commit();
			listaProduto.setListaProdutoItems(temp);
		}catch (CpsDaoException e) {
			transaction.rollback();
			throw new CpsHandlerException(e);
		}
	}
	
	/**
	 * Atualiza os itens de uma lista de produtos.
	 * @param listaItens - Lista de itens.
	 * @throws CpsDaoException Se alguma exce��o ocorrer nas camadas abaixo.
	 */
	public void atualizarItensListaProduto(List<ListaProdutoItem> listaItens) throws CpsHandlerException {
		for(ListaProdutoItem item : listaItens) {
			atualizarItensListaProduto(item);
		}
	}
	
	/**
	 * Atualiza os itens de uma lista de produtos.
	 * @param item - Item
	 * @throws CpsHandlerException Se alguma exce��o ocorrer nas camadas abaixo.s
	 */
	public void atualizarItensListaProduto(ListaProdutoItem item) throws CpsHandlerException{
		try{
			itemListaDao.update(item);
			session.flush();
		}catch (CpsDaoException e) {
			throw new CpsHandlerException(e);
		}
	}
	/**
	 * Exclui uma lista de produtos
	 * @param listaProduto - Lista de produtos
	 * @throws CpsHandlerException Se alguma exce��o ocorrer nas camadas abaixo.
	 */
	public void excluirListaDeProdutos(final ListaProduto listaProduto) throws CpsHandlerException {
		Transaction transaction = HibernateConfig.getSession().getTransaction();
		try{
			transaction.begin();
			listaProdutoDao.excluir(listaProduto);
			session.flush();
			transaction.commit();
		}catch (CpsDaoException e) {
			transaction.rollback();
			throw new CpsHandlerException(e);
		}
	}
	
	/**
	 * Exclui um item de produto.
	 * @param listaProdutoItem - Lista Item de produto.
	 * @throws CpsHandlerException Se ocorrer algum erro nas camadas abaixo.
	 */
	public void excluirItensListaProduto(final ListaProdutoItem listaProdutoItem) throws CpsHandlerException {
		try{
			itemListaDao.excluir(listaProdutoItem);
			session.flush();
		}catch (CpsDaoException e) {
			throw new CpsHandlerException(e);
		}
	}

	/**
	 * Inclui uma lista de produtos e seus items.
	 * @param listaProduto - A lista de produto
	 * @param itemLista - Os items da lista
	 * @throws CpsHandlerException Se alguma exce��o ocorrer nas camadas abaixo.
	 */
	public void incluirListaDeProdutos(final ListaProduto listaProduto,
									  final Set<ListaProdutoItem> itemLista) throws CpsHandlerException {
		Transaction transaction = HibernateConfig.getSession().getTransaction();
		transaction.begin();
		try{
			listaProdutoDao.salvar(listaProduto);
			session.flush();
			
			ListaProduto newListaProduto = obterLista();
			for(ListaProdutoItem item : itemLista) {
				item.setListaProduto(newListaProduto);
			}
			itemListaDao.salvarLista(itemLista);
			transaction.commit();
		}catch (CpsDaoException e) {
			transaction.rollback();
			throw new CpsHandlerException(e);
		}
	}
	

	
	/**
	 * Obtem o ultimo Id da lista inserida no banco.
	 * @return Uma Entidade Lista de produto.
	 * @throws IllegalArgumentException - Se algo de errado acontecer nas camadas abaixo,
	 * ou se id for nulo.
	 */
	private ListaProduto obterLista() throws IllegalArgumentException {
		ListaProduto lista = new ListaProduto();
		try {
			Integer id =
					itemListaDao.getLastIdFromModel(new ListaProduto());
			if(id == null) {
				throw new IllegalArgumentException("O Id n�o poder ser nulo!");
			}
			lista.setId(id);
		} catch (CpsDaoException e) {
			throw new IllegalArgumentException(e);
		}
		return lista;
	}
}