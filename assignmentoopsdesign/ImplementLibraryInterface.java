package assignmentoopsdesign;

import java.util.ArrayList;

public class ImplementLibraryInterface implements Library {


    @Override
    public void addBook() { Books book = new Books();}


    @Override
    public void addFurniture() { Furniture furniture = new Furniture();}


    @Override
    public void addStaff() {
        Staff staffs = new Staff();
    }

    @Override
    public void addBook(String bookIsbnNo, boolean bookRentStatus, String bookAuthor) {
        Books book = new Books(bookIsbnNo, bookRentStatus, bookAuthor);
    }

    @Override
    public void addFurniture(String furnitureType, String furnitureMaterial) {
        Furniture furniture = new Furniture(furnitureType,furnitureMaterial);

    }

    @Override
    public void addStaff(int staffAge, String staffFirstName, String staffLastName) {
        Staff staff = new Staff(staffAge,staffFirstName,staffLastName);

    }


}
