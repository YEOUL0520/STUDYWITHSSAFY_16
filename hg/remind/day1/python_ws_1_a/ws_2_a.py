#zero_list 변수에 숫자 0을 하나 가지고 있는 리스트를 할당한다. 
zero_list = [0]
#zero_list 변수를 출력한다.
print(zero_list)
#many_zero_list 변수에 숫자 0을 25만개 가지고 있는 리스트를 할당한다. 
many_zero_list = [0] * 250000 #리스트와 곱셈 연산자를 활용하여 할당
#many_zero_list의 길이를 출력한다. 
print(len(many_zero_list))
#numbers 변수에 range를 활용하여 1부터 10까지의 수를 가진 리스트를 할당한다. 
numbers = list(range(1, 11))
#numbers 변수를 출력한다. 
print(numbers)
#numbers의 3번째부터 마지막 요소까지 출력한다.
print(numbers[3:])