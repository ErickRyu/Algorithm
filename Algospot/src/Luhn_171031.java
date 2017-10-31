import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * for문을 반으로 접는다고 생각하고 해봤다
 */
public class Luhn_171031 {
    public boolean luhn(int num){
        int sum = 0;
        int digit;
        while(num > 0){
            digit = num % 10;
            sum += digit;
            num /= 10;

            digit = num % 10;
            digit *= 2;
            if(digit > 9)
                digit = digit/10 + digit%10;
            sum += digit;
            num /= 10;
        }
        return (sum % 10) == 0;
    }
    @Test
    public void test() {
        assertTrue(luhn(2121));
        assertTrue(luhn(83111211));
        assertFalse(luhn(5050));
        assertTrue(luhn(917567));
    }
}
