package HWI_Solid_prep.HWI_24_SampleQues;

import java.util.Scanner;

public class HWI_24_Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] segment = new int[n];
        for(int i=0; i<n; i++){
            segment[i] = sc.nextInt();
        }

        // total reduction over D days are D^2
        // now reductionNeeded <= D^2
        // means D^2 >= reduction req
        // D >= sqrt(reduction req)
        // min days req for reducing this terrain would be the ceil of the sqrt of reduction needed
        // for the curr terrain
        // we want the min days to reduce all the segments of terrain, and we would take that day which is the worst day
        // as “Worst required reduction decides total days” which will be minimum!!
        // aree see lets take ex -> ek test ek bacha 20min m krta hai, ek bacha 30 min m krta hai aur ek 60 min m...
        // too ism min req time kya hoga koi is exam ko pura krn m ie 60 min!! ab samajhe!! :)

        int minDay = 0;
        int prevSeg = segment[0];
        for(int i=1; i<n; i++){
            if(segment[i] >= prevSeg){
                int reducNeeded = segment[i] - (prevSeg-1);

                // smallest D such that D >= ceil of sqrt of reducNeeded
                int d = (int)Math.ceil(Math.sqrt(reducNeeded));
                minDay = Math.max(d, minDay);

                prevSeg = segment[i]-reducNeeded; // or can write:
//              prevSeg = prevSeg - 1; // **
            } else {
                // no reduction
                prevSeg = segment[i];
            }
        }
        System.out.println(minDay);
    }
    /*
    **
    * needed = seg[i] - (prev[i]-1)
    * prev[i] = seg[i] - needed
    *
    * prev[i] = seg[i] - (seg[i] - (prev[i] - 1))
    *         = seg[i] - seg[i] + prev[i] - 1
    *         = prev[i] - 1
    * */
}
