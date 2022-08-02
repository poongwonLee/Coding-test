def solution(id_list, report, k):
    report = set(report)
    answer = []
    temp = {}
    
    for i in id_list:
        temp[i] = 0
    
    temp2 = temp.copy()
    for line in report:
        a, b = line.split(' ')
        temp[b] += 1
    
    
    for key, val in temp.items():
        if val >= k:
            answer.append(key)
            
    for line in report:
        a, b = line.split()
        if b in answer:
            temp2[a] += 1
    
    return list(temp2.values())