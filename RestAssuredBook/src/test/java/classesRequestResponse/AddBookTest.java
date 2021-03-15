package classesRequestResponse;


import responseBookStructure.BookResponseStructure;
import requestBookStructure.BookObjectStructure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.*;
import java.util.Random;

public class AddBookTest extends BaseClassTest {

    @Test
    public void addBookTest() throws IOException {
        String expectedBookID;
        BookObjectStructure addBook = new BookObjectStructure();
        Random random = new Random();
        int partialBookID = random.nextInt(1000);
        addBook.setBookName("Learn Appium Automation with Java 012");
        addBook.setIsbn("Book0"+partialBookID);
        addBook.setAisle("22722");
        addBook.setAuthor("John");
        RestAssured.baseURI = "http://216.10.245.166";
        Response response = RestAssured.given()
                .header("Content-type","application/json")
                .body(addBook)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat().statusCode(200).extract().response();
        //System.out.println(response.asString());
        expectedBookID = addBook.getIsbn()+addBook.getAisle();
        BookResponseStructure addedBookDetails = response.as(BookResponseStructure.class);
        int bookCounter = 1;
        prop.setProperty("bookID"+bookCounter,addedBookDetails.getBookID());
        prop.setProperty("bookName"+bookCounter,addBook.getBookName());
        prop.setProperty("isbn"+bookCounter,addBook.getIsbn());
        prop.setProperty("aisle"+bookCounter,addBook.getAisle());
        prop.setProperty("author"+bookCounter,addBook.getAuthor());
        prop.put("bookID"+bookCounter,addedBookDetails.getBookID());
        prop.put("bookName"+bookCounter,addBook.getBookName());
        prop.store(propertiesFile,"Adding Book Details");
        //System.out.println("Inside Add book Book ID is: " + addedBookDetails.getBookID());
        Assert.assertEquals(addedBookDetails.getMsg(),"successfully added");
        Assert.assertEquals(addedBookDetails.getBookID(),expectedBookID);

    }

    /* @Test
    public void getBookRequest(){

        RestAssured.baseURI = "http://216.10.245.166";
        System.out.println("BookID is : " + prop.get("bookID"));
        Response response =
                RestAssured.given().queryParam("ID","{value}",prop.get("bookID"))
                        .header("Content-type","application/json")
                        .when()
                        .get("/Library/GetBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();

        bookGetRequest[] bookGet = response.as(bookGetRequest[].class);
        System.out.println("In Get Method : " + bookGet[0].getBookName());
        Assert.assertEquals(bookGet[0].getBookName(),"Learn Appium Automation with Java 012");
    }*/

}
