public class Winnercode {
    
}
def process_logs(logs):
    branches = {}
    current_branch = "main"

    for log in logs:
        action, *args = log.split()

        if action == "switch":
            
            current_branch = args[0]

        elif action == "push":
            file_name = args[0]

            
            if current_branch not in branches:
                branches[current_branch] = set()

            branches[current_branch].add(file_name)

    
    max_branch = max(branches, key=lambda branch: len(branches[branch]))

    return max_branch