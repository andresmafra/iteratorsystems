package br.iteratorsystems.cps.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.iteratorsystems.cps.interfaces.EntityAble;

/**
 * Preco generated by hbm2java
 */
@Entity
@Table(name="preco"
    ,schema="tabelas"
)
public class PRECO  implements java.io.Serializable, EntityAble {


	 private static final long serialVersionUID = -162626912854446730L;
	 private PRECOID id;
     private PRODUTO produto;
     private String precoVarejo;

    public PRECO() {
    }

    public PRECO(PRECOID id, PRODUTO produto, String precoVarejo) {
       this.id = id;
       this.produto = produto;
       this.precoVarejo = precoVarejo;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idRede", column=@Column(name="id_rede", nullable=false) ), 
        @AttributeOverride(name="idLoja", column=@Column(name="id_loja", nullable=false) ), 
        @AttributeOverride(name="codigoBarras", column=@Column(name="codigo_barras", nullable=false, length=20) ) } )
    public PRECOID getId() {
        return this.id;
    }
    
    public void setId(PRECOID id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="codigo_barras", referencedColumnName="codigo_barras", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="id_loja", referencedColumnName="id_loja", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="id_rede", referencedColumnName="id_rede", nullable=false, insertable=false, updatable=false) } )
    public PRODUTO getProduto() {
        return this.produto;
    }
    
    public void setProduto(PRODUTO produto) {
        this.produto = produto;
    }
    
    @Column(name="preco_varejo", nullable=false, length=30)
    public String getPrecoVarejo() {
        return this.precoVarejo;
    }
    
    public void setPrecoVarejo(String precoVarejo) {
        this.precoVarejo = precoVarejo;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((precoVarejo == null) ? 0 : precoVarejo.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PRECO))
			return false;
		PRECO other = (PRECO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (precoVarejo == null) {
			if (other.precoVarejo != null)
				return false;
		} else if (!precoVarejo.equals(other.precoVarejo))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PRECO [id=" + id + ", precoVarejo=" + precoVarejo
				+ ", produto=" + produto + "]";
	}
    
    
}