def check_number():
    try:
        number = float(input())
        if number > 0:
            print('양수입니다.')
        elif number < 0:
            print('음수입니다.')
        else:
            print('0입니다.')
    except ValueError:
        print('잘못된 입력입니다. 숫자를 입력해주세요.')


check_number()