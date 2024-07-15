public class code {
    
}
// https://t.me/oahelpchannels/229


def first_day(visits, target):
    total_visits = 0
    for i, daily_visits in enumerate(visits):
        total_visits += daily_visits
        if total_visits >= target:
            return i
    return -1