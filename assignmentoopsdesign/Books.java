package assignmentoopsdesign;

import java.util.ArrayList;

public class Books {

    public static ArrayList<Books> BooksObjects = new ArrayList<>();
    public String Isbn;
    public boolean IsBookRented;
    public String Author;
    public static int BooksCount = 0;


    public Books()
    {
        this.Isbn = "123-345";
        this.IsBookRented = true;
        this.Author = "John";
        //BooksCount = BooksCount + 1;
        BooksObjects.add(this);
    }
    public Books(String IsbnNo, boolean BookRent, String BookAuthor)
    {
        this.Isbn = IsbnNo;
        this.IsBookRented = BookRent;
        this.Author = BookAuthor;
        //BooksCount = BooksCount + 1;
        BooksObjects.add(this);

    }


}

