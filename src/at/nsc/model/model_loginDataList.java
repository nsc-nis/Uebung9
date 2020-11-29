package at.nsc.model;

import java.util.ArrayList;

/**
 *  Übung 9 - Model
 * @author Niklas Schachl
 * @version 1.0, 29.11.2020
 */
public class model_loginDataList
{
    private static ArrayList<model_LoginData> list_Logins = new ArrayList<model_LoginData>();

    public static void setList_Logins(model_LoginData loginData)
    {
        list_Logins.add(loginData);
    }

    public static model_LoginData getList_Logins (int index)
    {
        return list_Logins.get(index);
    }

    public static int getLength()
    {
        return list_Logins.size();
    }
}
