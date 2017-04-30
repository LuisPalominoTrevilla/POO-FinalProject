package Users;

public class RegisteredUser extends User{
    
    private String password;
    
    public RegisteredUser(String name, String image, String password, int hs1, int time1, int hs2, int time2, int hs3, int time3, int mxLevel,int hs4, int time4){
        super(name, image, hs1, time1, hs2, time2, hs3, time3, mxLevel, hs4, time4);
        this.password = password;
    }
    
    public boolean comparePasswords(String pswd){
        return this.password.equals(pswd);
    }
}
