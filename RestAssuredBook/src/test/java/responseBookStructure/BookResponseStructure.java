package responseBookStructure;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponseStructure {

    @JsonProperty("Msg")
    @JsonAlias("msg")
    private String msg;
    @JsonProperty("ID")
    private String bookID;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
}
