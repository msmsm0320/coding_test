# 피보나치 수열 소스코드(재귀적)

# 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 리스트 초기화
d=[0] * 100

def fibo(x):
    if x == 1 or x == 2:
        return 1
    
    if d[x] != 0:
        return d[x]
    
    d[x] = fibo(x-1) + fibo(x-2)
    return d[x]

print(fibo(99))