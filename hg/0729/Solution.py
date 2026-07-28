#6319. [파이썬 프로그래밍 기초(1) 파이썬의 기본 구조와 기초 문법] 8. 함수의 기초 1
def reverse_word(word):
    reversed_str = ""
    # 반복문을 이용 -> 문자 젤 뒤에서부터 글자 가져오기
    for char in word:
        reversed_str = char + reversed_str
    return reversed_str


# 사용자로부터 단어 입력받기 
# 예시 입력: eye 원래 문제에는 입력 출력이라는 단어는 없지만 그냥 보기 좋게 추가해놓음
word = input("입력\n").strip()

# 단어 뒤집기 함수 호출
result = reverse_word(word)

# 결과 출력
print("출력")
print(result)

# 회문 여부 판단
if word == result:
    print("입력하신 단어는 회문(Palindrome)입니다.")
else:
    print("입력하신 단어는 회문(Palindrome)이 아닙니다.") 