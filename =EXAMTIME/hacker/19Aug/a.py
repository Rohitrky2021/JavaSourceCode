def solve(N, people, starting, ending):
    # Create a list of (start, end, people) tuples
    meetings = [(starting[i], ending[i], people[i]) for i in range(N)]
    
    # Sort the meetings by their ending times (and by start time for tie-breaking)
    meetings.sort(key=lambda x: (x[1], x[0]))
    
    # Track the end time of the last meeting we scheduled
    last_end_time = -1
    total_people_who_can_meet = 0
    
    for start, end, num_people in meetings:
        if start > last_end_time:
            # Schedule this meeting
            last_end_time = end
            total_people_who_can_meet += num_people
    
    # Total number of people
    total_people = sum(people)
    
    # Calculate the minimum number of people who cannot meet
    people_who_cannot_meet = total_people - total_people_who_can_meet
    
    return people_who_cannot_meet

# Example usage:
N = 5
people = [4, 3, 5, 6, 10]
starting = [1, 2, 3, 6, 5]
ending = [1, 2, 5, 7, 7]
print(solve(N, people, starting, ending))  # Output should be 10
