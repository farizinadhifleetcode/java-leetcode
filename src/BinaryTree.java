import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    TreeNode root;

    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }
    }

    BinaryTree(int value) {
        TreeNode newRoot = new TreeNode(value);
        this.root = newRoot;
    }

    /** mehtods */
    public TreeNode addLeft(TreeNode root, int newLeftVal) {
        TreeNode newLeft = new TreeNode(newLeftVal);
        root.left = newLeft;
        return root.left;
    }

    public TreeNode addRight(TreeNode root, int newRightVal) {
        TreeNode newRight = new TreeNode(newRightVal);
        root.right = newRight;
        return root.right;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    /** Problems */
    public List<List<Integer>> binaryTreeOrderTraversal(TreeNode root) {
        /**
         * BFS
         * 102
         * Given the root of a binary tree, return the level order traversal of its
         * nodes' values. (i.e., from left to right, level by level).
         * 
         * Example 1:
         * 
         * 
         * Input: root = [3,9,20,null,null,15,7]
         * Output: [[3],[9,20],[15,7]]
         * Example 2:
         * 
         * Input: root = [1]
         * Output: [[1]]
         * Example 3:
         * 
         * Input: root = []
         * Output: []
         * 
         * 
         * Constraints:
         * 
         * The number of nodes in the tree is in the range [0, 2000].
         * 
         * 
         */

        Queue<TreeNode> myQueue = new ArrayDeque<>();
        List<List<Integer>> listOfResults = new ArrayList<>();
        myQueue.add(root);

        while (!myQueue.isEmpty()) {
            Integer count = myQueue.size();
            List<Integer> subList = new ArrayList<>();
            for (var i = 0; i < count; i++) {
                TreeNode polledValue = myQueue.poll();
                if (polledValue.left != null) {
                    myQueue.add(polledValue.left);
                }

                if (polledValue.right != null) {
                    myQueue.add(polledValue.right);
                }

                subList.add(polledValue.val);
            }
            listOfResults.add(subList);
        }

        return listOfResults;

    }

    /** run problem */
    public static void runProblem() {

        BinaryTree myTree = new BinaryTree(2);

        TreeNode node11 = myTree.addLeft(myTree.getRoot(), 3);
        TreeNode node12 = myTree.addRight(myTree.getRoot(), 3);

        TreeNode node21 = myTree.addLeft(node11, 3);

        System.out.println(myTree.binaryTreeOrderTraversal(myTree.getRoot()));

    }
}