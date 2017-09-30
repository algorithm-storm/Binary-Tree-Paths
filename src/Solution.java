import java.util.ArrayList;
import java.util.List;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {

    public static void main(String [] args){

        TreeNode root = new TreeNode(1);
        TreeNode leftTree = new TreeNode(2);
        root.left = leftTree;
        TreeNode rightTree4 = new TreeNode(4);
        TreeNode rightTree5 = new TreeNode(5);
        TreeNode rightTree = new TreeNode(3);
        rightTree.left = rightTree4;
        rightTree.right = rightTree5;
        root.right = rightTree;
        Solution a = new Solution();

        List<String> nodes = new ArrayList<>(a.binaryTreePaths(root));

        for (String node : nodes) {
            System.out.println(node);
        }
    }

    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        if(root == null){
            return paths;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        if(root.left == null && root.right == null){
            paths.add(Integer.toString(root.val));
        }

        for(String path : leftPaths){
            paths.add(root.val + "->" + path);
        }
        for(String path : rightPaths){
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}