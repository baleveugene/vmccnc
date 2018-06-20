package com.springapp.mvc.util.exel;

import com.springapp.mvc.domain.lines.AutomatedLine;
import com.springapp.mvc.domain.lines.AutomatedLineWorkpiece;
import com.springapp.mvc.domain.lines.Photo;
import com.springapp.mvc.domain.lines.Video;
import com.springapp.mvc.domain.lines.WorkpiecePhoto;

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
        AutomatedLineWorkpiece workpiece = new AutomatedLineWorkpiece(
                df.formatCellValue(curentRow.getCell(1)).trim(), 
                df.formatCellValue(curentRow.getCell(2)).trim(),
                df.formatCellValue(rowIterator.next().getCell(1)).trim());
        WorkpiecePhoto workpiecePhoto1 = new WorkpiecePhoto(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        WorkpiecePhoto workpiecePhoto2 = new WorkpiecePhoto(df.formatCellValue(rowIterator.next().getCell(1)).trim());        
        if(workpiecePhoto1.getName()!=null && !workpiecePhoto1.getName().equals("")){
            workpiecePhoto1.setWorkpiece(workpiece);          
        }
        if(workpiecePhoto2.getName()!=null && !workpiecePhoto2.getName().equals("")){           
            workpiece.addPhoto(workpiecePhoto2);
        }       
        curentRow = rowIterator.next();
        workpiece.setWorkpieceDescriptionEn(df.formatCellValue(curentRow.getCell(1)).trim());
        workpiece.setWorkpieceDescriptionRu(df.formatCellValue(curentRow.getCell(2)).trim());        
        automatedLine.setWorkpiece(workpiece);
        printInFile("readAutomatedLine.txt", "11 setWorkpiece = " + workpiece.getWorkpieceEn());        
        System.out.println(workpiece.getWorkpieceEn()); 
        
        automatedLine.setLength(intFromCell(rowIterator, df)); 
        automatedLine.setWidth(intFromCell(rowIterator, df));
        automatedLine.setWeight(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        automatedLine.setNumOfWorkingStaff(intFromCell(rowIterator, df));
        automatedLine.setProductivity(df.formatCellValue(rowIterator.next().getCell(1)).trim());
               
        Photo photo1 = new Photo(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        Photo photo2 = new Photo(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        Photo photo3 = new Photo(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        if(photo1.getName()!=null && !photo1.getName().equals("")){           
            automatedLine.addPhoto(photo1);
        }
        if(photo2.getName()!=null && !photo2.getName().equals("")){           
            automatedLine.addPhoto(photo2);
        }
        if(photo3.getName()!=null && !photo3.getName().equals("")){           
            automatedLine.addPhoto(photo3);
        }
        
        automatedLine.setPrice(intFromCell(rowIterator, df));
        
        curentRow = rowIterator.next();
        automatedLine.setDescriptionEn(df.formatCellValue(curentRow.getCell(1)).trim());
        automatedLine.setDescriptionRu(df.formatCellValue(curentRow.getCell(2)).trim());
        
        Video video1 = new Video(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        Video video2 = new Video(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        Video video3 = new Video(df.formatCellValue(rowIterator.next().getCell(1)).trim());
       
        if(video1.getName()!=null && !video1.getName().equals("")){           
            automatedLine.addVideo(video1);
        }
        if(video2.getName()!=null && !video2.getName().equals("")){           
            automatedLine.addVideo(video2);
        }
        if(video3.getName()!=null && !video3.getName().equals("")){          
            automatedLine.addVideo(video3);
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
