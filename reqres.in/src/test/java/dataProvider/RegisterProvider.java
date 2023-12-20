package dataProvider;

import org.testng.annotations.DataProvider;
import registeration.payload.RegisterPayload;

public class RegisterProvider
{
    public static int count = 0;
    @DataProvider(name = "RegisterProvider")
    public static Object[][] registerProvider()
    {
        count++;
        return new Object[][]
                {
                        {RegisterPayload.registerSuccessfulPayload(),"200"},
                        {RegisterPayload.registerUnSuccessfulPayload(),"400"},
                };
    }
}
