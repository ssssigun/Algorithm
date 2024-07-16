/*
    1. 재귀함수로 풀거나 반복문으로 풀어도 될 것 같다.
        - 유저 정보를 클래스로 만들어서 사용
        - 방문 처리로 방에 입장한 유저 확인
        - 2차원 리스트로 방문객 관리
        - 마지막에 정렬해서 출력하기
    2. 첫째 줄에 플레이어의 수 p, 방의 정원 m
        - 두번째 줄부터 p개의 플레이어 레벨 i, 닉네임 n이 주어짐
    3. 생성된 방에 대해서 시작 유무와 플레이어들의 레벨과 아이디를 return
        - 방의 생성 순서대로
        - 방의 플레이어들은 닉네임이 사전순으로 정렬
        - 시작되었으면 Started!, 대기 중이면 Waiting!

* */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class User implements Comparable<User>{
    int level;
    String name;
    User(int level, String name){
        this.level = level;
        this.name = name;
    }
    User(User u){
        this.level = u.level;
        this.name = u.name;
    }
    @Override
    public int compareTo(User o1){ // 닉네임 사전 순서
        return this.name.equals(o1.name) ? this.level - o1.level : this.name.compareTo(o1.name);
    }
}
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<User> player = new ArrayList<>(); // 선수 참여 목록 배열
        List<List<User>> room = new ArrayList<>(); // 방 배열
        boolean[] visited = new boolean[p];; // 방문 처리 배열

        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            player.add(new User(level, name));
        }

        for(int i=0; i<p; i++){ // 방 만들기
            int standard = player.get(i).level;
            int cnt = 0;
            if(!visited[i]){ // 방문하지 않았으면 새로 만들고 추가
                room.add(new ArrayList<>());
                room.get(room.size()-1).add(new User(player.get(i)));
                visited[i] = true;
                cnt++;
                for(int j=0; j<p; j++){
                    if(!visited[j] && Math.abs(standard - player.get(j).level) <= 10){ // 레벨 차이가 10 이하
                        room.get(room.size()-1).add(new User(player.get(j)));
                        visited[j] = true;
                        cnt++;
                    }
                    if(cnt == m) break; // m명 이하여야 함
                }
            }
        }
        // 출력
        for(int i=0; i<room.size(); i++){
            if(room.get(i).size() == m){ // 방이 다 차면 시작
                bw.write("Started!\n");
            }else{
                bw.write("Waiting!\n");
            }
            Collections.sort(room.get(i)); // 닉네임 사전순으로 정렬
            for(int j=0; j<room.get(i).size(); j++){
                bw.write(room.get(i).get(j).level +" "+ room.get(i).get(j).name);
                bw.write("\n");
            }
        }
        bw.flush();
    }
}