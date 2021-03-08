package assignmentoopsdesign;

public class Engineering {

        public boolean Lab;
        public ImplementationLibrary Library1;

        public Engineering()
        {
            this.Lab = true;
            this.Library1 = new ImplementationLibrary();

        }

        public Engineering(boolean LabDetails, String BIsbn, boolean BRent, String BAuth, String FType, String FMater, int SAge, String SFName, String SLName )
        {
            this.Lab = LabDetails;
            this.Library1 = new ImplementationLibrary(BIsbn,  BRent,  BAuth,  FType,  FMater,  SAge,  SFName,  SLName);

        }
}
