import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        Arrays.sort(mats);

        for(int i = 0; i<mats.length/2; i++){
            int temp = mats[i];
            mats[i] = mats[mats.length-1-i];
            mats[mats.length-1-i] = temp;
        }

        for(int k : mats){

            for(int i = 0; i<=park.length-k; i++){
                for(int j = 0; j<=park[0].length-k; j++){
                    boolean putMats = true;

                    for(int m = i; m<i+k; m++){
                        boolean allMinus = true;
                        for(int n = j; n<j+k; n++){
                            if(!park[m][n].equals("-1")){
                                allMinus = false;
                                break;
                            }
                        }
                        if(!allMinus){
                            putMats = false;
                            break;
                        }
                    }
                    if(putMats) return k;
                }
            }
        }

        return answer;
    }
}