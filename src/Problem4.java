import java.util.Arrays;

public class Problem4 {
    public double minDistBrute(double [][] p){
        double best = Double.MAX_VALUE;
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                best = Math.min(best, dist(p[i], p[j]));
            }
        }
        return best == Double.MAX_VALUE ? 0.0 : best;
    }

    public double minDistSmart(double [][] p){
        if (p.length < 2) return 0.0;
        double[][] px = p.clone();
        Arrays.sort(px, (a, b) -> Double.compare(a[0], b[0]));
        return solve(px, 0, px.length - 1);
    }

    private double solve(double[][] p, int l, int r) {
        if (r - l < 3) {
            double best = Double.MAX_VALUE;
            for (int i = l; i <= r; i++) {
                for (int j = i + 1; j <= r; j++) {
                    best = Math.min(best, dist(p[i], p[j]));
                }
            }
            Arrays.sort(p, l, r + 1, (a, b) -> Double.compare(a[1], b[1]));
            return best;
        }
        int m = (l + r) / 2;
        double midX = p[m][0];
        double d = Math.min(solve(p, l, m), solve(p, m + 1, r));
        double[][] tmp = new double[r - l + 1][];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (p[i][1] <= p[j][1]) tmp[k++] = p[i++];
            else tmp[k++] = p[j++];
        }
        while (i <= m) tmp[k++] = p[i++];
        while (j <= r) tmp[k++] = p[j++];
        System.arraycopy(tmp, 0, p, l, tmp.length);
        double[][] strip = new double[r - l + 1][];
        int s = 0;
        for (int t = l; t <= r; t++) {
            if (Math.abs(p[t][0] - midX) < d) strip[s++] = p[t];
        }
        for (int a = 0; a < s; a++) {
            for (int b = a + 1; b < s && strip[b][1] - strip[a][1] < d; b++) {
                d = Math.min(d, dist(strip[a], strip[b]));
            }
        }
        return d;
    }

    private double dist(double[] a, double[] b) {
        double dx = a[0] - b[0], dy = a[1] - b[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    static void main() {
        var solver = new Problem4();
        System.out.println(solver.minDistBrute(new double[][]{{0,0},{3,4},{5,3}}));
        System.out.println(solver.minDistSmart(new double[][]{{0,0},{3,4},{5,3}}));
    }
}
