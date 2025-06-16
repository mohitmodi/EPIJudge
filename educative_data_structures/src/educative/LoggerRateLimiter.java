package educative;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    int timeLimit;
    Map<String, Integer> requestMap;

    LoggerRateLimiter(int timeLimit) {
        this.timeLimit = timeLimit;
        requestMap = new HashMap<>();
    }

    public boolean messageRequestDecision(int timestamp, String request) {
        if (requestMap.containsKey(request)) {
            int remTime = requestMap.get(request);
            if (timestamp - remTime >= timeLimit) {
                requestMap.put(request, timestamp);

                return true;
            } else {
                return false;
            }
        } else {
            requestMap.put(request, timestamp);
            return true;
        }
    }
}
