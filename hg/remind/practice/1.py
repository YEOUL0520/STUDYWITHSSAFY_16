nums = [12, 45, 7, 23, 56, 89, 34]
#최소값과 최대값 찾기
#리스트 요소 접근하기
#반복문으로 접근 가느
for num in nums:
    print(num, end=' ')
print()

for i in range(len(nums)):
    print(nums[i], end=' ')
print()

max_num = 0
min_num = 654821
for i in range(len(nums)):
    #print (nums[i], end=' ')
    if max_num < nums[i]:
        max_num = nums[i]
    

print(max_num)

for i in range(len(nums)):
    if min_num > nums[i]:
        min_num = nums[i]

print(min_num)
