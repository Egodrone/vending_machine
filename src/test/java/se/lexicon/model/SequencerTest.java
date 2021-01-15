package se.lexicon.model;



import org.junit.Test;
import static org.junit.Assert.*;



public class SequencerTest {



    @Test
    public void testSequencer() {
        int expected = 30;
        int test = 0;
        int counter = 0;
        while (counter < 30) {
            test = Sequencer.nextProductId();
            ++counter;
        }
        assertEquals(expected, test);
    }



}
