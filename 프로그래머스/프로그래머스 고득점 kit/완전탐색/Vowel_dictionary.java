import java.util.*;

class Solution {

    static PriorityQueue<String> pq = new PriorityQueue<>();
    static String[] arr = {"A", "E", "I", "O", "U"};

    public void permute(String str, int depth){
        if(depth == 5){
            return;
        }

        for(int i = 0; i<arr.length; i++){
            String s = str + arr[i];
            pq.add(s);
            permute(s, depth +1);
        }
    }

    public int solution(String word) {
        int answer = 0;
        HashMap<String,Integer> hm = new HashMap<>();

        permute("", 0);

        int index = 1;
        while(!pq.isEmpty()){
            hm.put(pq.poll(), index++);
        }

        answer = hm.get(word);
        return answer;
    }
}