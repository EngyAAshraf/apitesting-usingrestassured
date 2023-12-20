package dataReader;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{
    public static String getProperty(String file, String key) throws IOException
    {
        Properties prop = new Properties();
        prop.load(PropertyReader.class.getClassLoader().getResourceAsStream(file));
        return prop.getProperty(key);
    }
}