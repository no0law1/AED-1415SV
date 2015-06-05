package serie3;

import org.junit.Test;

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

    }
}