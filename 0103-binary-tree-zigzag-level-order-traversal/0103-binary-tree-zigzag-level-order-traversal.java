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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result=new ArrayList<>();

        if(root==null)
        {
            return result;
        }

        Queue<TreeNode>q=new LinkedList<>();

        q.add(root);

        boolean direction=true;

        while(!q.isEmpty())
        {
            int size=q.size();

            List<Integer>level=new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();

                if(direction)
                {
                    level.add(curr.val);
                }
                else
                {
                    level.add(0,curr.val);
                }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            result.add(level);
            direction=!direction;
        }
        return result;
    }
}