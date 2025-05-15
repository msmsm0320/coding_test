class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        int floor = n/w;
        if(n%w > 0 ) floor++;

        int[][] boxes = new int[floor][w];

        int current = 1;

        int numFloor = 0;
        int numIndex = 0;

        for(int i = 0; i<floor; i++){
            if(i%2 == 0){
                for(int j = 0; j<w && current<=n; j++){
                    if(num == current){
                        numFloor = i;
                        numIndex = j;
                    }
                    boxes[i][j] = current++;
                }
                continue;
            }
            for(int j = w-1; j>=0 && current<=n; j--){
                if(num == current){
                    numFloor = i;
                    numIndex = j;
                }
                boxes[i][j] = current++;
            }

        }

        for(int i = numFloor; i<floor; i++){
            if(boxes[i][numIndex] > 0) answer++;
        }


        return answer;
    }
}