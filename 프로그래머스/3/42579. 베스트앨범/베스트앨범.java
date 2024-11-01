import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genre = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreKeys = new ArrayList<>(genre.keySet());
        genreKeys.sort((o1, o2) -> genre.get(o2).compareTo(genre.get(o1)));
        
        List<Integer> answer = new ArrayList<>();
    
        for(String key : genreKeys) {
            Map<Integer, Integer> songs = new HashMap<>();
            
            for(int i=0; i<genres.length; i++) {
                if(key.equals(genres[i])) {
                    songs.put(i, plays[i]);
                }
            }
            
            List<Integer> songsKeys = new ArrayList<>(songs.keySet());
            songsKeys.sort(Comparator.comparing((Integer number) -> songs.get(number))
                          .reversed()
                          .thenComparing(number -> number));
            
            if(songsKeys.size() == 1) {
                answer.add(songsKeys.get(0));
            } else {
                answer.add(songsKeys.get(0));
                answer.add(songsKeys.get(1));
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Song {
    int number;
    String genre;
    int playNumber;
    
    Song() {};
    
    Song(int number, String genre, int playNumber) {
        this.number = number;
        this.genre = genre;
        this.playNumber = playNumber;
    }
}