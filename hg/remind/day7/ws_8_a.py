# 1: KeyError 예외 처리
data = {'name': '홍길동'}
try:
    if not data['age']:
        print(data['age'])
    else:
        print('data에는 age라는 키가 없습니다.')
        data['age'] = 30
        print(data)
except KeyError:
    print('해당 키가 존재 하지 않음을 알립니다.')
    data['age'] = 30
    print(data)


# 2: IndexError 예외 처리
arr = ['반갑', '하세요', '안녕']
try:
    for i in range(4):
        print(arr.pop())
    print(arr)
except IndexError:
    print(arr)
    print('더 이상 작업을 진행할 수 없음을 알립니다.')


# 3: ValueError 예외 처리
word = '3.15'
try:
    print(int(word))
except ValueError:
    print('적절한 값을 입력해야 합니다.')