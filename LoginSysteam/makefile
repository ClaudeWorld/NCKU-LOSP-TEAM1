JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
		UserUnit.java \
		UserManager.java \
		LoginSystem.java \
		GetCommand.java \
		ListManager.java

default: classes

classes: $(CLASSES:.java=.class)

run: LoginSystem.class
	java LoginSystem