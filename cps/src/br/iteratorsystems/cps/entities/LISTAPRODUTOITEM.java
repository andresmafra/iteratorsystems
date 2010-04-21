package br.iteratorsystems.cps.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.iteratorsystems.cps.interfaces.EntityAble;

/**
 * ListaProdutoItem generated by hbm2java
 */
@Entity
@Table(name="lista_produto_item"
    ,schema="tabelas"
)
public class LISTAPRODUTOITEM  implements java.io.Serializable, EntityAble {


	 private static final long serialVersionUID = 5768174124919155293L;
	 private Integer idItensLista;
     private LISTAPRODUTO listaProduto;
     private PRODUTOGERAL produtogeral;
     private Integer quantidade;

    public LISTAPRODUTOITEM() {
    }

    public LISTAPRODUTOITEM(Integer idItensLista, LISTAPRODUTO listaProduto, PRODUTOGERAL produtogeral, Integer quantidade) {
       this.idItensLista = idItensLista;
       this.listaProduto = listaProduto;
       this.produtogeral = produtogeral;
       this.quantidade = quantidade;
    }
   
     @Id 
    
    @Column(name="id_itens_lista", unique=true, nullable=false)
    public Integer getIdItensLista() {
        return this.idItensLista;
    }
    
    public void setIdItensLista(Integer idItensLista) {
        this.idItensLista = idItensLista;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_lista", nullable=false)
    public LISTAPRODUTO getListaProduto() {
        return this.listaProduto;
    }
    
    public void setListaProduto(LISTAPRODUTO listaProduto) {
        this.listaProduto = listaProduto;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_barras", nullable=false)
    public PRODUTOGERAL getProdutogeral() {
        return this.produtogeral;
    }
    
    public void setProdutogeral(PRODUTOGERAL produtogeral) {
        this.produtogeral = produtogeral;
    }
    
    @Column(name="quantidade", nullable=false)
    public Integer getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idItensLista == null) ? 0 : idItensLista.hashCode());
		result = prime * result
				+ ((listaProduto == null) ? 0 : listaProduto.hashCode());
		result = prime * result
				+ ((produtogeral == null) ? 0 : produtogeral.hashCode());
		result = prime * result
				+ ((quantidade == null) ? 0 : quantidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LISTAPRODUTOITEM))
			return false;
		LISTAPRODUTOITEM other = (LISTAPRODUTOITEM) obj;
		if (idItensLista == null) {
			if (other.idItensLista != null)
				return false;
		} else if (!idItensLista.equals(other.idItensLista))
			return false;
		if (listaProduto == null) {
			if (other.listaProduto != null)
				return false;
		} else if (!listaProduto.equals(other.listaProduto))
			return false;
		if (produtogeral == null) {
			if (other.produtogeral != null)
				return false;
		} else if (!produtogeral.equals(other.produtogeral))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LISTAPRODUTOITEM [idItensLista=" + idItensLista
				+ ", listaProduto=" + listaProduto + ", produtogeral="
				+ produtogeral + ", quantidade=" + quantidade + "]";
	}
    
    
}