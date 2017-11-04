package etc;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class kakao_3 {

    public int solution(int cacheSize, String[] cities){
        List<String> cache = new LinkedList<>();
        int time = 0;
        for(String city : cities){
            city = city.toLowerCase();
            if(cache.contains(city)){
                int index = cache.indexOf(city);
                cache.remove(index);
                cache.add(0, city);
                time += 1;
            }else{
                if(cache.size() == cacheSize){
                    cache.remove(cacheSize-1);
                    cache.add(0, city);
                }else{
                    cache.add(0, city);
                }
                time += 5;
            }
        }
        return time;
    }
    @Test
    public void test(){
        assertTrue(true);
        assertEquals(50,solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }));
        assertEquals(21, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        assertEquals(60, solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        assertEquals(52, solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        assertEquals(16, solution(16, new String[]{	"Jeju", "Pangyo", "NewYork", "newyork"}));
        assertEquals(25, solution(25, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}

