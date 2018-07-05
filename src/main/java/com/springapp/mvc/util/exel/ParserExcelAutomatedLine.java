package com.springapp.mvc.util.exel;

import com.springapp.mvc.dao.HbmDAO;
import com.springapp.mvc.domain.lines.AutomatedLine;
import com.springapp.mvc.domain.lines.Photo;
import com.springapp.mvc.domain.lines.Video;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParserExcelAutomatedLine  {
    
    private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }
   
       public static AutomatedLine readAutomatedLine(File file) throws IOException{
      
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis,file.getPath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        DataFormatter df = new DataFormatter();
 
        AutomatedLine automatedLine = new AutomatedLine();
     
        Row curentRow = rowIterator.next();
        automatedLine.setTypeEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setTypeRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readAutomatedLine.txt", "1 setType = " + automatedLine.getTypeEn());
        System.out.println(automatedLine.getTypeEn());
        System.out.println(automatedLine.getTypeRu());
 
        curentRow = rowIterator.next();
        automatedLine.setModelEn(df.formatCellValue(curentRow.getCell(1)).trim()); 
        automatedLine.setModelRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readAutomatedLine.txt", "2 setSubType = " + automatedLine.getModelEn());
        System.out.println(automatedLine.getModelEn());
        System.out.println(automatedLine.getModelRu());
      
        automatedLine.setUrl(getUrl(automatedLine.getModelEn()));        
        printInFile("readAutomatedLine.txt", "3 setUrl"  );   
        
        curentRow = rowIterator.next();
        automatedLine.setManufacturerEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setManufacturerRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readAutomatedLine.txt", "4 setManufacturer = " + automatedLine.getManufacturerEn());
        System.out.println(automatedLine.getManufacturerEn());
         
        curentRow = rowIterator.next();
        automatedLine.setCountryEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setCountryRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readAutomatedLine.txt", "5 setCountry = " + automatedLine.getCountryEn());        
        System.out.println(automatedLine.getCountryEn());
        
        curentRow = rowIterator.next();
        automatedLine.setCncEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setCncRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readAutomatedLine.txt", "6 setCnc = " + automatedLine.getCncEn());        
        System.out.println(automatedLine.getCncEn());
        
        curentRow = rowIterator.next();
        automatedLine.setCncFullEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setCncFullRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readAutomatedLine.txt", "7 setCncFull = " + automatedLine.getCncFullEn());        
        System.out.println(automatedLine.getCncFullEn());
        
        curentRow = rowIterator.next();
        automatedLine.setMachineConditionEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setMachineConditionRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readMachineCondition.txt", "8 setMachineCondition = " + automatedLine.getMachineConditionEn());        
        System.out.println(automatedLine.getMachineConditionEn());
        
        curentRow = rowIterator.next();
        automatedLine.setMachineLocationEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setMachineLocationRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readAutomatedLine.txt", "9 setCncFull = " + automatedLine.getMachineLocationEn());        
        System.out.println(automatedLine.getMachineLocationEn());
        
        automatedLine.setYearOfManufacture(intFromCell(rowIterator, df)); 
        
        curentRow = rowIterator.next();
        automatedLine.setWorkpieceEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setWorkpieceRu(df.formatCellValue(curentRow.getCell(2)).trim());
        
        automatedLine.setWorkpieceWeight(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        
        String path = getPath(automatedLine);
        String fotoName1 = path + df.formatCellValue(rowIterator.next().getCell(1)).trim();
        String fotoName2 = path + df.formatCellValue(rowIterator.next().getCell(1)).trim();
            
        if(fotoName1!=null && !fotoName1.equals("")){
            Photo workpiecePhoto1 = new Photo(fotoName1);
            workpiecePhoto1.setName(fotoName1);
            automatedLine.addPhoto(workpiecePhoto1);
            workpiecePhoto1.setLine(automatedLine);
        }
        if(fotoName2!=null && !fotoName2.equals("")){
            Photo workpiecePhoto2 = new Photo(fotoName2);
            workpiecePhoto2.setName(fotoName2);
            automatedLine.addPhoto(workpiecePhoto2);
            workpiecePhoto2.setLine(automatedLine);
        }       
        curentRow = rowIterator.next();
        automatedLine.setWorkpieceDescriptionEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setWorkpieceDescriptionRu(df.formatCellValue(curentRow.getCell(2)).trim());        
        
        printInFile("readAutomatedLine.txt", "11 setWorkpiece = " + automatedLine.getWorkpieceEn());        
        System.out.println(automatedLine.getWorkpieceEn()); 
        
        automatedLine.setLength(intFromCell(rowIterator, df)); 
        automatedLine.setWidth(intFromCell(rowIterator, df));
        automatedLine.setWeight(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        automatedLine.setNumOfWorkingStaff(intFromCell(rowIterator, df));
        automatedLine.setProductivity(df.formatCellValue(rowIterator.next().getCell(1)).trim());
               
        fotoName1 = path + df.formatCellValue(rowIterator.next().getCell(1)).trim();
        fotoName2 = path + df.formatCellValue(rowIterator.next().getCell(1)).trim();
        String fotoName3 = path + df.formatCellValue(rowIterator.next().getCell(1)).trim();
       
        if(fotoName1!=null && !fotoName1.equals("")){           
            Photo photo1 = new Photo(fotoName1);
            photo1.setName(fotoName1);
            automatedLine.addPhoto(photo1);
            photo1.setLine(automatedLine);
        }
        if(fotoName2!=null && !fotoName2.equals("")){           
            Photo photo2 = new Photo(fotoName2);
            photo2.setName(fotoName2);
            automatedLine.addPhoto(photo2);
            photo2.setLine(automatedLine);
        }
        if(fotoName3!=null && !fotoName3.equals("")){           
            Photo photo3 = new Photo(fotoName3);
            photo3.setName(fotoName3);
            automatedLine.addPhoto(photo3);
            photo3.setLine(automatedLine);
        }
        
        automatedLine.setPrice(intFromCell(rowIterator, df));
        
        curentRow = rowIterator.next();
        automatedLine.setDescriptionEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setDescriptionRu(df.formatCellValue(curentRow.getCell(2)).trim());
        
        String videoName1 = df.formatCellValue(rowIterator.next().getCell(1)).trim();
        String videoName2 = df.formatCellValue(rowIterator.next().getCell(1)).trim();
        String videoName3 = df.formatCellValue(rowIterator.next().getCell(1)).trim();
       
        if(videoName1!=null && !videoName1.equals("")){
            Video video1 = new Video(videoName1);
            video1.setName(videoName1);                      
            automatedLine.addVideo(video1);
            video1.setLine(automatedLine);
        }
        if(videoName2!=null && !videoName2.equals("")){           
            Video video2 = new Video(videoName2);
            video2.setName(videoName2); 
            automatedLine.addVideo(video2);
            video2.setLine(automatedLine);
        }
        if(videoName3!=null && !videoName3.equals("")){           
            Video video3 = new Video(videoName3);
            video3.setName(videoName3);          
            automatedLine.addVideo(video3);
            video3.setLine(automatedLine);
        }      
       
        fis.close();
        return automatedLine;
    }
    
       private static String getUrl (String str){
        return   str.replaceAll(" ", "-")
                    .replaceAll("'", "-")
                    .replaceAll("\"", "-")
                    .replaceAll(",", "-")
                    .replaceAll(":", "-")
                    .replaceAll(";", "-")
                    .replaceAll("\\.", "-")
                    .replaceAll("&", "-") 
                    .replaceAll("/", "-") 
                    .replaceAll("\\|", "-") // ??
                    .replaceAll("!", "-")
                    .replaceAll("\\?", "-")
                    .replaceAll("\\(", "-")
                    .replaceAll("\\)", "-")
                    .replaceAll("---", "-") 
                    .replaceAll("--", "-")
                    .replaceAll("--", "-") ;
       }
      
       private static String getID (String str){
        return   str.replaceAll(" ", "")
                    .replaceAll("'", "")
                    .replaceAll("\"", "")
                    .replaceAll(",", "")
                    .replaceAll(":", "")
                    .replaceAll(";", "")
                    .replaceAll("\\.", "")
                    .replaceAll("&", "") 
                    .replaceAll("/", "") 
                    .replaceAll("\\|", "") // ??
                    .replaceAll("!", "")
                    .replaceAll("\\?", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .replaceAll("---", "") 
                    .replaceAll("--", "")
                    .replaceAll("--", "") ;
       }
      
    private static int intFromCell (Iterator<Row> rowIterator, DataFormatter df ){
           int tt;
          Row tmp = rowIterator.next();
                  try {
                  tt = (int)tmp.getCell(1).getNumericCellValue();   
                   } catch (Exception e) {
                    tt = Integer.parseInt( df.formatCellValue(tmp.getCell(1)).trim());
                   }        
         return tt;
       }
    
    private static String getPath (AutomatedLine automatedLine){                  
        String absPath = automatedLine.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String[] absPathAfterSplit = absPath.split("target");
        File folder = new File(absPathAfterSplit[0]
                +"src/main/webapp/resources/assets/images/products/automated_lines/" + automatedLine.getUrl());
        if(!folder.exists()){
            folder.mkdirs();
        }       
        return automatedLine.getUrl()+"/";    
       }
       
    static void printInFile(String fileName, String str){    // For Check             
         File file = new File("d:\\2\\"+fileName);         
//            File file = new File("HMC exeption2.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("-------> "+new Date()+"): \n");
            fileWriter.write(str + "\n\n");
        } catch (IOException ex) {
//            Logger.getLogger(ControllerMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } 


}
