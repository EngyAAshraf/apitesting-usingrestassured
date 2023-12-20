package staticVariables;

import dataHelper.DataGenerator;

public class CommonCreateUserData
{
    public static String UserId;
    public static String userNameAr = DataGenerator.randomName("ar");
    public static String userNameEn = DataGenerator.randomName("en") + DataGenerator.randomNumber(4);
}
