package CONTROLLER;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ct_InfoStudent1 {
    int rows, cols, count = 0;
    public Sheet readDataFromSever(){
        try {
            File file = new File("D:\\Learn\\Code\\Java\\PMTTN\\src\\EXCEL\\Test.xls");
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            rows = sheet.getRows();
            cols = sheet.getColumns();

            System.out.println(sheet.getCell(2, 1).getContents());

            for(int row = 0; row < rows; row++) {
                for(int col = 0; col < cols; col++) {
                    System.out.print(sheet.getCell(col, row).getContents()+" ");
                    count++;
                }
                System.out.println("\n");
            }
            return sheet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
