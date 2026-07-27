#1이상 45 이하의 숫자를 (중복 되지 않도록) 6개를 뽑아야 한다.
#random 모듈을 이용하면 임의의 숫자 1개를 뽑을 수 있다.
#list를 활용해서 숫자 6개 저장하자 >> set 써도 되겠네
#set의 크기가 6이 될 때 까지 뽑자 반복문 활용해서
#다 뽑았으면 출력

import random
my_hope = set()
while len(my_hope) < 6:
    my_hope.add(random.randint(1,45))


#print(my_hope)
print(sorted(my_hope))
