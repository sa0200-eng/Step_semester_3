public class Problem5MaxContainerArea {

    // Approach 1: Brute Force
    public static int bruteForce(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {

                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // Approach 2: Two Pointers
    public static int maxContainerArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {

            int height = Math.min(heights[left], heights[right]);
            int width = right - left;

            maxArea = Math.max(maxArea, height * width);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxContainerArea(heights));
    }
}

/*
Approach 1:
Time Complexity: O(n²)
Additional Space Complexity: O(1)

Approach 2:
Time Complexity: O(n)
Additional Space Complexity: O(1)
*/