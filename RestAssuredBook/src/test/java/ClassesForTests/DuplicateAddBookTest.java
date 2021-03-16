package ClassesForTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import requestBookStructure.BookObjectStructure;
import responseBookStructure.BookResponseStructure;

public class DuplicateAddBookTest extends BaseClassTest {

    @Test
    @Parameters("duplicateBookValidationMessage")
    public void duplicateBookAddTest(String duplicateBookValidationMessage){
        BookObjectStructure addBook = new BookObjectStructure();
        RestAssured.baseURI = "http://216.10.245.166";
        Response responseGetBookDetails =
                RestAssured.given().queryParam("ID","{value}",prop.getProperty("bookID1"))
                        .header("Content-type","application/json")
                        .when()
                        .get("/Library/GetBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();

        BookObjectStructure[] bookGet = responseGetBookDetails.as(BookObjectStructure[].class);
        addBook.setBookName(bookGet[0].getBookName());
        addBook.setIsbn(bookGet[0].getIsbn());
        addBook.setAisle(bookGet[0].getAisle());
        addBook.setAuthor(bookGet[0].getAuthor());
        Response response = RestAssured.given()
                .header("Content-type","application/json")
                .body(addBook)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat().statusCode(404).extract().response();
        BookResponseStructure bookDuplicateError = response.as(BookResponseStructure.class);
        System.out.println(bookDuplicateError.getMsg());
        Assert.assertEquals(bookDuplicateError.getMsg(),duplicateBookValidationMessage);


    }
}
