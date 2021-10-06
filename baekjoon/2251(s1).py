from collections import deque

waterCan=list(map(int,input().split()))
visit=[[[0]*201 for _ in range(201) ] for i in range(201)]
res=[0]*201


# 용량이  8 9 10  현재 0 5 9
def func(cur,From,to):
   r=cur.copy()
   if(cur[From]+cur[to] <= waterCan[to]):
      r[to] +=r[From]
      r[From] =0
   else:
      r[From] -=(waterCan[to] -r[to])
      r[to]=waterCan[to]
   return r 
   
q=deque()
q.append([0,0,waterCan[2]])

visit[0][0][waterCan[2]]=1

while q:
   cur=q.popleft()
   
   if(cur[0]==0):
       res[cur[2]]=1
   for From in range(3):
      for to in range(3):
         if(From==to): continue
         curNext=func(cur,From,to)
         if(not visit[curNext[0]][curNext[1]][curNext[2]]):
            visit[curNext[0]][curNext[1]][curNext[2]]=1
            q.append([curNext[0],curNext[1],curNext[2]])

for i in range(201):
   if(res[i]):
      print(i,end= ' ')
