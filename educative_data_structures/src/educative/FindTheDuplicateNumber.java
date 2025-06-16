package educative;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 2;
        while (true) {
            if (nums[slow] == nums[fast])
                return nums[slow];
            else {
                slow++;
                if (slow > nums.length) {
                    slow = slow % nums.length;
                }
                fast += 2;
                if (fast > nums.length) {
                    fast = fast % nums.length;
                }
            }

        }
    }
}
