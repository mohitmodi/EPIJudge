package educative;

public class FindDuplicateWithNoExtraSpace {
    public static int findDuplicate(int[] nums) {
        int size = nums.length;
        int slow = 0;
        int fast = 1;
        while (nums[slow] != nums[fast]) {

            slow++;
            fast++;

            if (slow > size-1) {
                slow = slow % size;
            }
            if (fast > size-1) {
                fast = fast % size;
            }
            if (nums[slow] == nums[fast]) {
                return nums[slow];
            }
        }

        return nums[slow];
    }

    public static void main(String[] args) {
        int p[] = new int[]{1,3,6,2,7,3,5,4};
        System.out.println(findDuplicate(p));
    }
}
