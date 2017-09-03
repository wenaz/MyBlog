package com.tencent.latke.demo.util;

import java.util.ArrayList;

/**
 * Created by ansonwen on 2017/8/31.
 */
class ListNode{
    int val;
    ListNode next=null;
    ListNode(int val){
        this.val=val;
    }
}

public class PrintListRevert {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res=new ArrayList<>();
        if (listNode==null)
            return res;
        ListNode node=listNode;
        ListNode after=node.next;
        node.next=null;
        while (after!=null){
            ListNode tmp=after.next;
            after.next=node;

            node=after;
            after=tmp;
        }
        while (node!=null){
            res.add(node.val);
            node=node.next;
        }
        return res;
    }

}
