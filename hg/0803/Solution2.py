#6730 장애물 경주 
#먼데 이거 파이썬으로 제출 할 수가 없네
T = int(input())

for t in range(1, T + 1):
    N = int(input())
    blocks = list(map(int, input().split()))
    
    max_up = 0
    max_down = 0
    
    for i in range(N - 1):
        diff = blocks[i + 1] - blocks[i]
        
        if diff > 0:  # 올라가는 경우
            max_up = max(max_up, diff)
        elif diff < 0:  # 내려가는 경우
            max_down = max(max_down, abs(diff))
            
    print(f"#{t} {max_up} {max_down}")