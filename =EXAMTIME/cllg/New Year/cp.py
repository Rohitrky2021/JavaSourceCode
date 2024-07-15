from itertools import combinations

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"({self.x},{self.y})"

def main():
    n = int(input())
    points = []

    for _ in range(n):
        x, y = map(int, input().split())
        points.append(Point(x, y))

    count = count_valid_groups(points)
    print(count)

check = set()

def count_valid_groups(points):
    count = 0
    valid_points_set = set()

    for trio in combinations(points, 3):
        p, q, r = trio
        if not is_valid_points_set_contains(valid_points_set, p, q, r) and not is_valid_points_set_contains(check, p, q, r):
            if is_midpoint(q, p, r):
                count += 1
                add_to_valid_points_set(valid_points_set, p, q, r)

    return count

def is_midpoint(q, p, r):
    return distance(p, r) == 2 * distance(q, r) and (q.y - p.y) * (r.x - q.x) == (r.y - q.y) * (q.x - p.x)

def distance(a, b):
    return ((a.x - b.x) ** 2 + (a.y - b.y) ** 2) ** 0.5

def is_valid_points_set_contains(valid_points_set, p, q, r):
    return trio_to_string(p, q, r) in valid_points_set

def add_to_valid_points_set(valid_points_set, p, q, r):
    valid_points_set.add(trio_to_string(p, q, r))
    check.add(trio_to_string(r, p, q))

def trio_to_string(p, q, r):
    return f"{p} {q} {r}"

if __name__ == "__main__":
    main()
