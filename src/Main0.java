import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = in.nextInt();

        int[] first = new int[n];
        int[] second = new int[m];

        int currentSum = 0;
        int currentCount = 0;

        boolean isSumFlag = true;

        for (int i = 0; i < Math.max(n, m); i++) {
            if (isSumFlag && i < n) {
                first[i] = in.nextInt();
                if (first[i] + currentSum <= sum) {
                    currentSum += first[i];
                    currentCount++;
                } else {
                    isSumFlag = false;
                }
            } else {
                in.next();
            }
            if (i < m) {
                second[i] = in.nextInt();
            } else {
                in.next();
            }
        }

        int secondIt = 0;
        int maxCount = currentCount;
        for (int firstIt = currentCount - 1; firstIt >= 0 && secondIt < m; firstIt--) {
            while (secondIt < m && second[secondIt] + currentSum <= sum) {
                currentSum += second[secondIt];
                currentCount++;
                secondIt++;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
            currentSum -= first[firstIt];
            currentCount--;
        }

        System.out.println(maxCount);
    }
}