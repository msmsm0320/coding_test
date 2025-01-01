array = [7, 5, 9, 0, 3, 1,6,2,4,8]

for i in range(len(array)):
    min_idex= i
    #최솟값이 있는 index를 찾아서 지정해야하는 index 위치에 넣는 것(ex : 1번자리 확정 후 2번자리 ~~ 바놉ㄱ)
    for j in range(i+1, len(array)):
        if array[min_idex] > array[j]:
            min_idex = j
    array[i], array[min_idex] = array[min_idex], array[i]

print(array)