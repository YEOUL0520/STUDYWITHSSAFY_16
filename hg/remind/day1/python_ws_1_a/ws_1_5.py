#변수 사용x
print("변수 사용 안 했을 때 결과")
print(3 * 2)               # 3의 2배
print(3 ** 2)              # 3의 제곱
print((3 ** 2) // (3 * 2))  # 몫
print((3 ** 2) % (3 * 2))   # 나머지
print((3 ** 2) + ((-3) ** 2)) # 3의 제곱 + -3의 제곱

# 변수 사용
print("\n 변수 사용 했을 때 결과")
number = 3
double_value = number * 2
square_value = number ** 2
minus_square_value = (-number) ** 2

print(double_value)
print(square_value)
print(square_value // double_value)  # 몫
print(square_value % double_value)   # 나머지
print(square_value + minus_square_value)