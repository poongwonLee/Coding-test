n=input()
dx=[-2,-1,1,2,2,1,-1,-2] #8가지의 경우를 입력 
dy=[1,2,2,1,-1,-2,-2,-1]
cnt=0
for i in range(8):
    if 1<=(ord(n[0])-96)+dx[i]<=8 and 1<=(int(n[1]))+dy[i]<=8:
        cnt+=1      # ord로 이용해 문자를 아스키코드로 변환후 -96하여 a~z를 1~26로 변환
print(cnt)          #dx dy에 저장한 나이트의 이동 경로 8개를 반복하여 row colum 범위 안에 있으면 cnt를 1증가