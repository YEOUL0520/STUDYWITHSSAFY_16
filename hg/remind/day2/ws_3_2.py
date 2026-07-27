number_of_people = 0

def increase_user(): #실습1에서 작성한 increase_user 함수 호출
    global number_of_people
    number_of_people += 1

def create_user(name, age, address):
    increase_user()
    print(f'{name}님 환영합니다!')
    #create_user 함수가 호출되면 환영한다는 메시지 출력
    user_info = {
        'name': name,
        'age': age,
        'address': address
    }
    return user_info #완성된 user_info 딕셔너리를 반환한다

print(f'현재 가입 된 유저 수 : {number_of_people}')

result = create_user('홍길동 ', 30, '서울 ')
print(result)

print(f'현재 가입 된 유저 수 : {number_of_people}')