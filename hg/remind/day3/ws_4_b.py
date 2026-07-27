food_list = [
    {
        '종류': '한식',
        '이름': '잡채'
    },
    {
        '종류': '채소',
        '이름': '토마토'
    },
    {
        '종류': '중식',
        '이름': '자장면'
    },
]

# 아래에 코드를 작성하시오.
# for과 if 문을 사용하여 각각 적절한 값이 출력되도록

#food_list의 각 요소 dict 값을 {이름}은/는 {종류}이다 로 출력
for food in food_list:
    if food['이름'] == '토마토': #만약에 이름이 토마토라면
        food['종류'] = '과일' # 종류를 과일로 바꿔버려

    if food['이름'] == '자장면': #만약 이름이 자장면이라면
            print("자장면엔 고춧가루지") #이거 출력하기

    print(f"{food['이름']} 은/는 {food['종류']} (이)다.")

    

print(food_list) #반복문이 끝난 후 food_list 출력

#추가 )  for 문으로 작성한 코드를 while 문으로 변경한다. 단 실행 결과는 동일하여야 한다
i = 0

while i < len(food_list):
    food = food_list[i]
    
    if food['이름'] == '토마토':
        food['종류'] = '과일'

    if food['이름'] == '자장면':
            print("자장면엔 고춧가루지")


    print(f"{food['이름']} 은/는 {food['종류']} (이)다.")
    
    
        
    i += 1

print(food_list)