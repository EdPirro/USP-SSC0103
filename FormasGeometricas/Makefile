# defines source code files in alphabetic order to check if you have them all
sourceFiles = Circulo.java EntradaTeclado.java FigurasGeometricas.java Main.java Quadrado.java Retangulo.java

# gets all .java files you have
javaFiles = $(sort $(wildcard *.java))

# ceates a list of .class files based on the .java files found
classFiles = $(patsubst %.java,%.class,$(javaFiles))

# checks if you have all needed source files
ifneq ($(javaFiles), $(sourceFiles))
$(error You're missing some (if not all) source code files, try getting them at 'https://github.com/EdPirro/USP-SSC0103/tree/master/Bozo' and running again.)
endif  

# sets up arguments to be used on the clean target
ifeq ($(OS),Windows_NT)
	eraseArgs = powershell "(rm * -Include *.class)"
else 
	eraseArgs = rm *.class
endif

# defines which file contains the main function
main = Main.java

all $(classFiles): # simply compiles all .java file
	javac $(javaFiles)

run: $(classFiles) # runs the main java file (.java file where the main function can be found)
	java $(main)

clean: $(classFiles) # clean taret currently only works properly with windows powershell or linux bash
	$(eraseArgs)
