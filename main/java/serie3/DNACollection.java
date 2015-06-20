package serie3;

/**
 *
 */
public class DNACollection {

    private TNode<Character> collection;

    public DNACollection(){
        collection = new TNode<>();
    }

    /**
     *
     * @param fragment indicated as AACT ...
     */
    public void add(String fragment){
        TNode aux = collection;
        for (int i = 0; i < fragment.length(); i++) {
            char c = fragment.charAt(i);
            if(isDNAPart(c)){
                if(aux.getChild(c) == null) {
                    if(i == fragment.length()-1){
                        aux.add(c, true);
                    } else {
                        aux.add(c, false);
                    }
                }
                aux = aux.getChild(c);
            }
        }
    }

    private boolean isDNAPart(char c) {
        return c == 'A' || c == 'C' || c == 'G' || c == 'T';
    }

    public int prefixCount(String p){
        TNode aux = collection;
        for (int i = 0; i < p.length(); i++) {
            if(aux.getChild(p.charAt(i)) == null){
                break;
            }
            aux = aux.getChild(p.charAt(i));
        }

        //TODO
        return -1;
    }

}
