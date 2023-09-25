package data;

public class demo {

    public static void doo(){
    
    String projectPath = System.getProperty("user.dir");
    ReadData excel = new ReadData(projectPath+"/excel/customerlist.xlsx", "Sheet1");

    //excel.getRowCount();
   // excel.getCellDataString();
    //excel.getCellDataNumber
    }
}
