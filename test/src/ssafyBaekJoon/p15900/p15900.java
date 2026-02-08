package ssafyBaekJoon.p15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p15900 {
	static List<Integer>[] list;
	static int N;
	
	
	static boolean bfs() {
		//count가 짝수면 지고 홀수면 이김
		int count = 0;

		//루트 노드의 카운트를 0으로 하기 위해 미방문을 -1로 처리
		int[] visited = new int[N+1];
		for (int i = 0; i <= N; i++) {
			visited[i] = -1;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
	
		q.offer(1);
		visited[1] = 0;
		
		while(!q.isEmpty()) {
			
			int a = q.poll();

			//정점이 2개인 경우대비
			if(a != 1 && list[a].size() == 1) {
				count += visited[a];
				//System.out.println(count);
			}
			
			
			for(int i : list[a]) {
				if(visited[i] == -1) {
					visited[i] = visited[a]+1;
					q.offer(i);
					//System.out.println("offer");
				}
				
				
			}
			
		}

		if(count%2 == 0) {
			return false;
		}else return true;
		

	}
	
	
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());		//정점의 개수
		
		
		// 0은 자식이 없다
		// 자식노드의 번호를 값으로 가짐
		// 행부분이 노드 번호
		list = new ArrayList[N+1];

		
		for(int i = 1; i <=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			

			list[a].add(b);
			list[b].add(a);

			
		}
		
		boolean result = bfs();
		
		if(result) System.out.println("Yes");
		else System.out.println("No");
		
		
		
	}

}
