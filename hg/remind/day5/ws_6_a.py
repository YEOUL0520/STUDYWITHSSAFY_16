# 1. my_set을 순회하며 얻은 값을 key로 하는 my_dict의 value를 출력 (get 메서드 활용, 없으면 None 출력)
for item in my_set:
    print(my_dict.get(item))

# 2. dict의 키로 사용 가능한 자료형을 var 변수에 할당 (예: 문자열 또는 튜플)
var = '다'

# 3. my_dict에 var 변수를 key로 하는 value '변수로도 키 설정 가능' 문자열 할당
my_dict[var] = '변수로도 키 설정 가능'

# 4. 변경된 my_dict 출력
print(my_dict)