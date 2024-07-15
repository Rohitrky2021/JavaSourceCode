from datetime import datetime
# Tested WOrking 
def wait_for_bus(schedule, current_time):
    curr = datetime.strptime(current_time, "%H:%M")

    times = [datetime.strptime(t, "%H:%M") for t in schedule]
    pasts = [t for t in times if t < curr]

    if not pasts:
        return -1

    last = max(pasts)

    diff = (curr - last).total_seconds() / 60

    return int(diff)

# Example usage:
schedule = ["12:30", "14:00", "19:55"]
current_time = "14:30"
result = wait_for_bus(schedule, current_time)
print(result)
