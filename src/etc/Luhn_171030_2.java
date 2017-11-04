package etc;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class Luhn_171030_2 {
    final int[] doubledAndReducedNum = {
            0, 2, 4, 6, 8, 1, 3, 5, 7, 9
    };
    public boolean luhn(int num){
        int sum = 0;
        int digit;
        for(int i = 1; num > 0; i++){
            digit = num % 10;
            if(i %2 == 0){
                sum += doubledAndReducedNum[digit];
            }else{
                sum += digit;
            }
            num /= 10;
        }
        return (sum % 10) == 0;
    }
    @Test
    public void test() {
        assertTrue(luhn(2121));
        assertTrue(luhn(811111111));
        assertFalse(luhn(5050));
        assertTrue(luhn(917567));
    }
}
