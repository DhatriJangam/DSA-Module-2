import java.util.*;

public class Maze {
    private int[][] maze;
    private boolean[][] visited;

    public Maze(int[][] maze) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
    }

    public int[][] getMaze() {
        return maze;
    }

    public boolean solveMazeDFS(int startX, int startY, int endX, int endY) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0], y = current[1];

            if (x == endX && y == endY) {
                return true;
            }

            for (int[] direction : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isSafe(newX, newY)) {
                    stack.push(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return false;
    }

    public boolean solveMazeBFS(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            if (x == endX && y == endY) {
                return true;
            }

            for (int[] direction : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isSafe(newX, newY)) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return false;
    }

    private boolean isSafe(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && !visited[x][y];
    }

    public void resetVisited() {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public static void main(String[] args) {
        int[][] mazeArray = {
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 0},
            {1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0}
        };

        Maze maze = new Maze(mazeArray);
        int startX = 0, startY = 0;
        int endX = 4, endY = 5;

        if (maze.solveMazeDFS(startX, startY, endX, endY)) {
            System.out.println("Path found using DFS");
        } else {
            System.out.println("No path found using DFS");
        }

        maze.resetVisited();

        if (maze.solveMazeBFS(startX, startY, endX, endY)) {
            System.out.println("Path found using BFS");
        } else {
            System.out.println("No path found using BFS");
        }
    }
}
