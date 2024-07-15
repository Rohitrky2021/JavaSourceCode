import requests

def get_vote_count(city_name, estimated_cost):
    try:
        # Construct the URL for the GET request
        url = f"https://jsonmock.hackerrank.com/api/food_outlets?city={city_name}&estimated_cost={estimated_cost}"

        # Send GET request
        response = requests.get(url)

        # Check if request was successful
        if response.status_code != 200:
            print("Error:", response.status_code)
            return -1

        # Parse the JSON response
        data = response.json()

        # Check if there are any data entries
        if len(data["data"]) == 0:
            return -1

        # Calculate the total votes
        total_votes = sum(outlet["user_rating"]["votes"] for outlet in data["data"])

        return total_votes
    except Exception as e:
        print("Exception:", e)
        return -1

if __name__ == "__main__":
    # Example usage
    city_name = "Delaware"
    estimated_cost = 150
    vote_count = get_vote_count(city_name, estimated_cost)
    print("Total votes:", vote_count)
