import java.util.*;
public class OrderIt_2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = Integer.parseInt(sc.nextLine().trim());
            sc.nextLine(); // skip "shuffled"
            List<String> shuffled = new ArrayList<>();
            for (int i = 0; i < N; ++i) shuffled.add(sc.nextLine());
            sc.nextLine(); // skip "original"
            List<String> original = new ArrayList<>();
            for (int i = 0; i < N; ++i) original.add(sc.nextLine());

            int minOps = minOperations(shuffled, original);
            System.out.println(minOps);
        }

        static int minOperations(List<String> shuffled, List<String> original) {
            int N = shuffled.size();
            Queue<State> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            State start = new State(shuffled, 0);
            queue.add(start);
            visited.add(listToString(shuffled));

            String target = listToString(original);

            while (!queue.isEmpty()) {
                State current = queue.poll();
                String currStr = listToString(current.list);
                if (currStr.equals(target)) return current.depth;

                // Try all contiguous blocks to move
                for (int i = 0; i < N; ++i) {
                    for (int j = i; j < N; ++j) {
                        List<String> block = current.list.subList(i, j + 1);
                        List<String> rest = new ArrayList<>(current.list.subList(0, i));
                        rest.addAll(current.list.subList(j + 1, N));
                        for (int k = 0; k <= rest.size(); ++k) {
                            List<String> newList = new ArrayList<>(rest);
                            newList.addAll(k, block);
                            String newStr = listToString(newList);
                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                queue.add(new State(newList, current.depth + 1));
                            }
                        }
                    }
                }
            }
            return -1; // Not possible, should not happen
        }

        static String listToString(List<String> list) {
            return String.join("#", list); // # is a separator unlikely to be in the list
        }

        static class State {
            List<String> list;
            int depth;
            State(List<String> l, int d) { list = new ArrayList<>(l); depth = d; }
        }

}
