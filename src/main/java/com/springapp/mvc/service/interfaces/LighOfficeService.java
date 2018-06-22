/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.light.LightOffice;
import com.springapp.mvc.domain.light.LightOfficePower;
import com.springapp.mvc.domain.light.LightOfficeSize;
import com.springapp.mvc.domain.light.LightOfficeType;

import java.util.*;
import org.springframework.web.multipart.MultipartFile;

public interface LighOfficeService {
 
    public String[] listImage(String path);
 
    public void uploadImagesLight(String path, MultipartFile[] images);
//    public Wesold getWesold(int id);
    public LightOffice getLightByUrl(String url);
    public LightOffice getLightById(String id);
    
    public  List<LightOffice> getListLighByIds(String ids);
    public  List<LightOffice> getListLightFromSearch(String word);
//    public List<Wesold> getListWesold();
    public List<LightOffice> getListLightOffice();
    public List<LightOffice> getListLightOffice(String emergency, String powers, String size, String type);
    public void uploadLightOffice(String path, MultipartFile[] file);

    public List<LightOfficePower> getListLightOfficePower();
    public List<LightOfficeSize> getListLightOfficeSize();
    public List<LightOfficeType> getListLightOfficeType();
    
    
 //   public void renewFiltersLight();


}

