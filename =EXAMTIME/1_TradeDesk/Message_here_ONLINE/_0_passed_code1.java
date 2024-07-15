public class _0_passed_code1 {
    
}
from collections import defaultdict

def calculate_mention_statistics(members, events):
    mention_count = defaultdict(int)

    for event in events:
        if event[0] == "MESSAGE":
            mentioned_users = extract_mentions(event[2])
            for user in mentioned_users:
                mention_count[user] += 1

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