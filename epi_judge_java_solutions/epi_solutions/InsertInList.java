package epi_solutions;

import epi.ListNode;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

public class InsertInList {

  // Insert newNode after node.
  public static void insertAfter(epi.ListNode<Integer> node,
                                 epi.ListNode<Integer> newNode) {

    newNode.next = node.next;
    node.next = newNode;
  }

  @EpiTest(testDataFile = "insert_in_list.tsv")
  public static epi.ListNode<Integer>
  insertListWrapper(TimedExecutor executor, epi.ListNode<Integer> l, int nodeIdx,
                    int newNodeData) throws Exception {
    epi.ListNode<Integer> node = l;
    while (nodeIdx > 1) {
      node = node.next;
      --nodeIdx;
    }
    epi.ListNode<Integer> newNode = new epi.ListNode<Integer>(newNodeData, null);

    final ListNode<Integer> finalNode = node;
    executor.run(() -> insertAfter(finalNode, newNode));

    return l;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "InsertInList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
