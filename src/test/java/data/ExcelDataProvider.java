package data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

    //@Test(dataProvider = "customerlist")
    public void customer(String firstname, String lastname, String passcode)
    {
        System.out.println(firstname+" | "+lastname+" | "+passcode);
    }

    //@DataProvider(name = "customerlist")
    public Object[][] getData(){
        String projectPath = System.getProperty("user.dir");
        String excelPath = projectPath+"/excel/customerlist.xlsx";
        Object data[][] = testData(excelPath, "Sheet1");
        return data;
    }

    public Object[][] testData(String excelPath, String sheetName){

        ReadData excel = new ReadData(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];

        for (int i=1; i<rowCount; i++){
            for (int j=0; j<colCount; j++){

                String cellData = excel.getCellDataString(i, j);
                //System.out.print(cellData+"  |   ");
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;
    }
    
}
