package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.lines.AutomatedLine;
import com.springapp.mvc.domain.lines.AutomatedLineWorkpiece;

import java.util.List;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

public interface AutomatedLineService {

    public String[] listImage(String path);
 
    public void uploadImagesLine(String path, MultipartFile[] images);
//    public Wesold getWesold(int id);
    public AutomatedLine getLineById(long id);
    public AutomatedLine getLineByUrl(String url);
    
    public List<AutomatedLine> getListLinesByIds(String ids);
    public List<AutomatedLine> getListLineFromSearch(String word);
//    public List<Wesold> getListWesold();
    public List<AutomatedLine> getListAutomatedLine();
    public List<AutomatedLine> getListAutomatedLine(String workpiece);
    public void uploadAutomatedLine(String path, MultipartFile[] file);
          
    public List<AutomatedLineWorkpiece> getListAutomatedLineWorkpiece();
    
//    public void renewFiltersLines();
}

