#append는 뒤에 붙이기, pop은 맨 뒷 요소 제거
nums = []
nums.append(100)
print(nums) #[100]
nums.append(50)
print(nums) #[100, 50]

nums.append(1)
nums.append(2)
nums.append(3)
nums.append(4)
nums.append(5)
print(nums)

num = nums.pop() # 맨 마지막 요소 제거 및 반환
print(num)
print(nums)

num = nums.pop(0)
print(nums)

num = nums.pop(-2)
print(nums)