package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.HbmDAO;

import com.springapp.mvc.domain.light.LightOffice;
import com.springapp.mvc.domain.light.LightOfficePower;
import com.springapp.mvc.domain.light.LightOfficeSize;
import com.springapp.mvc.domain.light.LightOfficeType;
import com.springapp.mvc.service.interfaces.LighOfficeService;

import com.springapp.mvc.util.ImageUtil;
import com.springapp.mvc.util.UploadMultipartFileUtil;
import com.springapp.mvc.util.exel.ParserExcelLightOffice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service 
public class LighOfficeServiceImpl implements LighOfficeService {
     
    @Autowired  
    private HbmDAO hbmDAO;
    
    @Override @Transactional
    public void uploadLightOffice(String path, MultipartFile[] file) {
        for (int i = 0; i < file.length; i++) {
            try {
                File uploadFile = UploadMultipartFileUtil.uploadFile(path, file[i]);
                LightOffice lightOffice = ParserExcelLightOffice.readLightOffice(uploadFile);
                hbmDAO.add(lightOffice);
                uploadFile.delete();
                System.out.println("Successfully uploaded machine: " + file[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload machine file: " + e.getMessage());
            }
        }
    }
    
    @Override @Transactional
    public List<LightOffice> getListLightOffice() {
        return  hbmDAO.getAll(LightOffice.class);
    }
   
    @Override @Transactional
    public List<LightOfficePower> getListLightOfficePower() {
        return  hbmDAO.getAll(LightOfficePower.class);
    }
    
    @Override @Transactional
    public List<LightOfficeSize> getListLightOfficeSize() {
        return  hbmDAO.getAll(LightOfficeSize.class);
    }
   
    @Override @Transactional
    public List<LightOfficeType> getListLightOfficeType() {
        return  hbmDAO.getAll(LightOfficeType.class);
    }
    
    @Override @Transactional
    public List<LightOffice> getListLightOffice(String emergency, String powers, String size, String type) {
        String[] arrPowers = (powers != null) ? powers.split(",") : null;
        List<Criterion> restrictions = new ArrayList();
        if (type != null && !type.equals("")){
            restrictions.add(Restrictions.eq("type", type));                  
        }
        if (size != null && !size.equals("")){
            restrictions.add(Restrictions.eq("size", size));                  
        }
        if (emergency != null){
            restrictions.add(Restrictions.ne("luminousFluxEmergency", 0));                  
        }
        if (arrPowers != null && !arrPowers[0].equals("")){
            restrictions.add(Restrictions.in("power", arrPowers));                  
        }     
        return  hbmDAO.getAll(LightOffice.class, restrictions);
    }
    
    @Override @Transactional
    public LightOffice getLightByUrl(String url) {
        return  (LightOffice) hbmDAO.getByUrl(LightOffice.class, url);
    }
    
        @Transactional
    public String[] listImage(String path) {
        return ImageUtil.getListImage(path);
    }
    
    
        @Transactional
    public void uploadImagesLight(String path, MultipartFile[] images) {
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
    public LightOffice getLightById(String id) {
        return  (LightOffice) hbmDAO.getById(LightOffice.class, id);
    }
/*    
    @Override @Transactional
    public void renewFiltersLight() {
     
    lightOfficeDao.renewLightOfficePower();
    lightOfficeDao.renewLightOfficeSize();
      
    lightOfficeDao.renewLightOfficeType();

    }
*/
    @Override @Transactional
    public List<LightOffice> getListLighByIds(String ids) {
         String[] idsArr = (ids != null) ? ids.split(",") : null;
      return hbmDAO.getListByIds(LightOffice.class, idsArr);
    }
    
    @Override @Transactional
    public List<LightOffice> getListLightFromSearch(String word) {
      return hbmDAO.getListFromSearch(LightOffice.class, word);
    }
}
