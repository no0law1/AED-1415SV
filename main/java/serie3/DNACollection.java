package serie3;

/**
 *
 */
public class DNACollection {

    private static class TNode{
        private static final int NUM_CHILDREN = 4;

        Character value;

        boolean end;

        /**
         * Better implemented with a list
         */
        TNode[] children;

        public TNode(Character value, boolean end){
            this.value = value;
            this.end = end;
            children = new TNode[NUM_CHILDREN];
        }

        public TNode(){
            this(null, false);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private TNode collection;

    public DNACollection(){
        collection = new TNode();
    }

    private boolean isDNAPart(char c) {
        return c == 'A' || c == 'C' || c == 'G' || c == 'T';
    }

    public void add(String fragment){
        TNode aux = collection;
        for (int i = 0; i < fragment.length(); i++) {
            char code = fragment.charAt(i);
            if(!isDNAPart(code)){
                throw new IllegalArgumentException();
                //break; Ficaria mal, uma child sem fim.
            }
            int childIndex;
            if((childIndex = childrenIsAlreadyInCollection(aux.children, code)) != -1) {
                aux = aux.children[childIndex];
            } else {
                aux = addToChildren(aux.children, code, i == fragment.length()-1);
            }
        }

    }

    private TNode addToChildren(TNode[] children, char code, boolean end) {
        for (int i = 0; i < children.length; i++) {
            if(children[i] == null){
                children[i] = new TNode(code, end);
                return children[i];
            }
        }
        throw new IllegalStateException("If reached, code is wrong! ");
    }

    private int childrenIsAlreadyInCollection(TNode[] children, char code) {
        for (int i = 0; i < children.length; i++) {
            if(children[i] == null){
                break;
            }
            if(children[i].value == code){
                return i;
            }
        }
        return -1;
    }

    public int prefixCount(String p){
        TNode aux = collection;
        for (int i = 0; i < p.length(); i++) {
            char code = p.charAt(i);
            if(!isDNAPart(code)){
                throw new IllegalArgumentException();
            }
            int childIndex;
            if((childIndex = childrenIsAlreadyInCollection(aux.children, code)) != -1) {
                aux = aux.children[childIndex];
            } else {
                return -1;
            }
        }

        return prefixCountRecursive(aux);
    }

    private int prefixCountRecursive(TNode aux) {
        int i = 0;
        if(aux == null){
            return 0;
        }
        if(aux.end){
            i = 1;
        }
        return i + prefixCountRecursive(aux.children[0]) + prefixCountRecursive(aux.children[1])
                + prefixCountRecursive(aux.children[2]) + prefixCountRecursive(aux.children[3]);
    }

}
