number_of_people = 0


def increase_user():
    global number_of_people
    number_of_people += 1
    pass


name = ['김시습', '허균', '남영로', '임제', '박지원']
age = [20, 16, 52, 36, 60]
address = ['서울', '강릉', '조선', '나주', '한성부']


def create_user(name, age, address):
    increase_user()
    print(f'{name}님 환영합니다!')
    user_info = {
        'name': name,
        'age': age,
        'address': address
    }
    return user_info #완성된 user_info 딕셔너리를 반환한다
# 앞서 정의된 리스트들을 활용하여 유저 정보를 생성하고 출력
user_list = list(map(create_user, name, age, address))

many_user = [
    {'name' : '김시습', 'age' : 20},
    {'name' : '허균', 'age' : 16},
    {'name' : '남혜인', 'age' : 25}
]

number_of_book = 100

def decrease_book(n): #한 번에 대여하는 책의 수를 정수로 넘겨받음
    global number_of_book
    number_of_book -= n #넘겨 받은 값 만큼 number_of_book의 수를 감소시키고
    print(f'남은 책의 수 : {number_of_book}') #현재 남은 책 수 출력

def rental_book(info):
    # info 딕셔너리에서 키와 값을 추출 (예: {'김시습': 20})
    for name, age_val in info.items():
        rental_count = age_val // 10
        decrease_book(rental_count)
        print(f'{name}님이 {rental_count}권의 책을 대여하였습니다 .')


# [도전] 4단계: for문을 lambda와 map으로 변경하기
# 3단계 변환 규칙을 lambda로 구현하고 map 적용 후 list()로 감싸 실행
user_info = list(map(lambda user: {user['name']: user['age']}, many_user))

# 4단계 로직을 map과 list를 통해 일괄 실행
list(map(rental_book, user_info))