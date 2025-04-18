'''8x8 평면 체스판이 있다. 나이트는 L자 형태로만 이동할 수 있으며, 정원 밖으로는 이동 할 수 없다.
나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
8x8 좌표 평면상에서 나이트의 위치가 주어졌을 때, 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
이 때, 왕실의 정원에서 행 위치를 표현할 때는 1~8로 표현하며, 열 위치를 표현할 때는 a부터 h로 표현한다.

입력  예시
a1
출력 예시
2'''
input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0]))- int(ord('a')) + 1

result = 0

step_type = [(-2,-1),(-2,1),(2,-1),(2,1),(-1,-2),(-1,2),(1,-2),(1,2)]

for step in step_type:
    c_row = row + step[0]
    c_column = column + step[1]

    if 8>=c_row>=1 and 8>=c_column>=1 :
        result +=1

print(result)

# 이동하는 경우의 수는 이동해야하는 것의 step을 경우의 수로 계산한다!