t = int(input())

for _ in range(t):
    quiz = input()
    score = 0
    narrow = 0

    for char in quiz:
        if char == 'O':
            narrow += 1
            score += narrow
        else:
            narrow = 0

    print(score)
