package assignmentoopsdesign;

import java.util.ArrayList;

public class Furniture {

    public static ArrayList<Furniture> FurnitureObjects = new ArrayList<>();
    public String Type;
    public String Material;

    public Furniture()
    {
        this.Type = "Chair";
        this.Material = "Wooden";
        FurnitureObjects.add(this);

    }
    public Furniture(String FurnitureType, String FurnitureMaterial)
    {
        this.Type = FurnitureType;
        this.Material = FurnitureMaterial;
        FurnitureObjects.add(this);
    }


}
