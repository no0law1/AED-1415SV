package serie3;

/**
 *
 */
public class TNode<E> {

    public static final int NUM_CHILDREN = 4;

    public E value;

    /**
     * Better implemented with a list
     */
    public TNode<E>[] children;

    public TNode(E value){
        this.value = value;
        children = new TNode[NUM_CHILDREN];
    }

    public TNode(){
        this(null);
    }

    @Override
    public String toString() {
        return this.value+"";
    }

    public void add(E value) {
        for (int i = 0; i < children.length; i++) {
            if(children[i] == null){
                children[i] = new TNode<>(value);
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
