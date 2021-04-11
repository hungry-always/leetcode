package match.d29;

public class Solution1491 {
    public double average(int[] salary) {
        double sum = salary[0];
        int max = salary[0];
        int min = salary[0];
        for (int i = 1; i < salary.length; i++) {
            int num = salary[i];
            sum += num;
            if (num > max) {
                sum += max - num;
                max = num;
            }
            if (num < min) {
                sum += min - num;
            }
        }
        return sum / (salary.length - 2);
    }
}
