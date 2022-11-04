all: main

main.class Prim.class Kruskal.class Graph.class: main.java Prim.java Kruskal.java Graph.java
	javac main.java Prim.java Kruskal.java Graph.java

main: main.class Prim.class Kruskal.class Graph.class
	java main