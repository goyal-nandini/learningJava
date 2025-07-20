package Arrays;

import java.util.*;

public class Matrix_ArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = 3;
        // 1. this is how u can add a single value to whole matrix
        for(int i=0; i<n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);  // Add 0 to each column
            }
            ans.add(row);  // Add the row to the matrix
        }

//        System.out.println(ans);
        for (ArrayList<Integer> row : ans) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
// ORRR
//        for (int i = 0; i < ans.size(); i++) {
//            for (int j = 0; j < ans.get(i).size(); j++) {
//                System.out.print(ans.get(i).get(j) + " ");
//            }
//            System.out.println(); // Move to the next line after each row
//        }

        System.out.println();
        // 2.
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        for (ArrayList<Integer> row : matrix) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
