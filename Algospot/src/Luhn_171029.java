import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class Luhn_171029 {
    public boolean luhn(int num){
        int sum = 0;
        int toAdd = 0;
        for(int i = 1; num > 0; i++){
            toAdd = (num % 10);
            if(i%2 == 0) toAdd *= 2;
            if(toAdd > 9){
                toAdd = toAdd/10 + toAdd%10;
            }
            sum += toAdd;
            num /= 10;
        }
        return sum%10 == 0;
    }
    @Test
    public void test(){
        assertTrue(luhn(2121));
        assertTrue(luhn(811111111));
        assertFalse(luhn(5050));
        assertTrue(luhn(917567));
    }
}
