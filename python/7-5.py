'''동빈이네 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다. 
어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다. 동빈이는 손님이 문의한 부품 M개 종류를 모두 확인해서
견적서를 작성해야 한다. 이 때 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성하라

입력 조건
- 첫째 줄에는 정수 N이 주어진다.
- 둘째 줄에는 공백으로 구분하여 N개의 정수가 주어진다. 이때 정수는 1보다 크고 1,000,000 이하이다.
- 셋째 줄에는 정수 M이 주어진다.
- 넷째 줄에는 공백으로 구분하여 M개의 정수가 주어진다. 이 때 정수는 1보다 크고 1,000,000 이하이다.

출력 조건
- 첫째 줄에 공백으로 구분하여 각 부품이 존재하면 yes를, 없으면 no를 출력한다.'''
def binary_Search(array,target,start,end):
    if start>end:
        return None
    mid = (start+end)//2

    if array[mid] == target :
        return mid
    
    elif array[mid] > target :
        return binary_Search(array,target,start,mid-1)

    else:
        return binary_Search(array,target,mid+1,end)
    return None

n = int(input())
array = list(map(int, input().split()))
array.sort()

m = int(input())
x = list(map(int, input().split()))


for i in x:
    result = binary_Search(array,i,0,n-1)
    if result != None :
        print("yes", end=' ')
    else:
        print("no", end=' ')