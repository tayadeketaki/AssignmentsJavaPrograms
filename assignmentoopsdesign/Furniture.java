package assignmentoopsdesign;

public class Furniture {


    public String furnitureType;
    public String furnitureMaterial;

    public Furniture()
    {
        this.furnitureType = "Chair";
        this.furnitureMaterial = "Wooden";
        Library.furnitureDetails.add(this);

    }
    public Furniture(String furnitureType, String furnitureMaterial)
    {
        this.furnitureType = furnitureType;
        this.furnitureMaterial = furnitureMaterial;
        Library.furnitureDetails.add(this);

    }


}
