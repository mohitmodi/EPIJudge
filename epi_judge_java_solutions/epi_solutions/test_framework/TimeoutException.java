
package epi_solutions.test_framework;

import epi_solutions.test_framework.TestTimer;

public class TimeoutException extends Exception {
  private epi_solutions.test_framework.TestTimer timer;

  TimeoutException(long timeoutSeconds) {
    timer = new epi_solutions.test_framework.TestTimer(timeoutSeconds);
  }

  TestTimer getTimer() { return timer; }
}
