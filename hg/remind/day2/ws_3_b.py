pro_num = 1000
global_data = {'subject': 'python', 'day': 3, 'title': '함수 활용하기'}

#create_data함수 정의하기
def create_data(subject, day, title=None): #인자로 과목, 일차, 제목 받기 제목은 None
    global pro_num #global에 정의된 pronum 변수의
    pro_num += 1 #값에 1을 더한 값이 되어야 함
    
    data = {
        '과목': subject,
        '일차': day,
        '제목': title,
        '문제 번호': pro_num
    }
    return data

result_1 = create_data('python', 3) # 문자열 python과 정수 3을 순서대로 담아 호출한다
result_2 = create_data(subject='web', day=1, title='web 연습하기')
result_3 = create_data(**global_data)

print(result_1)
print(result_2)
print(result_3)