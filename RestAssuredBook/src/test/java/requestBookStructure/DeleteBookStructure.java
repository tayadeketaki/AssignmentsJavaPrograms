package requestBookStructure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBookStructure {

    @JsonProperty("ID")
    private String bookID;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }





}
