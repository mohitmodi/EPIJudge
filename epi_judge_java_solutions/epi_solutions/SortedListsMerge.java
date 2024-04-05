package epi_solutions;

import epi.ListNode;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static epi.ListNode<Integer> mergeTwoSortedLists(epi.ListNode<Integer> L1,
                                                          epi.ListNode<Integer> L2) {

    // Creates a placeholder for the result.
    epi.ListNode<Integer> dummyHead = new epi.ListNode<>(0, null);
    ListNode<Integer> current = dummyHead;

    while (L1 != null && L2 != null) {
      if (L1.data <= L2.data) {
        current.next = L1;
        L1 = L1.next;
      } else {
        current.next = L2;
        L2 = L2.next;
      }
      current = current.next;
    }

    // Appends the remaining nodes of L1 or L2.
    current.next = L1 != null ? L1 : L2;
    return dummyHead.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
