from itertools import combinations

def calc_list(my_dice):
    cand = []
    nCr = list(combinations(my_dice, len(my_dice)))[0]
    for i in nCr[0]:
        for j in nCr[1]:
            cand.append(i * j)
    return cand

def compare_cand(my_cand, other_cand):
    cnt = 0
    for cand1 in my_cand:
        for cand2 in other_cand:
            if cand1 > cand2:
                cnt+=1
    return cnt

def solution(dice:list):
    winner_set = list()
    winner_index = list()
    max_possible = 0
    nCr = combinations(dice, len(dice)//2)
    for c in nCr:
        my_dice = []
        other_dice = []
        for d in c:
            my_dice.append(d)
        for d in dice:
            if d not in my_dice:
                other_dice.append(d)
        my_cand = calc_list(my_dice)
        other_cand = calc_list(other_dice)
        win_count = compare_cand(my_cand, other_cand)
        win_possible = (win_count) / (len(my_cand) + len(other_cand))
        if win_possible > max_possible:
            winner_set.clear()
            max_possible = win_count
            winner_set.append(my_dice)
    for dice_set in winner_set[0]:
        winner_index.append(dice.index(dice_set))
    winner_index.sort()
    print(winner_index)
    return winner_index



solution([[1, 2, 3, 4, 5, 6], [2, 2, 4, 4, 6, 6]])