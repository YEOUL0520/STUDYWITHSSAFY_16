T = int(input())

for t in range(1, T + 1):
    N = int(input())
    
    if N % 2 == 0:
        print("#{} Alice".format(t))
    else:
        print("#{} Bob".format(t))