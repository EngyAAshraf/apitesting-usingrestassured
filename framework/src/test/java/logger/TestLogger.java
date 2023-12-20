package logger;

import io.restassured.config.LogConfig;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.PrintStream;
import java.io.StringWriter;

import static io.restassured.RestAssured.config;


public class TestLogger
{
    public static StringWriter myWriter = new StringWriter();

    static
    {
        @SuppressWarnings("deprecation")
        PrintStream printStream = new PrintStream(new WriterOutputStream(myWriter), true);
        config = config().logConfig(LogConfig.logConfig().
                enableLoggingOfRequestAndResponseIfValidationFails().
                defaultStream(printStream));
    }
}