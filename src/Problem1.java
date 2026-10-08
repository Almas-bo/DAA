public class Problem1 {
    public int countFreqBrute(int key, int [] A){
        int c = 0;
        for (int x : A) {
            if (x == key) c++;
        }
        return c;
    }

    public int countFreqSmart(int key, int [] A){
        return lower(A, key + 1L) - lower(A, key);
    }

    private int lower(int[] A, long key) {
        int l = 0, r = A.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] < key) l = m + 1;
            else r = m;
        }
        return l;
    }

    static void main() {
        int[] A = {1,1,1,2,2,2,2,2,2,4,4,4,5,5,5,5};
        System.out.println(new Problem1().countFreqBrute(4, A));
        System.out.println(new Problem1().countFreqSmart(4, A));
    }
}
