import java.util.*;

class Solution {

    static boolean visited[] = new boolean[7];
    static Set<Integer> set;

    public void permute(String numbers, String str, int depth){
        if(depth > numbers.length()){
            return;
        }

        for(int i = 0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                String s = str + numbers.charAt(i);
                set.add(Integer.parseInt(s));
                permute(numbers,s,depth + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        permute(numbers,"",0);

        for(int n : set){
            if(n<2){
                continue;
            }else{
                boolean check = true;
                for(int i = 2; i<=Math.sqrt(n); i++){
                    if(n % i == 0){
                        check = false;
                        break;
                    }
                }
                if(check){
                    answer++;
                }
            }
        }

        return answer;
    }
}