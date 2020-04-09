package impQuestions;

import java.util.LinkedList;
import java.util.List;

public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    static ListNode  mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                res.next = l1;
                l1=l1.next;
                res= res.next;
            }else{
                res.next = l2;
                l2=l2.next;
                res= res.next;
            }
        }
        res.next = l1!=null?l1:l2;
        return res;
    }
    public static ListNode[] getSubList(ListNode[] lists, int start, int end){
        ListNode[] subLists = new ListNode[end];
        for(int i=0;i<end;i++){
            subLists[start++] = lists[i];
        }
        return subLists;
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        if(lists.length==2)
            return mergeTwoLists(lists[0],lists[1]);
        return mergeTwoLists(mergeKLists(getSubList(lists,0,lists.length/2)),mergeKLists(getSubList(lists,lists.length/2,lists.length)));
    }
    public static void main(String []args){
        List []lists =new LinkedList[3];
        List<ListNode>  listNodes =new LinkedList<>();
        listNodes.add(new ListNode(1));
        listNodes.add(new ListNode(4));
        listNodes.add(new ListNode(5));
        lists[0] = listNodes;
        List<ListNode>  listNodes1 =new LinkedList<>();
        listNodes1.add(new ListNode(1));
        listNodes1.add(new ListNode(3));
        listNodes1.add(new ListNode(4));
        lists[1] = listNodes1;
        listNodes.clear();
        List<ListNode>  listNodes2 =new LinkedList<>();
        listNodes2.add(new ListNode(2));
        listNodes2.add(new ListNode(6));
        lists[2] = listNodes2;
       // mergeKLists(lists);
    }
}
