n,m=map(int,input().split()) # n by m 행렬 입력
c=[]
max1=0          # 최대값 저장할 변수 0으로 초기화
for i in range(n):  #n행만큼 반복
    c.append(list(map(int,input().split())))    #n by m 행렬 입력
    min1=min(c[i])                              # c[i] i행 원소들의 최소값을 min1 에 저장
    max1=max(max1,min1)                         #max1에 각행의 최소값들과 비교해 최대값 저장
print(max1)                                     #max1 출력 결과.
