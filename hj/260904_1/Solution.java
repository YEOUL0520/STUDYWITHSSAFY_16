import java.util.*;
import java.io.*;

public class Solution {
    public static int bfs(int startNode, List<Integer>[] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];

        queue.offer(startNode);
        visited[startNode] = true;

        int answer = startNode;

        while(!queue.isEmpty()){
            int size = queue.size();
            int maxNode = 0;

            for(int i = 0; i<size; i++){
                int now = queue.poll();

                maxNode = Math.max(now, maxNode);

                for(int next : graph[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            answer = maxNode;
        }
        return answer;

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int test_case = 1; test_case <= 10; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            //연결 리스트 만들기 (노드 연결 그래프 그리자)
            List<Integer>[] graph = new ArrayList[101];


            for(int i = 1; i<=100; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for( int i = 0; i<length/2;  i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            int answer = bfs(startNode, graph);
            System.out.println("#"+test_case+" "+answer);
        }

    }

}