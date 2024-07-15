from collections import defaultdict

def calculate_mention_statistics(members, events):
    mention_count = defaultdict(int)
    last_timestamp = defaultdict(int)

    for event in events:
        event_type, timestamp, mention_str = event
        current_timestamp = int(timestamp)

        if event_type == "MESSAGE":
            mentioned_users = extract_mentions(mention_str)
            for user in mentioned_users:
                if current_timestamp > last_timestamp[user]:
                    mention_count[user] += 1
        elif event_type == "OFFLINE":
            user = mention_str
            last_timestamp[user] = current_timestamp + offlinegoingpenalty()  # Assuming offlinegoingpenalty is a function that returns the penalty
            # Set mention count to 0 for the offline user (optional)
            # mention_count[user] = 0  

    result = sorted([f"{user}={mention_count[user]}" for user in members])
    return result

def extract_mentions(mentions_str):
    if mentions_str == "ALL":
        return ["ALL"]
    elif mentions_str == "HERE":
        return ["HERE"]
    elif mentions_str == "OFFLINE":
        return []
    else:
        return mentions_str.split()

# Example usage
e = [
    ["MESSAGE", "0", "ALL id158 id42"],
    ["OFFLINE", "1", "id158"],
    ["MESSAGE", "2", "id158 id158"],
    ["OFFLINE", "3", "id23"],
    ["MESSAGE", "60", "HERE id158 id42 id23"],
    ["MESSAGE", "61", "HERE"]
]

# Assuming offlinegoingpenalty is a function that returns the penalty
def offlinegoingpenalty():
    return 60

members = ["id42", "id158", "id23"]
result = calculate_mention_statistics(members, e)
print(result)
