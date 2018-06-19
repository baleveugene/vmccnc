package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.HbmDAO;

import com.springapp.mvc.domain.lines.AutomatedLine;
import com.springapp.mvc.domain.lines.AutomatedLineWorkpiece;
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
                hbmDAO.add(automatedLine);
                uploadFile.delete();
                System.out.println("Successfully uploaded: " + file[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload file: " + e.getMessage());
            }
        }
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
    public Set<AutomatedLine> getListAutomatedLine(String workpiece) { 
        
        List<Criterion> restrictions = new ArrayList();
        if (workpiece != null && !workpiece.equals("")){
            restrictions.add(Restrictions.eq("workpieceEn", workpiece));                  
        }
        AutomatedLineWorkpiece lineWorkpiece = (AutomatedLineWorkpiece)hbmDAO.getAll(AutomatedLineWorkpiece.class, restrictions).iterator().next();
        return  lineWorkpiece.getLines();
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
    public AutomatedLine getLineById(String id) {
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
