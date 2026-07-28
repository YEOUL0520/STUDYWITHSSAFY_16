# 아래 클래스를 수정하시오.
class Shape:
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def calculate_area(self):
        return self.width * self.height

    def calculate_perimeter(self):
        return (self.width + self.height) * 2

    def print_info(self):
        area = self.calculate_area()
        perimeter = self.calculate_perimeter()
        print(f"Width: {self.width}\nHeight: {self.height}\nArea: {area}\nPerimeter: {perimeter} \n")


shape1 = Shape(5, 3)
shape1.print_info()