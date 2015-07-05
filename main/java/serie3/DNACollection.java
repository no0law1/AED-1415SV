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

        int size;

        public TNode(Character value){
            this.value = value;
            this.end = false;
            children = new TNode[NUM_CHILDREN];
            size = 0;
        }

        public TNode(){
            this(null);
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
                throw new IllegalArgumentException("Bad DNA Fragment. Collection corrupted");
            }
            int childIndex;
            if((childIndex = childrenIsAlreadyInCollection(aux, code)) != -1) {
                aux = aux.children[childIndex];
            } else {
                aux = addToChildren(aux, code);
            }
        }
        aux.end=true;
    }

    private TNode addToChildren(TNode root, char code) {
        if(root.size == root.children.length){
            throw new IllegalStateException("DNA Node full!");
        }
        root.children[root.size] = new TNode(code);
        return root.children[root.size++];
    }

    private int childrenIsAlreadyInCollection(TNode root, char code) {
        for (int i = 0; i < root.size; i++) {
            if(root.children[i].value == code){
                return i;
            }
        }
        return -1;
    }

    public int prefixCount(String p){
        TNode aux = collection;
        for (int i = 0; i < p.length(); i++) {
            char code = p.charAt(i);
            int childIndex;
            if((childIndex = childrenIsAlreadyInCollection(aux, code)) != -1) {
                aux = aux.children[childIndex];
            } else {
                return -1;
            }
        }

        return fragmentsCount(aux);
    }

    private int fragmentsCount(TNode aux) {
        int i = 0;
        if(aux == null){
            return 0;
        }
        if(aux.end){
            i = 1;
        }
        return i + fragmentsCount(aux.children[0]) + fragmentsCount(aux.children[1])
                + fragmentsCount(aux.children[2]) + fragmentsCount(aux.children[3]);
    }

}
