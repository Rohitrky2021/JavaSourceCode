def solve(initial, deltas):
    health = initial
    for d in deltas:
        health += d
        health = max(0, min(health, 100))
    return health

# Example usage:
initial = 12
deltas = [-4, -12, 6, 2]

result = solve(initial, deltas)
print(result)
