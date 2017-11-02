import org.junit.Test;
import static org.junit.Assert.*;
public class Luhn_171101 {

    public boolean luhn(int num){
        int sum = 0;
        int digit;
        for(int i = 1; num > 0; i++){
            digit = num%10;
            if(i%2 == 0){
                digit *= 2;
                if(digit > 4) digit += 1;   //어차피 digit*2를 했을 때 10자리는 무시돼도 됨
            }
            sum += digit;
            num /= 10;
        }
        return sum%10 == 0;
    }
    public boolean luhn2(int num){
        int sum = 0;
        int digit;
        for(int i = 1; num > 0; i++){
            digit = num%10;
            if(i%2 == 0){
                digit *= 2;
                if(digit > 9) digit -= 9;   // 10을 빼고 1을 더함. ex) 2*9 = 18 ->  10을 빼서 1의 자리만 남기고, 10의 자리인 1을 더함. 결국 9빼기.
            }
            sum += digit;
            num /= 10;
        }
        return sum%10 == 0;
    }
    @Test
    public void test(){
        assertTrue(luhn2(2121));
        assertTrue(luhn2(811111111));
        assertFalse(luhn2(5050));
        assertTrue(luhn2(917567));
    }
}
