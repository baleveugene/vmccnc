package com.springapp.mvc.web.lines;

import com.springapp.mvc.domain.lines.AutomatedLine;
import com.springapp.mvc.service.interfaces.AutomatedLineService;
import com.springapp.mvc.util.compare.lines.CompareCartItemAutomatedLine;
import com.springapp.mvc.util.compare.lines.CompareCartAutomatedLine;
import com.springapp.mvc.domain.message.Message;
import com.springapp.mvc.util.PrintInFile;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class ConlrollerCompareLines extends PrintInFile{
  
final private String COMPARE_LINES = "compare-lines";

@Autowired  AutomatedLineService automatedLineService;
  
       
    @RequestMapping(value =  "/"+COMPARE_LINES+"", method = RequestMethod.GET)
    public String compareLines(HttpSession session) {
        String ids = "";
       CompareCartAutomatedLine compareCartAutomatedLine = (CompareCartAutomatedLine) session.getAttribute("compareCartAutomatedLine");
       if (compareCartAutomatedLine==null)  {
           compareCartAutomatedLine = new CompareCartAutomatedLine();
       }  else {
           for(CompareCartItemAutomatedLine cc : compareCartAutomatedLine.getItems()){
             ids +=  cc.getProduct().getId()+",";
           }
       }
       if (ids.equals(""))  
        return "redirect:/"+COMPARE_LINES+"?ids="+null; 
       return "redirect:/"+COMPARE_LINES+"?ids="+ids; 
    }
    
    
    @RequestMapping(value =  "/"+COMPARE_LINES+"", method = RequestMethod.GET, params = "ids")
    public ModelAndView compareLinesWithID( @RequestParam(value = "ids", required = false) String ids,
                                            HttpSession session){
    
    ModelAndView mv = new ModelAndView("lines/lines_compare");
    List<AutomatedLine> listAutomatedLine = null;
    if(ids!=null && !ids.equals("") )  listAutomatedLine = automatedLineService.getListLinesByIds(ids);

    Message mes=new Message(); mes.setMessage(listAutomatedLine.toString());
        
    mv.addObject("message", mes); // it is need for feed back !!!!!!
    mv.addObject("listAutomatedLine", listAutomatedLine);
    session.setAttribute("currentpagewithpage", COMPARE_LINES+"?ids="+ids);
    return mv;
    }
   
   
    
//        @RequestMapping(value =  "/compare/light/add" , method = RequestMethod.GET)
        @RequestMapping(value =  "/compare-lines-add" , method = RequestMethod.GET)
    public String addProductToCompareList( 
            @RequestParam(value = "id") String id, 
            @RequestParam(value = "pagereturn") String pagereturn, 
            HttpSession session ) {
       
    CompareCartAutomatedLine compareCartAutomatedLine = (CompareCartAutomatedLine) session.getAttribute("compareCartAutomatedLine");
    if (compareCartAutomatedLine==null)  compareCartAutomatedLine = new CompareCartAutomatedLine();

 
    compareCartAutomatedLine.addItem(automatedLineService.getLineById(id));
    session.setAttribute("compareCartAutomatedLine", compareCartAutomatedLine);  

           
//    if (pagereturn == null)   pagereturn = "index";
//        
//    return "redirect:/"+pagereturn;  
       String currentpagewithpage =  (String)session.getAttribute("currentpagewithpage");              
           if (currentpagewithpage == null)   currentpagewithpage = "index";
      return "redirect:"+currentpagewithpage;   
    }

    

    
        @RequestMapping(value = "/compare-lines-del-{id}", method = RequestMethod.GET)
    public String delfromcompare(@PathVariable("id") String id, HttpSession session) {
   
    CompareCartAutomatedLine compareCartAutomatedLine = (CompareCartAutomatedLine) session.getAttribute("compareCartAutomatedLine");
    if (compareCartAutomatedLine==null)  compareCartAutomatedLine = new CompareCartAutomatedLine();
    AutomatedLine automatedLine =  new AutomatedLine();
    automatedLine.setId(Long.parseLong("id", 10));

    compareCartAutomatedLine.update(automatedLine, "0"); // delete from compare
    session.setAttribute("compareCartAutomatedLine", compareCartAutomatedLine);

    return "redirect:/"+COMPARE_LINES+""; 
    }
  
    
    


    
}
