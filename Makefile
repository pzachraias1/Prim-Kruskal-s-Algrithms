all: main

main.class Prim.class Kruskal.class: main.java Prim.java
	javac main.java Prim.java Kruskal.java

main: main.class Prim.class Kruskal.class
	java main