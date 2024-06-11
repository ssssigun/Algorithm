import java.io.*;
import java.util.StringTokenizer;

/*
    1. 동근이의 위치가 마지막이므로 입력 다 받고 진행
        - 양 옆에 위치해 있으면 그냥 더하기
        - 단 반대 변의 위치해 있을때 최단거리인지 판별해야함
        - 전부 더해서 return
    2. 첫째 줄에 가로, 세로 길이
        - 둘째 줄엔 상점의 개수 N
        - 셋째 줄부터 +N까지 상점의 위치 (1 북, 2 남, 3 서, 4 동), (기준은 왼쪽 or 위부터의 거리)
        - 마지막 줄엔 동근이의 위치
    3. 동근이와 상점의 위치들의 최단 거리 합 return
* */
class Main {
    static int hor; // 가로 길이
    static int ver; // 세로 길이
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        hor = Integer.parseInt(st.nextToken());
        ver = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()); // 동근이 위치 (기준점)
        int standardDir = Integer.parseInt(st.nextToken());
        int standardDis = Integer.parseInt(st.nextToken());
        // 거리 구하기
        for(int i=1; i<=N; i++){
            int dir = arr[i][0];
            int dis = arr[i][1];
            if(standardDir == dir){ // 기준과 같은 변이면 거리 차이를 절대값 계산
                sum += Math.abs(standardDis - dis);
            }else if(standardDir == 1){ // 기준이 북쪽일 때
                if(dir == 2){ // 남쪽 (반대)
                    sum += minDis(standardDis, dis, "v");
                }else if(dir == 3){ // 서쪽
                    sum += add(standardDis, dis);
                }else if(dir == 4){ // 동쪽
                    sum += add(Math.abs(standardDis - hor), dis);
                }
            }else if(standardDir == 2){ // 기준이 남쪽일 때
                if(dir == 1){ // 북쪽 (반대)
                    sum += minDis(standardDis, dis, "v");
                }else if(dir == 3){ // 서쪽
                    sum += add(standardDis, Math.abs(dis - ver));
                }else if(dir == 4){ // 동쪽
                    sum += add(Math.abs(standardDis - hor), Math.abs(dis - ver));
                }
            }else if(standardDir == 3){ // 기준이 서쪽일 때
                if(dir == 1){ // 북쪽
                    sum += add(standardDis, dis);
                }else if(dir == 2){ // 남쪽
                    sum += add(Math.abs(standardDis - ver), dis);
                }else if(dir == 4){ // 동쪽 (반대)
                    sum += minDis(standardDis, dis, "h");
                }
            }else if(standardDir == 4){// 기준이 동쪽일 때
                if(dir == 1){ // 북쪽
                    sum += add(standardDis, Math.abs(dis - hor));
                }else if(dir == 2){ // 남쪽
                    sum += add(Math.abs(standardDis - hor), Math.abs(dis - hor));
                }else if(dir == 3){ // 서쪽 (반대)
                    sum += minDis(standardDis, dis, "h");
                }
            }
        }
        // 출력
        bw.write(sum+"");
        bw.flush();
    }
    public static int minDis(int a, int b, String s){ // 마주보고 잇을 때 최단 거리를 찾는 함수
        int t1 = 0;
        int t2 = 0;
        if(s.equals("v")){ // 수직일 때
            t1 = ver;
            t2 = hor;
        }else{
            t1 = hor;
            t2 = ver;

        }
        int case1 = t1 + a + b;
        int case2 = t1 + Math.abs(a - t2) + Math.abs(b - t2);
        return Math.min(case1, case2);
    }
    public static int add(int a, int b){ // 더하기 함수
        return a + b;
    }
}