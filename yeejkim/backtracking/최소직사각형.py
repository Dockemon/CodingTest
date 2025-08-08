def solution(sizes):
    
    rotated = [] 
    # 모든 명함을 가로 >= 세로가 되도록 정렬
    for w, h in sizes:
        rotated.append([max(w, h), min(w, h)])
		
		# 가장 긴 가로 및 세로 길이 찾기
    max_w = max(w for w, h in rotated)
    max_h = max(h for w, h in rotated)
    
    return max_w * max_h