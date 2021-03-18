package assignmentoopsdesign;

public class Engineering implements Department{

        public boolean lab;
        public Library libraryDept;

        public Engineering()
        {
            this.lab = true;
            this.libraryDept = getLibrary();

        }
        public Engineering(boolean labStatus,String bookIsbn, boolean bookRent, String bookAuthor, String furnitureType, String furnitureMaterial, int staffAge, String staffFirstName, String staffLastName)
        {
                this.lab = labStatus;
                this.libraryDept = getLibrary(bookIsbn,bookRent, bookAuthor, furnitureType, furnitureMaterial, staffAge, staffFirstName, staffLastName);

        }

        @Override
        public Library getLibrary() {
                Library library = new ImplementLibraryInterface();
                library.addBook();
                library.addFurniture();
                library.addStaff();
                return library;
        }

        @Override
        public Library getLibrary(String bookIsbn, boolean bookRent, String bookAuthor, String furnitureType, String furnitureMaterial, int staffAge, String staffFirstName, String staffLastName) {
                Library library = new ImplementLibraryInterface();
                library.addBook(bookIsbn,bookRent,bookAuthor);
                library.addFurniture(furnitureType,furnitureMaterial);
                library.addStaff(staffAge,staffFirstName,staffLastName);
                return library;
        }
}
