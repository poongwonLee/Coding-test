n=int(input())                  #공간 크기 입력
c=list(map(str,input().split())) #이동 계획서 입력
a=b=1
mo={'L':0,'R':1,'U':2,'D':3}    #딕셔너리로 표현
dx=[-1,1,0,0]
dy=[0,0,-1,1]
for i in c:             #이동 계획서 만큼 반복
    if 1<=a+dx[mo[i]]<=n and 1<=b+dy[mo[i]]<=n: #더한뒤 범위 안에 있으면 실행
        a+=dx[mo[i]]
        b+=dy[mo[i]]
print(b,a)#결과 출력
