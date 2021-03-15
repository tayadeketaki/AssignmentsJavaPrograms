package classesRequestResponse;


import requestBookStructure.BookObjectStructure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookByIDTest extends BaseClassTest {

    @Test
    public void getBookByIDTest(){
        int bookIterator =1;
        RestAssured.baseURI = "http://216.10.245.166";
        Response response =
                RestAssured.given().queryParam("ID","{value}",prop.get("bookID"+bookIterator))
                        .header("Content-type","application/json")
                        .when()
                        .get("/Library/GetBook.php")
                        .then()
                        .statusCode(200)
                        .extract().response();

        BookObjectStructure[] bookGet = response.as(BookObjectStructure[].class);
        /*System.out.println("In Get Method : " + bookGet[0].getBookName());
        System.out.println(prop.get("bookName"+bookIterator));*/
        Assert.assertEquals(bookGet[0].getBookName(),prop.get("bookName"+bookIterator));
    }

}
