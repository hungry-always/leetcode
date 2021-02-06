package commmon;

public class ListNodeUtil {
    public static ListNode generate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode(nums[0]);
        ListNode temp = listNode;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            temp.next = next;
            temp = temp.next;
        }
        return listNode;
    }

    public static void sout(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val + "---");
            listNode = listNode.next;
        }
    }
//
//    public static void main(String[] args) {
//        int[] ints = new int[]{1, 2, 3, 4};
//        generate(ints);
//    }
}
