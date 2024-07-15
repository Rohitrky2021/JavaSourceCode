# # def exam(v):
# #      v = v + '4'
# #       v = v * 2
# #      return v

# # result = exam("jump")
# # print(result)


# # def is_sorted(arr):
# #     for i in range(len(arr) - 1):
# #         if arr[i] > arr[i + 1]:
# #             return False
# #     return True

# # # Example usage:
# # my_array = [1, 2, 3, 4, 5]
# # if is_sorted(my_array):
# #     print("The array is sorted.")
# # else:
# #     print("The array is not sorted.")

# import pandas as pd

# def saleOrder(df):
#     # Create a new DataFrame to store the counts of goods received and sold for each size and month
#     counts_df = pd.DataFrame(columns=['date_added', 'size', 'received', 'sold'])
    
#     # Iterate through the rows of the input DataFrame
#     for index, row in df.iterrows():
#         date_added = row['date_added']
#         sizes = row['sizes'].split('/')
#         for size in sizes:
#             # Check if the row corresponds to a 'Received' or 'Sold' item
#             if row['type'] == 'Received':
#                 # Increment the count of goods received for the size and month
#                 counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'received'] = counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'received'].add(1, fill_value=0)
#             else:
#                 # Increment the count of goods sold for the size and month
#                 counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'sold'] = counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'sold'].add(1, fill_value=0)
    
#     # Check if the number of goods received is greater than or equal to the number of goods sold for each size and month
#     counts_df['possible'] = counts_df['received'] >= counts_df['sold']
    
#     # Check if all rows in each month are possible and return the result
#     result = counts_df.groupby('date_added')['possible'].all()
    
#     if result.all():
#         return "Possible"
#     else:
#         return "Not Possible"

# Sample input DataFrame
data = {
    'id': [5763, 5731, 9159, 8804],
    'date_added': ['2015-08', '2015-08', '2015-08', '2017-11'],
    'type': ['Received', 'Sold', 'Received', 'Received'],
    'sizes': ['35/36/37/38/39/40', '36/37/38/39/40/41', '41/42', '5/6/7/8/9/10/11']
}



# # Call the function with the sample input
# print(saleOrder(df))
# # df))

import pandas as pd

def saleOrder(df):
    counts_df = pd.DataFrame(columns=['date_added', 'size', 'received', 'sold', 'possible'])
    
    for index, row in df.iterrows():
        date_added = row['date_added']
        sizes = row['sizes'].split('/')
        for size in sizes:
            if row['type'] == 'Received':
                counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'received'] = counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'received'].add(1, fill_value=0)
            else:
                counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'sold'] = counts_df.loc[(counts_df['date_added'] == date_added) & (counts_df['size'] == size), 'sold'].add(1, fill_value=0)
    
    counts_df['possible'] = counts_df['received'] >= counts_df['sold']
    
    result = counts_df.groupby('date_added')['possible'].all()
    
    return "Possible" if result.all() else "Not Possible"



df = pd.DataFrame(data)

print(saleOrder(df))