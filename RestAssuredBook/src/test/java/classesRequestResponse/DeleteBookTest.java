package classesRequestResponse;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import requestBookStructure.DeleteBookStructure;
import requestBookStructure.BookObjectStructure;
import responseBookStructure.BookResponseStructure;

public class DeleteBookTest extends AddBookTest{

    @Test(dependsOnMethods = "addBookTest")
    @Parameters ("deleteBookValidationMessage")
    public void deleteExistingBook(String deleteBookValidationMessage){

        DeleteBookStructure deleteBook = new DeleteBookStructure();
        deleteBook.setBookID(prop.get("bookID1").toString());
        //System.out.println();
        String expectedBookID;
        //RestAssured.baseURI = "http://216.10.245.166";
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
        //Create a book with same book ID and other details.
        BookObjectStructure addBook = new BookObjectStructure();
        addBook.setBookName(prop.get("bookName1").toString());
        addBook.setIsbn(prop.get("isbn1").toString());
        addBook.setAisle(prop.get("aisle1").toString());
        addBook.setAuthor(prop.get("author1").toString());
        expectedBookID = addBook.getIsbn()+addBook.getAisle();
        Response responseCreateNewBook = RestAssured.given()
                .header("Content-type","application/json")
                .body(addBook)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat().statusCode(200).extract().response();
        //System.out.println("After Delete Book ID is: "+prop.get("bookID1").toString());
        BookResponseStructure addedBookDetails = responseCreateNewBook.as(BookResponseStructure.class);
        Assert.assertEquals(addedBookDetails.getMsg(),"successfully added");
        Assert.assertEquals(addedBookDetails.getBookID(),expectedBookID);

    }
}
