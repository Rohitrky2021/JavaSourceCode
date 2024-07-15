def solve(logs): 
    branches = {}
    current_branch = "main"

    for log in logs:
        action, *args = log.split()

        if action == "switch":
            current_branch = args[0]
        elif action == "push":
            branches.setdefault(current_branch, set()).add(args[0])

    max_branch = max(branches, key=lambda branch: len(branches[branch]), default="main")
    return max_branch

# Example usage:
# this and WQinner Both tested Write any 
input_list = ["switch branch1",
               "push file1",
                 "push file2",
                 "push file1",
                   "switch branch2",
                     "switch issue2", 
                     "push file1",
                       "push file2", 
                       "push file3"]
result = solve(input_list)
print(result)
