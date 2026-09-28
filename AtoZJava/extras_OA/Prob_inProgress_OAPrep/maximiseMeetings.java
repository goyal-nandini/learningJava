package extras_OA.Prob_inProgress_OAPrep;

/*Maximize Meetings (Greedy variant, harder than standard)

You are given N meetings each with a start time and end time. Select the maximum number of non-overlapping meetings you can attend.

(Exact twist not shared — described as "tougher than normal LC variant")

Standard approach: sort by end time, greedily pick earliest ending meeting.

---
🟢 Direct Match
N Meetings in One Room (GFG)  ✅
Meeting Rooms I ✅
Meeting Rooms II - isk saath saath minimum platform aur ✅ ✅
job sequencing krn ka bhi mnn hai - too vo bhi hai ✅
Non-overlapping Intervals (LC 435) ✅
🟡 Same Pattern
Maximum Profit in Job Scheduling (LC 1235) ✅
Maximum Number of Events
Course Schedule III
Weighted Interval Scheduling
🔴 Advanced Variant
Maximum Number of Events II (LC 1751)
Select K Non-overlapping Intervals
Interval DP
Multi-resource Scheduling
*/

/*The pattern you should remember

Don't memorize:
"Meeting Rooms II = difference array."

Memorize this:
Intervals → convert them into START and END events → sweep from left to right → maintain how many intervals are
currently active → maximum active count is the answer.
This pattern shows up far beyond meeting rooms.

For example:

Employees entering/leaving office
Cars entering/leaving parking
Users online/offline
CPU jobs starting/ending
Maximum simultaneous bookings
Maximum overlapping intervals https://www.geeksforgeeks.org/problems/intersecting-intervals/1

All of these scream:
"Sweep line." 🔥

And your peer was right: difference array is essentially the discrete version of the same start +1 / end -1 event idea.*/

//public class maximiseMeetings {
//}
