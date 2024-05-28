package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P64064 {

	/*
    불량사용자 리스트 존재. 응모자(user_id) 중 불량사용자(banned_id) 리스트에 있는 사람 = 제재 아이디
    1. 불량사용자 id 별로 user_id에서 가능성 있는 목록을 뽑는다. -> 정규식
    ex) fr*d* -> fradi, frodo
    *rodo -> frodo, crodo
    ****** -> abc123, frodoc
    ****** ->  abc123, frodoc
    2. 가능성 목록에서 크기가 banned_id인 조합을 생성
    (fradi, frodo, abc123, frodoc), (fradi, crodo, abc123, frodoc), (frodo, crodo, abc123, frodoc)
    1번 리스트에서 하나를 선택
    2번 리스트에서 하나를 선택 중복이라면? 다른 것을 선택 더 이상 선택할 수 없다 -> 1번으로 돌아가 다음걸 선택
    저장은 Set을 통해 순서가 다른 경우도 같은 것으로 처리
    */
	class Solution {

		static List<String>[] BANNED;
		static Set<Set<String>> idSet = new HashSet<>();

		private void getBannedFromUser(String[] user_id, String[] banned_id) {
			for (int i = 0; i < banned_id.length; i++) {
				List<String> bannedId = new ArrayList<>();
				String banned = banned_id[i].replace("*", ".");

				for (String id : user_id) {
					if (id.matches(banned)) {
						bannedId.add(id);
					}
				}
				BANNED[i] = bannedId;
			}
		}

		private void recFunc(int depth, Set<String> ids) {
			if (depth == BANNED.length) {
				idSet.add(new HashSet<>(ids));
				return;
			}

			for (int i = 0; i < BANNED[depth].size(); i++) {
				if (ids.contains(BANNED[depth].get(i))) continue;
				ids.add(BANNED[depth].get(i));
				recFunc(depth + 1, ids);
				ids.remove(BANNED[depth].get(i));
			}
		}

		public int solution(String[] user_id, String[] banned_id) {
			BANNED = new ArrayList[banned_id.length];

			getBannedFromUser(user_id, banned_id);

			recFunc(0, new HashSet<>());

			return idSet.size();
		}
	}
}
