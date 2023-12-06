import copy
answer = 0
def solution(coin, cards):
    start = len(cards)//3
    my_cards = cards[:start]
    rec_func(0,start,coin,cards,my_cards)

    return answer

def is_sum_equal(target:int, my_cards:list):
    x = -1
    y = -1
    find = False
    nums = set()
    for card in my_cards:
        nums.add(card)
        if target - card in nums and target != 2*card:
            find = True
            x = card
            y = target - card
            break
    if find:
        my_cards.remove(x)
        my_cards.remove(y)
    return my_cards

def rec_func(cnt, depth, coin, cards, my_cards):
    global answer
    if depth == len(cards)//3:
        new_cards = copy.deepcopy(my_cards)
    else:
        new_cards = is_sum_equal(len(cards) + 1, copy.deepcopy(my_cards))
        if new_cards == my_cards:
            answer = max(answer, cnt)
            return
    if depth > len(cards):
        answer = max(answer, cnt)
        return

    if coin >=2:
        new_cards.append(cards[depth])
        new_cards.append(cards[depth+1])
        rec_func(cnt+1, depth+2, coin - 2,cards, new_cards)
        new_cards.pop()
        new_cards.pop()

    if coin >= 1:
        new_cards.append(cards[depth])
        rec_func(cnt+1, depth+2, coin - 1,cards, new_cards)
        new_cards.pop()
        new_cards.append(cards[depth+1])
        rec_func(cnt+1, depth+2, coin - 1,cards, new_cards)
        new_cards.pop()


    rec_func(cnt+1, depth+2, coin,cards, new_cards)

solution(4, [3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4])




import copy
answer = 0
def solution(coin, cards):
    start = len(cards)//3
    my_cards = cards[:start]
    rec_func(0,start,coin,cards,my_cards)

    return answer

def is_sum_equal(target:int, my_cards:list):
    x = -1
    y = -1
    find = False
    for i in range(len(my_cards) - 1):
        if find:
            break
        for j in range(len(my_cards)):
            if my_cards[i] + my_cards[j] == target:
                x = my_cards[i]
                y = my_cards[j]
                find = True
                break
    if find:
        my_cards.remove(x)
        my_cards.remove(y)
    return my_cards

def rec_func(cnt, depth, coin, cards, my_cards):
    global answer
    if depth == len(cards)//3:
        new_cards = copy.deepcopy(my_cards)
    else:
        new_cards = is_sum_equal(len(cards) + 1, copy.deepcopy(my_cards))
        if new_cards == my_cards:
            answer = max(answer, cnt)
            return
    if depth > len(cards):
        answer = max(answer, cnt)
        return

    if coin >=2:
        new_cards.append(cards[depth])
        new_cards.append(cards[depth+1])
        rec_func(cnt+1, depth+2, coin - 2,cards, new_cards)
        new_cards.pop()
        new_cards.pop()

    if coin >= 1:
        new_cards.append(cards[depth])
        rec_func(cnt+1, depth+2, coin - 1,cards, new_cards)
        new_cards.pop()
        new_cards.append(cards[depth+1])
        rec_func(cnt+1, depth+2, coin - 1,cards, new_cards)
        new_cards.pop()


    rec_func(cnt+1, depth+2, coin,cards, new_cards)

