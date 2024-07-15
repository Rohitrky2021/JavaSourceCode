// https://t.me/codingsolns/98433

from datetime import datetime

def wait_for_bus(schedule, current_time):
    current_datetime = datetime.strptime(current_time, "%H:%M")

    for bus_time in schedule:
        bus_datetime = datetime.strptime(bus_time, "%H:%M")

        if bus_datetime >= current_datetime:
            time_difference = bus_datetime - current_datetime
            return str(time_difference)

    return "-1"