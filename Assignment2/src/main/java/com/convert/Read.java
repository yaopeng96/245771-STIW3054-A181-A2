package com.convert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Read{
    private static final String MAIN = "C:\\Users\\Acer\\eclipse-workspace\\Assignment2\\Ranking.xlsx";
    static ArrayList<Title>title= new ArrayList<Title>();
    static ArrayList<Data> data = new ArrayList<Data>();

    public static List<Title>readTitle(){
        try{
            System.out.println("Getting words data...");
            FileInputStream fis = new FileInputStream(MAIN);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
                       
            //read info before the table
            for (int row = 0; row <= 2; row++) {
                Row word = sheet.getRow(row);
                title.add(new Title(word.getCell(0).getStringCellValue()));
            }
         
            wb.close();
            return title;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public static List<Data>readData(){
        try {
            System.out.println("Retrieving Excel Table data...");
            FileInputStream fis = new FileInputStream(MAIN);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            String no ="", name="", fidelID="", fed="", rtg="", clubncity="";
            int countCol = 0;
            int count = 0;
            for(Row row: sheet){
                for (Iterator<Cell> iterator = row.iterator(); iterator.hasNext();) {
					Cell cell = iterator.next();
					if(count>3 && count<155){
                        if(countCol==0) {
                            no = String.valueOf(row.getCell(0));
                        }
                        else if(countCol==1){
                            name = String.valueOf(row.getCell(1));
                        }
                        else if(countCol==2){
                            fidelID = String.valueOf(row.getCell(2));
                        }
                        else if(countCol==3){
                            fed = String.valueOf(row.getCell(3));
                        }
                        else if(countCol==4){
                            rtg = String.valueOf(row.getCell(4));
                        }
                        else if(countCol==5){
                            clubncity = String.valueOf(row.getCell(5));
                            data.add(new Data(no,name,fidelID,fed,rtg,clubncity));
                        }
                    }
                    countCol++;
				}
                // Adding count to proceed next row, reset countCol to start from new row 1st column
                count++;
                countCol = 0;
            }
            wb.close();
            return data;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}

