# import requests
# from pprint import pprint as print

# # 빈 dummy_data 리스트 생성
# dummy_data = []

# # 1부터 10까지 총 10명의 데이터를 반복문으로 요청
# for i in range(1, 11):
#     # 무작위 유저 정보 요청 경로 (유저 ID를 1부터 10까지 동적으로 생성)
#     API_URL = f'https://jsonplaceholder.typicode.com/users/{i}'
    
#     # API 요청
#     response = requests.get(API_URL)
    
#     # JSON -> dict 데이터 변환
#     parsed_data = response.json()
    
#     # 사용자의 name을 추출하여 dummy_data 리스트에 추가
#     name = parsed_data['name']
#     dummy_data.append(name)

# # 결과 확인
# print(dummy_data)

import requests
from pprint import pprint as print

# 무작위 유저 정보 요청 경로
API_URL = 'https://jsonplaceholder.typicode.com/users/1'
# API 요청
response = requests.get(API_URL)
# JSON -> dict 데이터 변환
parsed_data = response.json()

# --- 이 아래부터 코드 작성 ---
dummy_data = []
dummy_data.append(parsed_data['name'])

for i in range(2, 11):
    response = requests.get(f'https://jsonplaceholder.typicode.com/users/{i}')
    dummy_data.append(response.json()['name'])

print(dummy_data)