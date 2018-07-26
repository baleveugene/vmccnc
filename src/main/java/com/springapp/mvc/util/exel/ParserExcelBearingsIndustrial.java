package com.springapp.mvc.util.exel;

import com.springapp.mvc.domain.bearings.BearingsIndustrial;
import com.springapp.mvc.domain.bearings.BearingsIndustrialPhoto;
import com.springapp.mvc.domain.bearings.BearingsIndustrialVideo;

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

public class ParserExcelBearingsIndustrial  {

    private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

    
       public static BearingsIndustrial readBearingsIndustrial(File file) throws IOException{
      
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis,file.getPath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        DataFormatter df = new DataFormatter();

        BearingsIndustrial bearingsIndustrial = new BearingsIndustrial();
        
        df.formatCellValue(rowIterator.next().getCell(1)).trim();
        printInFile("readBearingsIndustrial.txt", "1");
        rowIterator.next();
        
        Row curentRow = rowIterator.next();                      
        bearingsIndustrial.setTypeEn(df.formatCellValue(curentRow.getCell(1)).trim());
        bearingsIndustrial.setTypeRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readBearingsIndustrial.txt", "2 setType = " + bearingsIndustrial.getTypeEn());
        System.out.println(bearingsIndustrial.getTypeEn());
        System.out.println(bearingsIndustrial.getTypeRu());
        
        curentRow = rowIterator.next();
        bearingsIndustrial.setSubTypeEn(df.formatCellValue(curentRow.getCell(1)).trim()); 
        bearingsIndustrial.setSubTypeRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readBearingsIndustrial.txt", "3 setSubType = " + bearingsIndustrial.getSubTypeEn());
        System.out.println(bearingsIndustrial.getSubTypeEn());
        System.out.println(bearingsIndustrial.getSubTypeRu());
        
        curentRow = rowIterator.next();
        bearingsIndustrial.setModelEn(df.formatCellValue(curentRow.getCell(1)).trim()); 
        bearingsIndustrial.setModelRu(df.formatCellValue(curentRow.getCell(2)).trim());        
        printInFile("readBearingsIndustrial.txt", "4 getModel = " + bearingsIndustrial.getModelEn());             
        System.out.println(bearingsIndustrial.getModelEn());
        
        bearingsIndustrial.setUrl(getUrl(bearingsIndustrial.getModelEn()));
        printInFile("readLightOffice.txt", "5 setUrl"  );
        
        curentRow = rowIterator.next();
        bearingsIndustrial.setManufacturerEn(df.formatCellValue(curentRow.getCell(1)).trim());
        bearingsIndustrial.setManufacturerRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readBearingsIndustrial.txt", "6 setManufacturer = " + bearingsIndustrial.getManufacturerEn());
        System.out.println(bearingsIndustrial.getManufacturerEn());
         
        curentRow = rowIterator.next();
        bearingsIndustrial.setCountryEn(df.formatCellValue(curentRow.getCell(1)).trim());
        bearingsIndustrial.setCountryRu(df.formatCellValue(curentRow.getCell(2)).trim());
        printInFile("readBearingsIndustrial.txt", "7 setCountry = " + bearingsIndustrial.getCountryEn());        
        System.out.println(bearingsIndustrial.getCountryEn());
         
        bearingsIndustrial.setReferenceSpeed(intFromCell(rowIterator, df));
        bearingsIndustrial.setLimitingSpeed(intFromCell(rowIterator, df));
        bearingsIndustrial.setFatiqueLoadLimit(intFromCell(rowIterator, df));
        bearingsIndustrial.setBasicDynamicLoadRating(intFromCell(rowIterator, df)); 
        bearingsIndustrial.setBasicStaticLoadRating(intFromCell(rowIterator, df));        
        
        bearingsIndustrial.setInnerDiameter(intFromCell(rowIterator, df));
        bearingsIndustrial.setOuterDiameter(intFromCell(rowIterator, df));
        bearingsIndustrial.setWidth(intFromCell(rowIterator, df));          
          
        bearingsIndustrial.setWeight(df.formatCellValue(rowIterator.next().getCell(1)).trim()); 
        bearingsIndustrial.setTemperatureWork(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        
        bearingsIndustrial.setGuarantee(df.formatCellValue(rowIterator.next().getCell(1)).trim()); 
        printInFile("readBearingsIndustrial.txt", "16 setGuarantee = " + bearingsIndustrial.getGuarantee());

        rowIterator.next();
        
        String path = getPath(bearingsIndustrial);
        String fotoName1 = path + df.formatCellValue(rowIterator.next().getCell(1)).trim();
        String fotoName2 = path + df.formatCellValue(rowIterator.next().getCell(1)).trim();
            
        if(fotoName1!=null && !fotoName1.equals("")){
            BearingsIndustrialPhoto photo1 = new BearingsIndustrialPhoto(fotoName1);
            photo1.setName(fotoName1);
            bearingsIndustrial.addPhoto(photo1);
            photo1.setBearings(bearingsIndustrial);
        }
        if(fotoName2!=null && !fotoName2.equals("")){
            BearingsIndustrialPhoto photo2 = new BearingsIndustrialPhoto(fotoName2);
            photo2.setName(fotoName2);
            bearingsIndustrial.addPhoto(photo2);
            photo2.setBearings(bearingsIndustrial);
        }      

        curentRow = rowIterator.next();
        bearingsIndustrial.setDescriptionEn(df.formatCellValue(curentRow.getCell(1)).trim());
        bearingsIndustrial.setDescriptionRu(df.formatCellValue(curentRow.getCell(2)).trim());
        
        String videoName1 = df.formatCellValue(rowIterator.next().getCell(1)).trim();
        if(videoName1!=null && !videoName1.equals("")){
            BearingsIndustrialVideo video1 = new BearingsIndustrialVideo(videoName1);
            video1.setName(videoName1);                      
            bearingsIndustrial.addVideo(video1);
            video1.setBearings(bearingsIndustrial);
        }       
        fis.close();
        return bearingsIndustrial;
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
    
    private static String getPath (BearingsIndustrial bearingsIndustrial){                  
        String absPath = bearingsIndustrial.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String[] absPathAfterSplit = absPath.split("target");
        File folder = new File(absPathAfterSplit[0]
                +"src/main/webapp/resources/assets/images/products/bearings/" + bearingsIndustrial.getUrl());
        if(!folder.exists()){
            folder.mkdirs();
        }       
        return bearingsIndustrial.getUrl()+"/";    
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
