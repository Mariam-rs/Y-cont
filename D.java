import java.io.*;
import java.util.*;

public class D {
	
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	    String[] line1 = br.readLine().split(" ");
	    int n = Integer.parseInt(line1[0]);
	  
       // Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        //scanner.nextLine();
        String s = br.readLine();

       // scanner.close();

        long[][] dp = new long[n][n];
        boolean[][] open = new boolean[n][3];
        boolean[][] close = new boolean[n][3];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    open[i][0] = true;
                    break;
                case '{':
                    open[i][1] = true;
                    break;
                case '[':
                    open[i][2] = true;
                    break;
                case ')':
                    close[i][0] = true;
                    break;
                case '}':
                    close[i][1] = true;
                    break;
                case ']':
                    close[i][2] = true;
                    break;
                case '?':
                    open[i][0] = open[i][1] = open[i][2] = true;
                    close[i][0] = close[i][1] = close[i][2] = true;
                    break;
            }
        }


        for (int len = 2; len <= n; len++) {
            for (int left = 0; left + len <= n; left++) {
                int right = left + len - 1;
                dp[left][right] = 0;

                for (int mid = left + 1; mid <= right; mid += 2) {
                    int numMatches = numMatchingTypes(left, mid, open, close);

                    if (numMatches == 0) {
                        continue;
                    }

                    long leftWays = (left + 1 <= mid - 1) ? dp[left + 1][mid - 1] : 1;
                    long rightWays = (mid + 1 <= right) ? dp[mid + 1][right] : 1;

                    long totalWays = (leftWays * rightWays) % 1000000007;
                    totalWays = (totalWays * numMatches) % 1000000007;

                    dp[left][right] = (dp[left][right] + totalWays) % 1000000007;
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }

    static int numMatchingTypes(int l, int k, boolean[][] open, boolean[][] close) {
        int count = 0;
        for (int t = 0; t < 3; t++) {
            if (open[l][t] && close[k][t]) {
                count++;
            }
        }

        return count;
    }
}