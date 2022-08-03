import sys

a,b=map(int,input().split())
arr = list(map(int, sys.stdin.readline().split()))
sum1=[0]
for i in range(a):
    sum1.append(sum1[i]+arr[i])
for i in range(b):
    x,y=map(int, sys.stdin.readline().split())
    print(sum1[y]-sum1[x-1])
