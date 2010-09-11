package br.iteratorsystems.cps.enums;

/**
 * Enum que indica o tipo de busca na compara��o.
 * @author Andr�
 *
 */
public enum TipoDeComparacao {

	MENOR_PRECO(1,"Menor pre�o"),
	MENOR_DISTANCIA(2,"Menor dist�ncia"),
	MENOR_PRECO_E_DISTANCIA(3,"Menor pre�o e menor dist�ncia");

	private int codigo;
	private String nome;
	
	/**
	 * Construtor
	 * @param codigo - codigo
	 * @param nome - nome
	 */
	TipoDeComparacao(int codigo,String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
}
