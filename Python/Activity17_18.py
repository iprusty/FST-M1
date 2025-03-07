# Import pandas
import pandas

# Create a Dictionary that will hold our data
data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

# Create a DataFrame using that data
dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("sample.csv", index=False)

# Read the data from csv file
input_data = pandas.read_csv("sample.csv")


# Print the values only in the Usernames column
print(input_data["usernames"]) # -> ["admin", "Charles", "Deku"],
# Print the username and password of the second row
print(input_data["usernames"][1])
print(input_data["password"][1])
# Sort the Usernames column data in ascending order and print data
print(input_data.sort_values("usernames"))
# Sort the Passwords column in descending order and print data
print(input_data.sort_values("usernames",ascending=False))
