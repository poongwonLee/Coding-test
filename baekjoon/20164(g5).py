import sys
input = sys.stdin.readline
sys.setrecursionlimit(200000)
si=sys.stdin.readline
def dfs(n,cnt):
    global MAX,MIN
    for i in n:
        if int(i)%2==1: cnt+=1
    if len(n)==2:
        dfs(str( int(n[0]) + int(n[1]) ),cnt)
    elif len(n)==1:
        MAX=max(MAX,cnt)
        MIN=min(MIN,cnt)
    else:
        for i in range(1,len(n)-1):
            for j in range(i+1,len(n)):
                dfs(str(int(n[0:i]) + int(n[i:j]) +int(n[j:])) ,cnt)


n=si().strip()

MAX=0
MIN=1000000000000
dfs(n,0)
print(MIN,MAX)
