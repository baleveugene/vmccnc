package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.HbmDAO;

import com.springapp.mvc.domain.bearings.BearingsIndustrial;
import com.springapp.mvc.domain.bearings.BearingsIndustrialCountry;
import com.springapp.mvc.domain.bearings.BearingsIndustrialInnerDiameter;
import com.springapp.mvc.domain.bearings.BearingsIndustrialOuterDiameter;
import com.springapp.mvc.domain.bearings.BearingsIndustrialWidth;
import com.springapp.mvc.domain.bearings.BearingsIndustrialManufacturer;
import com.springapp.mvc.domain.bearings.BearingsIndustrialPhoto;
import com.springapp.mvc.domain.bearings.BearingsIndustrialType;
import com.springapp.mvc.domain.bearings.BearingsIndustrialSubType;
import com.springapp.mvc.domain.bearings.BearingsIndustrialVideo;
import com.springapp.mvc.service.interfaces.BearingsIndustrialService;

import com.springapp.mvc.util.ImageUtil;
import com.springapp.mvc.util.UploadMultipartFileUtil;
import com.springapp.mvc.util.exel.ParserExcelBearingsIndustrial;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service 
public class BearingsIndustrialServiceImpl implements BearingsIndustrialService {
      
    @Autowired  
    private HbmDAO hbmDAO;
    
    @Override @Transactional
    public void uploadBearingsIndustrial(String path, MultipartFile[] file) {
        for (int i = 0; i < file.length; i++) {
            try {
                File uploadFile = UploadMultipartFileUtil.uploadFile(path, file[i]);
                BearingsIndustrial bearingsIndustrial = ParserExcelBearingsIndustrial.readBearingsIndustrial(uploadFile);
                BearingsIndustrial bearingsIndustrialFromDB = (BearingsIndustrial)hbmDAO.getByUrl(BearingsIndustrial.class, bearingsIndustrial.getUrl());
                if(bearingsIndustrialFromDB != null){
                    bearingsIndustrialFromDB = setValuesForUpdate(bearingsIndustrialFromDB, bearingsIndustrial);
                    hbmDAO.add(bearingsIndustrialFromDB);
                } else {
                    hbmDAO.add(bearingsIndustrial); 
                }                         
                uploadFile.delete();
                System.out.println("Successfully uploaded: " + file[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload file: " + e.getMessage());
            }
        }
    }
    
    private BearingsIndustrial setValuesForUpdate(BearingsIndustrial bearingsIndustrialFromDB, BearingsIndustrial bearingsIndustrial){
        bearingsIndustrialFromDB.setBasicDynamicLoadRating(bearingsIndustrial.getBasicDynamicLoadRating());
        bearingsIndustrialFromDB.setBasicStaticLoadRating(bearingsIndustrial.getBasicStaticLoadRating());
        bearingsIndustrialFromDB.setCountryEn(bearingsIndustrial.getCountryEn());
        bearingsIndustrialFromDB.setCountryRu(bearingsIndustrial.getCountryRu());
        bearingsIndustrialFromDB.setDescriptionEn(bearingsIndustrial.getDescriptionEn());
        bearingsIndustrialFromDB.setDescriptionRu(bearingsIndustrial.getDescriptionRu());
        bearingsIndustrialFromDB.setFatiqueLoadLimit(bearingsIndustrial.getFatiqueLoadLimit());
        bearingsIndustrialFromDB.setGuarantee(bearingsIndustrial.getGuarantee());
        bearingsIndustrialFromDB.setInnerDiameter(bearingsIndustrial.getInnerDiameter());
        bearingsIndustrialFromDB.setLimitingSpeed(bearingsIndustrial.getLimitingSpeed());
        bearingsIndustrialFromDB.setManufacturerEn(bearingsIndustrial.getManufacturerEn());
        bearingsIndustrialFromDB.setManufacturerRu(bearingsIndustrial.getManufacturerRu());
        bearingsIndustrialFromDB.setModelEn(bearingsIndustrial.getModelEn());
        bearingsIndustrialFromDB.setModelRu(bearingsIndustrial.getModelRu());
        bearingsIndustrialFromDB.setOuterDiameter(bearingsIndustrial.getOuterDiameter());
        bearingsIndustrialFromDB.setPrice(bearingsIndustrial.getPrice());
        bearingsIndustrialFromDB.setReferenceSpeed(bearingsIndustrial.getReferenceSpeed());
        bearingsIndustrialFromDB.setSubTypeEn(bearingsIndustrial.getSubTypeEn());
        bearingsIndustrialFromDB.setSubTypeRu(bearingsIndustrial.getSubTypeRu());
        bearingsIndustrialFromDB.setTemperatureWork(bearingsIndustrial.getTemperatureWork());
        bearingsIndustrialFromDB.setTypeEn(bearingsIndustrial.getTypeEn());
        bearingsIndustrialFromDB.setTypeRu(bearingsIndustrial.getTypeRu());
        bearingsIndustrialFromDB.setUrl(bearingsIndustrial.getUrl());
        bearingsIndustrialFromDB.setWeight(bearingsIndustrial.getWeight());
        bearingsIndustrialFromDB.setWidth(bearingsIndustrial.getWidth());       
        Set<BearingsIndustrialPhoto> photos = bearingsIndustrial.getPhotos();
        for(BearingsIndustrialPhoto photo : photos){
            BearingsIndustrialPhoto photoFromDB = (BearingsIndustrialPhoto)hbmDAO.getByName(BearingsIndustrialPhoto.class, photo.getName());
            if(photoFromDB == null){
                bearingsIndustrialFromDB.addPhoto(photo);
            }           
        }
        Set<BearingsIndustrialVideo> videos = bearingsIndustrial.getVideos();
        for(BearingsIndustrialVideo video : videos){
            BearingsIndustrialVideo videoFromDB = (BearingsIndustrialVideo)hbmDAO.getByName(BearingsIndustrialVideo.class, video.getName());
            if(videoFromDB == null){
                bearingsIndustrialFromDB.addVideo(video);
            }                   
        }
        return bearingsIndustrialFromDB;
    }
    
    @Override @Transactional
    public List<BearingsIndustrial> getListBearingsIndustrial() {
    return  hbmDAO.getAll(BearingsIndustrial.class);
    }           
    
    @Override @Transactional
    public List<BearingsIndustrialInnerDiameter> getListBearingsIndustrialInnerDiameter() {
    return  hbmDAO.getAll(BearingsIndustrialInnerDiameter.class);
    }
    
    @Override @Transactional
    public List<BearingsIndustrialOuterDiameter> getListBearingsIndustrialOuterDiameter() {
    return  hbmDAO.getAll(BearingsIndustrialOuterDiameter.class);
    }
    
     @Override @Transactional
    public List<BearingsIndustrialWidth> getListBearingsIndustrialWidth() {
    return  hbmDAO.getAll(BearingsIndustrialWidth.class);
    }
            
    @Override @Transactional
    public List<BearingsIndustrialType> getListBearingsIndustrialType() {
    return  hbmDAO.getAll(BearingsIndustrialType.class);
    }
    
    @Override @Transactional
    public List<BearingsIndustrialSubType> getListBearingsIndustrialSubType() {
    return  hbmDAO.getAll(BearingsIndustrialSubType.class);
    }
    
    @Override @Transactional
    public List<BearingsIndustrialManufacturer> getListBearingsIndustrialManufacturer() {
    return  hbmDAO.getAll(BearingsIndustrialManufacturer.class);
    }
    
    @Override @Transactional
    public List<BearingsIndustrialCountry> getListBearingsIndustrialCountry() {
    return  hbmDAO.getAll(BearingsIndustrialCountry.class);
    }
    
    @Override @Transactional
    public List<BearingsIndustrial> getListBearingsIndustrial(
            String innerDiameter, String outerDiameter, String width, 
            String type, String subtype, String manufacturer, String country) {     
        List<Criterion> restrictions = new ArrayList();
        System.out.println(outerDiameter);
        if (innerDiameter != null && !innerDiameter.equals("")){            
            String[] arrInnerDFromTo = innerDiameter.split(" < d <= ");           
            if(arrInnerDFromTo.length>1){
                Criterion restr = Restrictions.between("innerDiameter", Integer.valueOf(arrInnerDFromTo[0]), Integer.valueOf(arrInnerDFromTo[1]));
                restrictions.add(restr);              
            } else{ 
                Criterion restr = Restrictions.sqlRestriction("d_inner_diameter >"+innerDiameter.substring(0, innerDiameter.indexOf("<")));
                restrictions.add(restr);                
            }                           
        }
        if (outerDiameter != null && !outerDiameter.equals("")){            
            String[] arrOuterDFromTo = outerDiameter.split(" < D <= ");                       
            if(arrOuterDFromTo.length>1){
                Criterion restr = Restrictions.between("outerDiameter", Integer.valueOf(arrOuterDFromTo[0]), Integer.valueOf(arrOuterDFromTo[1]));
                restrictions.add(restr);              
            } else { 
                Criterion restr = Restrictions.sqlRestriction("D_outer_diameter >"+outerDiameter.substring(0, outerDiameter.indexOf("<")));
                restrictions.add(restr);                
            }                                         
        }
        if (width != null && !width.equals("")){            
            String[] arrWidthFromTo = width.split(" < B <= ");           
            if(arrWidthFromTo.length>1){
                Criterion restr = Restrictions.between("width", Integer.valueOf(arrWidthFromTo[0]), Integer.valueOf(arrWidthFromTo[1]));
                restrictions.add(restr);              
            } else { 
                Criterion restr = Restrictions.sqlRestriction("B_width >"+width.substring(0, width.indexOf("<")));
                restrictions.add(restr);                
            }    
        }
        if (type != null && !type.equals("")){
            restrictions.add(Restrictions.eq("typeEn", type));                  
        }
        if (subtype != null && !subtype.equals("")){ 
            restrictions.add(Restrictions.eq("subTypeEn", subtype));
        }
        if (manufacturer != null && !manufacturer.equals("")){ 
            restrictions.add(Restrictions.eq("manufacturerEn", manufacturer));
        }
        if (country != null && !country.equals("")){
            restrictions.add(Restrictions.eq("countryEn", country));          
        } 
        return  hbmDAO.getAll(BearingsIndustrial.class, restrictions);
    }   
   
    @Override    @Transactional
    public String[] listImage(String path) {
        return ImageUtil.getListImage(path);
    }
    
    @Override    @Transactional
    public void uploadImagesBearings(String path, MultipartFile[] images) {
        for (int i = 0; i < images.length; i++) {
            try {
                UploadMultipartFileUtil.uploadImage(path, images[i]);
                System.out.println("Successfully uploaded photo: " + images[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload photo: " + e.getMessage());
            }
        }
    }
    
    
    @Override @Transactional
    public BearingsIndustrial getBearingsById(String id) {
        return  (BearingsIndustrial) hbmDAO.getById(BearingsIndustrial.class, id);
                
    }
    
    @Override @Transactional
    public BearingsIndustrial getBearingsByUrl(String url) {
    return  (BearingsIndustrial) hbmDAO.getByUrl(BearingsIndustrial.class, url);
    }
/*    
    @Override @Transactional
    public void renewFiltersBearings() {               
        bearingsIndustrialDao.renewBearingsIndustrialSize();  
        bearingsIndustrialDao.renewBearingsIndustrialType();
    }
*/
    @Override @Transactional
    public List<BearingsIndustrial> getListBearingsByIds(String ids) {
         String[] idsArr = (ids != null) ? ids.split(",") : null;
      return hbmDAO.getListByIds(BearingsIndustrial.class, idsArr);
    }
   
    @Override @Transactional
    public List<BearingsIndustrial> getListBearingsFromSearch(String word) {
      return hbmDAO.getListFromSearch(BearingsIndustrial.class, word);
    }      
}
