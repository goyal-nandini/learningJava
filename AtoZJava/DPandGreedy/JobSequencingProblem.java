package DPandGreedy;
import java.util.*;
class Tuple1{
    int id;
    int deadline;
    int profit;
    Tuple1(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + deadline + ", " + profit + ")";
    }
}
public class JobSequencingProblem {
    public static void main(String[] args) {
        int[] deadline = {4, 5, 6, 6, 4, 2, 2, 2};
        int[] profit = {20, 60, 70, 65, 25, 80, 10, 22};

//        jobSequencing(deadline, profit);
        System.out.println(jobSequencing(deadline, profit));
    }
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
       // making a tuple array
        int n=deadline.length;
        Tuple1[] arr = new Tuple1[n];

        for(int i=0; i<n; i++){
            Tuple1 t = new Tuple1(i+1, deadline[i], profit[i]);
            arr[i] = t;
        }

        // sorting acc to profit
        Arrays.sort(arr, new Comparator<Tuple1>() {
            @Override
            public int compare(Tuple1 o1, Tuple1 o2) {
                return o2.profit - o1.profit; // descending order
            }
        });

//        System.out.println(Arrays.toString(arr)); // great

        // time for applying logic to arr
        int maxProfit=0;
        int cntJobs=0;
        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, arr[i].deadline);

        // array for max deadline
        int[] deadlineArr = new int[max+1];
        Arrays.fill(deadlineArr, -1);

        // got to each tuple
        for(int i=0; i<n; i++){
            // find the last day of completing that job
            for(int j=arr[i].deadline; j>0; j--){ // no work on day 0, so not >=0 NOPE
                if(deadlineArr[j] == -1){
                    deadlineArr[j] = arr[i].id;
                    cntJobs++;
                    maxProfit+=arr[i].profit;
                    break;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(cntJobs);
        ans.add(maxProfit);
        return ans;
    }
}
