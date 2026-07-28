class Animal:
    num_of_animal = 0

    def __init__(self):
        Animal.num_of_animal += 1


class Dog(Animal):
    sound = '멍멍'

    def bark(self):
        print('멍멍!')


class Cat(Animal):
    sound = '야옹'

    def meow(self):
        print('야옹!')


# 1. Dog 클래스를 우선 상속하였을 경우
class Pet(Dog, Cat):
    def __str__(self):
        return f"애완동물은 {self.sound} 소리를 냅니다."


pet1 = Pet()
print(pet1)

print('---')

# 2. Cat 클래스를 우선 상속하였을 경우
class Pet(Cat, Dog):
    def __str__(self):
        return f"애완동물은 {self.sound} 소리를 냅니다."


pet2 = Pet()
print(pet2)