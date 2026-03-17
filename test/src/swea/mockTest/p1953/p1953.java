package swea.mockTest.p1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 * 가로와 세로를 검사할껀데
 * 숫자가 커지면 x만큼의 뒷칸을 검사
 * x만큼의 뒷칸이 배열 범위를 벗어나는 경우 주의
 * 
 * 숫자가 작아지면 x만큼의 앞칸을 검사
 * 역시 앞칸이 배열 범위를 벗어나는 경우 주의
 * 
 * 
 * 
 */



public class p1953 {
	static int N, X;
	static int[][] arr;
	static int[] dx = {-1, 1};
	static boolean[] visited;
	
	
	static boolean check(int a, boolean r) { 	// r이 ture면 가로검사, r이 false면 세로 검사
		
		
		if(r) {
			for(int i = 0; i < N - 1; i++) {
				int now = arr[a][i];
				int next = arr[a][i+1];
				
				// before과 now가 다르면 
				if(next != now) {
					if(Math.abs(next - now) > 1) return false;
					if(next > now) {	// next가 더 큰 경우 => 올라가는 경우
						for(int k = 0; k < X; k++) {
							int nx = i + dx[0]*k;
							if(nx < 0) return false;
							if(arr[a][nx] != now)return false;
							if(visited[nx]) return false;
							visited[nx] = true;
						}
					}else {	// next가 더 작은 경우 => 내려가는 경우
						
						for(int k = 1; k <= X; k++) {
							int nx = i + dx[1]*k;
							if(nx >= N) return false;
							if(arr[a][nx] != next)return false;
							if(visited[nx]) return false;
							visited[nx] = true;
						}	
					}
				}
				
			}
		}else {
			for(int i = 0; i < N - 1; i++) {
				int now = arr[i][a];
				int next = arr[i+1][a];
				
				// before과 now가 다르면 
				if(next != now) {
					if(Math.abs(next - now) > 1) return false;
					if(next > now) {	// next가 더 큰 경우 => 올라가는 경우
						for(int k = 0; k < X; k++) {
							int nx = i + dx[0]*k;
							if(nx < 0) return false;
							if(arr[nx][a] != now)return false;
							if(visited[nx]) return false;
							visited[nx] = true;
						}
					}else {	// next가 더 작은 경우 => 내려가는 경우
						
						for(int k = 1; k <= X; k++) {
							int nx = i + dx[1]*k;
							if(nx >= N) return false;
							if(arr[nx][a] != next)return false;
							if(visited[nx]) return false;
							visited[nx] = true;
						}	
					}
				}
				
			}
		}
		

		
		
		
		
		return true;
	}
	
	
	static int count() {
		int answer = 0;
		
		
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			if(check(i, true))answer++;
			visited = new boolean[N];
			if(check(i, false))answer++;
			
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());	// 배열의 크기
			
			X = Integer.parseInt(st.nextToken());	// 경사로의 길이
			
			arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			sb.append("#").append(test_case).append(" ").append(count()).append("\n");
//			System.out.println(count());
			
		}
		System.out.println(sb);
		
	}
}
