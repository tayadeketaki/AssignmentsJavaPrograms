package classesRequestResponse;

import org.testng.ITest;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.IAnnotationTransformer;
import requestBookStructure.BookObjectStructure;
import requestBookStructure.DeleteBookStructure;
import responseBookStructure.BookResponseStructure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Random;

public class GetBookByAuthorNameTest extends BaseClassTest {
    public static int bookCounter = 1;
    public static int bookCounterForIDDataCleanUp = 1;
    @Test (invocationCount = 3)
    @Parameters("partialAuthorName")
    public void addMultipleBooks(String partialAuthorName) throws IOException {

        BookObjectStructure addBook = new BookObjectStructure();
        Random random = new Random();
        int partialBookID = random.nextInt(1000);
        addBook.setBookName("Learn Appium Automation with Java 012"+partialAuthorName);
        addBook.setIsbn("Book"+partialBookID);
        addBook.setAisle("22722");
        addBook.setAuthor("abcBookAuthor"+partialAuthorName);
        RestAssured.baseURI = "http://216.10.245.166";
        Response response = RestAssured.given()
                .header("Content-type","application/json")
                .body(addBook)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat().statusCode(200).extract().response();
        //System.out.println(response.asString());
        BookResponseStructure addedBookDetails = response.as(BookResponseStructure.class);
        prop.setProperty("bookID"+bookCounter,addedBookDetails.getBookID());
        prop.setProperty("bookAuthor",addBook.getAuthor());
        bookCounter = bookCounter + 1;
        prop.put("bookID"+bookCounter,addedBookDetails.getBookID());
        prop.put("bookAuthor",addBook.getAuthor());
        prop.store(propertiesFile,"Adding Book ID & Author");
        Assert.assertEquals(addedBookDetails.getMsg(),"successfully added");
    }

    @Test
    public void getByAuthorName(){
        int bookCountForAuthor =1;
        RestAssured.baseURI = "http://216.10.245.166";
       //System.out.println("BookID is : " + prop.get("bookID"));
        Response response =
                RestAssured.given().queryParam("AuthorName","{value}",prop.get("bookAuthor"))
                        .header("Content-type","application/json")
                        .when()
                        .get("/Library/GetBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();
        bookCountForAuthor = bookCountForAuthor+1;
        BookObjectStructure[] bookGet = response.as(BookObjectStructure[].class);
        //System.out.println(bookGet[0].getBookName());
        for(BookObjectStructure book : bookGet)
        {
            System.out.println(book.getBookName());
        }
        Assert.assertEquals(bookGet.length,3);

    }
    @Test(invocationCount = 3)
    public void testDataCleanUp(){
        DeleteBookStructure deleteBook = new DeleteBookStructure();
        deleteBook.setBookID(prop.get("bookID"+bookCounterForIDDataCleanUp).toString());

        Response responseDeleteBookID =
                RestAssured.given()
                        .header("Content-type","application/json")
                        .body(deleteBook)
                        .when()
                        .post("/Library/DeleteBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();
        bookCounterForIDDataCleanUp = bookCounterForIDDataCleanUp+1;
    }


}


