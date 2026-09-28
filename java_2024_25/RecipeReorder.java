
    import java.util.*;

    public class RecipeReorder {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int numberOfInstructions = Integer.parseInt(scanner.nextLine().trim());
            scanner.nextLine(); // read the "shuffled" line

            List<String> shuffledInstructions = new ArrayList<>();
            for (int i = 0; i < numberOfInstructions; i++) {
                shuffledInstructions.add(scanner.nextLine());
            }

            scanner.nextLine(); // read the "original" line

            List<String> originalInstructions = new ArrayList<>();
            for (int i = 0; i < numberOfInstructions; i++) {
                originalInstructions.add(scanner.nextLine());
            }

            int minimumOperations = calculateMinimumReorderOperations(shuffledInstructions, originalInstructions);
            System.out.println(minimumOperations);
        }

        /**
         * Calculates the minimum number of cut-and-insert operations required
         * to reorder the shuffled instructions back to the original order.
         *
         * @param shuffled The list of instructions in shuffled order
         * @param original The list of instructions in the correct original order
         * @return The minimum number of operations to restore order
         */
        private static int calculateMinimumReorderOperations(List<String> shuffled, List<String> original) {
            // Map each original instruction to its index for quick lookup
            Map<String, Integer> originalIndexMap = new HashMap<>();
            for (int i = 0; i < original.size(); i++) {
                originalIndexMap.put(original.get(i), i);
            }

            // Convert shuffled instructions to their corresponding positions in original list
            int[] positions = new int[shuffled.size()];
            for (int i = 0; i < shuffled.size(); i++) {
                positions[i] = originalIndexMap.get(shuffled.get(i));
            }

            // Calculate the length of the longest increasing subsequence in positions
            int lisLength = findLongestIncreasingSubsequenceLength(positions);

            // Minimum operations = total instructions - length of longest ordered subsequence
            return shuffled.size() - lisLength;
        }

        /**
         * Finds the length of the longest strictly increasing subsequence in an array.
         * Uses a binary search optimization for O(N log N) time complexity.
         *
         * @param arr Array of integers representing positions in the original list
         * @return Length of the longest increasing subsequence
         */
        private static int findLongestIncreasingSubsequenceLength(int[] arr) {
            List<Integer> subsequence = new ArrayList<>();

            for (int num : arr) {
                // Binary search for the position to insert or replace
                int insertionIndex = Collections.binarySearch(subsequence, num);
                if (insertionIndex < 0) {
                    insertionIndex = -(insertionIndex + 1);
                }

                // If insertionIndex equals size, append else replace
                if (insertionIndex == subsequence.size()) {
                    subsequence.add(num);
                } else {
                    subsequence.set(insertionIndex, num);
                }
            }
            return subsequence.size();
        }
    }


