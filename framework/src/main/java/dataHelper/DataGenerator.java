package dataHelper;

import com.github.javafaker.Faker;
import config.FrameworkConfig;
import org.aeonbits.owner.ConfigFactory;
import java.util.*;

public class DataGenerator
{
    public static FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
    private static final Faker fakeData = new Faker();
    private static final Faker fakeDataArabic = new Faker(new Locale("ar"));

    public static String randomName(String locale)
    {
        if (locale.equalsIgnoreCase("en"))
        {
            return fakeData.name().fullName();
        }
        else if (locale.equalsIgnoreCase("ar"))
        {
            return fakeDataArabic.name().firstName() + " " + fakeDataArabic.name().lastName() + " " +
                    fakeDataArabic.name().lastName();
        }
        throw new InputMismatchException("Invalid locale selection. Enter either 'ar' or 'en'");
    }

    public static String randomNumber(int numberOfDigits)
    {
        return fakeData.number().digits(numberOfDigits);
    }



    

}