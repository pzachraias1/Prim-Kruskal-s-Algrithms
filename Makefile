all: main

main.class: main.java
	javac main.java

main: main.class
	java main