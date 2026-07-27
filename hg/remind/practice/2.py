# 합 평균 구하기
nums = [12, 45, 7, 23, 56, 89, 34]
sum_v = 0
cnt = 0
for i in range(len(nums)):
    #nums[i]랑 sum_v랑 더해서 다시 sum_v에 저장하기
    sum_v = nums[i] + sum_v
    cnt +=1

print(sum_v)
print(sum_v/cnt)