package epi_solutions;

import epi_solutions.test_framework.EpiTest;
import epi_solutions.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;

public class SmallestNonconstructibleValue {
  @EpiTest(testDataFile = "smallest_nonconstructible_value.tsv")

  public static int smallestNonconstructibleValue(List<Integer> A) {

    Collections.sort(A);
    int maxConstructibleValue = 0;
    for (int a : A) {
      if (a > maxConstructibleValue + 1) {
        break;
      }
      maxConstructibleValue += a;
    }
    return maxConstructibleValue + 1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SmallestNonconstructibleValue.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
