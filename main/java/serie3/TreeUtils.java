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
        if (accumulator >= sum) {
            return true;
        }

        return hasPathWithAtLeastSumRecursive(root.left, sum, accumulator + root.value) || hasPathWithAtLeastSumRecursive(root.right, sum, accumulator + root.value);
    }

    private static int leafLevel = 0;

    public static boolean areAllLeavesInSameLevel(Node root) {
        // First Implementation
        if (false) {
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
        leafLevel = 0;
        return areAllLeavesInSameLevelRecursive(root, 0);
    }

    private static boolean areAllLeavesInSameLevelRecursive(Node root, int accumulator) {
        if (root == null) {
            return true;
        }

        if (root.left == null ^ root.right == null) {
            return false;
        } else if (root.right == null && root.left == null) {
            if (leafLevel == 0) {
                leafLevel = accumulator;
                return true;
            }
            return leafLevel == accumulator;
        }

        return areAllLeavesInSameLevelRecursive(root.left, accumulator + 1)
                && areAllLeavesInSameLevelRecursive(root.right, accumulator + 1);
    }

    private static <E> int getHeight(Node<E> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static Node<Integer> lowestCommonAncestor(Node<Integer> root, Integer n1, Integer n2) {
        int min = Math.min(n1, n2);
        int max = Math.max(n1, n2);

        if (root.value < min && root.value < max) {
            return lowestCommonAncestor(root.right, n1, n2);
        } else if (root.value > min && root.value > max) {
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
