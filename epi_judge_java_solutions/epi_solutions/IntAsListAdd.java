package epi_solutions;

import epi.ListNode;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IntAsListAdd {
  @EpiTest(testDataFile = "int_as_list_add.tsv")

  public static epi.ListNode<Integer> addTwoNumbers(epi.ListNode<Integer> L1,
                                                    epi.ListNode<Integer> L2) {

    epi.ListNode<Integer> dummyHead = new epi.ListNode<>(0, null);
    epi.ListNode<Integer> placeIter = dummyHead;
    int carry = 0;
    while (L1 != null || L2 != null || carry != 0) {
      int val = carry + (L1 != null ? L1.data : 0) + (L2 != null ? L2.data : 0);
      L1 = L1 != null ? L1.next : null;
      L2 = L2 != null ? L2.next : null;
      placeIter.next = new ListNode<>(val % 10, null);
      carry = val / 10;
      placeIter = placeIter.next;
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsListAdd.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
