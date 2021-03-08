package assignmentoopsdesign;

import java.util.Collections;

class CollegeClass {

    public static void main(String[] args) {

        Engineering EngInstance1 = new Engineering();
        Engineering EngInstance2 = new Engineering(true,"1-2-3",false,"Adam","Table","Plastic",22,"John","SlName1");
        Engineering EngInstance3 = new Engineering(true,"1-2-4",true,"David","Table","Plastic",42,"Adams","SlName2");
        Arts Arts1 = new Arts();
        Arts Arts2 = new Arts(true,"1-2-4",true,"David","Table","Plastic",43,"James","SlName3");

        //Get total number of Books
        System.out.println("Total Numbers fo Books is : " + ImplementationLibrary.TotalBooks());

        //Number of Books are rented
        System.out.println("No. of Books are rented : " + ImplementationLibrary.GetBookRentDetails());

        //Get the number of chairs
        System.out.println("No. of chairs is : " + ImplementationLibrary.GetChairsCount());

        //Get the total number of staff.
        System.out.println("Total Staff : " + ImplementationLibrary.TotalStaff());

        // Eldest member working in library
        ImplementationLibrary.StaffSenior();

    }
}
