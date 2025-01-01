def binary_search(array, target, start, end):
    if start>end:
        return None
    mid = (start + end) // 2

    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    else:
        return binary_search(array,target,mid+1,end)
    

n,target = list(map(int, input().split())) #list를 통해 받는 이유는 map 객체는 리스트가 아니기 때문에 인덱스를 통해 접근할 수 없다.
array = list(map(int, input().split()))

result = binary_search(array,target,0,n-1)
if result == None:
    print("원소가 존재하지 않습니다.")
else:
    print(result +1)