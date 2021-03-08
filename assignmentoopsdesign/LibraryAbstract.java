package assignmentoopsdesign;

import java.util.Collections;

public abstract class LibraryAbstract {

    private Books BookDetails;
    private Furniture FurnitureDetails;
    private Staff StaffMembers;


    public LibraryAbstract()
    {
        this.BookDetails = new Books();
        this.FurnitureDetails = new Furniture();
        this.StaffMembers = new Staff();
    }
    public LibraryAbstract(String BIsbn, boolean BRent, String BAuth, String FType, String FMater, int SAge, String SFName, String SLName )
    {
        this.BookDetails = new Books(BIsbn,BRent,BAuth);
        this.FurnitureDetails = new Furniture(FType,FMater);
        this.StaffMembers = new Staff(SAge,SFName,SLName);
    }


//    public abstract void SetBookDetails();
    public static int GetBookRentDetails()
    {
        int RentCount = 0;
        for(Books Book : Books.BooksObjects)
        {
            if(Book.IsBookRented)
                RentCount = RentCount+1;
        }

        return RentCount;
        //System.out.println("The Books Count is : " + Books.BooksCount);
    }
    public static int GetChairsCount()
    {
        int ChairCount = 0;
        for(Furniture Furniture : Furniture.FurnitureObjects)
        {
            if(Furniture.Type.equalsIgnoreCase("Chair"))
                ChairCount = ChairCount + 1;
        }
        return ChairCount;

    }
    public static int TotalStaff()
    {
        return Staff.StaffObjects.size();
    }

    public static int TotalBooks()
    {
        return Books.BooksObjects.size();
    }

    public static void StaffSenior()
    {
        Collections.sort(Staff.StaffObjects,Collections.reverseOrder());
        System.out.println("Eldest Staff Member is : " + Staff.StaffObjects.get(0));


    }

//    public abstract void SetFurnitureDetails();
//    public abstract void SetStaffMembers();
    public abstract void GetBookDetails();
    public abstract void GetBooksCount();
}
