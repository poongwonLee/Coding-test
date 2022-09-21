from collections import deque
def solution(queue1, queue2):
    answer = 0
    queue1=deque(queue1)
    queue2=deque(queue2)
    qsum1=sum(queue1)
    qsum2=sum(queue2)
  
    while qsum1!=qsum2:
        if( qsum1 > qsum2):
            qsum1-=queue1[0]
            qsum2+=queue1[0]
            queue2.append(queue1.popleft())
        else:
            qsum2-=queue2[0]
            qsum1+=queue2[0]
            queue1.append(queue2.popleft())
        answer+=1
        if answer>1000000: return -1
    print(qsum1)
    return answer