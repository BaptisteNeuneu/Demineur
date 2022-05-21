### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java

### REGLES ESSENTIELLES ###

MainMenu.class : MainMenu.java Menu.class
	${JC} ${JCFLAGS} MainMenu.java

Menu.class : Menu.java ActionMenu.class
	${JC} ${JCFLAGS} Menu.java

ActionMenu.class : ActionMenu.java Menu2.class
	${JC} ${JCFLAGS} ActionMenu.java

Menu2.class : Menu2.java ActionMenu2.class
	${JC} ${JCFLAGS} Menu2.java

ActionMenu2.class : ActionMenu2.java Fenetre.class
	${JC} ${JCFLAGS} ActionMenu2.java

Fenetre.class : Fenetre.java ActionButton.class
	${JC} ${JCFLAGS} Fenetre.java

ActionButton.class : ActionButton.java Case.class
	${JC} ${JCFLAGS} ActionButton.java

Case.class : Case.java Test.class
	${JC} ${JCFLAGS} Case.java

Test.class : Test.java ActionVdDf.class
	${JC} ${JCFLAGS} Test.java

ActionVdDf.class : ActionVdDf.java
	${JC} ${JCFLAGS} ActionVdDf.java

### REGLES OPTIONNELLES ###

run : MainMenu.class
	${JVM} MainMenu


clean :
	-rm -f *.class

mrproper : clean MainMenu.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###

