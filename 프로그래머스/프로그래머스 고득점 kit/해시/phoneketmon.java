import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            Integer k=map.get(nums[i]);
            if(k == null){
                map.put(nums[i],1);
            }else{
                map.replace(nums[i], k+1);
            }
        }

        answer = map.size();

        if(answer >=nums.length/2){
            return nums.length/2;
        }else{
            return answer;
        }

    }
}