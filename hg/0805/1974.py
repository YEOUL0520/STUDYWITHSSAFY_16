# import sys
# sys.stdin = open("input.txt", "r")

T = int(input())
# 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 9x9 스도쿠 퍼즐 데이터를 먼저 입력받아야 함
    puzzle = []  # 퍼즐 판을 저장할 리스트
    for _ in range(9): 
        row = list(map(int, input().split()))
        puzzle.append(row)
        
    result = 1  # 스도쿠 검증 결과 초기값 (1: 유효한 스도쿠, 0: 유효하지 않은 스도쿠)
    
    # ///////////////////////////////////////////////////////////////////////////////////
    # 1. 가로줄 및 세로줄 검증
    for i in range(9):
        row_set = set()  # 가로줄 중복 체크용 세트
        col_set = set()  # 세로줄 중복 체크용 세트
        
        for j in range(9):
            row_set.add(puzzle[i][j])
            col_set.add(puzzle[j][i])
            
        # 1부터 9까지 숫자가 모두 들어있지 않다면 (중복이 있거나 빠진 숫자가 있다면)
        if len(row_set) != 9 or len(col_set) != 9:
            result = 0
            break  # 가로/세로 검증 중단
            
    # 2. 3x3 크기의 작은 격자 검증 (앞선 가로/세로 검증 통과했을 때만 실행되도록 하깅)
    if result == 1:
        # 3칸씩 건너뛰면서 3x3 격자의 시작 좌표 잡기
        for r in range(0, 9, 3):
            for c in range(0, 9, 3):
                subgrid_set = set()  # 3x3 격자 중복 체크용 세트
                
                for i in range(3):
                    for j in range(3):
                        subgrid_set.add(puzzle[r + i][c + j])
                        
                # 3x3 안에 1~9가 다 들어있지 않다면
                if len(subgrid_set) != 9:
                    result = 0
                    break
                    
            # 안쪽 반복문에서 유효하지 않다고 판정되면 바깥쪽 반복문도 탈출
            if result == 0:
                break
    # ///////////////////////////////////////////////////////////////////////////////////
    
    # 결과 출력 형식에 맞춰서 출력하기 (#테스트케이스번호 결과값)
    print(f"#{test_case} {result}")