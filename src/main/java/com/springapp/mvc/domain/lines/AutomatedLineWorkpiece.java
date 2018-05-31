/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.mvc.domain.lines;

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

/**
 *
 * @author Home
 */
@Entity
@Table(name="line_workpiece_type", schema = "", catalog = "automated_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutomatedLineWorkpiece.findAll", query = "SELECT l FROM AutomatedLineWorkpiece l"),
    @NamedQuery(name = "AutomatedLineWorkpiece.findByWorkpiece", query = "SELECT l FROM AutomatedLineWorkpiece l WHERE l.workpiece = :workpiece"),
 //   @NamedQuery(name = "BearingsIndustrialCountry.findByCountryRu", query = "SELECT l FROM BearingsIndustrialCountry l WHERE l.countryRu = :countryRu"),
    @NamedQuery(name = "AutomatedLineWorkpiece.findByNum", query = "SELECT l FROM AutomatedLineWorkpiece l WHERE l.num = :num")})
public class AutomatedLineWorkpiece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "workpiece_type")
    private String workpiece;
    @Column(name = "num")
    private Integer num;

    public AutomatedLineWorkpiece() {
    }

    public AutomatedLineWorkpiece(String workpiece) {
        this.workpiece = workpiece;
   //     this.countryRu = countryRu;
    }

    public String getWorkpiece() {
        return workpiece;
    }

    public void setWorkpiece(String workpiece) {
        this.workpiece = workpiece;
    }
    
/*    public String getCountryRu() {
        return countryRu;
    }

    public void setCountryRu(String countryRu) {
        this.countryRu = countryRu;
    }
*/
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workpiece != null ? workpiece.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutomatedLineWorkpiece)) {
            return false;
        }
        AutomatedLineWorkpiece other = (AutomatedLineWorkpiece) object;
        if ((this.workpiece == null && other.workpiece != null) || (this.workpiece != null && !this.workpiece.equals(other.workpiece))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.lines.domain.AutomatedLineWorkpieceType[ workpiece =" + workpiece + " ]";
    }
    
}
