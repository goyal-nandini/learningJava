package HWI_Solid_prep.HWI_24_SampleQues;

import java.util.Scanner;

public class HWI_24_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int heroHealth = sc.nextInt();

        int[] villainHealth = new int[n];
        for(int i=0; i<n; i++){
            villainHealth[i] = sc.nextInt();
        }
        int j=0; // hero
        int i=0; // villain
        int currHealth = heroHealth;
        while(i<n && j<m){
            if(villainHealth[i] < currHealth){
                currHealth -= villainHealth[i];
                i++;
            } else if(villainHealth[i] == currHealth){
                j++; // new hero coming up!
                i++;
                currHealth = heroHealth; // reset
            } else {
                // hero < villain the hero die immediately
                j++; // next hero comes up! with same villain
                currHealth = heroHealth; // reset
            }
        }
        if(i<n) {
            System.out.println(n-i);
        } else{
            System.out.println(0);
        }

    }
}
