import java.util.*;

class Solution {

    static boolean visited[] = new boolean[8];
    static List<String> com = new ArrayList<>();

    public void permute(int[][] dungeons, String str, int depth){
        if(depth == dungeons.length){
            com.add(str);
            return;
        }
        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i]){
                visited[i]=true;
                String s = str + i;
                permute(dungeons, s, depth +1);
                visited[i] = false;
            }
        }
    }



    public int solution(int k, int[][] dungeons) {

        List<Integer> countList = new ArrayList<>();

        permute(dungeons, "", 0);

        for(String n : com){
            int count = 0;
            int j = k;

            for(int i =0; i<n.length(); i++){
                if(j>= dungeons[n.charAt(i)-'0'][0]){
                    j-= dungeons[n.charAt(i)-'0'][1];
                    count++;
                }else{
                    break;
                }
            }
            countList.add(count);
        }

        int Max = 0;
        for(int l : countList){
            if(l>Max){
                Max=l;
            }
        }
        return Max;

    }
}