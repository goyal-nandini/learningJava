package extras_OA;
import java.util.*;

public class events_minRoomReq {

    static class EventPoint implements Comparable<EventPoint> {
        long time;
        int delta; // +panel[i] at start, -panel[i] at end

        EventPoint(long time, int delta) {
            this.time = time;
            this.delta = delta;
        }

        @Override
        public int compareTo(EventPoint other) {
            if (this.time != other.time) {
                return Long.compare(this.time, other.time);
            }
            // End events (-delta) processed before start events (+delta) at same time
            return Integer.compare(this.delta, other.delta);
        }
    }

    public static int solve(int[] left, int[] right, int[] panel, int base, int G, int T) {
        int n = left.length;
        List<EventPoint> events = new ArrayList<>();

        long totalPeakDemand = 0;
        for (int i = 0; i < n; i++) {
            events.add(new EventPoint(left[i], panel[i]));
            events.add(new EventPoint(right[i], -panel[i]));
            totalPeakDemand += panel[i];
        }

        Collections.sort(events);

        // Binary Search bounds for total rooms K
        long low = base;
        long high = base + totalPeakDemand;
        long ans = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isValid(events, base, mid, G, T)) {
                ans = mid;
                high = mid - 1; // Search for a smaller total room count
            } else {
                low = mid + 1;  // Need more rooms or earlier build start time
            }
        }

        return (int) ans;
    }

    private static boolean isValid(List<EventPoint> events, int base, long totalRooms, int G, int T) {
        long extraRooms = totalRooms - base;

        // Total construction time for extra rooms cannot exceed total available time T
        if (extraRooms * G > T) {
            return false;
        }

        long currentActiveDemand = 0;

        for (EventPoint ep : events) {
            currentActiveDemand += ep.delta;

            // Rule 1: Active demand cannot exceed total capacity mid
            if (currentActiveDemand > totalRooms) {
                return false;
            }

            // Rule 2: Active demand exceeding base capacity requires pre-built extra rooms
            if (currentActiveDemand > base) {
                long extraNeededByNow = currentActiveDemand - base;
                long requiredBuildTime = extraNeededByNow * G;

                // Extra rooms must complete construction on or before current event time
                if (ep.time < requiredBuildTime) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] left = {2, 5, 8};
        int[] right = {6, 10, 12};
        int[] panel = {3, 2, 4};
        int base = 1;
        int G = 2; // 2 units of time to build each new room
        int T = 15;

        System.out.println("Minimum Total Rooms Needed: " + solve(left, right, panel, base, G, T));
    }
}
