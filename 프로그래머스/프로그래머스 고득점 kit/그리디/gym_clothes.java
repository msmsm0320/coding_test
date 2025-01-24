import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs_l = new HashSet<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i : reserve){
            hs.add(i);
        }

        for(int j : lost){
            if(hs.contains(j)) {
                hs.remove(j);
            }else{
                hs_l.add(j);
            }
        }

        for(int k : hs){
            if(hs_l.contains(k-1)){
                hs_l.remove(k-1);
            }else if(hs_l.contains(k+1)){
                hs_l.remove(k+1);
            }
        }
        return n-hs_l.size();
    }
}