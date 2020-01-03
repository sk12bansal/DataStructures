import java.util.Arrays;

public class RatInMaze {
    public static void main(String args[]) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 1, 1},
        };
        int row = maze.length;
        int column = maze[0].length;
        int [][]solution = new int[row][column];
        System.out.println("========== Maze Matrix ========");
        printSolution(maze,row,column);
        System.out.println();
        String ans = "";
        mazeHelper(maze,solution,row,column,0,0,ans);
    }

    private static void mazeHelper(int[][] maze, int[][] solution, int row, int column, int x, int y,String ans) {
        if(x ==row-1 && y == column-1){
            solution[x][y] =1;
            System.out.println("========== Solution Matrix ========");
            System.out.println(ans);
            printSolution(solution,row,column);
            return;
        }

        if(isSafe(maze,solution,row,column,x,y)) {
            solution[x][y] = 1;
            mazeHelper(maze, solution, row, column, x - 1, y, ans + "D"); // bottom
            mazeHelper(maze, solution, row, column, x, y + 1, ans + "R"); // right
            mazeHelper(maze, solution, row, column, x + 1, y, ans + "U"); // top
            mazeHelper(maze, solution, row, column, x, y - 1, ans + "L"); // left
            solution[x][y] = 0;
        }
    }

    private static boolean isSafe(int[][] maze, int[][] solution, int row, int column, int x, int y) {
        if(x>=row || x<0 || y>=column || y<0 || solution[x][y]==1 || maze[x][y]==0)
            return false;
        return true;
    }

    private static void printSolution(int[][] solution, int row, int column) {

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
