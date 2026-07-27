# 아래 클래스를 수정하시오.
class StringRepeater:
    def repeat_string(self, count, text):
        for i in range(count): #여기서 공백(언더바)은 인덱스 무
            print(text)


repeater1 = StringRepeater()
repeater1.repeat_string(3, "Hello")