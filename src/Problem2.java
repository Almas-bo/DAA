public class Problem2 {
    public double getMedianBrute(int[]A, int [] B){
        int n = A.length, m = B.length;
        int[] c = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (A[i] <= B[j]) c[k++] = A[i++];
            else c[k++] = B[j++];
        }
        while (i < n) c[k++] = A[i++];
        while (j < m) c[k++] = B[j++];
        if (c.length % 2 == 1) return c[c.length / 2];
        return (c[c.length / 2 - 1] + c[c.length / 2]) / 2.0;
    }

    public double getMedianSmart(int[]A, int [] B){
        int total = A.length + B.length;
        if (total % 2 == 1) return kth(A, 0, B, 0, total / 2 + 1);
        return (kth(A, 0, B, 0, total / 2) + kth(A, 0, B, 0, total / 2 + 1)) / 2.0;
    }

    private int kth(int[] A, int a, int[] B, int b, int k) {
        if (a >= A.length) return B[b + k - 1];
        if (b >= B.length) return A[a + k - 1];
        if (k == 1) return Math.min(A[a], B[b]);
        int h = k / 2;
        int ai = Math.min(a + h, A.length) - 1;
        int bi = Math.min(b + h, B.length) - 1;
        if (A[ai] <= B[bi]) return kth(A, ai + 1, B, b, k - (ai - a + 1));
        return kth(A, a, B, bi + 1, k - (bi - b + 1));
    }

    public static void main() {
        System.out.println(new Problem2().getMedianBrute(new int[]{1,2,3},new int[]{3,4,5}));
        System.out.println(new Problem2().getMedianSmart(new int[]{1,2,3},new int[]{3,4,5}));
    }
}
