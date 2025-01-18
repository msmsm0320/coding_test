public class Vowel_dictionary_dfs {
}
import java.util.*;

class Solution {

    static String arr[] = {"A", "E", "I", "O", "U"};
    static int num = 0, count = 0;

    public void dfs(String word, String str, int depth){

        if(depth > 5){
            return;
        }
        if(str.equals(word)){
            num = count;
            return;
        }
        count++;
        for(int i =0 ; i<arr.length; i++){
            String s = str + arr[i];
            dfs(word, s, depth+1);

        }
    }

    public int solution(String word) {
        dfs(word, "", 0);
        return num;
    }
}