nums = [12, 45, 7, 23, 56, 89, 34]
#정렬
#sorted(): 내장함수, 정렬된 리스트 반환, 원본은 바뀌지 않음
# list.sort() : 메서드, 반환값 없음, 원본이 바뀜

sorted_nums = sorted(nums)
print(sorted_nums)
print(nums)

result = nums.sort () #원래는 result 안 쓰고 그냥 nums.sort 만 씀
print(result) #None
print(nums)

#append는 뒤에 붙이기, pop은 맨 뒷 요소 제거

