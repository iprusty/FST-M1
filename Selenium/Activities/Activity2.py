# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/login-form")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the username field
    username = driver.find_element(By.ID, "username")
    # Find the password field
    password = driver.find_element(By.ID, "password")

    # Enter the given credentials
    # Enter username
    username.send_keys("admin")
    # Enter password
    password.send_keys("password")

    # Find the login button
    login = driver.find_element(By.XPATH, "//button[text()='Submit']")
    login.click()

    # Print the login message
    message = driver.find_element(By.CSS_SELECTOR, "h1.text-center")
    print("Login message: ", message.text)