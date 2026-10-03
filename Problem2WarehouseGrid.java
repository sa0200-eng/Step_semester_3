public class Problem2WarehouseGrid {

    public static int[] warehouseSummary(int[][] grid) {

        int totalItems = 0;
        int maxValue = -1;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                totalItems += grid[i][j];

                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new int[]{totalItems, maxRow, maxCol};
    }

    public static void main(String[] args) {

        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        int[] result = warehouseSummary(grid);

        System.out.println("Total Items: " + result[0]);
        System.out.println("Maximum Coordinate: (" 
                + result[1] + ", " + result[2] + ")");
    }
}

/*
Time Complexity: O(m × n)
Additional Space Complexity: O(1)
*/