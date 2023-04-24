import Util.JSONUtils;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class App {
    private static JSONUtils jsonUtils = new JSONUtils();
    public static void main(String[] args) throws IOException, ParseException {
        jsonUtils.test();
    }
}