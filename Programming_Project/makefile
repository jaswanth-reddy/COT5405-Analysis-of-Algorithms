JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

jar: $(classes)
	jar -cvmf manifest.txt MarsBase.jar $(classes)
	echo '#!/usr/bin/java -jar' > MarsBase
	cat MarsBase.jar >> MarsBase
	chmod +x MarsBase

clean :
	rm -f *.class *.jar MarsBase