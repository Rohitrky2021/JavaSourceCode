public class code {
    
}

def solution(rates, strategy, k):
    n = len(rates)
    max_profit = float('-inf')

    for i in range(n - k + 1):
        current_strategy = strategy.copy()
        for j in range(k // 2):
            current_strategy[i + j] = 0
            current_strategy[i + k // 2 + j] = 1

        profit = calculate_profit(rates, current_strategy)
        max_profit = max(max_profit, profit)

    return max_profit

def calculate_profit(rates, strategy):
    bought_price = 0
    total_profit = 0

    for i in range(len(strategy)):
        if strategy[i] == -1:
            bought_price += rates[i]
        elif strategy[i] == 1:
            total_profit += rates[i] - bought_price
            bought_price = 0

    return total_profit

Autodesk ✅