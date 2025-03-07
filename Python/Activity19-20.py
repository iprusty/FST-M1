import pandas as pd
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}


df = pd.DataFrame(data)


# Write the dataframe to a Excel file
writer = ExcelWriter('sample.xlsx')
df.to_excel(writer, 'Sheet1', index = False)

# Commit data to the Excel file
writer.close()

input_data = pd.read_excel("sample.xlsx")
print("Number of rows:",input_data.shape[0])
print("Number of columns:",input_data.shape[1])
print(input_data["Email"])
print(input_data.sort_values("FirstName"))