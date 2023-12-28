package dataProvider;

import org.testng.annotations.DataProvider;

public class ListOfIDsProvider
{
    public static int count = 0;
    @DataProvider(name = "listOfIDsProvider")
    public  Object[] listOfIDsProvider(){
        count++;
        Object data[]={1,2,3,4,5,6,7,8,9,10,1000};
        return data;
    }
}
