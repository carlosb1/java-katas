package katas;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple Dispatcher.
 */
public class DispatcherTest {


    @Test
    public void givenAnOrderedThenReceiveAnEmptyListThenReturnsEmpty() {
        Dispatcher dispatcher = new Dispatcher();
        assertTrue(dispatcher.order(new String()).size() == 0);
    }

    @Test
    public void givenAnOrderedThenAJobThenReturnsJobOk() {
        //TODO move this object creation
        Dispatcher dispatcher = new Dispatcher();
        //TODO create job
        List<String> result = dispatcher.order("a =>");
        assertTrue(result.size() == 1 && result.get(0).equals("a"));

    }

}
