package coins.state;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    private Coins state1 = new Coins(7, 3); // the original initial state

    private Coins state2; // the goal state
    {
        BitSet bs = new BitSet(7);
        bs.set(0, 7);
        state2 = new Coins(7, 3, bs);
    }



    @Test
    void testIsGoal() {
        assertEquals(true, state2.isGoal());
    }

    @Test
    void testCanFlip() {

    }

    @Test
    void testFlip() {

    }

    @Test
    void testGenerateFlips() {

    }

    @Test
    void testGetFlips() {

    }

    @Test
    void testEquals() {

    }

    @Test
    void testHashCode() {

    }

    @Test
    void testClone() {

    }

    @Test
    void testToString() {
        assertEquals("O|O|O|O|O|O|O", state1.toString());
    }





}