package classesRequestResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import requestBookStructure.BookObjectStructure;
import requestBookStructure.DeleteBookStructure;
import responseBookStructure.BookResponseStructure;

import java.io.IOException;
import java.util.Random;

public class GetBookAuthorNameDeleteTest extends BaseClassTest{

    public static int bookCounter = 1;
    public static int bookCounterForIDDataCleanUp = 1;
    @Test(invocationCount = 3)
    @Parameters("partialCreateAuthorName")
    public void addMultipleBooks(String partialCreateAuthorName) throws IOException {

        BookObjectStructure addBook = new BookObjectStructure();
        Random random = new Random();
        int partialBookID = random.nextInt(1000);
        addBook.setBookName("Learn Appium Automation with Java 012"+partialCreateAuthorName);
        addBook.setIsbn("Book1"+partialBookID);
        addBook.setAisle("22722");
        addBook.setAuthor("abcBookAuthorName"+partialCreateAuthorName);
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
        prop.put("bookID"+bookCounter,addedBookDetails.getBookID());
        prop.put("bookAuthor",addBook.getAuthor());
        prop.store(propertiesFile,"Adding Book ID & Author");
        bookCounter = bookCounter + 1;
        Assert.assertEquals(addedBookDetails.getMsg(),"successfully added");
    }

    @Test
    @Parameters("deleteBookValidationMessage")
    public void getByAuthorNameDeleteOneCheckStatus(String deleteBookValidationMessage){
        RestAssured.baseURI = "http://216.10.245.166";
        //System.out.println("BookID is : " + prop.get("bookID"));
        Response responseAfterCreationOfBooks =
                RestAssured.given().queryParam("AuthorName","{value}",prop.get("bookAuthor"))
                        .header("Content-type","application/json")
                        .when()
                        .get("/Library/GetBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();
        BookObjectStructure[] bookGet = responseAfterCreationOfBooks.as(BookObjectStructure[].class);
        //System.out.println(bookGet[0].getBookName());
        for(BookObjectStructure book : bookGet)
        {
            System.out.println(book.getBookName());
        }
        Assert.assertEquals(bookGet.length,3);
        //Delete one of the book
        DeleteBookStructure deleteBook = new DeleteBookStructure();
        deleteBook.setBookID(prop.getProperty("bookID3"));
        Response responseDeleteBookID =
                RestAssured.given()
                        .header("Content-type","application/json")
                        .body(deleteBook)
                        .when()
                        .post("/Library/DeleteBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();
        BookResponseStructure deletedBookDetails = responseDeleteBookID.as(BookResponseStructure.class);
        Assert.assertEquals(deletedBookDetails.getMsg(),deleteBookValidationMessage);
        Response responseAfterDeletionOfBook =
                RestAssured.given().queryParam("AuthorName","{value}",prop.get("bookAuthor"))
                        .header("Content-type","application/json")
                        .when()
                        .get("/Library/GetBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();
        BookObjectStructure[] bookGetAfterDeletion = responseAfterDeletionOfBook.as(BookObjectStructure[].class);
        Assert.assertEquals(bookGetAfterDeletion.length,2);

    }
    @Test(invocationCount = 2)
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
