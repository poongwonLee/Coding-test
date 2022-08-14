def solution(s):
    answer = ''
    
    for i in s.split(" "):
        if i=="":
            answer+=' '
        else:
            answer+=i[0].upper()+i[1:].lower()+" "
    return answer[:-1]