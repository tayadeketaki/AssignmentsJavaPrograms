package assignmentoopsdesign;


public class Staff implements Comparable{

    private int staffAge;
    private String staffFirstName;
    private String staffLastName;


    public Staff()
    {
        this.staffAge = 20;
        this.staffFirstName = "AB";
        this.staffLastName = "XY";
        Library.staffDetails.add(this);

    }
    public Staff(int staffAge, String staffFirstName, String staffLastName)
    {
        this.staffAge = staffAge;
        this.staffFirstName = staffFirstName;
        this.staffLastName = staffLastName;
        Library.staffDetails.add(this);


    }

    @Override
    public int compareTo(Object o) {

            return  (this.StaffAge() < ((Staff) o).StaffAge() ? -1 : (this.StaffAge() == ((Staff) o).StaffAge() ? 0 : 1));
        }

    private int StaffAge()
    {
        return staffAge;
    }
    @Override
    public String toString() {
        return staffFirstName;
    }
}
