package br.iteratorsystems.cps.entities;


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.iteratorsystems.cps.interfaces.EntityAble;

/**
 * ContatoLoja generated by hbm2java
 */
@Entity
@Table(name="contato_loja"
    ,schema="tabelas"
)
public class CONTATOLOJA  implements java.io.Serializable, EntityAble {

     
	 private static final long serialVersionUID = 1576489847280666906L;
	 private CONTATOLOJAID id;
     private LOJA loja;
     private String dddCom;
     private String telCom;
     private String dddFax;
     private String telFax;
     private String dddCelCom;
     private String telCelCom;
     private String email;
     private String homepage;
     private Date dataultimamodificacao;

    public CONTATOLOJA() {
    }
	
    public CONTATOLOJA(CONTATOLOJAID id, LOJA loja, String dddCom, String telCom, String email, Date dataultimamodificacao) {
        this.id = id;
        this.loja = loja;
        this.dddCom = dddCom;
        this.telCom = telCom;
        this.email = email;
        this.dataultimamodificacao = dataultimamodificacao;
    }
    public CONTATOLOJA(CONTATOLOJAID id, LOJA loja, String dddCom, String telCom, String dddFax, String telFax, String dddCelCom, String telCelCom, String email, String homepage, Date dataultimamodificacao) {
       this.id = id;
       this.loja = loja;
       this.dddCom = dddCom;
       this.telCom = telCom;
       this.dddFax = dddFax;
       this.telFax = telFax;
       this.dddCelCom = dddCelCom;
       this.telCelCom = telCelCom;
       this.email = email;
       this.homepage = homepage;
       this.dataultimamodificacao = dataultimamodificacao;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idRede", column=@Column(name="id_rede", nullable=false) ), 
        @AttributeOverride(name="idLoja", column=@Column(name="id_loja", nullable=false) ) } )
    public CONTATOLOJAID getId() {
        return this.id;
    }
    
    public void setId(CONTATOLOJAID id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="id_loja", referencedColumnName="id_loja", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="id_rede", referencedColumnName="id_rede", nullable=false, insertable=false, updatable=false) } )
    public LOJA getLoja() {
        return this.loja;
    }
    
    public void setLoja(LOJA loja) {
        this.loja = loja;
    }
    
    @Column(name="ddd_com", nullable=false, length=3)
    public String getDddCom() {
        return this.dddCom;
    }
    
    public void setDddCom(String dddCom) {
        this.dddCom = dddCom;
    }
    
    @Column(name="tel_com", nullable=false, length=8)
    public String getTelCom() {
        return this.telCom;
    }
    
    public void setTelCom(String telCom) {
        this.telCom = telCom;
    }
    
    @Column(name="ddd_fax", length=3)
    public String getDddFax() {
        return this.dddFax;
    }
    
    public void setDddFax(String dddFax) {
        this.dddFax = dddFax;
    }
    
    @Column(name="tel_fax", length=8)
    public String getTelFax() {
        return this.telFax;
    }
    
    public void setTelFax(String telFax) {
        this.telFax = telFax;
    }
    
    @Column(name="ddd_cel_com", length=3)
    public String getDddCelCom() {
        return this.dddCelCom;
    }
    
    public void setDddCelCom(String dddCelCom) {
        this.dddCelCom = dddCelCom;
    }
    
    @Column(name="tel_cel_com", length=8)
    public String getTelCelCom() {
        return this.telCelCom;
    }
    
    public void setTelCelCom(String telCelCom) {
        this.telCelCom = telCelCom;
    }
    
    @Column(name="email", nullable=false, length=30)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="homepage", length=100)
    public String getHomepage() {
        return this.homepage;
    }
    
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="dataultimamodificacao", nullable=false, length=13)
    public Date getDataultimamodificacao() {
        return this.dataultimamodificacao;
    }
    
    public void setDataultimamodificacao(Date dataultimamodificacao) {
        this.dataultimamodificacao = dataultimamodificacao;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataultimamodificacao == null) ? 0 : dataultimamodificacao
						.hashCode());
		result = prime * result
				+ ((dddCelCom == null) ? 0 : dddCelCom.hashCode());
		result = prime * result + ((dddCom == null) ? 0 : dddCom.hashCode());
		result = prime * result + ((dddFax == null) ? 0 : dddFax.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
		result = prime * result
				+ ((telCelCom == null) ? 0 : telCelCom.hashCode());
		result = prime * result + ((telCom == null) ? 0 : telCom.hashCode());
		result = prime * result + ((telFax == null) ? 0 : telFax.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CONTATOLOJA))
			return false;
		CONTATOLOJA other = (CONTATOLOJA) obj;
		if (dataultimamodificacao == null) {
			if (other.dataultimamodificacao != null)
				return false;
		} else if (!dataultimamodificacao.equals(other.dataultimamodificacao))
			return false;
		if (dddCelCom == null) {
			if (other.dddCelCom != null)
				return false;
		} else if (!dddCelCom.equals(other.dddCelCom))
			return false;
		if (dddCom == null) {
			if (other.dddCom != null)
				return false;
		} else if (!dddCom.equals(other.dddCom))
			return false;
		if (dddFax == null) {
			if (other.dddFax != null)
				return false;
		} else if (!dddFax.equals(other.dddFax))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		if (telCelCom == null) {
			if (other.telCelCom != null)
				return false;
		} else if (!telCelCom.equals(other.telCelCom))
			return false;
		if (telCom == null) {
			if (other.telCom != null)
				return false;
		} else if (!telCom.equals(other.telCom))
			return false;
		if (telFax == null) {
			if (other.telFax != null)
				return false;
		} else if (!telFax.equals(other.telFax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CONTATOLOJA [dataultimamodificacao=" + dataultimamodificacao
				+ ", dddCelCom=" + dddCelCom + ", dddCom=" + dddCom
				+ ", dddFax=" + dddFax + ", email=" + email + ", homepage="
				+ homepage + ", id=" + id + ", loja=" + loja + ", telCelCom="
				+ telCelCom + ", telCom=" + telCom + ", telFax=" + telFax + "]";
	}
    
    
}