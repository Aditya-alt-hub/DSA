/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode>s=new Stack<>();

        for(int i=0;i<nums.length;i++)
        {
            TreeNode current=new TreeNode(nums[i]);
            while(!s.isEmpty()&&s.peek().val<nums[i])
            {
                current.left=s.pop();
            }

            if(!s.isEmpty())
            {
                s.peek().right=current;
            }
            s.push(current);
        }
        return s.firstElement();
}   }