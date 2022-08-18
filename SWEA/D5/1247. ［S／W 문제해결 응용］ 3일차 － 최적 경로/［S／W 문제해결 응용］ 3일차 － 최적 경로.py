
m=int(input())
visit=[]
def dfs(v,n,x,y,dist):
    global visit,MAP,MIN
    if v==n:
        MIN=min(MIN, dist+abs(MAP[-1][0]-x) + abs(MAP[-1][1]-y))
    else:
        for i in range(n):
            if visit[i]==0 and dist+abs(MAP[i+1][0]-x)+abs(MAP[i+1][1]-y) < MIN:
                visit[i]=1
                dfs(v+1,n,MAP[i+1][0],MAP[i+1][1],dist+abs(MAP[i+1][0]-x)+abs(MAP[i+1][1]-y))
                visit[i]=0

for test in range(m):
    MIN=2100000000
    n=int(input())
    MAP=[]
    
    tmp=list(map(int,input().split()))
    MAP.append([tmp[2],tmp[3]])
    for i in range(4,len(tmp)-1,2):
        MAP.append([tmp[i],tmp[i+1]])
    MAP.append([tmp[0],tmp[1]])
    visit=[0]*(n)
    dfs(0,n,MAP[0][0],MAP[0][1],0)
    print("#%d %d"%(test+1,MIN))