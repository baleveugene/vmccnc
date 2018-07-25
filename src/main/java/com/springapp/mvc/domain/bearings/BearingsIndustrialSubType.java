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
@Table(name="bearings_industrial_subtype", schema = "", catalog = "bearings_industrial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BearingsIndustrialSubType.findAll", query = "SELECT l FROM BearingsIndustrialSubType l"),
    @NamedQuery(name = "BearingsIndustrialSubType.findBySubTypeEn", query = "SELECT l FROM BearingsIndustrialSubType l WHERE l.subTypeEn = :subTypeEn"),
    @NamedQuery(name = "BearingsIndustrialSubType.findBySubType", query = "SELECT l FROM BearingsIndustrialSubType l WHERE l.subTypeRu = :subTypeRu"),
    @NamedQuery(name = "BearingsIndustrialSubType.findByNum", query = "SELECT l FROM BearingsIndustrialSubType l WHERE l.num = :num")})
public class BearingsIndustrialSubType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subtype_en")
    private String subTypeEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subtype_ru")
    private String subTypeRu;
    @Column(name = "num")
    private Integer num;

    public BearingsIndustrialSubType() {
    }

    public BearingsIndustrialSubType(String subType) {
        this.subTypeEn = subType;
    }

    public String getSubTypeEn() {
        return subTypeEn;
    }

    public void setSubTypeEn(String subType) {
        this.subTypeEn = subType;
    }
    
    public String getSubTypeRu() {
        return subTypeRu;
    }

    public void setSubTypeRu(String subType) {
        this.subTypeRu = subType;
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
        hash += (subTypeEn != null ? subTypeEn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BearingsIndustrialSubType)) {
            return false;
        }
        BearingsIndustrialSubType other = (BearingsIndustrialSubType) object;
        if ((this.subTypeEn == null && other.subTypeEn != null) || (this.subTypeEn != null && !this.subTypeEn.equals(other.subTypeEn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.domain.bearings.BearingsIndustrialSubType[ subType=" + subTypeEn + " ]";
    }
    
}
