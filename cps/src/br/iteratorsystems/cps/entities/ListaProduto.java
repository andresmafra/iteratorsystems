package br.iteratorsystems.cps.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.iteratorsystems.cps.interfaces.EntityAble;

/**
 * ListaProduto generated by hbm2java
 */
@Entity
@Table(name = "lista_produto", schema = "tabelas")
@SequenceGenerator(name = "generatorLista", sequenceName = "lista_produto_id_lista_seq")
public class ListaProduto implements java.io.Serializable,EntityAble {

	private static final long serialVersionUID = 8790039664826383450L;

	private Integer id;
	private Usuario usuario;
	private String nomeLista;
	private Date dataCriacao;
	private Set<ListaProdutoItem> listaProdutoItems = new HashSet<ListaProdutoItem>(
			0);

	public ListaProduto() {
	}

	public ListaProduto(Integer id, Usuario usuario,
			String nomeLista, Date dataCriacao) {
		this.id = id;
		this.usuario = usuario;
		this.nomeLista = nomeLista;
		this.dataCriacao = dataCriacao;
	}

	public ListaProduto(Integer idLista, Usuario usuario,
			String nomeLista, Date dataCriacao,
			Set<ListaProdutoItem> listaProdutoItems) {
		this.id = idLista;
		this.usuario = usuario;
		this.nomeLista = nomeLista;
		this.dataCriacao = dataCriacao;
		this.listaProdutoItems = listaProdutoItems;
	}

	@Id
	@Column(name = "id_lista", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generatorLista")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer idLista) {
		this.id = idLista;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nome_lista", nullable = false, length = 30)
	public String getNomeLista() {
		return this.nomeLista;
	}

	public void setNomeLista(String nomeLista) {
		this.nomeLista = nomeLista;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao", nullable = false, length = 13)
	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "listaProduto")
	public Set<ListaProdutoItem> getListaProdutoItems() {
		return this.listaProdutoItems;
	}

	public void setListaProdutoItems(
			Set<ListaProdutoItem> listaProdutoItems) {
		this.listaProdutoItems = listaProdutoItems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nomeLista == null) ? 0 : nomeLista.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ListaProduto)) {
			return false;
		}
		ListaProduto other = (ListaProduto) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null) {
				return false;
			}
		} else if (!dataCriacao.equals(other.dataCriacao)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (nomeLista == null) {
			if (other.nomeLista != null) {
				return false;
			}
		} else if (!nomeLista.equals(other.nomeLista)) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaProduto [dataCriacao=" + dataCriacao
				+ ", id=" + id + ", nomeLista=" + nomeLista
				+ ", usuario=" + usuario + ", items = "+listaProdutoItems+"]";
	}
}