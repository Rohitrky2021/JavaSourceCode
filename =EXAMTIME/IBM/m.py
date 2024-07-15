import json

def find_keys_with_different_values(s1, s2):
    map1 =  json.loads(s1)
    map2 =  json.loads(s2)
    ans = []

    for key in map1.keys():
        if key in map2 and map1[key] != map2[key]:
            ans.append(key)

    return ans
 
# Example usage
s1 = '{"key1":"value1","key2":"value2","key3":"value3"}'
s2 = '{"key1":"value1","key2":"valueX","key3":"valueZ"}'

result = find_keys_with_different_values(s1, s2)
print(result)
