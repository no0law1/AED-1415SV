package serie3;

/**
 *
 */
public class TreeUtils {

    public static boolean hasPathWithAtLeastSum(Node<Integer> root, int sum) {
        return hasPathWithAtLeastSumRecursive(root, sum, 0);
    }

    private static boolean hasPathWithAtLeastSumRecursive(Node<Integer> root, int sum, int accumulator) {
        if (root == null) {
            return false;
        }
        if (accumulator >= sum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathWithAtLeastSumRecursive(root.left, sum, accumulator + root.value)
                || hasPathWithAtLeastSumRecursive(root.right, sum, accumulator + root.value);
    }

    public static boolean areAllLeavesInSameLevel(Node root) {
        if(root == null){
            return true;
        }
        return areAllLeavesInSameLevelRecursive(root) != -1;
    }

    private static int areAllLeavesInSameLevelRecursive(Node root) {

        if(root.left == null && root.right == null){
            return 0;
        }

        if(root.left == null){
            return 1+areAllLeavesInSameLevelRecursive(root.right);
        } else if(root.right == null){
            return 1+areAllLeavesInSameLevelRecursive(root.left);
        } else {
            int left = areAllLeavesInSameLevelRecursive(root.left);
            return left == areAllLeavesInSameLevelRecursive(root.right) ? left+1 : -1;
        }
    }

    public static Node<Integer> lowestCommonAncestor(Node<Integer> root, Integer n1, Integer n2) {
        if (root.value < n1 && root.value < n2) {
            return lowestCommonAncestor(root.right, n1, n2);
        } else if (root.value > n1 && root.value > n2) {
            return lowestCommonAncestor(root.left, n1, n2);
        } else {
            if (containsValue(root, n1) && containsValue(root, n2)) {
                return root;
            }
            return null;
        }
    }

    private static boolean containsValue(Node<Integer> root, Integer number) {
        if (root == null) {
            return false;
        }

        if (root.value > number) {
            return containsValue(root.left, number);
        } else if (root.value < number) {
            return containsValue(root.right, number);
        } else {
            return true;
        }
    }
}
