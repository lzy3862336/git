// solution 1: DFS, for each node, calculate the number of paths start from the node with dfs

class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        helper(root,sum);
        return count;
    }
    public void helper(TreeNode root,int sum){
        if(root==null) return;
        dfs(root,0,sum);
        helper(root.left,sum);
        helper(root.right,sum);
    }
    
    public void dfs(TreeNode node,int cur,int sum){
        if(node==null) return;
        cur += node.val;
        if(cur==sum) count++;
        
        dfs(node.left,cur,sum);
        dfs(node.right,cur,sum);
    }
}

class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        start(root,sum);
        return count;
    }
    
    public void start(TreeNode root,int sum){
        if(root==null) return;
        start(root.left,sum);
        start(root.right,sum);
        
        dfs(root,0,sum);
    } 
    
    public void dfs(TreeNode root,int cur,int sum){
        if(root==null) return;
        
        cur += root.val;
        if(cur==sum) count++;
        
        dfs(root.left,cur,sum);
        dfs(root.right,cur,sum);
    }
}
