class Animal:
    num_of_animal = 0

    def __init__(self):
        Animal.num_of_animal += 1


class Dog(Animal):
    pass


class Cat(Animal):
    pass


class Pet(Dog, Cat):
    @classmethod
    def access_num_of_animal(cls):
        return Animal.num_of_animal


dog = Dog()
print(Pet.access_num_of_animal())
cat = Cat()
print(Pet.access_num_of_animal())