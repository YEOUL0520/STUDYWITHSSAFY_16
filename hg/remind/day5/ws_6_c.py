data = [
    {
        'name': 'galxy flip',
        'company': 'samsung',
        'is_collapsible': True,
    },
    {
        'name': 'ipad',
        'is_collapsible': False
    },
    {
        'name': 'galxy fold',
        'company': 'samsung',
        'is_collapsible': True
    },
    {
        'name': 'galxy note',
        'company': 'samsung',
        'is_collapsible': False
    },
    {
        'name': 'optimus',
        'is_collapsible': False
    },
]

key_list = ['name', 'company', 'is_collapsible']

#아래에 코드를 작성하시오
# data를 순회
for item in data:
    # key_list를 순회
    for key in key_list:
        # setdefault 메서드를 사용하여 key가 없으면 'unkwnow'를 할당하고 그 값을 반환받음
        value = item.setdefault(key, 'unkwnow')
        print(f'{key} 은/는 {value}입니다.')