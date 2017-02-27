package katas;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dispatcher
{

    public List<String> order(String input) {
        //TODO to java 8

        String[] lines = input.split("\n");
        for (String line: lines) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            //TODO check malfformed string
            if (!tokenizer.hasMoreTokens()) {
                return Arrays.asList();
            }
            String firstValue = tokenizer.nextToken();
            return Arrays.asList(firstValue);
        }



        return Arrays.asList();
    }
}
