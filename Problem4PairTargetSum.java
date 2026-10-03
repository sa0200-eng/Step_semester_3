import java.util.HashSet;

public class Problem4PairTargetSum {

    // Approach 1: Brute Force
    public static boolean bruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // Approach 2: HashSet
    public static boolean hasPairWithSum(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(target - num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 4, 6};

        System.out.println(hasPairWithSum(nums1, 9));
        System.out.println(hasPairWithSum(nums2, 20));
    }
}

/*
Approach 1:
Time Complexity: O(n²)
Space Complexity: O(1)

Approach 2:
Time Complexity: O(n) average
Space Complexity: O(n)
*/