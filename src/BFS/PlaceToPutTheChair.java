package BFS;

import java.util.*;

public class PlaceToPutTheChair {
    private static final char EQUIPMENT = 'E';
    private static final char OBSTACLE = 'O';

    public static List<Integer> putChair(char[][] gym) {
        int rLen = gym.length;
        int cLen = gym[0].length;
        //in every cell we record the sum of shortest path cost
        // each cell is the lowest cost from this cell to all equipments
        int[][] cost = new int[rLen][cLen];
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                //if the cell is equipment
                //use BFS to find all the cell where we can put chairs
                //and on each Chair cell, we put the cost
                //so then is later we found more equipment cell we can do the same that we
                //find all the cell reachable for this equipment cell and then add cost for
                //all the cell(plus the cost before for another equipment cell)

                //if the cell is equipment
                if (gym[r][c] == 'E') {
                    // System.out.println("Adding cost for equipment: ");
                    if (!addCost(cost, gym, r, c)) { //if there is another equipment cell
                        return null; //then return null
                    }
                }
            }
        }
        List<Integer> result = null;
        //for all the cell in the gym matrix and cost matrix

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                //if cell is not equipment and obstacles, it's chair
                if (gym[i][j] != EQUIPMENT && gym[i][j] != OBSTACLE) {
                    //check
                    if (result == null) { //when result is null, it means that it's starting, there has
                        //not been any element add to result
                        result = Arrays.asList(i, j);//store i j to
                        // System.out.println("result is null: ");
                        //print(result);
                    } else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
                        // System.out.println("result is not null: ");
                        //System.out.println("cost[i][j]: " + cost[i][j] + " i is " + i + " j is " + j);
                        //if the result is not null
                        //then if the current cell cost is smmaller than the cost at
                        //result [0][1]
                        //then we set... why?
                        System.out.println();
                        result.set(0, i);
                        result.set(1, j);

                        // print(result);
                        //System.out.println("done");
                    }
                }
            }
        }
        return result;
    }

    public static boolean addCost(int[][] cost, char[][] gym, int r, int c) {
        //use a boolean matrix to make sure each cell will be visited no more than once
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int pathCost = 1;
        //add this one cell to the queue, and the rest using BFS
        Queue<Pair> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new Pair(r, c));
        while (!queue.isEmpty()) {
            int size = queue.size(); //how many nodes related to this node(cell)
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                //get all the rout accesible for this current cell
                List<Pair> neis = getNeis(cur, gym);
                //for every rout
                System.out.println("Visiting " + gym[cur.i][cur.j] + "{" + cur.i + "," + cur.j + "}");
                for (Pair nei : neis) {
                    if (!visited[nei.i][nei.j]) {
                        visited[nei.i][nei.j] = true;
                        cost[nei.i][nei.j] = cost[nei.i][nei.j] + pathCost;
                        System.out.println(gym[cur.i][cur.j] + " at {" + cur.i + "," + cur.j + "}" + " generates: {" + gym[nei.i][nei.j] + "}" + " at {" + nei.i + "," + nei.j + "}");
                        print(cost);
                        queue.offer(nei);
                    }
                }
                System.out.println("=======================");
            }
            pathCost++;
        }

        return true;
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    /**
     * received 1 cell, and for that cell, we try to find all the neighboring cells
     * from this cell walk to other cells; remember, we can not pass on obstacles.
     * so we are only adding the chair cells,
     */
    public static List<Pair> getNeis(Pair cur, char[][] gym) {
        int row = cur.i; //this is the row location of the cell
        int col = cur.j; //this is the col location of the cell
        //first we get the location of the current cell
        int rowLen = gym.length; // up and down
        int colLen = gym[0].length; // left and right
        List<Pair> neis = new ArrayList<>();
        //as long as the row + 1 in the row length and the cell is not an obstacle
        //look down
        if (row + 1 < rowLen && gym[row + 1][col] != OBSTACLE) {
            neis.add(new Pair(row + 1, col));
        }
        //look right
        if (col + 1 < colLen && gym[row][col + 1] != OBSTACLE) {
            neis.add(new Pair(row, col + 1));
        }
        //look up
        //if we are the cells in the middle(not the first row)
        if (row - 1 >= 0 && gym[row - 1][col] != OBSTACLE) {
            neis.add(new Pair(row - 1, col));
        }
        //look left
        //if the cell is not in the leftmost col
        if (col - 1 >= 0 && gym[row][col - 1] != OBSTACLE) {
            neis.add(new Pair(row, col - 1));
        }
        return neis;
    }

    public static void print(List<Integer> list) {
        System.out.println("Printing List: ");
        if (list == null) {
            System.out.println("List is null");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void print(char[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[][] matrix) {
        System.out.println("Start Printing");
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Done");
    }

    public static void main(String[] args) {
        char[][] gym = new char[][]
                {
                        {'E', 'O', 'C'},
                        {'C', 'E', 'C'},
                        {'C', 'C', 'C'}
                };
        print(gym);
        putChair(gym);
    }

}
