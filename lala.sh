#!/bin/bash
/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/bin/java -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=52390:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar:/Applications/IntelliJ IDEA.app/Contents/plugins/junit/lib/junit-rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/lib/tools.jar:/Users/rigel/workspace/kozazz/codetest/target/test-classes:/Users/rigel/workspace/kozazz/codetest/target/classes:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/1.4.1.RELEASE/spring-boot-starter-actuator-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-starter/1.4.1.RELEASE/spring-boot-starter-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot/1.4.1.RELEASE/spring-boot-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.4.1.RELEASE/spring-boot-autoconfigure-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-starter-logging/1.4.1.RELEASE/spring-boot-starter-logging-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/ch/qos/logback/logback-classic/1.1.7/logback-classic-1.1.7.jar:/Users/rigel/.m2/repository/ch/qos/logback/logback-core/1.1.7/logback-core-1.1.7.jar:/Users/rigel/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.21/jcl-over-slf4j-1.7.21.jar:/Users/rigel/.m2/repository/org/slf4j/jul-to-slf4j/1.7.21/jul-to-slf4j-1.7.21.jar:/Users/rigel/.m2/repository/org/slf4j/log4j-over-slf4j/1.7.21/log4j-over-slf4j-1.7.21.jar:/Users/rigel/.m2/repository/org/yaml/snakeyaml/1.17/snakeyaml-1.17.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-actuator/1.4.1.RELEASE/spring-boot-actuator-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.8.3/jackson-databind-2.8.3.jar:/Users/rigel/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.8.3/jackson-annotations-2.8.3.jar:/Users/rigel/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.8.3/jackson-core-2.8.3.jar:/Users/rigel/.m2/repository/org/springframework/spring-context/4.3.3.RELEASE/spring-context-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/spring-aop/4.3.3.RELEASE/spring-aop-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/spring-expression/4.3.3.RELEASE/spring-expression-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/1.4.1.RELEASE/spring-boot-starter-jdbc-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/org/apache/tomcat/tomcat-jdbc/8.5.5/tomcat-jdbc-8.5.5.jar:/Users/rigel/.m2/repository/org/apache/tomcat/tomcat-juli/8.5.5/tomcat-juli-8.5.5.jar:/Users/rigel/.m2/repository/org/springframework/spring-jdbc/4.3.3.RELEASE/spring-jdbc-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/spring-beans/4.3.3.RELEASE/spring-beans-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/spring-tx/4.3.3.RELEASE/spring-tx-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/mysql/mysql-connector-java/5.1.39/mysql-connector-java-5.1.39.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-starter-test/1.4.1.RELEASE/spring-boot-starter-test-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-test/1.4.1.RELEASE/spring-boot-test-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/boot/spring-boot-test-autoconfigure/1.4.1.RELEASE/spring-boot-test-autoconfigure-1.4.1.RELEASE.jar:/Users/rigel/.m2/repository/com/jayway/jsonpath/json-path/2.2.0/json-path-2.2.0.jar:/Users/rigel/.m2/repository/net/minidev/json-smart/2.2.1/json-smart-2.2.1.jar:/Users/rigel/.m2/repository/net/minidev/accessors-smart/1.1/accessors-smart-1.1.jar:/Users/rigel/.m2/repository/org/ow2/asm/asm/5.0.3/asm-5.0.3.jar:/Users/rigel/.m2/repository/org/slf4j/slf4j-api/1.7.21/slf4j-api-1.7.21.jar:/Users/rigel/.m2/repository/junit/junit/4.12/junit-4.12.jar:/Users/rigel/.m2/repository/org/assertj/assertj-core/2.5.0/assertj-core-2.5.0.jar:/Users/rigel/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/Users/rigel/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/Users/rigel/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/Users/rigel/.m2/repository/org/hamcrest/hamcrest-library/1.3/hamcrest-library-1.3.jar:/Users/rigel/.m2/repository/org/skyscreamer/jsonassert/1.3.0/jsonassert-1.3.0.jar:/Users/rigel/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/rigel/.m2/repository/org/springframework/spring-core/4.3.3.RELEASE/spring-core-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/org/springframework/spring-test/4.3.3.RELEASE/spring-test-4.3.3.RELEASE.jar:/Users/rigel/.m2/repository/org/apache/commons/commons-io/1.3.2/commons-io-1.3.2.jar:/Users/rigel/.m2/repository/com/google/code/gson/gson/2.7/gson-2.7.jar" com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 com.lala.NameTest,nameGen
