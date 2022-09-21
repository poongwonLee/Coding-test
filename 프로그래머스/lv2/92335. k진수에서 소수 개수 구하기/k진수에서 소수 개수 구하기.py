def solution(n, k):
    answer = 0
    print(func(n,k))
    re=func(n,k)
    i=0
    while i<len(re):
        if(re[i]!='0'):
            j=i
            num=""
            while j<len(re) and re[j]!='0':
                num+=re[j]
                j+=1
            print(num)
            if check(num): answer+=1
            i=j
        i+=1
    return answer
def func(n,k):
    ans=0
    while n>0:
        ans*=10
        ans+=n%k
        n//=k
    return str(ans)[::-1]

def check(n):
    n=int(n)
    if n<=1 : return False
    for i in range(2,int(n**0.5)+1):
        if( n % i == 0):
            return False;
    return True;