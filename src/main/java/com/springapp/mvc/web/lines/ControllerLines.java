package com.springapp.mvc.web.lines;

import com.springapp.mvc.domain.lines.AutomatedLine;
import com.springapp.mvc.service.interfaces.AutomatedLineService;
import com.springapp.mvc.util.pdf.AutomatedLinePdf;
import com.springapp.mvc.domain.message.Message;

import com.springapp.mvc.util.PrintInFile;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerLines extends PrintInFile {

    @Autowired  AutomatedLineService automatedLineService;
 
    
    @RequestMapping(value="/lines", method = RequestMethod.GET)
    public ModelAndView lines_all(  
                                    @RequestParam(value = "workpiece", required = false) String workpiece,                 
                                    HttpSession session ) {
        
        ModelAndView mv = new ModelAndView("lines/lines_all"); 
        if(workpiece==null) {
            mv.addObject("listAutomatedLine", automatedLineService.getListAutomatedLine());
        }else{
            mv.addObject("listAutomatedLine", automatedLineService.getListAutomatedLine(workpiece));
        }               
        mv.addObject("listLineWorkpiece", automatedLineService.getListAutomatedLineWorkpiece());
        
        mv.addObject("workpiece", workpiece); // it is need for feed back !!!!!!
         
        mv.addObject("message", new Message()); // it is need for feed back !!!!!!
        session.setAttribute("search", "lines"); // for search

        String str = "" ;
          
        if (workpiece!=null && !workpiece.equals("")){
            str += "&workpiece="+workpiece;
        }     
        session.setAttribute("currentpagewithpage", "/lines?"+str);
     
        return mv;
    }
        
    @RequestMapping(value = "/line-{url}", method = RequestMethod.GET)
    public ModelAndView lines_one(@PathVariable ("url") String url, HttpSession session) {
    
        ModelAndView mv = new ModelAndView("lines/lines_one");
        AutomatedLine automatedLine = automatedLineService.getLineByUrl(url);
        
        mv.addObject("automatedLine", automatedLine);
        mv.addObject("listPhotos", automatedLine.getPhotos());
        mv.addObject("listVideos", automatedLine.getVideos());
        
        mv.addObject("message", new Message("Automated Line " +automatedLine.getTypeEn() , automatedLine.getModelEn())); // it is need for feed back !!!!!!
        session.setAttribute("search", "line"); // for search
        session.setAttribute("currentpagewithpage", "/line-" + url);
        return mv;
    }
 


    @RequestMapping(value =  "/lines/pdf/{url}", method = RequestMethod.GET)
public ResponseEntity<byte[]> getPdfSingle(HttpServletRequest request, @PathVariable ("url") String url )throws Exception {
//    public ResponseEntity<byte[]> getPdfSingle(@RequestParam("productId") String productId,
//                                               @RequestParam(value = "company", required = false) String company,
//                                               @RequestParam(value = "director", required = false) String director,
//                                               @RequestParam("showPrice") String showPrice,
//                                               HttpServletRequest request) throws Exception {

        String path = request.getServletContext().getRealPath("") + "/resources";
//        return getPDFOfferSingle(path, productId, company, "director", Boolean.getBoolean("true"));
        return getPDFOfferSingle(path, url, "company", "director", Boolean.getBoolean("true"));
      }
    
    
    

    public ResponseEntity<byte[]> getPDFOfferSingle(String path, String url, String company, String director, boolean showPrice) throws Exception {
//        Hmc machine = hmcDAO.getMachine(productId);
        AutomatedLine automatedLine = automatedLineService.getLineByUrl(url);
        String pathPdf = AutomatedLinePdf.createPdfLine(path, automatedLine, company, director, showPrice);

        File file = new File(pathPdf);
        byte[] contents = new byte[(int) file.length()];
        new FileInputStream(file).read(contents);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "AutomatedLine-" + automatedLine.getModelEn() + ".pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
    } 
}
