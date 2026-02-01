import java.util.*;
public class Count_distinct_ele_in_every_window {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};

        System.out.println(countDistinct(arr, 4));

    }
    public static ArrayList<Integer> countDistinct(int[] arr, int k) {
        // now lets do from start
        int n=arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = countDistinct(arr, 0, k-1);
        ans.add(cnt);
        for(int i=k; i<n; i++){
            cnt = countDistinct(arr, i-k+1, i);
            ans.add(cnt);
        }
        return ans;
    }
    public static int countDistinct(int[] arr, int l, int r){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=l; i<=r; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            System.out.println(m.getValue());
            System.out.println(m.getKey());
        }
//        System.out.println(map.size());
        return map.size();
    }
    public static ArrayList<Integer> countDistinct_1(int arr[], int k) {
        // code here
        int r=0;
        int l=0;
        int n = arr.length;

        int cnt=0; // ans to return
        int len=0; // to check for k

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while(r<n){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);

            if(map.get(arr[r]) == 1){
                cnt++; // count only distinct elements
            }
            while((r-l+1) > k){
                map.put(arr[l], map.get(l) - 1);
                l++;
            }
            r++;
            ans.add(cnt);
        }
        return ans;
    }

}
