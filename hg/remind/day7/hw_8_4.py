class UserInfo:
    def __init__(self):
        self.user_data = {}

    def get_user_info(self):
        """
        사용자로부터 이름과 나이를 입력받습니다.
        - 이름이 없거나 공백이면 None을 반환합니다.
        - 나이가 숫자가 아니거나 입력되지 않으면 ValueError를 처리하고 False를 반환합니다.
        - 올바르게 입력되면 사용자 정보를 저장하고 True를 반환합니다.
        """
        name = input("이름을 입력하세요: ").strip()
        if not name:
            return None
        
        try:
            age_input = input("나이를 입력하세요: ")
            age = int(age_input)
        except ValueError:
            print("나이는 숫자로 입력해야 합니다.")
            return False
        
        self.user_data['name'] = name
        self.user_data['age'] = age
        return True

    def display_user_info(self):
        """
        저장된 사용자 정보를 출력합니다.
        - 정보가 없으면 "사용자 정보가 입력되지 않았습니다."를 출력합니다.
        """
        if not self.user_data:
            print("사용자 정보가 입력되지 않았습니다.")
        else:
            print(f"이름: {self.user_data['name']}, 나이: {self.user_data['age']}")


# 아래 코드는 수정하지 마세요.
user = UserInfo()
result = user.get_user_info()

if result is True:
    user.display_user_info()
elif result is None:
    # 이름이 입력되지 않은 경우, display_user_info()가 적절한 메시지를 출력해야 합니다.
    user.display_user_info()
# 나이가 잘못 입력된 경우 (result is False), get_user_info()에서 이미 메시지를 출력했으므로
# 추가적인 동작이 필요 없습니다.