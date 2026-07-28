class Myth:
    # 클래스 변수
    type_of_myth = 0

    def __init__(self, name):
        self.name = name
        # 인스턴스가 생성될 때마다 클래스 변수 1 증가
        Myth.type_of_myth += 1

    @staticmethod
    def description():
        print("신화는 한 나라 혹은 한 민족으로부터 전승되어 오는 예로부터 섬기는 신을 둘러싼 이야기를 뜻한다.")

# 2개 이상의 인스턴스 
myth1 = Myth("dangun") 
myth2 = Myth("greek & rome")

# 각 인스턴스의 name 출력
print(myth1.name)
print(myth2.name)

# Myth 클래스의 type_of_myth 출력
print(f"현재까지 생성된 신화 수 : {Myth.type_of_myth}")

# description 스태틱 메서드 호출
Myth.description()
