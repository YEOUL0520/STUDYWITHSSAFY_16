def intersection_sets(set1, set2):
    inter = set1 & set2
    if not inter:
        print("공통 요소가 없습니다")
    return (len(inter), inter)


result = intersection_sets({1, 2, 3}, {3, 4, 5})
print(result)  # (1, {3})

result = intersection_sets({1, 2}, {3, 4})
print(result)  # (0, set())
# 출력: 공통 요소가 없습니다