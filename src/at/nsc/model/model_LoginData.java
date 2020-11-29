package at.nsc.model;

/**
 *  Übung 9 - Model
 * @author Niklas Schachl
 * @version 1.0, 29.11.2020
 */
public class model_LoginData
{
    private String username;
    private String password;

    public model_LoginData(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
