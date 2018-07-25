package com.springapp.mvc.domain.bearings;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="bearings_industrial_video", schema = "", catalog = "bearings_industrial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BearingsIndustrialVideo.findAll", query = "SELECT l FROM BearingsIndustrialVideo l"),
    @NamedQuery(name = "BearingsIndustrialVideo.findByName", query = "SELECT l FROM BearingsIndustrialVideo l WHERE l.name = :name")
    })
public class BearingsIndustrialVideo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotNull
    @Size(max = 255)
    @Column(name = "video_name")
    private String name;
    
    @ManyToOne
    @JoinColumn(nullable = false, name="bearings_model_en", referencedColumnName = "model_en")
    private BearingsIndustrial bearings;

    public BearingsIndustrialVideo() {
    }

    public BearingsIndustrialVideo(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public BearingsIndustrial getBearings() {
        return bearings;
    }

    public void setBearings(BearingsIndustrial bearings) {
        this.bearings = bearings;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BearingsIndustrialVideo)) {
            return false;
        }
        BearingsIndustrialVideo other = (BearingsIndustrialVideo) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.domain.bearings.BearingsIndustrialVideo[ name =" + name + " ]";
    }
    
}
