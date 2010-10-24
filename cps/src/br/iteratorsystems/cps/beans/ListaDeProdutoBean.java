package br.iteratorsystems.cps.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.el.ELResolver;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.richfaces.component.html.HtmlDataTable;

import br.iteratorsystems.cps.entities.ListaProduto;
import br.iteratorsystems.cps.entities.ListaProdutoItem;
import br.iteratorsystems.cps.entities.Parametrizacao;
import br.iteratorsystems.cps.entities.ProdutoGeral;
import br.iteratorsystems.cps.entities.Usuario;
import br.iteratorsystems.cps.exceptions.CpsExceptions;
import br.iteratorsystems.cps.exceptions.CpsHandlerException;
import br.iteratorsystems.cps.handler.BuscaProdutoHandler;
import br.iteratorsystems.cps.handler.LoginUserHandler;
import br.iteratorsystems.cps.helper.ListaProdutoTOHelper;
import br.iteratorsystems.cps.service.ListaProdutoService;
import br.iteratorsystems.cps.to.ListaProdutoTO;
import br.iteratorsystems.cps.to.ProdutoTO;

/**
 * Classe bean respons�vel pela lista de compras do usu�rio
 * @author Robson
 *
 */
public class ListaDeProdutoBean {

	private static final String VARIAVEL_FOTO = "image?file=";
	private static final String VARIAVEL_CAMINHO_FOTO = "&amp;dir=";
	private static final String TIPO_IMAGEM = ".jpg";
	
	private String descricaoProduto;
	private String diretorioImagem = "";
	private String produtoDigitado;
	private String nomeLista;
	private String paginaAtual;
	private List<ProdutoTO> listaBusca;
	private List<ProdutoTO> listaPagina;
	private List<ListaProduto> listaProdutoUsuario;
	private ListaProdutoTO listaComprasUsuario;
	private ListaProduto listaSelecionadaTabela;
	private ListaProdutoService listaProdutoService;
	private BuscaProdutoHandler buscaProdutoHandler;
	private LoginUserHandler userHandler;
	private HtmlDataTable tabelasListaDataTable;
	private HtmlDataTable listaProdutosDataTable;
	private Usuario usuario;
	private ProdutoTO produtoListaSelecionado;
	private String nomeModalQuantidade;
	private Integer numeroMaximoItensCarrinho;
	private boolean nenhumRegistroEncontrado;
	
	/**
	 * Construtor padr�o	
	 */
	public ListaDeProdutoBean(){
		listaProdutoService = new ListaProdutoService();
		listaSelecionadaTabela = new ListaProduto();
		userHandler = new LoginUserHandler();
		numeroMaximoItensCarrinho = Integer.parseInt(obterParametrizacao().getNumMaxItensLista().trim());
		instanciarListaDeCompras();
		carregarPaginaBusca();
	}
	
	/**
	 * Verifica se o usu�rio tem lista de compras e mostra uma p�gina
	 * personalizada. 
	 */
	public void carregarPaginaBusca() {
		
		setPaginaAtual("newList.jsf");
		this.limparPagina();
		
		if(listaPagina != null) {
			listaPagina.clear();
		}if(listaBusca != null) {
			listaBusca.clear();
		}
		
		if(usuario == null || 
				(usuario.getListaProdutos() == null || usuario.getListaProdutos().isEmpty())) {
			setUsuario(recuperarUsuario());
		}
	}
	
	/**
	 * Carrega as listas de compra do usu�rio
	 */
	public void carregarListasUsuario(){
		setPaginaAtual("allLists.jsf");
		
		if(listaPagina != null) {
			listaPagina.clear();
		}if(listaBusca != null) {
			listaBusca.clear();
		}
		this.limparPagina();
		
		setUsuario(recuperarUsuario());
		listaProdutoUsuario = 
			new ArrayList<ListaProduto>(
					usuario.getListaProdutos());
	}
	
	/**
	 * Instancia a classe de lista de compras.
	 */
	private void instanciarListaDeCompras(){
		listaComprasUsuario = new ListaProdutoTO();
		listaPagina = new ArrayList<ProdutoTO>();
		if(listaComprasUsuario.getListaProdutos() == null) {
			listaComprasUsuario.setListaProdutos(new ArrayList<ProdutoTO>());
		}
	}
	
	/**
	 * Cria uma lista de compras para o usu�rio.
	 */
	public void criarLista() {
		listaComprasUsuario = new ListaProdutoTO();
		listaComprasUsuario.setNomeLista(this.getNomeLista());
		listaComprasUsuario.setListaProdutos(new ArrayList<ProdutoTO>());
	}
	
	/**
	 * Obtem uma lista de produto para edi��o.
	 */
	public void obterListaDeProduto() {
		listaSelecionadaTabela = (ListaProduto) tabelasListaDataTable.getRowData();
		listaPagina = (List<ProdutoTO>) 
				ListaProdutoTOHelper.converteItemLista(
						listaSelecionadaTabela.getListaProdutoItems());
	}
	
	/**
	 * Atualiza a lista de produtos.
	 * @throws CpsHandlerException Se ocorrer algum erro nas camadas abaixo.
	 */
	public void atualizarLista() throws CpsHandlerException {
		listaSelecionadaTabela.setListaProdutoItems(
				new HashSet<ListaProdutoItem>(
						ListaProdutoTOHelper.obtemListaProdutoItem(listaPagina)));
		listaProdutoService.atualizarListaDeProdutos(listaSelecionadaTabela);
		listaPagina.clear();
		limparPagina();
		if(listaBusca != null) {
			listaBusca.clear();
		}
	}
	
	/**
	 * Exclui uma lista de compras do usu�rio.
	 */
	public void excluirLista() {
		if(listaComprasUsuario != null) {
			if(listaComprasUsuario.getListaProdutos() != null) {
				listaComprasUsuario.getListaProdutos().clear();
			}
			listaComprasUsuario.setNomeLista(null);
			this.setNomeLista(null);
		}
		
		if(listaPagina != null) {
			listaPagina.clear();
		}if(listaBusca != null) {
			listaBusca.clear();
		}
	}
	
	/**
	 * Busca os produtos com base no que foi digitado pelo usu�rio.
	 * @throws CpsExceptions Alguma exce��o, verificada ou n�o nas
	 * camadas abaixo do Bean.
	 */
	public void buscarProduto() throws CpsExceptions{
		buscaProdutoHandler = new BuscaProdutoHandler();
		List<ProdutoGeral> listaTemp = null;
		listaBusca = new ArrayList<ProdutoTO>(1);

		try{
			listaTemp = 
				buscaProdutoHandler.buscaProduto(this.getProdutoDigitado());
			
			if(listaTemp == null || listaTemp.isEmpty()) {
				this.setNenhumRegistroEncontrado(true);
			}else{
				this.setNenhumRegistroEncontrado(false);
			}
			
			for(ProdutoGeral produtoGeral : listaTemp) {
				ProdutoTO produtoTO = new ProdutoTO();
				produtoTO.setProdutoGeral(produtoGeral);
				produtoTO.setQuantidadeSelecionada(1);
				
				if(produtoGeral.getImagem().toString().equalsIgnoreCase("S")) {
					produtoTO.setImagem(
							criarCaminhoFoto(
									produtoGeral.getCodigoBarras().trim()));
					produtoTO.setPossuiImagem(true);
				}
				
				listaBusca.add(produtoTO);
			}
			
			listaBusca.removeAll(listaPagina);
		}catch (CpsHandlerException e) {
			throw new CpsExceptions(e);
		}
	}
	
	
	/**
	 * Cria a String com o caminho da imagem na pasta.
	 * @param codigoProduto - C�digo do produto para ser usado na busca.
	 * @return Caminho concatenado com o nome do arquivo.
	 */
	private String criarCaminhoFoto(final String codigoProduto) {
		StringBuilder builder = new StringBuilder();
		builder.append(VARIAVEL_FOTO);
		builder.append(codigoProduto);
		builder.append(TIPO_IMAGEM);
		builder.append(VARIAVEL_CAMINHO_FOTO);
		builder.append(getDiretorioImagem().replace(File.separator,""));
		return builder.toString();
	}
	
	/**
	 * Obt�m a parametriza��o do sistema
	 * @return Classe de parametriza��o do sistema.
	 */
	private Parametrizacao obterParametrizacao() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Parametrizacao parametrizacao = (Parametrizacao)context.getApplicationMap().get("parametrizacao");
		return parametrizacao;
	}
	
	/**
	 * Exclui uma lista de produto
	 * @throws CpsExceptions - Se ocorrer alguma exce��o na camada abaixo do bean.
	 */
	public void excluirListaDeProdutos() throws CpsExceptions{
		
		listaSelecionadaTabela.getListaProdutoItems().clear();
		listaProdutoService.excluirListaDeProdutos(listaSelecionadaTabela);
		
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver el = context.getApplication().getELResolver();
		
		LoginUserBean userBean = (LoginUserBean)
					el.getValue(context.getELContext(),null,"loginUserBean");
		usuario = userHandler.getUserRelated(userBean.getLogin().getIdLogin());
		carregarPaginaBusca();
		
		if(usuario.getListaProdutos().isEmpty()) {
			instanciarListaDeCompras();
			limparPagina();
		}
	}
	
	/**
	 * Limpa a p�gina.
	 */
	private void limparPagina() {
		this.setNomeLista(null);
		this.setListaBusca(null);
		this.setNenhumRegistroEncontrado(false);
	}
	
	/**
	 * Inclui uma lista de produto
	 * @throws CpsExceptions - Se ocorrer alguma exce��o na camada abaixo do bean.
	 */
	public void incluirListaDeProdutos()throws CpsExceptions{
		listaComprasUsuario.setListaProdutos(listaPagina);
		Usuario usuario = getUsuario();
		
		if(usuario == null) {
			usuario = recuperarUsuario();
		}
		ListaProduto listaProduto = ListaProdutoTOHelper.popularUmaListaDeProduto(this.getNomeLista(), usuario);
		Set<ListaProdutoItem> itensProdutos = ListaProdutoTOHelper.converteListaProdutoTO(listaComprasUsuario.getListaProdutos());
		
		listaProdutoService.incluirListaDeProdutos(listaProduto);
		listaProdutoService.incluirItensNaListaDeProdutos(listaProduto, itensProdutos);
		
		carregarPaginaBusca();
	}
	
	/**
	 * Recupera o usu�rio ativo na sess�o.
	 * @return - Entidade com os dados do usu�rio.
	 */
	private Usuario recuperarUsuario() {
		Usuario usuario = null;
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver el = context.getApplication().getELResolver();

		LoginUserBean userBean = (LoginUserBean) el.getValue(context
				.getELContext(), null, "loginUserBean");
		try {
			usuario = userHandler.getUserRelated(userBean.getLogin()
					.getIdLogin());
		} catch (CpsHandlerException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	/**
	 * Adiciona um produto na lista de produtos.
	 */
	public void adicionarProdutoNaListaDeProdutos(){
		ProdutoTO produtoTO = (ProdutoTO) this.listaProdutosDataTable.getRowData();
		int quantidadeSelecionada = produtoTO.getQuantidadeSelecionada();
		
		nomeModalQuantidade = "";
		if(quantidadeSelecionada < 1) {
			nomeModalQuantidade = "Richfaces.showModalPanel('modalInfoQuantidade');";
		}else {
			if(listaPagina.size() +1 > getNumeroMaximoItensCarrinho()) {
				nomeModalQuantidade = "Richfaces.showModalPanel('modalQuantidadeCarrinho');";
			}else {
				if(!listaPagina.contains(produtoTO)) {
					listaPagina.add(produtoTO);
					listaBusca.remove(produtoTO);
				}
			}
		}
	}
	
	/**
	 * Exclui um produto da lista de produto.
	 */
	public void excluirProdutoDaListaDeProduto(){
		listaPagina.remove(produtoListaSelecionado);
	}
	
	/**
	 * @return the descricaoProduto
	 */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	/**
	 * @param descricaoProduto the descricaoProduto to set
	 */
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	/**
	 * @return the listaBusca
	 */
	public List<ProdutoTO> getListaBusca() {
		return listaBusca;
	}
	/**
	 * @param listaBusca the listaBusca to set
	 */
	public void setListaBusca(List<ProdutoTO> listaBusca) {
		this.listaBusca = listaBusca;
	}
	/**
	 * @return the listaComprasUsuario
	 */
	public ListaProdutoTO getListaComprasUsuario() {
		return listaComprasUsuario;
	}
	/**
	 * @param listaComprasUsuario the listaComprasUsuario to set
	 */
	public void setListaComprasUsuario(ListaProdutoTO listaComprasUsuario) {
		this.listaComprasUsuario = listaComprasUsuario;
	}

	/**
	 * @return the listaProdutoService
	 */
	public ListaProdutoService getListaProdutoService() {
		return listaProdutoService;
	}

	/**
	 * @param listaProdutoService the listaProdutoService to set
	 */
	public void setListaProdutoService(ListaProdutoService listaProdutoService) {
		this.listaProdutoService = listaProdutoService;
	}

	/**
	 * @return the listaProdutosDataTable
	 */
	public HtmlDataTable getListaProdutosDataTable() {
		return listaProdutosDataTable;
	}

	/**
	 * @param listaProdutosDataTable the listaProdutosDataTable to set
	 */
	public void setListaProdutosDataTable(HtmlDataTable listaProdutosDataTable) {
		this.listaProdutosDataTable = listaProdutosDataTable;
	}

	/**
	 * @return the nomeModalQuantidade
	 */
	public String getNomeModalQuantidade() {
		return nomeModalQuantidade;
	}

	/**
	 * @param nomeModalQuantidade the nomeModalQuantidade to set
	 */
	public void setNomeModalQuantidade(String nomeModalQuantidade) {
		this.nomeModalQuantidade = nomeModalQuantidade;
	}

	/**
	 * @param numeroMaximoItensCarrinho the numeroMaximoItensCarrinho to set
	 */
	public void setNumeroMaximoItensCarrinho(Integer numeroMaximoItensCarrinho) {
		this.numeroMaximoItensCarrinho = numeroMaximoItensCarrinho;
	}

	/**
	 * @return the numeroMaximoItensCarrinho
	 */
	public Integer getNumeroMaximoItensCarrinho() {
		return numeroMaximoItensCarrinho;
	}

	/**
	 * @param nenhumRegistroEncontrado the nenhumRegistroEncontrado to set
	 */
	public void setNenhumRegistroEncontrado(boolean nenhumRegistroEncontrado) {
		this.nenhumRegistroEncontrado = nenhumRegistroEncontrado;
	}

	/**
	 * @return the nenhumRegistroEncontrado
	 */
	public boolean isNenhumRegistroEncontrado() {
		return nenhumRegistroEncontrado;
	}

	/**
	 * @param produtoDigitado the produtoDigitado to set
	 */
	public void setProdutoDigitado(String produtoDigitado) {
		this.produtoDigitado = produtoDigitado;
	}

	/**
	 * @return the produtoDigitado
	 */
	public String getProdutoDigitado() {
		return produtoDigitado;
	}

	/**
	 * @param nomeLista the nomeLista to set
	 */
	public void setNomeLista(String nomeLista) {
		this.nomeLista = nomeLista;
	}

	/**
	 * @return the nomeLista
	 */
	public String getNomeLista() {
		return nomeLista;
	}

	/**
	 * @param listaPagina the listaPagina to set
	 */
	public void setListaPagina(List<ProdutoTO> listaPagina) {
		this.listaPagina = listaPagina;
	}

	/**
	 * @return the listaPagina
	 */
	public List<ProdutoTO> getListaPagina() {
		return listaPagina;
	}

	/**
	 * @param produtoListaSelecionado the produtoListaSelecionado to set
	 */
	public void setProdutoListaSelecionado(ProdutoTO produtoListaSelecionado) {
		this.produtoListaSelecionado = produtoListaSelecionado;
	}

	/**
	 * @return the produtoListaSelecionado
	 */
	public ProdutoTO getProdutoListaSelecionado() {
		return produtoListaSelecionado;
	}

	/**
	 * @param paginaAtual the paginaAtual to set
	 */
	public void setPaginaAtual(String paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	/**
	 * @return the paginaAtual
	 */
	public String getPaginaAtual() {
		return paginaAtual;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param userHandler the userHandler to set
	 */
	public void setUserHandler(LoginUserHandler userHandler) {
		this.userHandler = userHandler;
	}

	/**
	 * @return the userHandler
	 */
	public LoginUserHandler getUserHandler() {
		return userHandler;
	}

	/**
	 * @param listaProdutoUsuario the listaProdutoUsuario to set
	 */
	public void setListaProdutoUsuario(List<ListaProduto> listaProdutoUsuario) {
		this.listaProdutoUsuario = listaProdutoUsuario;
	}

	/**
	 * @return the listaProdutoUsuario
	 */
	public List<ListaProduto> getListaProdutoUsuario() {
		return listaProdutoUsuario;
	}

	/**
	 * @param tabelasListaDataTable the tabelasListaDataTable to set
	 */
	public void setTabelasListaDataTable(HtmlDataTable tabelasListaDataTable) {
		this.tabelasListaDataTable = tabelasListaDataTable;
	}

	/**
	 * @return the tabelasListaDataTable
	 */
	public HtmlDataTable getTabelasListaDataTable() {
		return tabelasListaDataTable;
	}

	/**
	 * @param listaSelecionadaTabela the listaSelecionadaTabela to set
	 */
	public void setListaSelecionadaTabela(ListaProduto listaSelecionadaTabela) {
		this.listaSelecionadaTabela = listaSelecionadaTabela;
	}

	/**
	 * @return the listaSelecionadaTabela
	 */
	public ListaProduto getListaSelecionadaTabela() {
		return listaSelecionadaTabela;
	}

	/**
	 * @param diretorioImagem the diretorioImagem to set
	 */
	public void setDiretorioImagem(String diretorioImagem) {
		this.diretorioImagem = diretorioImagem;
	}

	/**
	 * @return the diretorioImagem
	 */
	public String getDiretorioImagem() {
		return diretorioImagem;
	}
}
