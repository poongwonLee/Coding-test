import heapq
import sys

n=int(input())
k=int(input())

q=[]

arr=[[] for i in range(n+1)]
ch=[2174000000]*(n+1)
for i in range(k):
    a,b,c=map(int,sys.stdin.readline().split())
    arr[a].append((b,c))

start,end=map(int,input().split())
ch[start]=0
heapq.heappush(q,(0,start))


while q:
    cost,now=heapq.heappop(q)
    if cost>ch[now]: continue
    for n,n_c in arr[now]:
        n_c+=cost
        if(ch[n]>n_c):
            ch[n]=n_c
            heapq.heappush(q,(n_c,n))

print(ch[end])
