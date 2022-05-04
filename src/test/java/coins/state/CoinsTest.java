package coins.state;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        assertFalse(state1.isGoal());
        assertTrue(state2.isGoal());
    }

    @Test
    void testCanFlip() {
        BitSet bs = new BitSet(6);
        assertFalse(state1.canFlip(bs));
        bs.set(2, 5);
        assertTrue(state1.canFlip(bs));
        assertTrue(state2.canFlip(bs));
        bs = new BitSet(9);
        bs.set(0, 8);
        assertFalse(state1.canFlip(bs));
        assertFalse(state2.canFlip(bs));
    }

    @Test
    void testFlip() {
        BitSet bs = new BitSet(2);
        bs.set(1, 5);
        state1.flip(bs);
        assertEquals(bs, state1.getCoins());
    }

    @Test
    void testGenerateFlips() {
        long subs = CombinatoricsUtils.binomialCoefficient(10, 7);
        List<BitSet> flips = Coins.generateFlips(10, 7);
        assertEquals(subs, flips.size());
        subs = CombinatoricsUtils.binomialCoefficient(6, 2);
        flips = Coins.generateFlips(6, 2);
        assertEquals(subs, flips.size());
    }

    @Test
    void testGetFlips() {
        List<BitSet> flips = Coins.generateFlips(7, 3);
        assertEquals(flips.size(), state2.getFlips().size());
    }

    @Test
    void testHashCode() {
        BitSet bs = new BitSet(7);
        bs.set(0,7);
        assertEquals(new Coins(7,3,bs).hashCode(), state2.hashCode());
        assertEquals(new Coins(7,3).hashCode(), state1.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("O|O|O|O|O|O|O", state1.toString());
    }

    @Test
    void testGenerateFlipsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Coins.generateFlips(3, 0));
        assertThrows(IllegalArgumentException.class, () -> Coins.generateFlips(0, 4));
        assertThrows(IllegalArgumentException.class, () -> Coins.generateFlips(3, 10));
    }



}