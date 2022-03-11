from ubuntu           
run apt-get update && apt-get install -y \
openjdk-8-jdk \
curl \
unzip 
run curl -G https://dlcdn.apache.org/axis/axis2/java/core/1.8.0/axis2-1.8.0-bin.zip -o /opt/axis2.zip
run unzip /opt/axis2.zip -d /opt
#Variables de entorno
env AXIS2_HOME=/opt/axis2-1.8.0
env PATH=$PATH:$AXIS2_HOME/bin
env JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
workdir /ws
copy calculadora.java .
copy services.xml META-INF/
expose 8080
