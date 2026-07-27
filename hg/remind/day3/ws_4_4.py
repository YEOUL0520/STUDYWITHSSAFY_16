#4-3에서 가져온 거

import requests
from pprint import pprint as print

# 무작위 유저 정보 요청 경로
API_URL = 'https://jsonplaceholder.typicode.com/users/1'
# API 요청
response = requests.get(API_URL)
# JSON -> dict 데이터 변환
parsed_data = response.json()

# 빈 dummy_data 리스트 생성
dummy_data = []

# 1부터 10까지 총 10명의 데이터를 반복문으로 요청
for i in range(1, 11):
    url = f'https://jsonplaceholder.typicode.com/users/{i}'
    res = requests.get(url)
    data = res.json()
    
    # 위도, 경도는 문자열이므로 조건 비교를 위해 float로 변환
    lat = float(data['address']['geo']['lat'])
    lng = float(data['address']['geo']['lng'])
    
    # lat(위도)과 lng(경도)가 각각 80 미만, -80 초과인 경우
    if -80 < lat < 80 and -80 < lng < 80:
        user_dict = {
            'company': data['company']['name'],
            'lat': str(lat),
            'lng': str(lng),
            'name': data['name']
        }
        dummy_data.append(user_dict)

# 블랙리스트 정의
black_list = [
    'Hoeger LLC',
    'Keebler LLC',
    'Yost and Sons',
    'Johns Group',
    'Romaguera-Crona',
]


def create_user(user_list):
    censored_user_list = {}
    
    for user in user_list:
        company = user['company']
        name = user['name']
        
        # censorship 함수의 반환 값(True/False)을 기준으로 판단
        if censorship(company, name):
            if company not in censored_user_list:
                censored_user_list[company] = []
            censored_user_list[company].append(name)
            
    return censored_user_list

def censorship(company, name):
    # 회사 명이 black_list에 포함되어 있는지 확인
    if company in black_list:
        print(f'{company} 소속의 {name} 은/는 등록할 수 없습니다.')
        return False
    else:
        print('이상 없습니다.')
        return True

# create_user 함수 호출 및 결과 출력
result = create_user(dummy_data)
print(result)