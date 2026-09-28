package extras_OA.infosys_OA_Prep;

/*Maximum Train Overlap (Platform Count)

You are given N trains, each with an arrival time and a departure time. A train occupies the station from its arrival until its departure (inclusive).

Find the maximum number of trains present at the station at the same time.

This is equivalent to finding the maximum number of overlapping intervals.

Example:
trains = [(1,4), (2,6), (5,8), (3,5)]
At time 3 → trains 1,2,4 are present → overlap = 3
Answer: 3

Approach: Sort arrivals and departures separately, use two-pointer sweep.

---
Anchor Problem

🥇 GFG — Minimum Platforms

Almost identical.

Tier 1 Practice
⭐ GFG Minimum Platforms
⭐ LC253 Meeting Rooms II
LC2402 Meeting Rooms III (harder)

---
🎯 Pattern

Sweep Line / Interval Overlap

Recognition Checklist ✅
Do I see:

Arrival & Departure ✔️
Time intervals ✔️
Maximum simultaneous ✔️
Overlap ✔️

Immediately think:
Sweep Line
Not DP.
Not Graph.
Not Greedy in the usual sense.

https://chatgpt.com/s/t_6a66fd09689c81918195f0202c9836d3
*/

//public class trainOverlap {
//}
