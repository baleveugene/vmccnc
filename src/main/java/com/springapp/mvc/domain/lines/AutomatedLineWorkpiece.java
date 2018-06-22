package com.springapp.mvc.domain.lines;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home
 */
@Entity
@Table(name="workpiece", schema = "", catalog = "automated_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutomatedLineWorkpiece.findAll", query = "SELECT l FROM AutomatedLineWorkpiece l"),
    @NamedQuery(name = "AutomatedLineWorkpiece.findByWorkpieceEn", query = "SELECT l FROM AutomatedLineWorkpiece l WHERE l.workpieceEn = :workpieceEn"),
    @NamedQuery(name = "AutomatedLineWorkpiece.findByWorkpieceRu", query = "SELECT l FROM AutomatedLineWorkpiece l WHERE l.workpieceRu = :workpieceRu"),
    @NamedQuery(name = "AutomatedLineWorkpiece.findByNum", query = "SELECT l FROM AutomatedLineWorkpiece l WHERE l.num = :num")})
public class AutomatedLineWorkpiece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workpiece_id")
    private long id;
    @Column(name = "num")
    private Integer num;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "workpiece_en")
    private String workpieceEn;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "workpiece_ru")
    private String workpieceRu;
    @Basic(optional = false)
    @NotNull   
    @Column(name = "workpiece_weight")
    private String workpieceWeight;
    @Lob
    @Size(max = 65535)
    @Column(name = "workpiece_description_en")
    private String workpieceDescriptionEn;
    @Lob
    @Size(max = 65535)
    @Column(name = "workpiece_description_ru")
    private String workpieceDescriptionRu;
    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "workpiece")   
    private Set<WorkpiecePhoto> photos = new HashSet<>();
    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "workpiece")   
    private Set<AutomatedLine> lines = new HashSet<>();

    public AutomatedLineWorkpiece() {
    }

    public AutomatedLineWorkpiece(String workpieceEn, String workpieceRu, String workpieceWeight) {
        this.workpieceEn = workpieceEn;
        this.workpieceRu = workpieceRu;
        this.workpieceWeight = workpieceWeight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getWorkpieceEn() {
        return workpieceEn;
    }

    public void setWorkpieceEn(String workpieceEn) {
        this.workpieceEn = workpieceEn;
    }
    
    public String getWorkpieceRu() {
        return workpieceRu;
    }

    public void setWorkpieceRu(String workpieceRu) {
        this.workpieceRu = workpieceRu;
    }

    public String getWorkpieceWeight() {
        return workpieceWeight;
    }

    public void setWorkpieceWeight(String workpieceWeight) {
        this.workpieceWeight = workpieceWeight;
    }
    
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    
    public String getWorkpieceDescriptionEn() {
        return workpieceDescriptionEn;
    }

    public void setWorkpieceDescriptionEn(String workpieceDescriptionEn) {
        this.workpieceDescriptionEn = workpieceDescriptionEn;
    }
    
    public String getWorkpieceDescriptionRu() {
        return workpieceDescriptionRu;
    }

    public void setWorkpieceDescriptionRu(String workpieceDescriptionRu) {
        this.workpieceDescriptionRu = workpieceDescriptionRu;
    }
    
    public Set<WorkpiecePhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<WorkpiecePhoto> photos) {
        this.photos = photos;
    }
    
    public void addPhoto(WorkpiecePhoto photo) {
        this.photos.add(photo);
    }
    
    public Set<AutomatedLine> getLines() {
        return lines;
    }

    public void setLines(Set<AutomatedLine> lines) {
        this.lines = lines;
    }
    
    public void addLine(AutomatedLine line) {
        this.lines.add(line);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workpieceEn != null ? workpieceEn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutomatedLineWorkpiece)) {
            return false;
        }
        AutomatedLineWorkpiece other = (AutomatedLineWorkpiece) object;
        if ((this.workpieceEn == null && other.workpieceEn != null) || (this.workpieceEn != null && !this.workpieceEn.equals(other.workpieceEn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.lines.domain.AutomatedLineWorkpiece[ workpiece =" + workpieceEn + " ]";
    }
    
}
