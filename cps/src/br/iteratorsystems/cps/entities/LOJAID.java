package br.iteratorsystems.cps.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.iteratorsystems.cps.interfaces.EntityAble;

/**
 * LojaId generated by hbm2java
 */
@Embeddable
public class LOJAID  implements java.io.Serializable,EntityAble {

	 private static final long serialVersionUID = 4230452352558079492L;
	 
	 private Integer id;
     private Integer idRede;

    public LOJAID() {
    }

    public LOJAID(Integer idLoja, Integer idRede) {
       this.id = idLoja;
       this.idRede = idRede;
    }
   

    @Column(name="id_loja", nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer idLoja) {
        this.id = idLoja;
    }

    @Column(name="id_rede", nullable=false)
    public Integer getIdRede() {
        return this.idRede;
    }
    
    public void setIdRede(Integer idRede) {
        this.idRede = idRede;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LOJAID) ) return false;
		 LOJAID castOther = ( LOJAID ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getIdRede()==castOther.getIdRede());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getIdRede();
         return result;
   }

@Override
public String toString() {
	return "LOJAID [idLoja=" + id + ", idRede=" + idRede + "]";
}  
   
}