package top20.title1;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 */
public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int product = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= product;
            product *= nums[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }

    @Test
    public void test() {
        ArraysUtils.outArray(productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
class ParkingSystem {
    int big;
    int medium;
    int small;


    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big <= 0) {
                    return false;
                } else {
                    big--;
                    return true;
                }
            case 2:
                if (medium <= 0) {
                    return false;
                } else {
                    medium--;
                    return true;
                }
            case 3:
                if (small <= 0) {
                    return false;
                } else {
                    small--;
                    return true;
                }
            default:
                return false;
        }
    }
}


