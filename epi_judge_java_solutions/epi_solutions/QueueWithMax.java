package epi_solutions;

import epi.StackWithMax;
import epi_solutions.test_framework.EpiTest;
import epi_solutions.test_framework.EpiUserType;
import epi_solutions.test_framework.GenericTest;
import epi_solutions.test_framework.TestFailure;

import java.util.List;
import java.util.NoSuchElementException;

public class QueueWithMax {

  private epi.StackWithMax.Stack enqueue = new epi.StackWithMax.Stack();
  private epi.StackWithMax.Stack dequeue = new StackWithMax.Stack();

  public void enqueue(Integer x) { enqueue.push(x); }

  public Integer dequeue() {

    if (dequeue.empty()) {
      while (!enqueue.empty()) {
        dequeue.push(enqueue.pop());
      }
    }
    return dequeue.pop();
  }

  public Integer max() {

    if (!enqueue.empty()) {
      return dequeue.empty() ? enqueue.max()
                             : Math.max(enqueue.max(), dequeue.max());
    }
    return dequeue.max();
  }

  @EpiUserType(ctorParams = {String.class, int.class})
  public static class QueueOp {
    public String op;
    public int arg;

    public QueueOp(String op, int arg) {
      this.op = op;
      this.arg = arg;
    }
  }

  @EpiTest(testDataFile = "queue_with_max.tsv")
  public static void queueTester(List<QueueOp> ops) throws epi_solutions.test_framework.TestFailure {
    try {
      QueueWithMax q = new QueueWithMax();

      for (QueueOp op : ops) {
        switch (op.op) {
        case "QueueWithMax":
          q = new QueueWithMax();
          break;
        case "enqueue":
          q.enqueue(op.arg);
          break;
        case "dequeue":
          int result = q.dequeue();
          if (result != op.arg) {
            throw new epi_solutions.test_framework.TestFailure("Dequeue: expected " +
                                  String.valueOf(op.arg) + ", got " +
                                  String.valueOf(result));
          }
          break;
        case "max":
          int s = q.max();
          if (s != op.arg) {
            throw new epi_solutions.test_framework.TestFailure("Max: expected " + String.valueOf(op.arg) +
                                  ", got " + String.valueOf(s));
          }
          break;
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "QueueWithMax.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
