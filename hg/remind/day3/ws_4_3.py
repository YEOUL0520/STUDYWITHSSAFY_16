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

# dummy_data 출력
print(dummy_data)