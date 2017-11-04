package Algospot;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Scanner;

import static org.junit.Assert.*;
public class TSP {
    static int n;
    static double[][] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            n = sc.nextInt();
            distance = new double[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    distance[i][j] = sc.nextDouble();
                }
            }
            System.out.println(solution());
        }
        sc.close();
    }
    public static double solution(){
        double ret = 0;
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[n];
        double min = Double.MAX_VALUE;
        for(int here = 0; here < n; here++){
            path.add(here);
            visited[here] = true;

            ret = shortestPath(path, visited, 0);

            min = Math.min(min, ret);
            path.removeLast();
            visited[here] = false;
        }

        return min;
    }
    public static double shortestPath(LinkedList<Integer> path, boolean[] visited, double currentLength){
        if(path.size() == n) return currentLength;

        double min = Double.MAX_VALUE;
        for(int next = 0; next < n; next++){
            if(visited[next]) continue;
            int here = path.getLast();


            path.addLast(next);
            visited[next] = true;

            double ret = shortestPath(path, visited, currentLength + distance[here][next]);

            visited[next] = false;
            path.removeLast();
            min = Math.min(min, ret);
        }
        return min;
    }
//
//    @Test
//    public void should_return_4(){
//        int cityNum = 3;
//        double dist[][] = {
//                {0.0000000000,  611.6157225201,  648.7500617289},
//                {611.6157225201,  0.0000000000,  743.8557967501},
//                {648.7500617289,  743.8557967501,  0.0000000000}
//        };
//        assertEquals("1260.3657842490", solution(cityNum, dist));
//    }
}

