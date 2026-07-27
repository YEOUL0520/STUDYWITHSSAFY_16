matrix = [
        ['0, 1', '0, 2', '0, 3'], 
        ['1, 0', '1, 1', '1, 2', '1, 3'], 
        ['2, 0', '2, 1', '2, 2', '2, 3', '2, 4'], 
        ['3, 0', '3, 1'], 
        ['4, 0', '4, 1', '4, 2'], 
        ['5, 0']
    ]
# 아래에 코드를 작성하시오.

#built-in function len을 사용하지 않고, matrix의 총 길이를 matrix_len 변수에 담음
# 1. len을 사용하지 않고 matrix의 총 길이 구하기
matrix_len = 0 #matrix_len 변수에 0을 할당한다.
for row in matrix: #for 문을 사용하여 matrix 변수가 가진 요소를 모두 순회한다
    matrix_len += 1 # 각 요소를 순회할 때 마다 matrix_len 변수에 할당된 값을 1 증가시킴
print(matrix_len) #matrix_len 변수 출력


# 2. len을 사용하지 않고 각 요소의 길이를 구하여 4 이하인 경우 출력하기
for number in matrix: #for문을 사용하여 matrix 변수가 가진 각 요소를 순회함. 임시 변수 명은 number
    temporary_len = 0 #이때 각 요소들의 길이를 계산할 temporary_len 변수에 0을 할당한다

    for item in number: #요소 순회한다
        temporary_len += 1 # 매 순회마다 temporary_len 변수에 할당된 값을 1 증가 시킴
    
    if temporary_len <= 4:
        print(f'{number} 리스트는 {temporary_len}개 만큼 요소를 가지고 있습니다.')


# 3. range와 len을 사용하여 인덱스를 기준으로 순회하며 값 출력하기
for x in range(len(matrix)):
    for y in range(len(matrix[x])):
        print(f'matrix의 {x}, {y} 번째 요소의 값은 {matrix[x][y]} 입니다.')