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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "AutomatedLine.findByWorkpieceEn", query = "SELECT l FROM AutomatedLine l WHERE l.workpieceEn = :workpieceEn"),
    @NamedQuery(name = "AutomatedLine.findByWorkpieceRu", query = "SELECT l FROM AutomatedLine l WHERE l.workpieceRu = :workpieceRu"),
    @NamedQuery(name = "AutomatedLine.findByWorkpieceWeight", query = "SELECT l FROM AutomatedLine l WHERE l.workpieceWeight = :workpieceWeight"),
    @NamedQuery(name = "AutomatedLine.findByWorkpiecePhoto1", query = "SELECT l FROM AutomatedLine l WHERE l.workpiecePhoto1 = :workpiecePhoto1"),
    @NamedQuery(name = "AutomatedLine.findByWorkpiecePhoto2", query = "SELECT l FROM AutomatedLine l WHERE l.workpiecePhoto2 = :workpiecePhoto2"),
    @NamedQuery(name = "AutomatedLine.findByLength", query = "SELECT l FROM AutomatedLine l WHERE l.length = :length"),
    @NamedQuery(name = "AutomatedLine.findByWidth", query = "SELECT l FROM AutomatedLine l WHERE l.width = :width"),
    @NamedQuery(name = "AutomatedLine.findByHight", query = "SELECT l FROM AutomatedLine l WHERE l.hight = :hight"),
    @NamedQuery(name = "AutomatedLine.findByWeight", query = "SELECT l FROM AutomatedLine l WHERE l.weight = :weight"),
    @NamedQuery(name = "AutomatedLine.findByPrice", query = "SELECT l FROM AutomatedLine l WHERE l.price = :price"),
    @NamedQuery(name = "AutomatedLine.findByPhoto1", query = "SELECT l FROM AutomatedLine l WHERE l.photo1 = :photo1"),
    @NamedQuery(name = "AutomatedLine.findByPhoto2", query = "SELECT l FROM AutomatedLine l WHERE l.photo2 = :photo2"),
    @NamedQuery(name = "AutomatedLine.findByPhoto3", query = "SELECT l FROM AutomatedLine l WHERE l.photo3 = :photo3")})
public class AutomatedLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "id")
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
    @Size(min = 1, max = 255)
    @Column(name = "workpiece_en")
    private String workpieceEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "workpiece_ru")
    private String workpieceRu;
    @Basic(optional = false)
    @NotNull   
    @Column(name = "workpiece_weight")
    private String workpieceWeight;
    @Size(max = 245)
    @Column(name = "workpiece_photo1")
    private String workpiecePhoto1;
    @Size(max = 245)
    @Column(name = "workpiece_photo2")
    private String workpiecePhoto2;
    @Lob
    @Size(max = 65535)
    @Column(name = "workpiece_description_en")
    private String workpieceDescriptionEn;
    @Lob
    @Size(max = 65535)
    @Column(name = "workpiece_description_ru")
    private String workpieceDescriptionRu;
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
    @Size(max = 245)
    @Column(name = "photo1")
    private String photo1;
    @Size(max = 245)
    @Column(name = "photo2")
    private String photo2;
    @Size(max = 245)
    @Column(name = "photo3")
    private String photo3;   
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
            String cncFullEn, String cncFullRu,int yearOfManufacture, String workpieceEn, 
            String workpieceRu, int length, int width, int hight, String weight, int numOfWorkingStaff,
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
        this.workpieceEn = workpieceEn;
        this.workpieceRu = workpieceRu;
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

    public String getWorkpiecePhoto1() {
        return "automated_lines/workpiece/" +   workpiecePhoto1;
    }

    public void setWorkpiecePhoto1(String workpiecePhoto1) {
        this.workpiecePhoto1 = workpiecePhoto1;
    }

    public String getWorkpiecePhoto2() {
        return "automated_lines/workpiece/" +   workpiecePhoto2;
    }

    public void setWorkpiecePhoto2(String workpiecePhoto2) {
        this.workpiecePhoto2 = workpiecePhoto2;
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

    public String getPhoto1() {
        return "automated_lines/" +   photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return "automated_lines/" +   photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return "automated_lines/" +   photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3; 
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
