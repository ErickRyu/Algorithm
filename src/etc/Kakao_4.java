package etc;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Kakao_4 {
    static final int HOUR = 60;
    static final int TEN_OCLOCK = 600;
    static final int TEN_MINUTE = 10;
    public String solution(int n, int t, int m, String[] lines){
        List<Integer> times = new LinkedList<>();

        for(int i = 0; i < lines.length; i++){
            String[] hourAndMin = lines[i].split(":");
            times.add((Integer.parseInt(hourAndMin[0]) * 60) + Integer.parseInt(hourAndMin[1]));
        }
        Collections.sort(times);
        int bus = 9 * HOUR;
        int result = bus;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m; j++){
                if(!times.isEmpty() && times.get(0) <= bus){
                    times.remove(0);
                }
            }
            bus += t;
        }
        int max = 0;
        int j = 0;
        for(; j < m; j++){
            if(!times.isEmpty() && times.get(0) <= bus){
                max = Math.max(max, times.get(0));
                times.remove(0);
            }else{
                break;
            }
        }
        if(j != m){
            result = bus;
        }
        else if(max > 0){
            result = max - 1;
        }

        String hour = result < TEN_OCLOCK ? "0" + (result / HOUR) : "" + (result / HOUR);
        String min = (result % HOUR) < TEN_MINUTE ? "0" + (result % HOUR) : "" + (result % HOUR);
        return hour + ":" + min;
    }
    @Test
    public void test(){
        assertEquals("09:00", solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        assertEquals("09:09", solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        assertEquals("08:59", solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00" }));
        assertEquals("00:00", solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        assertEquals("09:00", solution(1, 1, 1, new String[]{"23:59"}));
        assertEquals("18:00", solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }
}
