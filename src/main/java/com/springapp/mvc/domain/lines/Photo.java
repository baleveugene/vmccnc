package com.springapp.mvc.domain.lines;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name="line_photo", schema = "", catalog = "automated_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT l FROM Photo l"),
    @NamedQuery(name = "Photo.findByName", query = "SELECT l FROM Photo l WHERE l.name = :name")
    })
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    @Column(name = "photo_name")
    private String name;
    
    @ManyToOne
    @JoinColumn(nullable = false, name="line_model_en", referencedColumnName = "model_en")
    private AutomatedLine line;

    public Photo() {
    }

    public Photo(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return "automated_lines/" + name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public AutomatedLine getLine() {
        return line;
    }

    public void setLine(AutomatedLine line) {
        this.line = line;
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
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.lines.domain.Photo[ name =" + name + " ]";
    }
    
}
