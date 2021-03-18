package assignmentoopsdesign;

import java.util.Collections;

class College {

    public College(){

        Engineering engineering = new Engineering();
        Engineering engineeringInstance1 = new Engineering(true,"1-2-3",false,"Adam","Table","Plastic",22,"John","SlName1");
        Engineering engineeringInstance2 = new Engineering(true,"1-2-4",true,"David","Table","Plastic",42,"Adams","SlName2");
        Arts arts = new Arts();
        Arts artsInstance1 = new Arts(false,"1-2-5",false,"Adam","Chair","Wooden",25,"John","SlName1");
        Arts artsInstance2 = new Arts(true,"1-2-6",true,"David","Chair","Plastic",44,"David","SlName2");
    }


}
