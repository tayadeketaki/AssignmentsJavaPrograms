package assignmentoopsdesign;

public interface Department {

    public Library getLibrary();
    public Library getLibrary(String bookIsbn, boolean bookRentStatus, String bookAuthor, String furnitureType, String furnitureMaterial, int staffAge, String staffFirstName, String staffLastName);

}
