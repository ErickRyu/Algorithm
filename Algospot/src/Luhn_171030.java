import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class Luhn_171030 {
    /**
     * Input num의 left significant number 부터 읽어들여서 유효성 검사.
     * @param n
     * @return whether is it correct card num
     */
    public boolean luhn(int n){
        String num = n+"";
        int length = num.length();
        int sum = 0;
        for(int i = 0; i < length; i++){
            int digit = num.charAt(i) - '0';
            if((length - i) % 2 == 0){
                digit *= 2;
            }
            if( digit > 9){
                digit = (digit/10) + (digit% 10);
            }
            sum += digit;

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
