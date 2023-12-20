package dataProvider;

import login.payload.LoginPayload;
import org.testng.annotations.DataProvider;

public class LoginProvider
{
    public static int count = 0;
    @DataProvider(name = "LoginProvider")
    public static Object[][] loginProvider()
    {
        count++;
        return new Object[][]
                {
                        {LoginPayload.loginSuccessfulPayload(),"200"},
                        {LoginPayload.loginUnSuccessfulPayload(),"400"},
                };
    }
}
