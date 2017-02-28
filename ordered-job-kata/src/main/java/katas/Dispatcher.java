package katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Dispatcher
{

    public static final String SIGN_PARENT = "=>";

    public List<String> order(String input) {
        //TODO to java 8
        if (input.length() == 0) {
            return Arrays.asList();
        }

        String[] lines = input.split("\n");
        List<String> result = new ArrayList<String>();
        for (String line: lines) {
            StringTokenizer tokenizer = new StringTokenizer(line);

            String value = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens()) {
                break;
            }

            String equalsToken = tokenizer.nextToken();
            if (!equalsToken.equals(SIGN_PARENT)) {
                break;
            }

            result.add(value);
        }
        return result;
    }

}
