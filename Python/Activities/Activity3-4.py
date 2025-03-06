while(True):
     user1 = input("player 1, Enter rock/paper/secessiors: ").lower()
     user2 = input("player 2, Enter rock/paper/secessiors: ").lower()


    if user1 == user2:
       print("it is tie")
    elif (user1 == 'rock'):
    if (user2 == 'scissors'):
        print("player 1 wins!")
    print("rock will win")
    else:
        print("player 2 wins!")
    elif (user1 == 'paper'):
    if (user2 == 'rock'):
        print("player 1 win!")
        else:
            print("player 2 wins!")
    elif (user1 == 'scissors'):
        if (user2 == 'paper'):
     print("player 1 win!")
        else:
        print("player 2 win!")
       
   replay = input("continue ? Y/N")
    if replay == 'Y' or replay == 'N'
    else:
    print("Thank you for playing")
    raise SystemExit
    