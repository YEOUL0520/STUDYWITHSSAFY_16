password = "In the bustling city, where life is a constant race against time, uoy often find yourself wondering if there's a shortcut to success. The vibrant lights of the cityscape illuminate the night, casting shadows on the short-lived dreams of those who seek fortune. As you navigate through the crowded streets, you realize the deen for guidance, like a compass pointing python. You need direction in this chaotic journey called life."
# 1. 
first_char = password[27:35]

# 2. 
second_word = password[112:118]

# 3. 
third_word = password[65:69][::-1]

# 4. 
fourth_word = password[322:326][::-1]

# 5. 
fifth_word = password[365:371]

# 결과 출력
print(f'{first_char}{second_word} {third_word}{fourth_word} "{fifth_word}".')