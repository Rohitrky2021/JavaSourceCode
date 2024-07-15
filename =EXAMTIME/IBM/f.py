import json

def json_diff(json_str1, json_str2):
    # Parse JSON strings into Python objects
    obj1 = json.loads(json_str1)
    obj2 = json.loads(json_str2)

    # Find the keys that are unique to each object
    keys_only_in_obj1 = set(obj1.keys()) - set(obj2.keys())
    keys_only_in_obj2 = set(obj2.keys()) - set(obj1.keys())

    # Find the differences in values for common keys
    value_diff = {}
    for key in obj1.keys() & obj2.keys():
        if obj1[key] != obj2[key]:
            value_diff[key] = (obj1[key], obj2[key])

    return {
        'keys_only_in_obj1': list(keys_only_in_obj1),
        'keys_only_in_obj2': list(keys_only_in_obj2),
        'value_diff': value_diff
    }

# Example usage
json_str1 = '{"name": "John", "age": 30, "city": "New York"}'
json_str2 = '{"name": "Jane", "age": 25, "country": "Canada"}'

result = json_diff(json_str1, json_str2)
print(result)
