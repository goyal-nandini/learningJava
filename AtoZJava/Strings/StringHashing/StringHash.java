package Strings.StringHashing;

// https://www.geeksforgeeks.org/problems/challenge-by-nikitasha3208/1

public class StringHash{
    long[] prefix;
    long[] power;
    int p = 31;
    int mod = 1000000007;

    public StringHash(String s){
        int n = s.length();
        prefix = new long[n];
        power = new long[n];

        // precompute powers as p^0, p^1, p^2...
        power[0] = 1;
        for(int i=1; i<n; i++){
            power[i] = (power[i-1]*p)%mod;
        }

        // first prefix val
        prefix[0] = (s.charAt(0)-'a'+1); // +1 for numbering as a=1, b=2, c=3 etc else not doing +1 will get us a=0, b=1
        // etc.

       // build prefix array, using the formula here...
        for(int i=1; i<n; i++) {
            int val = s.charAt(i) - 'a' + 1;
            prefix[i] = (prefix[i - 1] + (val * power[i]) % mod) % mod;
        }
    }

    public long getHash(int l, int r){
        // long result = (prefix[r]-prefix[l-1]+mod)%mod;
        // alone this value is not correct as we have to adjust the powers of 31, means have to normalise the value

        long hash = prefix[r];
        if(l>0) {
            hash = (hash - prefix[l-1] + mod) % mod;
        }

        hash = (hash * modInverse(power[l])) % mod; // for dividing by p^l, and division is not normal with modulo so we
        // have to use modular multiplication inverse

        return hash;
    }

    private long modInverse(long x){
        return power(x, mod-2); // #fermat's little theorem #hardtoprocessNOW #ratooforNOW
    }

    // can use any method of power both are correct !!
    private long power1(long base, long exp){
        // binary exponentiation
        long ans = 1L;
        base %= mod;
        while(exp>0){
            if(exp % 2 == 0){ // exp is even
                exp /= 2;
                base = (base * base) % mod;
            } else { // exp is odd
                exp -= 1;
                ans = (ans * base) % mod;
            }
        }
        return ans;
    }

    private long power(long base, long exp){
        long ans = 1L;
        while(exp > 0){
            if((exp & 1) == 1){ // if exp is odd
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // divide exp by 2
        }
        return ans;
    }

}
