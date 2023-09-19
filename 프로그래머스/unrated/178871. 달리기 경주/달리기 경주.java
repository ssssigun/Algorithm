import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<players.length; i++){
            map.put(players[i],i);
        }
        for(int i=0; i<callings.length; i++){
            int index = map.get(callings[i]);
            String fp = players[map.get(callings[i])-1];
            players[map.get(callings[i])-1] = callings[i];
            players[index] = fp;
            map.put(players[index], index);
            map.put(players[index-1], index-1);
        }
        return players;
    }
}