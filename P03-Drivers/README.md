P03-Drivers - instrucciones rápidas

Estructura del módulo:

- intellij-configurations/   -> run configurations exportadas (copiar a .idea/runConfigurations si quieres importarlas)
- src/main/java/ppss/        -> código SUT (e.g., Cine.java)
- src/test/java/ppss/        -> tests JUnit (e.g., CineTest.java)
- src/test/resources/        -> ficheros de test (e.g., ficheroCorrecto.txt)
- pom.xml                    -> POM con Java 21 y JUnit 5

Cómo usar (línea de comandos)

1) Asegúrate de tener Java 21 en tu entorno (se ha instalado localmente en el proyecto en jdks/):

   export JAVA_HOME="$PWD/jdks/jdk-21.0.10+7"
   export PATH="$JAVA_HOME/bin:$PATH"

   java -version
   mvn -v

2) Ejecutar todos los tests con Maven (desde la carpeta `P03-Drivers`):

   mvn test

3) Ejecutar solo `CineTest`:

   mvn -Dtest=ppss.CineTest test

4) Ejecutar solo los tests parametrizados (si están en clase `ParametrizadosTest`):

   mvn -Dtest=ppss.ParametrizadosTest test

Cómo usar las run configurations de IntelliJ

- Las run configurations exportadas están en `intellij-configurations/`.
- Para usarlas en IntelliJ: copia los archivos XML desde `intellij-configurations/` a `.idea/runConfigurations/` del proyecto (crea la carpeta si no existe).
- No subir `.idea/` al repositorio: las configuraciones aquí pueden importarse localmente.

Notas:
- Si tu `/home` está lleno, las dependencias de Maven se descargan en `.m2/repository` por defecto; en este entorno hemos usado un repo alternativo en la unidad externa. Puedes editar `~/.m2/settings.xml` para cambiar permanentemente `localRepository`.
- El `pom.xml` está configurado para Java 21 (maven.compiler.release=21) y JUnit 5.

Si quieres que genere las instrucciones exactas para importar las run configs paso a paso en IntelliJ o que cree una entrada de `settings.gradle`/otros, dímelo.
