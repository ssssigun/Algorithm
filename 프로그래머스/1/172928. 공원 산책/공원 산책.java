/*
    1. 구현 문제
        - 처음 시작지 S 찾기
        - routes 배열의 명령어 실행
        - 만약 나가거나, 장애물을 만난다면 명령 취소
        - 마지막 위치 반환
    2. 맵 정보 park, 명령어 routes
    3. 마지막 위치 반환
*/
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;
        for(int i=0; i<park.length; i++){ // 초기 위치 찾기
            if(park[i].contains("S")){
                x = i;
                y = park[i].indexOf("S");
            }
        }
        for(int i=0; i<routes.length; i++){ // 명령어들을 돌면서 확인
            String[] c = routes[i].split(" ");
            int dis = Integer.parseInt(c[1]);
            int dx = 0;
            int dy = 0;
            if("N".equals(c[0])){
                dx = -1;
            }else if("S".equals(c[0])){
                dx = 1;
            }else if("W".equals(c[0])){
                dy = -1;
            }else if("E".equals(c[0])){
                dy =1;
            }
            int cx = x + (dx*dis);
            int cy = y + (dy*dis);
            if(cx<0 || cy<0 || cx>=park.length || cy>=park[0].length()){ // 맵 범위를 나가면 다음 명령어
                continue;
            }
            boolean flag = false;
            for(int j=1; j<=dis; j++){ // 이동 거리에 장애물이 있는 지 확인
                if(park[x + (dx*j)].charAt(y + (dy*j)) == 'X'){
                    flag = true;
                    break;
                }
            }
            if(flag){ // 있으면 다음 명령어
                continue;
            }
            // 없으면 이동 값 갱신
            x = cx;
            y = cy;
        }
        return new int[]{x,y};
    }
}