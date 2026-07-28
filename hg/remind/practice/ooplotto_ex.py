import random
class LottoMaker:
    #숫자 6개를 가지고 있어야 함 : 객체가 가져야 할 값 >> __init__에 정의
    #임의의 숫자 6개를 뽑을 수 있어야 함 : 행동 >> 객체가 해야하는 행동 >>method(함수)로 정의
    # 숫자를 정렬 할 수 있어야 함 : 행동
    def __init__(self): 
        self.numbers = set()
        pass

    def sort(self):
        #객체가 가지고 있는 숫자들 정렬
        self.numbers = sorted(self.numbers)

        
    def make_number(self):
        #객체가 가지고 있는 set에다가 임의의 숫자 6개 넣기
        while len(self.numbers) <6:
            self.numbers.add(random.randint(1,45))
        

#my_set = set()
###########객체를 사용하는 부분#########################

lottomaker = LottoMaker() #내부적으로 __init__() 호출하면서 객체가 하나 만들어짐 

# 객체 지향은 코드 작성을 위해서 그 역할을 할 수 있는 객체를 필요로 한다.
# 로또 번호 생성기 라는 애가 필요함 
# : (여러 개 저장해도 되고), 하나만 해도 되고,로또 번호 6개를 만들어줄 거고, 정렬도 할 수 있는 기계

lottomaker.make_number()
lottomaker.sort()
print(lottomaker.numbers)

# lottomaker 라는 기계 (객체)
# 필요한 객체의 특성을 정의 해놓고, 필요할 때마다 만들어 쓰기
