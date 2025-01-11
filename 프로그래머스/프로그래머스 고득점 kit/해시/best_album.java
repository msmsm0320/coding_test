import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genresPlayCount = new HashMap<>();
        HashMap<Integer, Integer> indexPlayCount = new HashMap<>();

        for(int i = 0; i<genres.length; i++){
            genresPlayCount.put(genres[i], genresPlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (int i = 0; i<plays.length; i++){
            indexPlayCount.put(i,plays[i]);
        }

        List<String> sortedGenres = new ArrayList<>(genresPlayCount.keySet());
        Collections.sort(sortedGenres, (o1,o2) -> genresPlayCount.get(o2).compareTo(genresPlayCount.get(o1)));

        List<Integer> sortedIndex = new ArrayList<>(indexPlayCount.keySet());
        Collections.sort(sortedIndex, (o1,o2) -> indexPlayCount.get(o2).compareTo(indexPlayCount.get(o1)));

        List<Integer> answerList = new ArrayList<>();

        for(String s : sortedGenres){
            int count = 0;
            for(int i : sortedIndex){
                if(genres[i].equals(s) && count <2){
                    count++;
                    answerList.add(i);
                }
            }
        }
        int answer[] = new int[answerList.size()];
        for(int i = 0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}