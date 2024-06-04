package constants;

public class Constants               
{
public static final String TESTDATAFILE = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
public static final String  MANAGESLIDERIMAGE = System.getProperty("user.dir")+"\\src\\test\\resources\\image.jpg";

public static final String CONFIGfILE = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";

}


/*
 This class contains a static,final variable 'TESTDATAFILE' which contains the path to the location of th xl sheet.
 create a sheet in excel,enter the data, copy it and paste it under src/test/resources. Right click on the file & properties will give
  path which is saved in the variable(path starting from src is only taken).
 



*/

