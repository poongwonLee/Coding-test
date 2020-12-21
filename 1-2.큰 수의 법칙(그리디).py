n,m,k=map(int,input().split())
arr=list(map(int,input().split()))
arr.sort(reverse=True) #큰 순으로 정렬

if arr[0]==arr[1]:     #가장 큰 값이 2개 일때
    print(arr[0]*m)
else:
    cnt=m//(k+1)       #k+1 수열로 반복 하기 때문에 m에 k+1를 나눈다
    print((m-cnt)*arr[0]+cnt*arr[1])
