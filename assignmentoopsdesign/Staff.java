package assignmentoopsdesign;

import java.util.ArrayList;
import java.util.List;


public class Staff implements Comparable{

    private int StaffAge;
    private String StaffFName;
    private String StaffLName;
    public static List<Staff> StaffObjects = new ArrayList<>();

    public Staff()
    {
        this.StaffAge = 20;
        this.StaffFName = "AB";
        this.StaffLName = "XY";
        StaffObjects.add(this);

    }
    public Staff(int Age, String FName, String LName)
    {
        this.StaffAge = Age;
        this.StaffFName = FName;
        this.StaffLName = LName;
        StaffObjects.add(this);

    }

    @Override
    public int compareTo(Object o) {

            return  (this.StaffAge() < ((Staff) o).StaffAge() ? -1 : (this.StaffAge() == ((Staff) o).StaffAge() ? 0 : 1));
        }

    private int StaffAge()
    {
        return StaffAge;
    }
    @Override
    public String toString() {
        return StaffFName ;
    }
}
