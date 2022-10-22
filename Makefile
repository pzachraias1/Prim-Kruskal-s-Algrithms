all: main

main.class Prim.class: main.java Prim.java
	javac main.java Prim.java

main: main.class Prim.class
	java main