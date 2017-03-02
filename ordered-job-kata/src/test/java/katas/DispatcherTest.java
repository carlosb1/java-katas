package katas;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple Dispatcher.
 */
public class DispatcherTest {


    private Dispatcher dispatcher;

    @Before
    public void setUp() {
        dispatcher = new Dispatcher();
    }

    @Test
    public void givenADispatcherWhereReceiveAnEmptyListThenReturnsEmpty() {
        assertTrue(dispatcher.order(new String()).size() == 0);
    }

    @Test
    public void givenADispatcherWhereAJobThenReturnsJobOk() {
        List<String> result = dispatcher.order("a =>");
        assertTrue(result.size() == 1 && result.get(0).equals("a"));
    }

    @Test
    public void givenADispatcherWhereAddIndependentJobsThenOk() {
        List<String> result = dispatcher.order("a =>\nb =>\nc =>");
        assertTrue(result.size() == 3 && result.contains("a") && result.contains("b") && result.contains("c"));
    }

    @Test
    public void givenAnDispatcherWhereAddIncorrectValueThenIgnoreIt() {
        List<String> result = dispatcher.order("novalue");
        assertTrue(result.size()==0);
    }


    @Test
    public void givenAnDispatcherWhereAddIncorrectValuesThenIgnoreIt() {
        List<String> result = dispatcher.order("novalue novalue");
        assertTrue(result.size()==0);
    }

    @Test
    public void givenAnDispatcherWhereAddIncorrectNewLineThenIgnoreIt() {
        List<String> result = dispatcher.order("\n\n");
        assertTrue(result.size()==0);
    }

    @Test
    public void givenAnDispatcherWhereAddParentThenOk() {
        //TODO to complicate strings
        List<String> result = dispatcher.order("a => b\nb =>");
        assertTrue(result.size()==2 && result.get(0).equals("b") && result.get(1).equals("a"));
    }

    @Test
    public void givenAnDispatcherWhereIncorrectParentThenIgnoreIt() {
        List<String> result = dispatcher.order("a => b\nc =>");
        assertTrue(result.size()==1);
    }

    @Test
    public void givenAnDispatcherWhereAddParentAndThreeNodesThenOk() {
        List<String> result = dispatcher.order("a =>\nb => c\nc =>");
        assertTrue(result.size()==3);
    }
}
