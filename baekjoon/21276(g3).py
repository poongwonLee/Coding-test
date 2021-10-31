from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline

n=int(si())
tmp=list(map(str,(si().split())))
tmp.sort()
name_dict={}
for i in range(len(tmp)):
    name_dict[tmp[i]]=i


arr=[[] for i in range(n)]
ch=[0]*n
q=deque()

m=int(si())
for i in range(m):
    y,x=map(str,si().split())
    arr[name_dict[x]].append(name_dict[y])
    ch[name_dict[y]]+=1

res=[]
res_list=[[] for i in range(n)]
for i in range(n):
    if(ch[i]==0):
        q.append(tmp[i])
        res.append(tmp[i])
while q:
    x=q.popleft()
    for i in arr[name_dict[x]]:
        ch[i]-=1
        if(ch[i]==0):
            res_list[name_dict[x]].append(i)
            q.append(tmp[i])
print(len(res))
print(*sorted(res))

for i in (res_list):
    i.sort()

for i in range(len(res_list)):
    print(tmp[i],len(res_list[i]),end=" ")
    
    for i in res_list[i]:
        print(tmp[i],end=" ")
    print()

