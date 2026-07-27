number_of_book = 100

def decrease_book(n): #한 번에 대여하는 책의 수를 정수로 넘겨받음
    global number_of_book
    number_of_book -= n #넘겨 받은 값 만큼 number_of_book의 수를 감소시키고
    print(f'남은 책의 수 : {number_of_book}') #현재 남은 책 수 출력

# 도서 대여 서비스
def rental_book(name, number): #대여하는 사람의 이름이랑 대여하는 책의 수 넘겨받음
    decrease_book(number) #rental_book 함수가 실행될 때, decrease_book 함수 호출
    print(f'{name} 님이 {number}권의 책을 대여하였습니다.')

rental_book('홍길동', 3)