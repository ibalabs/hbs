mvn clean install
rm -fr /home/siva/work/installables/apache-tomcat-8.5.31/webapps/*
rm -fr /home/siva/work/installables/apache-tomcat-8.5.31/work/*
rm -fr /home/siva/work/installables/apache-tomcat-8.5.31/temp/*
cp /home/siva/git/hbs/hbs/target/hbs.war /home/siva/work/installables/apache-tomcat-8.5.31/webapps
