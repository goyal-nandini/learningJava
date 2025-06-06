class Sample{
    int rollNo;
    String name;

    Sample(int r, String n){
        rollNo = r;
        name = n;
    }
    Sample(){
        System.out.println("this is default constructor");
    }
    void display(){
        System.out.println(rollNo + " and " + name);
    }
}
public class BasicArray {
    public static void main(String[] args) {
        int[] student = new int[]{1, 2, 3};

        int[] student1 = new int[3];
        student1[1] = 100;

        System.out.println(student1[1]);
        System.out.println(student[1]);

        // 2D
        int[][] anArray = {
                {1, 2, 3},
                {5, 6, 7}
        };
        System.out.println(anArray[1][1]);

        // 3D
        int[][][] ThreeDArray = {
                { {1, 2, 3}, {4, 5, 6} },
                { {1, 2, 3}, {4, 5, 6} }
        };
        System.out.println(ThreeDArray[1][1][1]);

        // Array of Objects:
        Sample[] s = new Sample[3];

        s[0] = new Sample(101, "Nand");
        s[1] = new Sample(102, "Ravi");
        s[2] = new Sample(103, "Chand");

        for (int i = 0; i < s.length; i++) {
            s[i].display();
        }

        // object calling default constructor
        Sample s1 = new Sample();
    }
}
