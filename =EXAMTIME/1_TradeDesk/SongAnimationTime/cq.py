def solve(s, a):
    r = []
    for song in s:
        sn, sl = song.split(':')
        sl = int(sl)

        for anim in a:
            an, al = anim.split(':')
            al = int(al)

            if sl % al == 0:
                r.append(f"{an}:{sl // al}")
                break

    return r

# Example usage
s = ["notion:180", "voyage:185", "sample:180"]
a = ["circles:360", "square:180", "lines:37"]

result = solve(s, a)

# Print the result
for res in result:
    print(res)
