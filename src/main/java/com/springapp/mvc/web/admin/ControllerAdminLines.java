package com.springapp.mvc.web.admin;

import com.springapp.mvc.service.interfaces.AutomatedLineService;
import com.springapp.mvc.web.admin.*;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.access.annotation.Secured;

@Controller
@RequestMapping(value = "/admin")
public class ControllerAdminLines {

    final private String LINES_URL = "lines";
    
    @Autowired  AutomatedLineService automatedLineService;
     
//        @RequestMapping(value = "/light_office/renewFiltersLightOffice", method = RequestMethod.GET)
/*            @RequestMapping(value = "/lines/renewFiltersAutomatedLine", method = RequestMethod.GET)
    public String renewFiltersAutomatedLine(){
        automatedLineService.renewFiltersLines();
        return "redirect:/admin/"+LINES_URL;
    }
*/    

//    @Secured(value =  "ROLE_ADMIN_LIGHT") //   ???
    @RequestMapping(value = "/"+LINES_URL, method = RequestMethod.GET)
    public ModelAndView adminWesold() {
    ModelAndView mv = new ModelAndView("admin/line_admin");
        mv.addObject("listAutomatedLine", automatedLineService.getListAutomatedLine());
        return mv;
    }
 

     
    @RequestMapping(value = "/lines/add", method = RequestMethod.POST)
    public String adminWesold_Add_POST(@RequestParam("textFile") MultipartFile[] wesoldinf, HttpServletRequest request){
        if (wesoldinf != null && wesoldinf.length > 0) {
            String path = request.getServletContext().getRealPath("") + "/resources/";
            automatedLineService.uploadAutomatedLine(path, wesoldinf);
        }
        return "redirect:/admin/"+LINES_URL;
    }
    
    
    
    
     ///       --------     Add pictures   ----------
      @RequestMapping(value = "/lines/photos", method = RequestMethod.GET)
    public ModelAndView galleryLines(HttpServletRequest request, Map<String,Object> map){
        ModelAndView mv = new ModelAndView("admin/galleryLines");
        String path = request.getServletContext().getRealPath("") + "/resources/assets/images/products/lines";
        mv.addObject("imageListLines", automatedLineService.listImage(path));
        return mv;
    }
    
    
    @RequestMapping(value = "/lines/photos/upload", method = RequestMethod.POST)
    public String adminUploadImagesAutomatedLine(@RequestParam("imageLathe") MultipartFile[] images, HttpServletRequest request){
        if (images != null && images.length > 0) {
            String path = request.getServletContext().getRealPath("") + "/resources/assets/images/products/lines";
            automatedLineService.uploadImagesLine(path, images);
        }
        return "redirect:/admin/lines/photos";
    }

//        @RequestMapping(value = "/gallerylathes/remove", method = RequestMethod.GET)
//    public String removeImageLathe(@RequestParam("image") String image, HttpServletRequest request) {
//        String path = request.getServletContext().getRealPath("") + "/resources/images/products/lathes";
//        workWithFilesService.removeImage(path,image);
//        return "redirect:/admin/gallerylathes";
//    }
  
}
