JAVAC = javac
JAVA = java
JFLAGS = -g

SRCS = $(wildcard *.java)
CLASSES = $(SRCS: .java = .class)
# CLASSES = $(patsubst %.java, %.class, $(SRCS))

all:$(SRCS)
	J
%.java: %.class
	$(JAVAC) $(JFLAGS) -g $<

clean:
	rm -rf *.class

run:all 
	$(JAVA) SimpleStartupGame

