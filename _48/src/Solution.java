public class Solution {
  public static void main(String[] args) {
    int[][] m1 = {{1,2,3 }, {4,5,6}, {7,8,9}};
    int[][] m2 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
    int[][] m3 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

    Solution solution = new Solution();
    solution.printMatrix(m1);
    solution.rotate(m1);
    solution.printMatrix(m1);
    solution.printMatrix(m2);
    solution.rotate(m2);
    solution.printMatrix(m2);
    solution.printMatrix(m3);
    solution.rotate(m3);
    solution.printMatrix(m3);
  }

  public void rotate(int[][] matrix) {
    int buf;
    int n = matrix.length;
    for (int counter = 0; counter < n / 2; counter++) {
      for (int i = 0; i < n - counter * 2 - 1; i++) {
        buf = matrix[counter][counter + i];
        matrix[counter][counter + i] = matrix[n - 1 - counter - i][counter];
        matrix[n - 1 - counter - i][counter] = matrix[n - 1 - counter][n - 1 - counter - i];
        matrix[n - 1 - counter][n - 1 - counter - i] = matrix[counter + i][n - 1 - counter];
        matrix[counter + i][n - 1 - counter] = buf;
      }
    }
  }

  public void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf("%3d ", matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println("-".repeat(3 * matrix.length + 1));
  }
}