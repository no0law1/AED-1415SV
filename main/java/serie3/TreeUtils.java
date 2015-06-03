package serie3;

/**
 *
 */
public class TreeUtils {

    public static boolean hasPathWithAtLeastSum(Node<Integer> root, int sum){
        return hasPathWithAtLeastSumRecursive(root, sum, 0);
    }

    private static boolean hasPathWithAtLeastSumRecursive(Node<Integer> root, int sum, int accumulator) {
        if(root == null){
            return false;
        }
        if(accumulator >= sum){
            return true;
        }

        return hasPathWithAtLeastSumRecursive(root.left, sum, accumulator+root.value) || hasPathWithAtLeastSumRecursive(root.right, sum, accumulator+root.value);
    }

    public static boolean areAllLeavesInSameLevel(Node root){
        // First Implementation
        if(false) {
            if (root == null) {
                return true;
            }
            int left = getHeight(root.left);
            int right = getHeight(root.right);

            return left - right == 0
                    && areAllLeavesInSameLevel(root.left)
                    && areAllLeavesInSameLevel(root.right);
        }
        //Second Implementation
        level = 0;
        return areAllLeavesInSameLevelRecursive(root, 0);
    }

    private static int level = 0;

    private static boolean areAllLeavesInSameLevelRecursive(Node root, int accumulator){
        if(root == null){
            return true;
        }

        if (root.left == null ^ root.right == null){
            return false;
        }
        else if(root.right == null && root.left == null){
            if(level == 0){
                level = accumulator;
                return true;
            }
            return level == accumulator;
        }

        return areAllLeavesInSameLevelRecursive(root.left, accumulator+1)
                && areAllLeavesInSameLevelRecursive(root.right, accumulator+1);
    }

    private static <E> int getHeight(Node<E> root){
        if(root==null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static Node<Integer> lowestCommonAncestor(Node<Integer> root, Integer n1, Integer n2){
        return null;
    }
}
