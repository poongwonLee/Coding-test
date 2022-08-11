a=[]
for i in range(0,9):
    a.append(int(input()))


a.sort()         

       
for i in range(0,9):
    for j in range(1+i,9):
        if(i!=j and (sum(a)-a[i]-a[j])==100):
            for k in range(9):
                if i!=k and j!=k:
                    print(a[k])
            exit()
