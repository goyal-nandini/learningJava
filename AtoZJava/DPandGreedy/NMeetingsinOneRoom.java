package DPandGreedy;

import java.util.Arrays;
import java.util.Comparator;

//We sort meetings by end time using a comparator, then greedily pick meetings whose start time is ≥ last selected meeting’s end.
//Time complexity is O(n log n) due to sorting, space complexity is O(n).

class Tuple{
    int start;
    int end;
    int pos;
    Tuple(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
    @Override
    public String toString(){
        return "(" + start + ", " + end + ", " + pos + ")";
    }
}
public class NMeetingsinOneRoom {
    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};

        System.out.println(maxMeetings(start, end));
    }
// tc: tuple array, sorting, one pass to count meetings => O(2n+nlogn)
// sc: tuple array O(3n), sorting space(java uses time sort worst case O(n)) => O(2n)

    public static int maxMeetings(int[] start, int[] end){
        // have to make a array of Tuple class
        int n = start.length;
        Tuple[] arr = new Tuple[n];
        for(int i=0; i<n; i++){
            Tuple p = new Tuple(start[i], end[i], i);
            arr[i] = p;
        }
        System.out.println(Arrays.toString(arr));

        // have to sort the meeting schedules on bases of end timings
        Arrays.sort(arr, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
//                It sorts meetings in descending order of end time NOT REQUIRED
//                if(o1.end < o2.end) return 1;
//                if(o1.end > o2.end) return -1;

                if(o1.end < o2.end) return -1;
                if(o1.end > o2.end) return 1;
                return 0;
            }
        });

        // or can use this ⭐⭐⭐⭐ MUST USE THIS
        Arrays.sort(arr, (a, b) -> a.end - b.end);
//        second parameter of above is a lambda expression (short form of a Comparator).
/*How Java interprets a.end - b.end

Java sorting rules:

Result	Meaning
< 0	a comes before b
> 0	b comes before a
= 0	order doesn’t matter

So:

If a.end < b.end
→ a.end - b.end is negative
→ a comes first ✅

If a.end > b.end
→ result is positive
→ b comes first

👉 Net effect: ascending order of end time*/

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(arr));

        // next task is to loop through sorted array to get cnt of max no of meeting along with
        // order of the meeting
        int cnt=1; // for counting first meeting in sorted array(as it will me fast ending meeting)
        int freeTime = arr[0].end;
        for(int i=1; i<n; i++){
            if(arr[i].start > freeTime){
                cnt++;
                freeTime = arr[i].end;
            }
        }
        return cnt;
    }
}
