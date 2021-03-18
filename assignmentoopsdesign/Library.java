package assignmentoopsdesign;

import java.util.ArrayList;
import java.util.Collections;

public interface Library {
    public int bookCount=0;
    public static ArrayList<Books> bookDetails = new ArrayList<>();
    public static ArrayList<Furniture> furnitureDetails = new ArrayList<>();
    public static ArrayList<Staff> staffDetails = new ArrayList<>();
    public void addBook();
    public void addFurniture();
    public void addStaff();
    public void addBook(String bookIsbnNo, boolean bookRentStatus, String bookAuthor);
    public void addFurniture(String furnitureType, String furnitureMaterial);
    public void addStaff(int staffAge, String staffFirstName, String staffLastName);
    public static int numberOfBooksRented()
    {
        int countRent = 0;
        for(Books book : bookDetails)
        {
            if(book.isBookRented)
                countRent = countRent+1;

        }
        return countRent;
    }
    public static int numberOfChairs()
    {
        int countChairNumber = 0;
        for(Furniture furniture : furnitureDetails)
        {
            if(furniture.furnitureType.equalsIgnoreCase("Chair"))
                countChairNumber = countChairNumber+1;

        }
        return countChairNumber;
    }
    public static int numberOfStaffs()
    {
        return Library.staffDetails.size();
    }

    public static String seniorMostStaffMember()
    {
        Collections.sort(staffDetails,Collections.reverseOrder());
        return staffDetails.get(0).toString();

    }



}
