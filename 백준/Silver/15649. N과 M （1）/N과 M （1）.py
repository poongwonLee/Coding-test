def dfs(v):
    global n,m,res,a
    if v==m:
        for i in range(0,m):
            print(res[i],end=' ')
        print()    
    else:
        for i in range(1,n+1):
            if ch[i]==0:
                res[v]=a[i]
                ch[i]=1
                dfs(v+1)
                ch[i]=0     
    
n,m=map(int,input().split())
ch=[0]*(n+1)
res=[0]*(n+1)
a=[i for i in range(0,n+1)]
dfs(0)