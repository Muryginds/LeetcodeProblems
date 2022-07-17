import java.util.HashSet;

class Solution {
  private char[][] grid;
  private final HashSet<Cell> checked = new HashSet<>();

  public static void main(String[] args) {
//    char[][] grid = {{'1', '1', '0', '0', '0'},
//        {'1', '1', '0', '0', '0'},
//        {'0', '0', '1', '0', '0'},
//        {'0', '0', '0', '1', '1'}};
        char[][] grid = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        };
    Solution solution = new Solution();
    System.out.println(solution.numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    this.grid = grid;
    int counter = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        counter += checkNeighbor(i, j) > 0 ? 1 : 0;
      }
    }
    return counter;
  }

  private int checkNeighbor(int i, int j) {
    if (grid[i][j] == '0') {
      return 0;
    }
    Cell cell = new Cell(i, j);
    if (checked.contains(cell)) {
      return 0;
    }
    checked.add(cell);
    int result = 1;
    if (i - 1 >= 0) {
      result += checkNeighbor(i - 1, j);
    }
    if (i + 1 < grid.length) {
      result += checkNeighbor(i + 1, j);
    }
    if (j - 1 >= 0) {
      result += checkNeighbor(i, j - 1);
    }
    if (j + 1 < grid[i].length) {
      result += checkNeighbor(i, j + 1);
    }
    return result;
  }
}

class Cell {
  private final int i;
  private final int j;
  Cell (int i, int j) {
    this.i = i;
    this.j = j;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Cell cell = (Cell) o;

    if (i != cell.i) {
      return false;
    }
    return j == cell.j;
  }

  @Override
  public int hashCode() {
    int result = i;
    result = 31 * result + j;
    return result;
  }
}