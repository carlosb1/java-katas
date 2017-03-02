package katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Dispatcher
{
    private static class Node {
        String value;
        Node parent;
        Node(String value, Node parent) {
            this.value =  value;
            this.parent = parent;
        }
        Node(String value) {
            this.value =  value;
            this.parent = null;
        }
    }

    public static final String SIGN_PARENT = "=>";

    public List<String> order(String input) {
        //TODO to java 8
        if (input.length() == 0) {
            return Arrays.asList();
        }

        String[] lines = input.split("\n");
        List<String> result = new ArrayList<String>();
        List<Node> pendings = new ArrayList<Node>();
        for (String line: lines) {
            StringTokenizer tokenizer = new StringTokenizer(line);

            String value = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens()) {
                continue;
            }

            String equalsToken = tokenizer.nextToken();
            if (!equalsToken.equals(SIGN_PARENT)) {
                continue;
            }
            if (tokenizer.hasMoreTokens()) {
                String parent = tokenizer.nextToken();
                //TODO  add test correct order inher
                if (!result.contains(parent)) {
                    pendings.add(new Node(value, new Node(parent)));
                    continue;
                }
            }
            //TODO move this operation to iterate in other place
            result.add(value);
            for (Node node: pendings) {
                if (value.equals(node.parent.value)) {
                    result.add(node.value);
                }
            }
        }
        return result;
    }

}
