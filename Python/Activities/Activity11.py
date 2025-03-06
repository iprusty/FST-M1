fruit_shop = {"apple" : 10,"kiwi": 15,"banana": 12,"orange" :8}

check = input("what are you looking for? ").lower()

if(check in fruit_shop):
  print("yes, this is available")
else :
    print("no, this is not available")