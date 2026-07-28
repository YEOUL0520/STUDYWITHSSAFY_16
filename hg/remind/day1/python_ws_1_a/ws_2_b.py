title = '딕셔너리 활용하기'
#data에 딕셔너리 할당
data = {
    '과목': 'Python',
    '구분': '실습',
    '단계': 2,
    '문제번호': 3251,
    '이름': None,
    '일차': 22
}

#data를 출력
print (data)

#data의 '단계' key에 할당된 값을 2단계가 되도록 수정 하고 문자열인 단계 덧셈해서 할당
data['단계'] = str(data['단계']) + '단계'

#data의 '이름' key에 title 변수 할당
data['이름'] = title

#data의 '일차'key에 할당된 값을, 원본 값에서 20을 뺀 만큼의 값을 할당
data['일차'] -= 20 #복합 연산자 사용

#data 변수 출력
print(data)