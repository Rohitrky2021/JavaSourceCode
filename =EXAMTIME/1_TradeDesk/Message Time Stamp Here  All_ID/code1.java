public class code1 {
    
}


def solution(members, events):
    mention_count = defaultdict(int)

    for event in events:
        if event[0] == "MESSAGE":
            mentioned_users = extract_mentions(event[2])
            for user_id in mentioned_users:
                mention_count[user_id] += 1

  
    result = sorted([{user: mention_count[user]} for user in mention_count], key=lambda x: next(iter(x.values())), reverse=True)
    return result

    // https://t.me/codingsolns/98367