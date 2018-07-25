package com.springapp.mvc.domain.bearings;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="bearings_industrial_type", schema = "", catalog = "bearings_industrial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BearingsIndustrialType.findAll", query = "SELECT l FROM BearingsIndustrialType l"),
    @NamedQuery(name = "BearingsIndustrialType.findByTypeEn", query = "SELECT l FROM BearingsIndustrialType l WHERE l.typeEn = :typeEn"),
    @NamedQuery(name = "BearingsIndustrialType.findByTypeRu", query = "SELECT l FROM BearingsIndustrialType l WHERE l.typeRu = :typeRu"),
    @NamedQuery(name = "BearingsIndustrialType.findByNum", query = "SELECT l FROM BearingsIndustrialType l WHERE l.num = :num")})
public class BearingsIndustrialType implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type_en")
    private String typeEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type_ru")
    private String typeRu;
    @Column(name = "num")
    private Integer num;

    public BearingsIndustrialType() {
    }

    public BearingsIndustrialType(String type) {
        this.typeEn = type;
    }

    public String getTypeEn() {
        return typeEn;
    }

    public void setTypeEn(String type) {
        this.typeEn = type;
    }
    
    public String getTypeRu() {
        return typeRu;
    }

    public void setTypeRu(String type) {
        this.typeRu = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeEn != null ? typeEn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BearingsIndustrialType)) {
            return false;
        }
        BearingsIndustrialType other = (BearingsIndustrialType) object;
        if ((this.typeEn == null && other.typeEn != null) || (this.typeEn != null && !this.typeEn.equals(other.typeEn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.domain.bearingsBearingsIndustrialType[ type=" + typeEn + " ]";
    }
    
}
