/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="automated_line", schema = "", catalog = "automated_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutomatedLine.findAll", query = "SELECT l FROM AutomatedLine l"),
    @NamedQuery(name = "AutomatedLine.findById", query = "SELECT l FROM AutomatedLine l WHERE l.id = :id"),
    @NamedQuery(name = "AutomatedLine.findByUrl", query = "SELECT l FROM AutomatedLine l WHERE l.url = :url"),
    @NamedQuery(name = "AutomatedLine.findByTypeEn", query = "SELECT l FROM AutomatedLine l WHERE l.typeEn = :typeEn"),
    @NamedQuery(name = "AutomatedLine.findByTypeRu", query = "SELECT l FROM AutomatedLine l WHERE l.typeRu = :typeRu"),
    @NamedQuery(name = "AutomatedLine.findByModelEn", query = "SELECT l FROM AutomatedLine l WHERE l.modelEn = :modelEn"),
    @NamedQuery(name = "AutomatedLine.findByModelRu", query = "SELECT l FROM AutomatedLine l WHERE l.modelRu = :modelRu"),
    @NamedQuery(name = "AutomatedLine.findByManufacturerEn", query = "SELECT l FROM AutomatedLine l WHERE l.manufacturerEn = :manufacturerEn"),
    @NamedQuery(name = "AutomatedLine.findByManufacturerRu", query = "SELECT l FROM AutomatedLine l WHERE l.manufacturerRu = :manufacturerRu"),
    @NamedQuery(name = "AutomatedLine.findByCountryEn", query = "SELECT l FROM AutomatedLine l WHERE l.countryEn = :countryEn"),
    @NamedQuery(name = "AutomatedLine.findByCountryRu", query = "SELECT l FROM AutomatedLine l WHERE l.countryRu = :countryRu"),
    @NamedQuery(name = "AutomatedLine.findByCncEn", query = "SELECT l FROM AutomatedLine l WHERE l.cncEn = :cncEn"),
    @NamedQuery(name = "AutomatedLine.findByCncRu", query = "SELECT l FROM AutomatedLine l WHERE l.cncRu = :cncRu"),
    @NamedQuery(name = "AutomatedLine.findByCncFullEn", query = "SELECT l FROM AutomatedLine l WHERE l.cncFullEn = :cncFullEn"),
    @NamedQuery(name = "AutomatedLine.findByCncFullRu", query = "SELECT l FROM AutomatedLine l WHERE l.cncFullRu = :cncFullRu"),
    @NamedQuery(name = "AutomatedLine.findByMachineConditionEn", query = "SELECT l FROM AutomatedLine l WHERE l.machineConditionEn = :machineConditionEn"),
    @NamedQuery(name = "AutomatedLine.findByMachineConditionRu", query = "SELECT l FROM AutomatedLine l WHERE l.machineConditionRu = :machineConditionRu"),
    @NamedQuery(name = "AutomatedLine.findByMachineLocationEn", query = "SELECT l FROM AutomatedLine l WHERE l.machineLocationEn = :machineLocationEn"),
    @NamedQuery(name = "AutomatedLine.findByMachineLocationRu", query = "SELECT l FROM AutomatedLine l WHERE l.machineLocationRu = :machineLocationRu"),
    @NamedQuery(name = "AutomatedLine.findByYearOfManufacture", query = "SELECT l FROM AutomatedLine l WHERE l.yearOfManufacture = :yearOfManufacture"),
    @NamedQuery(name = "AutomatedLine.findByLength", query = "SELECT l FROM AutomatedLine l WHERE l.length = :length"),
    @NamedQuery(name = "AutomatedLine.findByWidth", query = "SELECT l FROM AutomatedLine l WHERE l.width = :width"),
    @NamedQuery(name = "AutomatedLine.findByHight", query = "SELECT l FROM AutomatedLine l WHERE l.hight = :hight"),
    @NamedQuery(name = "AutomatedLine.findByWeight", query = "SELECT l FROM AutomatedLine l WHERE l.weight = :weight"),
    @NamedQuery(name = "AutomatedLine.findByPrice", query = "SELECT l FROM AutomatedLine l WHERE l.price = :price")})
public class AutomatedLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private String id;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "type_en")
    private String typeEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "type_ru")
    private String typeRu;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "model_en")
    private String modelEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "model_ru")
    private String modelRu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "manufacturer_en")
    private String manufacturerEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "manufacturer_ru")
    private String manufacturerRu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "country_en")
    private String countryEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "country_ru")
    private String countryRu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CNC_en")
    private String cncEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CNC_ru")
    private String cncRu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CNC_full_en")
    private String cncFullEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CNC_full_ru")
    private String cncFullRu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "machine_condition_en")
    private String machineConditionEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "machine_condition_ru")
    private String machineConditionRu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "machine_location_en")
    private String machineLocationEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "machine_location_ru")
    private String machineLocationRu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year_of_manufacture")
    private int yearOfManufacture;   
    @Basic(optional = false)
    @NotNull   
    @Column(name = "line_length")
    private int length;
    @Basic(optional = false)
    @NotNull   
    @Column(name = "line_width")
    private int width;
    @Basic(optional = false)
    @NotNull   
    @Column(name = "line_hight")
    private int hight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line_weight")
    private String weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_of_working_staff")
    private int numOfWorkingStaff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "productivity")
    private String productivity;
    @Column(name = "price")
    private Integer price;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "line")
    private Set<Photo> photos = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "line")
    private Set<Video> videos = new HashSet<>();
    @ManyToOne   
    @JoinColumn(name = "workpiece_id")
    @NotNull
    private AutomatedLineWorkpiece workpiece;
    @Lob
    @Size(max = 65535)
    @Column(name = "description_en")
    private String descriptionEn;
    @Lob
    @Size(max = 65535)
    @Column(name = "description_ru")
    private String descriptionRu;

    public AutomatedLine() {
    }

    public AutomatedLine(String model) {
        this.modelEn = model;
    }

    public AutomatedLine(String modelEn, String modelRu, String typeEn,
            String manufacturerEn, String countryEn, String typeRu, String subTypeRu, 
            String manufacturerRu, String countryRu, String cncEn, String cncRu,
            String cncFullEn, String cncFullRu,int yearOfManufacture, 
            int length, int width, int hight, String weight, int numOfWorkingStaff,
            String productivity) {
        this.modelEn = modelEn;
        this.modelRu = modelRu;
        this.typeEn = typeEn;
        this.typeRu = typeRu;
        this.manufacturerEn = manufacturerEn;
        this.manufacturerRu = manufacturerRu;
        this.countryEn = countryEn;
        this.countryRu = countryRu;
        this.cncEn = cncEn;
        this.cncRu = cncRu;
        this.cncFullEn = cncFullEn;
        this.cncFullRu = cncFullRu;
        this.length = length;
        this.width = width;
        this.hight = hight;
        this.weight = weight;
        this.numOfWorkingStaff = numOfWorkingStaff;
        this.productivity = productivity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTypeEn() {
        return typeEn;
    }

    public void setTypeEn(String typeEn) {
        this.typeEn = typeEn;
    }
    
    public String getTypeRu() {
        return typeRu;
    }

    public void setTypeRu(String typeRu) {
        this.typeRu = typeRu;
    }
    
    public String getModelEn() {
        return modelEn;
    }

    public void setModelEn(String model) {
        this.modelEn = model;
    }
    
    public String getModelRu() {
        return modelRu;
    }

    public void setModelRu(String model) {
        this.modelRu = model;
    }

    public String getManufacturerEn() {
        return manufacturerEn;
    }

    public void setManufacturerEn(String manufacturerEn) {
        this.manufacturerEn = manufacturerEn;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }
    
    public String getManufacturerRu() {
        return manufacturerRu;
    }

    public void setManufacturerRu(String manufacturerRu) {
        this.manufacturerRu = manufacturerRu;
    }

    public String getCountryRu() {
        return countryRu;
    }

    public void setCountryRu(String countryRu) {
        this.countryRu = countryRu;
    }

    public String getCncEn() {
        return cncEn;
    }

    public void setCncEn(String cncEn) {
        this.cncEn = cncEn;
    }
    
    public String getCncRu() {
        return cncRu;
    }

    public void setCncRu(String cncRu) {
        this.cncRu = cncRu;
    }
    
    public String getCncFullEn() {
        return cncFullEn;
    }

    public void setCncFullEn(String cncFullEn) {
        this.cncFullEn = cncFullEn;
    }
    
    public String getCncFullRu() {
        return cncFullRu;
    }

    public void setCncFullRu(String cncFullRu) {
        this.cncFullRu = cncFullRu;
    }
    
    public String getMachineConditionEn() {
        return machineConditionEn;
    }

    public void setMachineConditionEn(String machineConditionEn) {
        this.machineConditionEn = machineConditionEn;
    }
    
    public String getMachineConditionRu() {
        return machineConditionRu;
    }

    public void setMachineConditionRu(String machineConditionRu) {
        this.machineConditionRu = machineConditionRu;
    }
    
    public String getMachineLocationEn() {
        return machineLocationEn;
    }

    public void setMachineLocationEn(String machineLocationEn) {
        this.machineLocationEn = machineLocationEn;
    }
    
    public String getMachineLocationRu() {
        return machineLocationRu;
    }

    public void setMachineLocationRu(String machineLocationRu) {
        this.machineLocationRu = machineLocationRu;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }   
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getNumOfWorkingStaff() {
        return numOfWorkingStaff;
    }

    public void setNumOfWorkingStaff(int numOfWorkingStaff) {
        this.numOfWorkingStaff = numOfWorkingStaff;
    }

    public String getProductivity() {
        return productivity;
    }

    public void setProductivity(String productivity) {
        this.productivity = productivity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }
    
    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }
    
    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }
    
    public void addVideo(Video video) {
        this.videos.add(video);
    }
    
    public AutomatedLineWorkpiece getWorkpiece() {
        return workpiece;
    }

    public void setWorkpiece(AutomatedLineWorkpiece workpiece) {
        this.workpiece = workpiece;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    
    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelEn != null ? modelEn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutomatedLine)) {
            return false;
        }
        AutomatedLine other = (AutomatedLine) object;
        if ((this.modelEn == null && other.modelEn != null) || (this.modelEn != null && !this.modelEn.equals(other.modelEn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.lines.domain.AutomatedLine[ model=" + modelEn + " ]";
    }
}
