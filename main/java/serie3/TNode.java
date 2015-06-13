package serie3;

/**
 *
 */
public class TNode<E> {

    public static final int NUM_CHILDREN = 4;

    public E value;

    public boolean end;

    /**
     * Better implemented with a list
     */
    public TNode<E>[] children;

    public TNode(E value, boolean end){
        this.value = value;
        this.end = end;
        children = new TNode[NUM_CHILDREN];
    }

    public TNode(){
        this(null, false);
    }

    @Override
    public String toString() {
        return this.value+"";
    }

    public void add(E value, boolean end) {
        for (int i = 0; i < children.length; i++) {
            if(children[i] == null){
                children[i] = new TNode<>(value, end);
                break;
            }
        }
    }

    public TNode getChild(E value) {
        for (int i = 0; i < children.length; i++) {
            if(children[i] != null && children[i].value.equals(value)){
                return children[i];
            }
        }
        return null;
    }
}
