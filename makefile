Bookshelf.class: Bookshelf.java Work.class Note.class
	javac -g Bookshelf.java

Work.class: Work.java Note.class HasMenu.class Converter.class
	javac -g Work.java

Note.class: Note.java
	javac -g Note.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

Converter.class: Converter.java
	javac -g Converter.java

run: Bookshelf.class
	java Bookshelf

clean:
	rm *.class

testWork: Work.class
	java Work


