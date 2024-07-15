costs = {
    'A': {'A': 'AB', 'B': 'AB', 'C': 'ABC'},
    'B': {'A': 'AB', 'B': 'AB', 'C': 'BC'},
    'C': {'A': 'ABC', 'B': 'BC', 'C': 'BC'}
}

start_city = 'Z'
dest_city = 'X'

city_names_A = ['X']
city_names_B = ['Z']
city_names_C = ['Y']

if start_city in city_names_A:
    start_city = 'A'
elif start_city in city_names_B:
    start_city = 'B'
elif start_city in city_names_C:
    start_city = 'C'

if dest_city in city_names_A:
    dest_city = 'A'
elif dest_city in city_names_B:
    dest_city = 'B'
elif dest_city in city_names_C:
    dest_city = 'C'

def calc_cost(costs, start, dest):
    if start not in costs or dest not in costs:
        return None
    return costs[start][dest]

cost = calc_cost(costs, start_city, dest_city)

if cost is not None:
    print(f"Cost from {start_city} to {dest_city}: {cost}")
else:
    print("Invalid input cities.")
