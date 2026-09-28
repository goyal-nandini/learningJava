import java.util.*;
public class OrderIt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        scanner.nextLine(); // skip "shuffled"

        String[] shuffledList = new String[n];
        for (int i = 0; i < n; i++) {
            shuffledList[i] = scanner.nextLine().trim();
        }

        scanner.nextLine(); // skip "original"

        String[] originalList = new String[n];
        for (int i = 0; i < n; i++) {
            originalList[i] = scanner.nextLine().trim();
        }

        int minOps = calculateMinimumOperations(shuffledList, originalList);
        System.out.println(minOps);
    }

    // Main logic: counts minimum cut-and-insert operations
    private static int calculateMinimumOperations(String[] shuffled, String[] original) {
        int n = shuffled.length;

        // Map every instruction in original list to its correct position
        Map<String, Integer> originalPosition = new HashMap<>();
        for (int i = 0; i < n; i++) {
            originalPosition.put(original[i], i);
        }

        // Convert shuffled instructions to their position indices
        int[] shuffledIndices = new int[n];
        for (int i = 0; i < n; i++) {
            shuffledIndices[i] = originalPosition.get(shuffled[i]);
        }

        // Count the number of contiguous ordered segments
        int orderedBlocks = countOrderedBlocks(shuffledIndices);

        // Minimum operations = number of blocks - 1
        return orderedBlocks - 1;
    }

    // Helper: counts how many contiguous ordered sequences exist
    private static int countOrderedBlocks(int[] indices) {
        int blocks = 1;
        for (int i = 1; i < indices.length; i++) {
            if (indices[i] != indices[i - 1] + 1) {
                blocks++;
            }
        }
        return blocks;
    }


}
