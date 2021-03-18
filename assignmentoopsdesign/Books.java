package assignmentoopsdesign;

import java.util.ArrayList;

public class Books {


    public String isbn;
    public boolean isBookRented;
    public String author;



    public Books()
    {
        this.isbn = "123-345";
        this.isBookRented = true;
        this.author = "John";
        Library.bookDetails.add(this);

    }
    public Books(String bookIsbnNo, boolean bookRentStatus, String bookAuthor)
    {
        this.isbn = bookIsbnNo;
        this.isBookRented = bookRentStatus;
        this.author = bookAuthor;
        Library.bookDetails.add(this);


    }


}

