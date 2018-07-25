package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.bearings.BearingsIndustrial;
import com.springapp.mvc.domain.bearings.BearingsIndustrialCountry;
import com.springapp.mvc.domain.bearings.BearingsIndustrialInnerDiameter;
import com.springapp.mvc.domain.bearings.BearingsIndustrialOuterDiameter;
import com.springapp.mvc.domain.bearings.BearingsIndustrialWidth;
import com.springapp.mvc.domain.bearings.BearingsIndustrialManufacturer;
import com.springapp.mvc.domain.bearings.BearingsIndustrialType;
import com.springapp.mvc.domain.bearings.BearingsIndustrialSubType;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;


public interface BearingsIndustrialService {
    

 public String[] listImage(String path);
 
  public void uploadImagesBearings(String path, MultipartFile[] images);
//    public Wesold getWesold(int id);
    public BearingsIndustrial getBearingsById(String id);
    public BearingsIndustrial getBearingsByUrl(String url);
    
    public  List<BearingsIndustrial> getListBearingsByIds(String ids);
    public  List<BearingsIndustrial> getListBearingsFromSearch(String word);
//    public List<Wesold> getListWesold();
    public List<BearingsIndustrial> getListBearingsIndustrial();
    public List<BearingsIndustrial> getListBearingsIndustrial(
            String innerDiameter, String outerDiameter, String width, 
            String type, String subtype, String manufacturer, String country);
    public void uploadBearingsIndustrial(String path, MultipartFile[] file);
          
    public List<BearingsIndustrialInnerDiameter> getListBearingsIndustrialInnerDiameter();
    public List<BearingsIndustrialOuterDiameter> getListBearingsIndustrialOuterDiameter();
    public List<BearingsIndustrialWidth> getListBearingsIndustrialWidth();
    public List<BearingsIndustrialType> getListBearingsIndustrialType();
    public List<BearingsIndustrialSubType> getListBearingsIndustrialSubType();
    public List<BearingsIndustrialManufacturer> getListBearingsIndustrialManufacturer();
    public List<BearingsIndustrialCountry> getListBearingsIndustrialCountry();
      
  //  public void renewFiltersBearings();
}

