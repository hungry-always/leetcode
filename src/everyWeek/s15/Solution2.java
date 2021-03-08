package everyWeek.s15;

public class Solution2 {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            int i = n % 3;
            if (i ==  2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
