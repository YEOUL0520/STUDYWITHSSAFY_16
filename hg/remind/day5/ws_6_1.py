def union_sets(set1, set2):
    return set1 | set2

def union_multiple_sets(*sets):
    if len(sets) < 2:
        print("최소 두 개의 셋이 필요합니다")
        return
    
    result = set()
    for s in sets:
        result |= s
    return result


result = union_sets({1, 2, 3}, {3, 4, 5})
print(result)  # {1, 2, 3, 4, 5}

result = union_multiple_sets({1, 2}, {3, 4}, {5, 6})
print(result)  # {1, 2, 3, 4, 5, 6}

result = union_multiple_sets({1, 2})
# 출력 : 최소 두 개의 셋이 필요합니다