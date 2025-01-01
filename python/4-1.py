x,y = 1,1
move_type =['L','R','U','D']
dx = [0,0,-1,1]
dy = [-1,1,0,0]

N=int(input())
plans =input().split()

for plan in plans:
    for i in range(len(move_type)):
        if plan == move_type[i] :
            nx = x + dx[i]
            ny = y + dy[i]
        
    if nx < 1 or nx > N or ny < 1 or ny > N :
        continue
    #x,y를 계속하여 수정해주어야한다. nx와 ny 는 계속하여 초기화 되고 있으므로 x,y = nx,ny 문장을 바깥 for문에서 plan이 바뀌기 전에 수정해주는 것이다.
    x,y = nx, ny
print(x,y)