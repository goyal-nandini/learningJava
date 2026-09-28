package BitManipulation;

public class XorBasis{
    static final int HIGH = 17;
    long[] basis = new long[HIGH];

    void insert(long x){
        for(int i=HIGH-1; i>=0; i--){
            // check bit at i
            if(((x >> i)&1) == 0) continue; // as we need highest set bit, skip if its unset

            if(basis[i] == 0) { // empty slot, place x
                basis[i] = x;
                return;
            }
            x = x^basis[i];
            // is x becomes 0, its died -> contributes nothing new, do nothing
        }
    }

    long queryMax(){
        long result = 0;
        for(int i=HIGH-1; i>=0; i--){
            if((result ^ basis[i]) > result){
                result = result ^ basis[i];
            }
        }
        return result;
    }

    static void main() {
        XorBasis xb = new XorBasis();

        xb.insert(1);
        xb.insert(5);
        xb.insert(3);
        xb.insert(3);

        System.out.println(xb.queryMax());
    }
}
