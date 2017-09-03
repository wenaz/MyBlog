package com.tencent.latke.demo.util;

/**
 * Created by ansonwen on 2017/8/31.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
}
public class RebuildTree {

    public TreeNode reConstructBinaryTree(int[] pre,int[] in,int preStart,int preEnd,
    int inStart,int inEnd){
        if (preStart>preEnd)
            return null;
        TreeNode node=new TreeNode(pre[preStart]);
        int index=inStart;
        while (index<=inEnd&&in[index]!=pre[preStart])
            index++;
        if (index>inEnd)
            throw new RuntimeException("invalid input");
        int len=index-inStart;
        node.left=reConstructBinaryTree(pre,in,preStart+1,preStart+len,inStart,index-1);
        node.right=reConstructBinaryTree(pre,in,preStart+len+1,preEnd,index+1,inEnd);
        return node;
    }

    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }
}
