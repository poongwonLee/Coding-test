
while True:
    ans=0
    len=0
    try:
        n = int(input())
    except EOFError:
        break
    if n == 1:
        print('1')
        continue
    while(True):

        ans=ans*10 +1
        len+=1
        if( ans % n==0):
            print(len)
            break
        else:
            ans%=n
