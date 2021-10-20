import sys
from collections import deque
sys.setrecursionlimit(100005)
si = sys.stdin.readline

n,m=map(int,(si().split()))
arr=[]
for i in range(n):
    arr.append(int(si()))
arr.sort()
r=0
res=1<<31
for i in range(n):
    while r+1 < n and arr[r]-arr[i] < m:
        r+=1

    if arr[r]-arr[i]>=m:
        res=min(arr[r]-arr[i],res)
print(res)
