mvn clean install
rm -fr /home/siva/work/installables/apache-tomcat-8.5.31/webapps/*
rm -fr /home/siva/work/installables/apache-tomcat-8.5.31/work/*
rm -fr /home/siva/work/installables/apache-tomcat-8.5.31/temp/*
cp /home/siva/work/dev/product/HBS-trunk/target/hbs.war /home/siva/work/installables/apache-tomcat-8.5.31/webapps
