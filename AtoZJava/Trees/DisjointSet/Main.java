package Trees.DisjointSet;

public class Main {
    public static void main(String[] args) {
        DisjointSet_02 ds = new DisjointSet_02(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        System.out.println(ds.isConnected(1, 5)); // false
        ds.printGroups();
        ds.unionByRank(3, 7);

        System.out.println(ds.isConnected(1, 5)); // true
        ds.printGroups();

        // union by size:
//        DisjointSet_01 ds1 = new DisjointSet_01(7);
//        ds1.unionBySize(1, 2);
//        ds1.unionBySize(2, 3);
//        ds1.unionBySize(4, 5);
//        ds1.unionBySize(6, 7);
//        ds1.unionBySize(5, 6);
//
//        System.out.println(ds.isConnected(1, 5)); // false
//
//        ds1.unionBySize(3, 7);
//
//        System.out.println(ds.isConnected(1, 5)); // true
    }

    /*Here’s a clean side‑by‑side comparison table for **Union by Rank vs. Union by Size**:

| Aspect              | Union by Rank                          | Union by Size                          |
|---------------------|----------------------------------------|----------------------------------------|
| **What we track**   | Height (rank)                          | Count (size)                           |
| **Comparison**      | 3 cases: `<`, `>`, `==`                | 2 cases: `<`, else                     |
| **Why?**            | Equal ranks → height increases         | Equal sizes → just add them            |
| **Update rule**     | `rank++` only when equal               | `size += size` always                  |

This table captures the essence:
- **Rank** focuses on tree height, so only equal heights cause growth.
- **Size** focuses on element count, so merging always updates the total.*/
}
