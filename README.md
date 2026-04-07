# CS121_Final

## Algorithm
# Date
```
Date():
    day = 0
    month = 0
    year = 0

Day(int day, int month, int year):
    day = day
    month = month
    year = year

getStringDate():
    ArrayList<string> months = ["January, February, ... , December]
    int matchMonth = month - 1
    string stringMonth = months(matchMonth)
    String stringDate = monthString + " " + getDay() + ", " + getYear()
    returns stringDate
```

# Note
```
Note():
    content = "No notes"
```

# Work (abstract)
```
Work():
    pageLength = 0
    wordLength = 0

menu():
    Print "0) Exit editing menu"
    Print "1) Edit title"
    Print "2) Edit author"
    Print "3) Edit length"
    Print "4) Edit genre"
    Print "5) Edit date finished"
    Print "6) Add or edit note"
    Print "7) Add or edit rating"

    Print "Please input a number 0-7"
    take user input and put in string userChoice
    return userChoice    

start():
    boolean keepGoing = true;
    while keepGoing = true:
        userChoice = menu()
        if userChoice = 0:
            print "Exiting work menu"
            keepGoing = false
        if userChoice = 1:
            Print "Current title set to: " getTitle()
            Print "Enter new title: "
            Take input into newTitle
            setTitle(newTitle)
            call printWork for work
        if userChoice = 2:
            Print "Current author name set to: " getAuthor()
            Print "Enter new author name: "
            Take input into newAuthor
            setAuthor(newAuthor)
            call printWork for work
        if userChoice = 3:
            Print "Current genre set to: " getGenre()
            Print "Enter new genre: "
            Take input into newGenre
            setTitle(newGenre)
            call printWork for work
        if userChoice = 4:
            Print "Current word length: " getWordLength()
            Print "Current page length: " getpageLength()
            if type = "fanfic":
                Print "Enter new word length: "
                Take input into newLength
                call setWordLength(newLength) for work
                call convertLength() for work
            else:
                Print "Enter new page length : "
                Take input into newLength
                call setWordLength(newLength) for work
                call convertLength() for work
            call printWork for work
        if userChoice = 5:
            Print "Current date finished set to: " getStringDate() for dateFinished
            Print "Enter year finished: "
            Take input into newYear
            Print "Enter number of month finished (January = 1, February = 2): "
            Take input into newMonth
            Print "Enter day finished (the numerical day): "
            Take input into newDay
            setYear(newYear)
            setMonth(NewMonth)
            setDay(NewDay)
            call printWork for work
        if userChoice = 6:
            Print "Current note set to: " getContent() for note
            Print "Enter new note: "
            Take input into newNote
            setContent(newNote) for note
            call printWork for work
        if userChoice = 7:
            Print "Current rating set to: " getRating()
            Print "Enter new rating (on a scale of -5 to 5, 0 being neutral): "
            Take input into newRating
            setRating(newRating)
            call printWork for work

    printWork(): abstract
    convertLength(): abstract
```

# Book
```
printWork():
    Print "Title: " + Print "Current genre set to: " getGenre()
    Print "Author: " + getAuthor()
    Print "Type: " + getType()
    Print "Date Finished: " +  getDateFinished()
convertLength():
    int wordLength = getpagelength() * 300
    setWordLength(wordLength)
```

# Fanfic
```
printWork():
    Print "Title: " + Print "Current genre set to: " getGenre()
    Print "Author: " + getAuthor()
    Print "Type: " + getType()
    Print "Fandom: " + getFandom()
    Print "Ship: " + getShip()
    Print "Date Finished: " +  getDateFinished()
convertLength():
    double pageLength = getWordLength() / 300
    setPageLength(pageLength)
```

# Manga
```
printWork():
    Print "Title: " + Print "Current genre set to: " getGenre()
    Print "Author: " + getAuthor()
    Print "Type: " + getType()
    Print "Date Finished: " +  getDateFinished()
convertLength():
    int wordLength = getpagelength() * 100
    setWordLength(wordLength)
```

# Search
```
Search (ArrayList Works):
    searchList = Works

start():
    boolean keepGoing = true
    while keepGoing:
        choice = menu()
        if choice = 0:
            Print "Exiting search menu"
        if choice = 1:
            searchByTitle()
        if choice = 2:
            searchByAuthor()
        else:
            print "Please enter 0, 1, or 2"

menu():
    Print "0) Exit Search"
    Print "1) Search by title"
    Print "2) search by author"

    Print "Enter number of your choice: "
    taked input into string userChoice
    return userChoice    

clearSearchList():
    searchList.clear()

findWork(string enteredTitle):
    for work in Works:
        title = getTitle()
        if string = title:
            work.start()
        else:
            print "Work with title " enteredTitle "wasn't found."
            print "Try a search to find works or try print all works"
    FIGURE OUT IF THISLL ACTUALLY BE EFFECTIVE
searchByTitle():
    NEED TO FINISH
searchByAuthor():
    NEED TO FINISH
```

# BookShelf
```
Bookshelf():
    calls loadWorks()
    calls start()
    calls saveWorks()

start():
    boolean keepGoing = true
    while keepGoing:
        choice = menu()
        if choice = 0:
            print "Exiting Bookshelf menu"
            keepGoing = false
        if choice = 1:
            print "Add work..."
            addWork()
        if choice = 2:
            print "Enter title of work: "
            take input and put in string titleToMatch
            search.setSearchList(Works)
            search.findWork(titleToMatch)
            search.clearSearchList()
        if choice = 3:
            print "Search Menu"
            search.setSearchList(Works)
            search.start()
            search.clearSearchList()
        if choice = 4:
            print "All works: "
            printAll()
        if choice = 5:
            print "Printing summary..."
            printSummary()
        else:
            print "Please enter a number 0-5"

menu():
    print "0) Exit bookshelf menu"
    print "1) Add a work"
    print "2) Edit a work"
    print "3) Search for a work"
    print "4) Show all works"
    print "5) Print summary"
    
    takes user input into string called userChoice
    returns userChoice

loadWorks():
    NEED TO FINISH

saveWorks():
    NEED TO FINISH
    
addWork():
    print "Enter the following information:"
    
    boolean keepGoing = true
    while keepGoing:
        print "Type (Enter 0 for book, 1 for fanfic, and 2 for manga): "
        take user input into string numType

        if numType = 0:
            create new Book called w
            keepGoing = false
        if numType = 1: 
            create new Fanfic called w
            keepGoing = false
        if numType = 2:
            create new Manga called w
            keepGoing = false
        else:
            print "Please enter 0, 1, or 2"

    print "Title: "
    take user input as string into title
    w.setTitle(title)
    print "Author: "
    take user input as string into author
    w.setAuthor(author)
    print "Genre: "
    take user input as string into genre
    w.setGenre(genre)
    
    boolean keepGoing = true
    while keepGoing:
        print "Rating (-5 to 5, 0 being neutral): "
        take user input as string rating
        try casting rating to an integer
        catch if can't and print "Please enter a number from -5 to 5"
        
        if rating is >= -5 and <= 5:
            w.setRating(rating)
            keepGoing = false
        else:
            "Please enter a number from -5 to 5"
    
    print "Date finished..."
    print "Month (numerical, ie. 1 for January, 2 for February, etc.): "
    take user input as string into month
    w.dateFinished.setMonth(month)
    print "Day: "
    take user input as string into genre
    w.dateFinished.setDay(day)
    print "Year: " 
    take user input as string into genre
    w.dateFinished.setYear(year)
    
    print "Entered work:"
    w.printWork()

editWork():
    print "Enter title of work: "
    take input and put in string titleToMatch
    search.setSearchList(Works)
    search.findWork(titleToMatch)
    search.clearSearchList()
    
printAll():
    for each work in works:
        call printWork()

printSummary():
    NEED TO FINISH
``` 
