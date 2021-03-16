package ClassesForTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClassTest {
    //public static int bookCounter = 1;
    public static Properties prop = new Properties();
    public static FileOutputStream propertiesFile;

    @BeforeSuite
    public void setPropertiesFile() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        propertiesFile = new FileOutputStream("src/TestData"+java.time.LocalDate.now()+"-"+System.currentTimeMillis()+".properties");

    }
}
