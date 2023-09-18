# let 로그가 dig 로그보다 앞선다.
# let 로그는 내용의 사전순으로 정렬된다. 내용이같다면 let의 순으로 정렬된다
# digit은 순서를 유지한다.


class Solution:
    def reorderLogFiles(self, logs: list[str]) -> list[str]:
        # 1. let/dig 분리
        lets = []
        digs = []
        for log in logs:
            if log.split()[1].isdigit():
                digs.append(log)
            else:
                lets.append(log)

        lets.sort(key=lambda x: (x.split()[1:], x.split()[0]))
        return lets + digs
