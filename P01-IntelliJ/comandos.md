# P01 – Pruebas del Software (PPSS)

Este proyecto corresponde a la práctica **P01** de la asignatura *Pruebas del Software*.  
El objetivo es familiarizarse con **Maven**, su ciclo de vida, la ejecución de tests con **JUnit 5** y el uso de **Git**.

---

## 1. Comprobación del entorno

Comprobar versiones de Maven y Java:


mvn -version
java -version

2. Creación del directorio de trabajo

Desde el repositorio principal:

cd ~/ppss-2026-G5-Yamina-Chibane
mkdir P01-IntelliJ
cd P01-IntelliJ

3. Creación del proyecto Maven

Proyecto creado desde IntelliJ con los siguientes parámetros:

    Build system: Maven

    Lenguaje: Java

    JDK: 17

    Nombre del proyecto: simpleMavenProject

    groupId: ppss.P01

4. Copia del código de plantillas

Copiar el código fuente y los tests:

cp Plantillas-P01/Ejemplo.java \
simpleMavenProject/src/main/java/ppss/

cp Plantillas-P01/EjemploTest.java \
simpleMavenProject/src/test/java/ppss/

5. Compilación del código (sin tests)

cd simpleMavenProject
mvn compile

Resultado esperado:

BUILD SUCCESS

6. Compilación de los tests (debe fallar)

mvn test-compile

Resultado esperado:

BUILD FAILURE

Motivo: JUnit aún no está incluido como dependencia.
7. Añadir dependencia JUnit 5

Editar el archivo pom.xml:

nano pom.xml

Añadir en la sección <dependencies>:

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.11.4</version>
    <scope>test</scope>
</dependency>

8. Compilar los tests de nuevo

mvn test-compile

Resultado esperado:

BUILD SUCCESS

9. Ejecutar los tests

mvn test

Resultado esperado:

Tests run: 1, Failures: 0, Errors: 0
BUILD SUCCESS

10. Fijar versiones de los plugins

Editar pom.xml y añadir:

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.13.0</version>
        </plugin>

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.5.2</version>
        </plugin>
    </plugins>
</build>

11. Fase PACKAGE

mvn package

Resultado:

    Se ejecutan las fases hasta package

    Se genera el artefacto:

target/simpleMavenProject-1.0-SNAPSHOT.jar

12. Fase INSTALL

mvn install

Resultado:

    El artefacto se copia al repositorio local Maven:

~/.m2/repository/ppss/P01/simpleMavenProject/1.0-SNAPSHOT/

Esto permite reutilizar el proyecto como dependencia en otros proyectos Maven.
13. Ejercicio 1 – Respuestas teóricas

Crear el fichero con las respuestas:

cd ..
nano ejercicio1.txt

14. Control de versiones con Git

Comprobar estado del repositorio:

git status

15. Commits realizados
Commit 1 – Configuración Maven

git add simpleMavenProject/pom.xml
git commit -m "P01 Configuración inicial Maven y Java 21"

Commit 2 – Código fuente y tests

git add simpleMavenProject/src
git commit -m "P01 Ejemplo.java y EjemploTest con JUnit 5"

Commit 3 – Ejercicio teórico

git add ejercicio1.txt
git commit -m "P01 Ejercicio 1: fases package e install"

16. Subida a GitHub

git push

17. Comandos Maven utilizados

mvn compile
mvn test-compile
mvn test
mvn package
mvn install
