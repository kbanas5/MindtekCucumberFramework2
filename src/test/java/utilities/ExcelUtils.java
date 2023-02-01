package utilities;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    /**
     * .openRxcelFile("TestData","Sheet1"0; -> return void
     * .getValue(0,1); -> returns String
     * .setValue(2,6,"Kim"); -> returns void
     */


   private static Sheet sheet;
    private static Workbook workbook;
    private static FileInputStream input;
    private static FileOutputStream output;
    private static String path;

    public static void openExcelFile(String fileName, String sheetName) {
        path = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName + ".xlsx";

        try {
            input = new FileInputStream(path);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            System.out.println("Excel spreadsheet path is invalid " + path);
        } catch (IOException e) {
            System.out.println("Couldn't open Excel");
        }

    }
    public static String getValue(int rowNum, int cellNUm){
        return sheet.getRow(rowNum).getCell(cellNUm).toString();
    }
    public static void setValue(int rowNum, int cellNUm,String value){

        if(sheet.getPhysicalNumberOfRows()<=rowNum){
            sheet.createRow(rowNum).createCell(cellNUm).setCellValue(value);
        }else if(sheet.getRow(rowNum).getPhysicalNumberOfCells()<=cellNUm){
            sheet.getRow(rowNum).createCell(cellNUm).setCellValue(value);
        }else{
            sheet.getRow(rowNum).getCell(cellNUm).setCellValue(value);
        }
        try {
            output = new FileOutputStream(path);
            workbook.write(output);
        } catch (FileNotFoundException e) {
            System.out.println("Excel spreadsheet path is invalid " + path);
        } catch (IOException e) {
            System.out.println("Couldn't save changes to Excel");
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                System.out.println("Couldn't close fileOutputStream object");
            }
        }

    }

}
