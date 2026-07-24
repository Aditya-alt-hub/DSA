/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if(root==null)
        {
            return new ArrayList<>();
        }
        
        HashMap<TreeNode,TreeNode>parentMap=new HashMap<>();
        helper(root,parentMap);

        return traversefromTarget(target,parentMap,k);

    }

    public void helper(TreeNode root,HashMap<TreeNode,TreeNode>parentMap)
    {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();

            if(curr.left!=null)
            {
                parentMap.put(curr.left,curr);
                q.add(curr.left);
            }

            if(curr.right!=null)
            {
                parentMap.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }

    public List<Integer> traversefromTarget(TreeNode target,HashMap<TreeNode,TreeNode>parentMap,int k)
    {
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>visited=new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance=0;

        while(!q.isEmpty())
        {
            int size=q.size();

            if(distance++==k)
            {
                break;
            }

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();

                if(curr.left!=null&&!visited.contains(curr.left))
                {
                    visited.add(curr.left);
                    q.add(curr.left);
                }

                if(curr.right!=null&&!visited.contains(curr.right))
                {
                    visited.add(curr.right );
                    q.add(curr.right);
                }

                if(parentMap.containsKey(curr)&&!visited.contains(parentMap.get(curr)))
                {
                    visited.add(parentMap.get(curr));
                    q.add(parentMap.get(curr));
                }
            }
        }

        List<Integer>result=new ArrayList<>();
        while(!q.isEmpty())
        {
            result.add(q.poll().val);
        }

        return result;
    }
}