package Algospot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
public class Wildcard {
    char[] word;
    char[] pattern;
    int[][] mem;

    /**
     * 오답
     * @param args
     */
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        Wildcard wc = new Wildcard();
        while(tc-- > 0){
            String wildCard = sc.next();
            int wordNum = sc.nextInt();
            LinkedList<String> resultWords = new LinkedList<>();
            for(int i = 0; i < wordNum; i++){
                String word = sc.next();
                String res = wc.solution(word.toCharArray(), wildCard.toCharArray());
                if(!res.isEmpty())
                    resultWords.add(word);
            }
            Collections.sort(resultWords);
            for(String res : resultWords){
                System.out.println(res);
            }
        }
        sc.close();
        */
    }
    public String solution(char[] word, char[] pattern){
        this.pattern = pattern;
        this.word = word;
        mem = new int[word.length][pattern.length];
        for(int i = 0; i < word.length; i++){
            Arrays.fill(mem[i], -1);
        }
        if(isMatched(word.length - 1, pattern.length - 1) == 1){
            return String.valueOf(word);
        }
        return "";
    }
    public int isMatched(int wordIdx, int patternIdx){
        if(patternIdx == 0 && pattern[patternIdx] == '*') return 1;
        if(wordIdx < 0 && patternIdx < 0) return 1;
        if(wordIdx < 0 || patternIdx < 0) return 0;

        if(mem[wordIdx][patternIdx] != -1) return mem[wordIdx][patternIdx];

        if(pattern[patternIdx] == '*'){
            char nextPattern = pattern[patternIdx - 1];
            int nextWordIdx = wordIdx;
            for(; nextWordIdx >= 0 && word[nextWordIdx] != nextPattern; nextWordIdx--){

            }
            return mem[wordIdx][patternIdx] = isMatched(nextWordIdx, patternIdx - 1) | isMatched(nextWordIdx - 1, patternIdx);
        }
        else if(word[wordIdx] == pattern[patternIdx] || pattern[patternIdx] == '?'){
            return mem[wordIdx][patternIdx] = isMatched(wordIdx - 1, patternIdx - 1);
        }
        return 0;

    }
    @Test
    public void star_and_alphabet(){
        char[] word = "help".toCharArray();
        char[] pattern = "h*".toCharArray();
        assertEquals("help", solution(word, pattern));

        char[] word2 = "aaaaaaa".toCharArray();
        char[] pattern2 = "aa*".toCharArray();
        assertEquals("aaaaaaa", solution(word2, pattern2));
    }
    @Test
    public void only_star(){
        char[] word = "help".toCharArray();
        char[] pattern = "*".toCharArray();
        assertEquals("help", solution(word, pattern));
    }

    @Test
    public void only_alphabet_patern_and_word(){
        char[] word = "help".toCharArray();
        char[] pattern = "help".toCharArray();
        assertEquals("help", solution(word, pattern));

        char[] pattern2 = "hel".toCharArray();
        assertEquals("", solution(word, pattern2));

        char[] pattern3 = "helpp".toCharArray();
        assertEquals("", solution(word, pattern3));
    }

    @Test
    public void alphabet_and_question_makr(){
        char[] word = "help".toCharArray();
        char[] pattern = "?elp".toCharArray();
        assertEquals("help", solution(word, pattern));

        char[] pattern2 = "h?lp".toCharArray();
        assertEquals("help", solution(word, pattern2));

        char[] pattern3 = "he?p".toCharArray();
        assertEquals("help", solution(word, pattern3));

        char[] pattern4 = "hel?".toCharArray();
        assertEquals("help", solution(word, pattern4));

        char[] pattern5 = "hel?p".toCharArray();
        assertEquals("", solution(word, pattern5));

        char[] pattern6 = "???".toCharArray();
        assertEquals("", solution(word, pattern6));

        char[] pattern7 = "????".toCharArray();
        assertEquals("help", solution(word, pattern7));

    }
}
