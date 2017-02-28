package katas;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple Dispatcher.
 */
public class DispatcherTest {

    private static class Job {
        private final String id;
        private String parent = new String();

        public Job (String id)  {
            this.id = id;
        }
        public Job(String id, String parent) {
            this.id = id;
            this.parent = parent;
        }

        public String toString() {
            return  id+ " => "+parent;
        }

        public static Job makeInstance(String id) {
            return new Job(id);
        }


    }

    private Dispatcher dispatcher;

    @Before
    public void setUp() {
        dispatcher = new Dispatcher();
    }

    @Test
    public void givenAnOrderedThenReceiveAnEmptyListThenReturnsEmpty() {
        assertTrue(dispatcher.order(new String()).size() == 0);
    }

    @Test
    public void givenAnOrderedThenAJobThenReturnsJobOk() {
        List<String> result = dispatcher.order(Job.makeInstance("a").toString());
        assertTrue(result.size() == 1 && result.get(0).equals("a"));
    }


}
