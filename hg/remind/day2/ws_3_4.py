number_of_people = 0


def increase_user():
    global number_of_people
    number_of_people +=1

#실습2 참고해서 만들기
def create_user(name, age, address):
    increase_user()
    print(f'{name}님 환영합니다!')
    user_info = {
        'name': name,
        'age': age,
        'address': address
    }
    return user_info #완성된 user_info 딕셔너리를 반환한다

    

name = ['김시습', '허균', '남영로', '임제', '박지원']
age = [20, 16, 52, 36, 60]
address = ['서울', '강릉', '조선', '나주', '한성부']

#map 함수 사용하여 코드 작성
result = list(map(create_user, name, age, address))
print(result)