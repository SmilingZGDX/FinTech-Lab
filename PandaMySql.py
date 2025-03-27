import mysql.connector
import pandas as pd

# Step 1: Connect to MySQL Database
connection = mysql.connector.connect(
    host='localhost',
    user='root',
    password='hum006mysql',
    database='lab5s'
)
cursor = connection.cursor()

# Step 2: Fetch Data from Table
query = "SELECT * FROM customer_name"
cursor.execute(query)
rows = cursor.fetchall()

# Step 3: Get Column Names
columns = [desc[0] for desc in cursor.description]

# Step 4: Convert Data to Pandas DataFrame
df = pd.DataFrame(rows, columns=columns)

# Step 5: Export Data to CSV File
df.to_csv('customer_name_report.csv', index=False)
print("Data exported successfully to output.csv")

# Step 6: Close Database Connection
cursor.close()
connection.close()
