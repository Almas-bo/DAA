import java.math.BigInteger;

public class Problem5 {
    public String multBrute(String A, String B){
        int n = A.length(), m = B.length();
        int[] r = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                r[i + j + 1] += (A.charAt(i) - '0') * (B.charAt(j) - '0');
            }
        }
        for (int i = r.length - 1; i > 0; i--) {
            r[i - 1] += r[i] / 10;
            r[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int x : r) sb.append(x);
        return strip(sb.toString());
    }

    public String multSmart(String A, String B){
        return strip(karatsuba(strip(A), strip(B)));
    }

    private String karatsuba(String a, String b) {
        if (a.length() <= 18 && b.length() <= 18) {
            return BigInteger.valueOf(Long.parseLong(a)).multiply(BigInteger.valueOf(Long.parseLong(b))).toString();
        }
        int n = Math.max(a.length(), b.length());
        int h = n / 2;
        String a1 = a.length() > h ? a.substring(0, a.length() - h) : "0";
        String a0 = a.length() > h ? a.substring(a.length() - h) : a;
        String b1 = b.length() > h ? b.substring(0, b.length() - h) : "0";
        String b0 = b.length() > h ? b.substring(b.length() - h) : b;
        a1 = strip(a1); a0 = strip(a0); b1 = strip(b1); b0 = strip(b0);
        String z2 = karatsuba(a1, b1);
        String z0 = karatsuba(a0, b0);
        String z1 = sub(sub(karatsuba(add(a1, a0), add(b1, b0)), z2), z0);
        return add(add(shift(z2, 2 * h), shift(z1, h)), z0);
    }

    private String shift(String s, int k) {
        if (s.equals("0")) return s;
        return s + "0".repeat(k);
    }

    private String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0 || c > 0) {
            int s = c;
            if (i >= 0) s += a.charAt(i--) - '0';
            if (j >= 0) s += b.charAt(j--) - '0';
            sb.append(s % 10);
            c = s / 10;
        }
        return strip(sb.reverse().toString());
    }

    private String sub(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, br = 0;
        while (i >= 0) {
            int d = a.charAt(i--) - '0' - br;
            if (j >= 0) d -= b.charAt(j--) - '0';
            if (d < 0) {
                d += 10;
                br = 1;
            } else br = 0;
            sb.append(d);
        }
        return strip(sb.reverse().toString());
    }

    private String strip(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }

    static void main() {
        BigInteger a = new BigInteger("12345678987654321");
        BigInteger b = new BigInteger("98765432123456789");
        System.out.println(a.multiply(b));
        System.out.println(new Problem5().multBrute("12345678987654321", "98765432123456789"));
        System.out.println(new Problem5().multSmart("12345678987654321", "98765432123456789"));
    }
}
