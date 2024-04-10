package codeTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class RoyalKnightDuel {
	/*
기사 = 범위를 가지고 있다
1. 이동 로직
1-1. 이동하려는 위치에 벽이 존재한다 = 이동 불가
1-2. 다른 기사가 위치해있다 = 해당 기사가 이동 가능한지 판단.
 = 재귀로 영향을 받는 마지막 기사가 이동 가능한지 판단 필요

2. 받을 데미지 계산
2-1. 이동이 완료된 각 기사의 영역에서 해당 영역에 함정이 몇개나 포함 돼 있나 찾기
3. 받은 데미지로 체력 감소 -> 아웃 여부 판단.
데미지를 map으로 관리. 아웃된 기사는 map에서 삭제
*/
	class Main {

		static FastReader scan = new FastReader();
		static int L, N, Q;
		static int[][] board;
		static int[][] knightBoard;
		static Map<Integer, Knight> knightMap;
		static List<Query> queries;
		static int[] dr = {-1, 0, 1, 0};
		static int[] dc = {0, 1, 0, -1};

		static class Knight {
			int id;
			int r;
			int c;
			int w;
			int h;
			int k;
			int damage;
			List<int[]> position = new ArrayList<>();

			public Knight(int id, int r, int c, int h, int w, int k) {
				this.id = id;
				this.r = r;
				this.c = c;
				this.h = h;
				this.w = w;
				this.k = k;
			}

			public String toString() {
				return id + "번 기사. 체력 : " + k + " 받은 데미지 : " + damage;
			}
		}

		static class Query {
			int id;
			int d;

			public Query(int id, int d) {
				this.id = id;
				this.d = d;
			}

			@Override
			public String toString() {
				return id + " " + d;
			}
		}

		static boolean isMovable(int id, int d) {
			// 현재 기사의 모든 좌표를 새로운 좌표로 갱신 -> 하나라도 이동할 수 없다면 원복
			Knight knight = knightMap.get(id);
			for (int[] pos : knight.position) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				if (nr < 0 || nr >= L || nc < 0 || nc >= L)
					return false; // 범위를 벗어남 = 벽이라 못움직임
				if (board[nr][nc] == 2)
					return false; // 벽을 만난 상태
				if (knightBoard[nr][nc] != id && knightBoard[nr][nc] != 0) {
					if (!isMovable(knightBoard[nr][nc], d))
						return false;
				}

			}
			return true;
		}

		static void move(int id, int d, int queryId) {
			Knight knight = knightMap.get(id);
			List<int[]> newPosition = new ArrayList<>();
			if (isMovable(id, d)) {
				for (int i = 0; i < knight.position.size(); i++) {
					int[] pos = knight.position.get(i);
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];
					if (knightBoard[nr][nc] != 0 && knightBoard[nr][nc] != id) {
						move(knightBoard[nr][nc], d, queryId);
					}
					newPosition.add(new int[] {nr, nc});
				}
				knight.position = newPosition;
				redrawBoard();
				if (id != queryId) {
					damage(id);
				}
			}
		}

		static void redrawBoard() {
			knightBoard = new int[L][L];
			for (Knight knight : knightMap.values()) {
				for (int[] pos : knight.position) {
					knightBoard[pos[0]][pos[1]] = knight.id;
				}
			}
		}

		static void damage(int id) {
			// 이동한 id 기사, 안움직인 애 뺴고 나머지 기사들을 순회하며 해당 위치에 함정이 있다면 갯수만큼 체력차람. 체력이 0이하가 되면 제거
			Knight knight = knightMap.get(id);
			int dam = 0;
			for (int[] pos : knight.position) {
				if (board[pos[0]][pos[1]] == 1) {
					dam++;
				}
			}
			knight.damage += dam;
			if (knight.k <= knight.damage) {
				knightMap.remove(id);
			}
		}

		static void logic() {
			for (int[] row : knightBoard) {
				System.out.println(Arrays.toString(row));
			}
			System.out.println();
			for (Query q : queries) {
				System.out.println("q = " + q);
				if (knightMap.get(q.id) == null)
					continue;
				move(q.id, q.d, q.id);

				for (Knight knight : knightMap.values()) {
					System.out.println("knight = " + knight);
				}

				for (int[] row : knightBoard) {
					System.out.println(Arrays.toString(row));
				}
				System.out.println();
			}
		}

		static void input() {
			L = scan.nextInt();
			N = scan.nextInt();
			Q = scan.nextInt();

			board = new int[L][L];
			knightBoard = new int[L][L];
			knightMap = new HashMap<>();
			queries = new ArrayList<>();

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < L; j++) {
					board[i][j] = scan.nextInt();
				}
			}

			for (int i = 1; i <= N; i++) {
				//knightboard 위치 초기화 필
				int r = scan.nextInt() - 1;
				int c = scan.nextInt() - 1;
				int h = scan.nextInt();
				int w = scan.nextInt();
				int k = scan.nextInt();
				knightMap.put(i, new Knight(i, r, c, h, w, k));
				Knight knight = knightMap.get(i);
				for (int row = r; row < r + h; row++) {
					for (int col = c; col < c + w; col++) {
						knightBoard[row][col] = i;
						knight.position.add(new int[] {row, col});
					}
				}
			}

			for (int i = 0; i < Q; i++) {
				queries.add(new Query(scan.nextInt(), scan.nextInt()));
			}

		}

		public static void main(String[] args) {
			input();
			logic();
			int answer = 0;
			for (Knight knight : knightMap.values()) {
				answer += knight.damage;
				System.out.println(knight);
			}

			System.out.println(answer);
		}

		static class FastReader {
			BufferedReader br;
			StringTokenizer st;

			public FastReader() {
				br = new BufferedReader(new InputStreamReader(System.in));
			}

			public FastReader(String s) throws FileNotFoundException {
				br = new BufferedReader(new FileReader(new File(s)));
			}

			String next() {
				while (st == null || !st.hasMoreElements()) {
					try {
						st = new StringTokenizer(br.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				return st.nextToken();
			}

			int nextInt() {
				return Integer.parseInt(next());
			}

			long nextLong() {
				return Long.parseLong(next());
			}

			double nextDouble() {
				return Double.parseDouble(next());
			}

			String nextLine() {
				String str = "";

				try {
					str = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return str;
			}
		}
	}
}
