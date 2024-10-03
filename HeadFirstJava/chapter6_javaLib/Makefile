JAVAC = javac
JAVA = java
JFLAGS = -g

SRCS = $(wildcard *.java)
CLASSES = $(SRCS:.java=.class)

all: $(SRCS)
	$(JAVAC) $(JFLAGS) $(SRCS)

clean:
	rm -rf *.class

run: all
	$(JAVA) StartBust
