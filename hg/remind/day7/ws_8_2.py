class Animal:
    num_of_animal = 0

    def __init__(self):
        Animal.num_of_animal += 1


class Dog(Animal):
    def bark(self):
        print('멍멍!')


dog1 = Dog()
dog1.bark()