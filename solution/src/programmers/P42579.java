package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class P42579 {
	/*
장르별로 가장 많이 재생된 노래 두개씩 -> 노래를 장르별로 묶어서 정렬 필요
장르 : List<노래>
map을 sort => List<노래>의 재생 수의 합 내림차순
List<노래> 재생수 내림차순, 고유번호 오름차순
*/
	class Solution {

		static class Song {
			int id;
			int play;

			public Song(int id, int play) {
				this.id = id;
				this.play = play;
			}
		}

		public int[] solution(String[] genres, int[] plays) {
			Map<String, List<Song>> genreMap = new HashMap<>();

			for (int i = 0; i < genres.length; i++) {
				genreMap.putIfAbsent(genres[i], new ArrayList<>());
				List<Song> lst = genreMap.get(genres[i]);
				lst.add(new Song(i, plays[i]));
			}
			List<Integer> result = new ArrayList<>();

			Stream<List<Song>> sortedMap = genreMap.values()
				.stream()
				.sorted((o1, o2) -> {
					int play1 = o1.stream().mapToInt(song -> song.play).sum();
					int play2 = o2.stream().mapToInt(song -> song.play).sum();
					return Integer.compare(play2, play1);
				});

			sortedMap.forEach(songs -> {
				songs.stream().sorted((o1, o2) -> Integer.compare(o2.play, o1.play)).limit(2) // stable sort
					.forEach(song -> result.add(song.id));
			});


			return result.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
