//package extras_OA.hackvegaR2_OA;
//
//import java.util.*;
//
//public class que1 {
//    static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // Step 1: Read grid
//        int[][] grid = readGrid(sc);
//
//        // Step 2: Read number of operations
//        int n = sc.nextInt();
//        List<Character> moves = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            moves.add(sc.next().charAt(0));
//        }
//
//        // Step 3: Apply moves
//        applyMoves(grid, moves);
//
//        // Step 4: Print final grid
//        printGrid(grid);
//
//        sc.close();
//    }
//    // Read the 4x4 grid
//    private static int[][] readGrid(Scanner sc) {
//        int[][] grid = new int[4][4];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                grid[i][j] = sc.nextInt();
//            }
//        }
//        return grid;
//    }
//    // Apply moves one by one
//    private static void applyMoves(int[][] grid, List<Character> moves) {
//        for (char move : moves) {
//            switch (Character.toUpperCase(move)) {
//                case 'L':
//                    moveLeft(grid);
//                    break;
//                case 'R':
//                    moveRight(grid);
//                    break;
//                case 'U':
//                    moveUp(grid);
//                    break;
//                case 'D':
//                    moveDown(grid);
//                    break;
//            }
//        }
//    }
//    // Print final grid
//    private static void printGrid(int[][] grid) {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(grid[i][j]);
//                if (j < 3) System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }
//}
