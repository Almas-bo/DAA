public class Problem3 {
    public int maxSumBrute(int [] A){
        int best = A[0];
        for (int i = 0; i < A.length; i++) {
            int s = 0;
            for (int j = i; j < A.length; j++) {
                s += A[j];
                if (s > best) best = s;
            }
        }
        return best;
    }

    public int maxSumSmart(int [] A){
        return solve(A, 0, A.length - 1);
    }

    private int solve(int[] A, int l, int r) {
        if (l == r) return A[l];
        int m = (l + r) / 2;
        int left = solve(A, l, m);
        int right = solve(A, m + 1, r);
        int s = 0, bl = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            s += A[i];
            bl = Math.max(bl, s);
        }
        s = 0;
        int br = Integer.MIN_VALUE;
        for (int i = m + 1; i <= r; i++) {
            s += A[i];
            br = Math.max(br, s);
        }
        return Math.max(Math.max(left, right), bl + br);
    }

    static void main() {
        System.out.println(new Problem3().maxSumBrute(new int[]{-17, 5, 3, -10, 6, 1, 4, -3, 8, 1, -13, 4}));
        System.out.println(new Problem3().maxSumSmart(new int[]{-17, 5, 3, -10, 6, 1, 4, -3, 8, 1, -13, 4}));
    }
}
