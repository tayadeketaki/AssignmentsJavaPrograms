package assignmentoopsdesign;

public class Queries {
    public static void main(String[] args) {

        College college = new College();

        //Number of books available in the College (Art+ Engineering)
        System.out.println("Books available in College: " + Library.bookDetails.size());

        //How many books are rented
        System.out.println("Number of Books Rented: "+Library.numberOfBooksRented());

        //How many chairs are there
        System.out.println("Number of Chairs : " + Library.numberOfChairs());

        //total count of staff
        System.out.println("Total number of staffs : "+ Library.numberOfStaffs());

        //Eldest Staff member working
        System.out.println("Eldest Staff Member: " + Library.seniorMostStaffMember());
    }

}
