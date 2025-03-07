# import pandas
import pandas as pd

# Create a dictionary to hold our data
data = {
  "X": [1, 2, 3, 4, 5],
  "Y": [9, 8, 7, 6, 5],
  "Z": [10, 12, 8, 4, 3]
}

# Create a new DataFrame using our dictionary
table = pd.DataFrame(data)

# Print the DataFrame
print(table)
print(table["Z"][1])