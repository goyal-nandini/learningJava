package Contest_CC_CF_LC_CSES;

/*✨✨ for input: RRRUU, what is means is the robot himself followed this sequence and started from 0, 0 and reached at
0, 0 by following this given command but in actual Evan has doubt how is it possible that robot return at origin he must
have skipped the some commands and we have to find out those commands which will actually lead back to origin among the
given commands!!

and in general if we saw how's robot doing that!? so it will definitely means that robot is missing some commands so we have to
get the correct count of commands.

REAL PROBLEM (translated brutally)
Some commands may have been ignored.
What is the maximum number of commands that could have been executed such that the robot ends at (0,0)?

✨✨ refined: Robot says: “I followed the whole sequence and reached (0,0)”
Ivan says: “No way. If you actually followed everything, you wouldn’t end at (0,0). You must have skipped some commands.”

🔥 Correct interpretation
We are doing this:
👉 From the given string
👉 choose some commands
👉 such that they bring robot back to (0,0)
👉 AND the number of chosen commands is maximum
*/

import java.util.Scanner;

public class CF_BuggyRobot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] sequence = new char[n];
        for(int i=0; i<n; i++){
            String ss = sc.next();
            sequence[i] = ss.charAt(0); // just keep in mind to take input of char array ^_~, else its slow hnn so,
            // take string naa as asked in problem!!
        }

        int cntL = 0;
        int cntR = 0;
        int cntU = 0;
        int cntD = 0;
        for(int i=0; i<n; i++){
            if(sequence[i] == 'R') cntR++;
            else if(sequence[i] == 'U') cntU++;
            else if(sequence[i] == 'D') cntD++;
            else cntL++;
        }

        int horizValidCommands = Math.min(cntL, cntR); // valid commands that will be turns out to cancel each other move
        int vertValidCommands = Math.min(cntD, cntU); // by this we are getting the largest valid subset of directions,
        // l and r & u and d

        int validCommands = 2*(horizValidCommands+vertValidCommands); // total commands not pairs of commands, so '2*cnt'
        // is must!!
        System.out.println(validCommands);
    }
/*
*  ✨✨ mental model (lock this in)
Whenever you see:
* movements
* return to origin

👉 Translate to:
balance in x-axis + balance in y-axis
*
* ✨✨Pattern Recognition (IMPORTANT)
When you see:

“End at same position”
“Ignore some operations”
“Max valid subset”

✨✨ 👉 Immediately think:

Balance / cancellation / pairing

This pattern appears in:

Parentheses problems
Net movement problems
Frequency balancing
*
*
* ✨✨if one asked: “minimum number of commands to remove so that robot ends at (0,0)”
* 2*(min(L,R) + min(U,D)) = max commands that can form a valid return to origin
Remaining commands = useless ones ❌
So:
total - useful = commands to remove
*
*
* ✨✨💡 Real takeaway

Whenever you see:
Movement + grid
Don’t jump to BFS.

Ask:
Am I exploring possibilities OR just evaluating a given sequence?

👉 Here:
Sequence is fixed
No choices during traversal

So:
No BFS needed*/
}
