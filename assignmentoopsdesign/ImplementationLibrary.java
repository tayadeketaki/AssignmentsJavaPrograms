package assignmentoopsdesign;

public class ImplementationLibrary extends LibraryAbstract {
    //public Books Book1;
    //public Furniture Furniture1;

    ImplementationLibrary()
    {
        super();
    }
    ImplementationLibrary(String BIsbn, boolean BRent, String BAuth, String FType, String FMater, int SAge, String SFName, String SLName)
    {
        super(BIsbn,  BRent,  BAuth,  FType,  FMater,  SAge,  SFName,  SLName);
    }

  /*  @Override
    public  int GetBookRentDetails() {
        int RentCount = 0;
        for(Books Book : Books.BooksObjects)
        {
            if(Book.IsBookRented)
                RentCount = RentCount+1;
        }

        return RentCount;
    }*/

 /*   @Override
    public int GetChairsCount() {
        int ChairCount = 0;
        for(Furniture Furniture : Furniture.FurnitureObjects)
        {
            if(Furniture.Type.equalsIgnoreCase("Chair"))
                ChairCount = ChairCount + 1;
        }
        return ChairCount;
    }*/

    @Override
    public void GetBookDetails() {

    }

    @Override
    public void GetBooksCount() {
       // System.out.println("The Books Count is : " + Books.BooksObjects.size());
    }
}
