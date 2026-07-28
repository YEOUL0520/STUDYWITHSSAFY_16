class Car:
    # 클래스 변수
    wheels = 4 #모든 자동차들이 공통으로 가질 클래스변수

    # 생성자 메서드
    def __init__(self, engine, driving_system, sound):
        self.engine = engine #엔진의 종류를 담을 수 있는 엔진변수
        self.driving_system = driving_system #구동방식을 담을 수 있는 변수
        self.sound = sound #엔진 소리를 담을 수 있는 변수
        # 각각 인자로 넘겨받은 값을 할당받는다

    # 인스턴스 메서드: drive
    def drive(self):
        print(self.sound) #호출 시 인스턴스가 가진 고유 sound 출력
        return self.engine #인스턴스가 가진 엔진 반환

    # 인스턴스 메서드: introduce
    def introduce(self): #호출 시 인스턴스 엔진 종류, 구동 방식 소개하는 문자열 출력
        print(f"제 차의 엔진은 {self.engine} 방식이고, {self.driving_system} (으)로 동작합니다.")

    # 클래스 메서드: increase_wheels
    #모든 자동차의 바퀴 수를 1 증가시킨다
    @classmethod
    def increase_wheels(cls):
        cls.wheels += 1 #호출 될 때마다 클래스변수가 1 증가함
        print('법이 개정되어 모든 자동차의 필요 바퀴 수가 1증가하였습니다.')

    # 스태틱 메서드: description
    @staticmethod #자동차에 대한 설명을 출력하는 스태틱메서드
    def description(): 
        print("자동차(自動車, 영어: car, automobile)는 엔진에서 만든 동력을 바퀴에 전달하여 지상에서 승객이나 화물을 운반하는 교통 수단이다.")


car1 = Car('gasoline', '후륜구동', '부릉부릉')
car2 = Car('diesel', '전륜구동', '달달달달')
car3 = Car('hybrid', '4wd', '슈웅')

car1.drive()
print(car2.drive())

print('===')
car1.introduce()
car3.introduce()

print('===')
print(f'이 세상의 자동차는 {Car.wheels}개의 바퀴를 가집니다.')
Car.increase_wheels()
print(f'이 세상의 자동차는 {Car.wheels}개의 바퀴를 가집니다.')

Car.description()