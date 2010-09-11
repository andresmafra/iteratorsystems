package br.iteratorsystems.cps.enums;

/**
 * Enum de tipo de resultado do calculo de rota.
 * @author Andr�
 *
 */
public enum TipoResultado {

	KILOMETROS(1,"Kil�metros"),
	MILHAS(2,"Milhas");
	
	/**
	 * Construtor
	 * @param codigo - codigo
	 * @param descricao - descricao
	 */
	private TipoResultado(int codigo,String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	private int codigo;
	private String descricao;
	
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
