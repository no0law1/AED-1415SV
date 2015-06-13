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

    @Test
    public void testPrefixCount() throws Exception {
        DNACollection dna = new DNACollection();
        dna.add("ACTG");
        dna.add("ACG");
        dna.add("AGTC");

        assertEquals(3, dna.prefixCount("A"));
        assertEquals(0, dna.prefixCount("G"));
    }
}