package assignmentoopsdesign;

public class Arts {
    public boolean MusicRoom;
    public ImplementationLibrary Library1;

    public Arts()
    {
        this.MusicRoom = true;
        this.Library1 = new ImplementationLibrary();

    }

    public Arts(boolean MRDetails, String BIsbn, boolean BRent, String BAuth, String FType, String FMater, int SAge, String SFName, String SLName )
    {
        this.MusicRoom = MRDetails;
        this.Library1 = new ImplementationLibrary(BIsbn,  BRent,  BAuth,  FType,  FMater,  SAge,  SFName,  SLName);

    }
}
