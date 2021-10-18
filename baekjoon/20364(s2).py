import sys
from collections import deque
si = sys.stdin.readline

n,m=map(int,si().split())

arr=[0]*(n+1)

def func(v):
    global tmp
    if(arr[v] == 1):
        tmp=v
    if v == 1 :return 1

    return func(v//2)

for i in range(m):
    tmp=0
    k=int(si())
    
    func(k)
    if not tmp:
        arr[k]=1
    print(tmp)
