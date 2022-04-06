package utilities.readers;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;




public class ExcelReader {
    static String filePath ="0";
    static XSSFWorkbook wb;
    public static void setPath(String filePath) throws IOException {
        File InputsFile = new File(filePath);
        FileInputStream fip = new FileInputStream(InputsFile);
        wb= new XSSFWorkbook(fip);

    }
    public static String read(int RowNumber, int ColumnNumber)throws IOException{
        String CellData= "2";
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(RowNumber);
        Cell cell= row.getCell(ColumnNumber);
        if (CellData !=null && cell !=null)
            CellData= cell.getStringCellValue().toString();
        return CellData;
    }
    public static void main (String[] args )throws IOException
    {
        String filePath = System.getProperty("user.dir")+ "/src/test/resources/"+"data.xlsx";
        setPath(filePath);
        ExcelReader ExcelObj = new ExcelReader();
        String CellDataValue = "1";
        for (int i = 1; i <2; i++) {
            for (int j = 0; j < 2; j++) {
                CellDataValue = ExcelObj.read(i,j);
                System.out.println(CellDataValue);


            }

        }
    }
}
