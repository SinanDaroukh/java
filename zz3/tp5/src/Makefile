make-java:
	javac Random.java CPP_Writer.java Fetcher.java Main.java

run-java: make-java
	java Main Random Random --stdout

make-cpp: run-java
	g++ Random.hpp

clean:
	rm -rf *.o
	rm -rf *.class