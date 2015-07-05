package serie3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class DNACollectionTest {

    @Test
    public void testAdd() throws Exception {
        DNACollection dna = new DNACollection();
        dna.add("ACTG");
        dna.add("ACG");
    }

    /**
     * Needs better implementation.
     *  run string to see all chars before?
     * @throws Exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddToFix() throws Exception {
        DNACollection dna = new DNACollection();
        dna.add("ACTF");
    }

    @Test
    public void testPrefixCount() throws Exception {
        DNACollection dna = new DNACollection();
        dna.add("ACTG");
        dna.add("ACG");
        dna.add("AGTC");

        assertEquals(3, dna.prefixCount("A"));
        assertEquals(1, dna.prefixCount("ACTG"));
    }

    @Test
    public void testPrefixCountBadFragment() throws Exception {
        DNACollection dna = new DNACollection();
        dna.add("ACTG");
        dna.add("ACG");
        dna.add("AGTC");

        assertEquals(-1, dna.prefixCount("G"));
        assertEquals(-1, dna.prefixCount("LOL"));
    }
}