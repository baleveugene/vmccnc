package com.springapp.mvc.domain.bearings;

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
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="bearings_industrial", schema = "", catalog = "bearings_industrial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BearingsIndustrial.findAll", query = "SELECT l FROM BearingsIndustrial l"),
    @NamedQuery(name = "BearingsIndustrial.findById", query = "SELECT l FROM BearingsIndustrial l WHERE l.id = :id"),
    @NamedQuery(name = "BearingsIndustrial.findByUrl", query = "SELECT l FROM BearingsIndustrial l WHERE l.url = :url"),
    @NamedQuery(name = "BearingsIndustrial.findByTypeEn", query = "SELECT l FROM BearingsIndustrial l WHERE l.typeEn = :typeEn"),
    @NamedQuery(name = "BearingsIndustrial.findByTypeRu", query = "SELECT l FROM BearingsIndustrial l WHERE l.typeRu = :typeRu"),
    @NamedQuery(name = "BearingsIndustrial.findBySubTypeEn", query = "SELECT l FROM BearingsIndustrial l WHERE l.subTypeEn = :subTypeEn"),
    @NamedQuery(name = "BearingsIndustrial.findBySubTypeRu", query = "SELECT l FROM BearingsIndustrial l WHERE l.subTypeRu = :subTypeRu"),
    @NamedQuery(name = "BearingsIndustrial.findByModelEn", query = "SELECT l FROM BearingsIndustrial l WHERE l.modelEn = :modelEn"),
    @NamedQuery(name = "BearingsIndustrial.findByModelRu", query = "SELECT l FROM BearingsIndustrial l WHERE l.modelRu = :modelRu"),
    @NamedQuery(name = "BearingsIndustrial.findByManufacturerEn", query = "SELECT l FROM BearingsIndustrial l WHERE l.manufacturerEn = :manufacturerEn"),
    @NamedQuery(name = "BearingsIndustrial.findByManufacturerRu", query = "SELECT l FROM BearingsIndustrial l WHERE l.manufacturerRu = :manufacturerRu"),
    @NamedQuery(name = "BearingsIndustrial.findByCountryEn", query = "SELECT l FROM BearingsIndustrial l WHERE l.countryEn = :countryEn"),
    @NamedQuery(name = "BearingsIndustrial.findByCountryRu", query = "SELECT l FROM BearingsIndustrial l WHERE l.countryRu = :countryRu"),
    @NamedQuery(name = "BearingsIndustrial.findByBasicDynamicLoadRating", query = "SELECT l FROM BearingsIndustrial l WHERE l.basicDynamicLoadRating = :basicDynamicLoadRating"),
    @NamedQuery(name = "BearingsIndustrial.findByBasicStaticLoadRating", query = "SELECT l FROM BearingsIndustrial l WHERE l.basicStaticLoadRating = :basicStaticLoadRating"),
    @NamedQuery(name = "BearingsIndustrial.findByFatiqueLoadLimit", query = "SELECT l FROM BearingsIndustrial l WHERE l.fatiqueLoadLimit = :fatiqueLoadLimit"),
    @NamedQuery(name = "BearingsIndustrial.findByReferenceSpeed", query = "SELECT l FROM BearingsIndustrial l WHERE l.referenceSpeed = :referenceSpeed"),
    @NamedQuery(name = "BearingsIndustrial.findByLimitingSpeed", query = "SELECT l FROM BearingsIndustrial l WHERE l.limitingSpeed = :limitingSpeed"),
    @NamedQuery(name = "BearingsIndustrial.findByInnerDiameter", query = "SELECT l FROM BearingsIndustrial l WHERE l.innerDiameter = :innerDiameter"),
    @NamedQuery(name = "BearingsIndustrial.findByOuterDiameter", query = "SELECT l FROM BearingsIndustrial l WHERE l.outerDiameter = :outerDiameter"),
    @NamedQuery(name = "BearingsIndustrial.findByWidth", query = "SELECT l FROM BearingsIndustrial l WHERE l.width = :width"),
    @NamedQuery(name = "BearingsIndustrial.findByWeight", query = "SELECT l FROM BearingsIndustrial l WHERE l.weight = :weight"),
    @NamedQuery(name = "BearingsIndustrial.findByTemperatureWork", query = "SELECT l FROM BearingsIndustrial l WHERE l.temperatureWork = :temperatureWork"),
    @NamedQuery(name = "BearingsIndustrial.findByGuarantee", query = "SELECT l FROM BearingsIndustrial l WHERE l.guarantee = :guarantee"),
    @NamedQuery(name = "BearingsIndustrial.findByPrice", query = "SELECT l FROM BearingsIndustrial l WHERE l.price = :price")})
public class BearingsIndustrial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "subType_en")
    private String subTypeEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "subType_ru")
    private String subTypeRu;
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
    @Column(name = "basic_dynamic_load_rating")
    private int basicDynamicLoadRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "basic_static_load_rating")
    private int basicStaticLoadRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fatique_load_limit")
    private int fatiqueLoadLimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reference_speed")
    private int referenceSpeed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limiting_speed")
    private int limitingSpeed;
    @Basic(optional = false)
    @NotNull   
    @Column(name = "d_inner_diameter")
    private int innerDiameter;
    @Basic(optional = false)
    @NotNull   
    @Column(name = "D_outer_diameter")
    private int outerDiameter;
    @Basic(optional = false)
    @NotNull   
    @Column(name = "B_width")
    private int width;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "weight")
    private String weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "temperature_work")
    private String temperatureWork;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "guarantee")
    private String guarantee;  
    @Column(name = "price")
    private Integer price;   
    @Lob
    @Size(max = 65535)
    @Column(name = "description_en")
    private String descriptionEn;
    @Lob
    @Size(max = 65535)
    @Column(name = "description_ru")
    private String descriptionRu;
    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "bearings")   
    private Set<BearingsIndustrialPhoto> photos = new HashSet<>();
    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "bearings")  
    private Set<BearingsIndustrialVideo> videos = new HashSet<>();

    public BearingsIndustrial() {
    }

    public BearingsIndustrial(String modelEn) {
        this.modelEn = modelEn;
    }

    public BearingsIndustrial(String modelEn, String modelRu, String typeEn, String subTypeEn, 
            String manufacturerEn, String countryEn, String typeRu, String subTypeRu, 
            String manufacturerRu, String countryRu, int basicDynamicLoadRating, 
            int basicStaticLoadRating, int fatiqueLoadLimit, int referenceSpeed, 
            int limitingSpeed, int innerDiameter, int outerDiameter, int width, String weight, String temperatureWork, 
            String guarantee) {
        this.modelEn = modelEn;
        this.modelRu = modelRu;
        this.typeEn = typeEn;
        this.subTypeEn = subTypeEn;
        this.manufacturerEn = manufacturerEn;
        this.countryEn = countryEn;
        this.typeRu = typeRu;
        this.subTypeRu = subTypeRu;
        this.manufacturerRu = manufacturerRu;
        this.countryRu = countryRu;
        this.basicDynamicLoadRating = basicDynamicLoadRating;
        this.basicStaticLoadRating = basicStaticLoadRating;
        this.fatiqueLoadLimit = fatiqueLoadLimit;
        this.referenceSpeed = referenceSpeed;
        this.limitingSpeed = limitingSpeed;
        this.innerDiameter = innerDiameter;
        this.outerDiameter = outerDiameter;
        this.width = width;
        this.weight = weight;
        this.temperatureWork = temperatureWork;
        this.guarantee = guarantee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    
     public String getSubTypeEn() {
        return subTypeEn;
    }

    public void setSubTypeEn(String subTypeEn) {
        this.subTypeEn = subTypeEn;
    }
    
    public String getTypeRu() {
        return typeRu;
    }

    public void setTypeRu(String typeRu) {
        this.typeRu = typeRu;
    }
    
     public String getSubTypeRu() {
        return subTypeRu;
    }

    public void setSubTypeRu(String subTypeRu) {
        this.subTypeRu = subTypeRu;
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

    public int getBasicDynamicLoadRating() {
        return basicDynamicLoadRating;
    }

    public void setBasicDynamicLoadRating(int basicDynamicLoadRating) {
        this.basicDynamicLoadRating = basicDynamicLoadRating;
    }

    public int getBasicStaticLoadRating() {
        return basicStaticLoadRating;
    }

    public void setBasicStaticLoadRating(int basicStaticLoadRating) {
        this.basicStaticLoadRating = basicStaticLoadRating;
    }

    public int getFatiqueLoadLimit() {
        return fatiqueLoadLimit;
    }

    public void setFatiqueLoadLimit(int fatiqueLoadLimit) {
        this.fatiqueLoadLimit = fatiqueLoadLimit;
    }

    public int getReferenceSpeed() {
        return referenceSpeed;
    }

    public void setReferenceSpeed(int referenceSpeed) {
        this.referenceSpeed = referenceSpeed;
    }

    public int getLimitingSpeed() {
        return limitingSpeed;
    }

    public void setLimitingSpeed(int limitingSpeed) {
        this.limitingSpeed = limitingSpeed;
    }

    public int getInnerDiameter() {
        return innerDiameter;
    }

    public void setInnerDiameter(int innerDiameter) {
        this.innerDiameter = innerDiameter;
    }

    public int getOuterDiameter() {
        return outerDiameter;
    }

    public void setOuterDiameter(int outerDiameter) {
        this.outerDiameter = outerDiameter;
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

    public String getTemperatureWork() {
        return temperatureWork;
    }

    public void setTemperatureWork(String temperatureWork) {
        this.temperatureWork = temperatureWork;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<BearingsIndustrialPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<BearingsIndustrialPhoto> photos) {
        this.photos = photos;
    }
    
    public void addPhoto(BearingsIndustrialPhoto photo) {
        this.photos.add(photo);
    }
    
    public Set<BearingsIndustrialVideo> getVideos() {
        return videos;
    }

    public void setVideos(Set<BearingsIndustrialVideo> videos) {
        this.videos = videos;
    }
    
    public void addVideo(BearingsIndustrialVideo video) {
        this.videos.add(video);
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
        if (!(object instanceof BearingsIndustrial)) {
            return false;
        }
        BearingsIndustrial other = (BearingsIndustrial) object;
        if ((this.modelEn == null && other.modelEn != null) || (this.modelEn != null && !this.modelEn.equals(other.modelEn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.domain.bearings.BearingsIndustrial[ model=" + modelEn + " ]";
    }
}
