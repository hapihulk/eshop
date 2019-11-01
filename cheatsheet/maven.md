### Eclise project from pom
mvn eclipse:clean eclipse:eclipse

### Effective POM = Super POM + Simplest POM   

mvn help:effective-pom 

### Redirect output to a text file.  

mvn help:effective-pom -Doutput=effective-pom.xml