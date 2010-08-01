package br.iteratorsystems.cps.enums;

/**
 * Enum de Estados do Brasil
 * @author Andr�
 *
 */
public enum EEstados {
	
	AC("Acre"),
	AL("Alagoas"),
	AP("Amap�"),
	AM("Amazonas"),
	BA("Bahia"),
	CE("Cear�"),
	DF("Distrito Federal"),
	GO("Goi�s"),
	ES("Esp�rito Santo"),
	MA("Maranh�o"),
	MT("Mato Grosso"),
	MS("Mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Par�"),
	PB("Para�ba"),
	PR("Paran�"),
	PE("Pernambuco"),
	PI("Piau�"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rond�nia"),
	RR("R�raima"),
	SP("S�o Paulo"),
	SC("Santa Catarina"),
	SE("Sergipe"),
	TO("Tocantins");
	
	/**
	 * Construtor default
	 * @param s
	 */
	EEstados(String s){
		this.setNome(s);
	}

	private String nome_completo;
	
	/**
	 * Modifica o nome do estado
	 * @param nome - Novo nome
	 */
	public void setNome(String nome) {
		this.nome_completo = nome;
	}
	
	/**
	 * Recupera o nome do estado
	 * @return Nome do estado.
	 */
	public String getNome() {
		return nome_completo;
	}
}
