package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.HbmDAO;

import com.springapp.mvc.domain.lines.AutomatedLine;
import com.springapp.mvc.domain.lines.AutomatedLineWorkpiece;
import com.springapp.mvc.domain.lines.Photo;
import com.springapp.mvc.domain.lines.Video;
import com.springapp.mvc.service.interfaces.AutomatedLineService;

import com.springapp.mvc.util.ImageUtil;
import com.springapp.mvc.util.UploadMultipartFileUtil;
import com.springapp.mvc.util.exel.ParserExcelAutomatedLine;

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
public class AutomatedLineServiceImpl implements AutomatedLineService {
      
    @Autowired  
    private HbmDAO hbmDAO;
    
    @Override @Transactional
    public void uploadAutomatedLine(String path, MultipartFile[] file) {
        for (int i = 0; i < file.length; i++) {
            try {
                File uploadFile = UploadMultipartFileUtil.uploadFile(path, file[i]);              
                AutomatedLine automatedLine = ParserExcelAutomatedLine.readAutomatedLine(uploadFile);
                AutomatedLine automatedLineFromDB = (AutomatedLine)hbmDAO.getByUrl(AutomatedLine.class, automatedLine.getUrl());
                if(automatedLineFromDB != null){
                    automatedLineFromDB = setValuesForUpdate(automatedLineFromDB, automatedLine);
                    hbmDAO.add(automatedLineFromDB);
                } else {
                    hbmDAO.add(automatedLine); 
                }                                                            
                uploadFile.delete();
                System.out.println("Successfully uploaded: " + file[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload file: " + e.getMessage());
            }
        }
    }
    
    private AutomatedLine setValuesForUpdate(AutomatedLine automatedLineFromDB, AutomatedLine automatedLine){
        automatedLineFromDB.setCncEn(automatedLine.getCncEn());
        automatedLineFromDB.setCncFullEn(automatedLine.getCncFullEn());
        automatedLineFromDB.setCncFullRu(automatedLine.getCncFullRu());
        automatedLineFromDB.setCncRu(automatedLine.getCncRu());
        automatedLineFromDB.setCountryEn(automatedLine.getCountryEn());
        automatedLineFromDB.setCountryRu(automatedLine.getCountryRu());
        automatedLineFromDB.setDescriptionEn(automatedLine.getDescriptionEn());
        automatedLineFromDB.setDescriptionRu(automatedLine.getDescriptionRu());
        automatedLineFromDB.setHight(automatedLine.getHight());
        automatedLineFromDB.setLength(automatedLine.getLength());
        automatedLineFromDB.setMachineConditionEn(automatedLine.getMachineConditionEn());
        automatedLineFromDB.setMachineConditionRu(automatedLine.getMachineConditionRu());
        automatedLineFromDB.setMachineLocationEn(automatedLine.getMachineLocationEn());
        automatedLineFromDB.setMachineLocationRu(automatedLine.getMachineLocationRu());
        automatedLineFromDB.setManufacturerEn(automatedLine.getManufacturerEn());
        automatedLineFromDB.setManufacturerRu(automatedLine.getManufacturerRu());
        automatedLineFromDB.setModelEn(automatedLine.getModelEn());
        automatedLineFromDB.setModelRu(automatedLine.getModelRu());
        automatedLineFromDB.setNumOfWorkingStaff(automatedLine.getNumOfWorkingStaff());
        automatedLineFromDB.setPrice(automatedLine.getPrice());
        automatedLineFromDB.setProductivity(automatedLine.getProductivity());
        automatedLineFromDB.setUrl(automatedLine.getUrl());
        automatedLineFromDB.setWeight(automatedLine.getWeight());
        automatedLineFromDB.setWidth(automatedLine.getWidth());
        automatedLineFromDB.setWorkpieceDescriptionEn(automatedLine.getWorkpieceDescriptionEn());
        automatedLineFromDB.setWorkpieceDescriptionRu(automatedLine.getWorkpieceDescriptionRu());
        automatedLineFromDB.setWorkpieceEn(automatedLine.getWorkpieceEn());
        automatedLineFromDB.setWorkpieceRu(automatedLine.getWorkpieceRu());
        automatedLineFromDB.setWorkpieceWeight(automatedLine.getWorkpieceWeight());
        automatedLineFromDB.setYearOfManufacture(automatedLine.getYearOfManufacture());
        Set<Photo> photos = automatedLine.getPhotos();
        for(Photo photo : photos){
            Photo photoFromDB = (Photo)hbmDAO.getByName(Photo.class, photo.getName());
            if(photoFromDB == null){
                automatedLineFromDB.addPhoto(photo);
            }           
        }
        Set<Video> videos = automatedLine.getVideos();
        for(Video video : videos){
            Video videoFromDB = (Video)hbmDAO.getByName(Video.class, video.getName());
            if(videoFromDB == null){
                automatedLineFromDB.addVideo(video);
            }                   
        }
        return automatedLineFromDB;
    }
    
    @Override @Transactional
    public List<AutomatedLine> getListAutomatedLine() {
        return  hbmDAO.getAll(AutomatedLine.class);
    }           
    
    @Override @Transactional
    public List<AutomatedLineWorkpiece> getListAutomatedLineWorkpiece() {
    return  hbmDAO.getAll(AutomatedLineWorkpiece.class);
    }          
    
    @Override @Transactional
    public List<AutomatedLine> getListAutomatedLine(String workpiece) {
        List<Criterion> restrictions = new ArrayList();
        if (workpiece != null && !workpiece.equals("")){
            restrictions.add(Restrictions.eq("workpieceEn", workpiece));                  
        }
        return  hbmDAO.getAll(AutomatedLine.class, restrictions);
    }   
   
    @Override @Transactional
    public String[] listImage(String path) {
        return ImageUtil.getListImage(path);
    }
    
    
    @Override    @Transactional
    public void uploadImagesLine(String path, MultipartFile[] images) {
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
    public AutomatedLine getLineById(long id) {
        return  (AutomatedLine) hbmDAO.getById(AutomatedLine.class, id);
    }
    
    @Override @Transactional
    public AutomatedLine getLineByUrl(String url) {
    return  (AutomatedLine) hbmDAO.getByUrl(AutomatedLine.class, url);
    }
/*    
    @Override @Transactional
    public void renewFiltersLines() {               
        automatedLineDao.renewAutomatedLineWorkpiece();  
    }
*/
    @Override @Transactional
    public List<AutomatedLine> getListLinesByIds(String ids) {
        String[] idsArr = (ids != null) ? ids.split(",") : null;
        return hbmDAO.getListByIds(AutomatedLine.class, idsArr);
    }
   
    @Override @Transactional
    public List<AutomatedLine> getListLineFromSearch(String word) {
      return hbmDAO.getListFromSearch(AutomatedLine.class, word);
    }      
}
