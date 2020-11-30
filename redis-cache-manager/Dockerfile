FROM 876496569223.dkr.ecr.us-east-1.amazonaws.com/wdpr-ra/wdpr-ra-docker-base-jre8:2.1.0-42.0.0.0

COPY crypto/* ${CACERTDIR}/
RUN keytool -importcert -noprompt -keystore ${CACERTDIR}/cacerts -storepass changeit -trustcacerts -file ${CACERTDIR}/ca-bundle.pem -alias twdc-ca-bundle

ADD scripts/* /scripts
RUN chmod +x /scripts/*

COPY config_dlp.hcl /tmp/envconsul/config.hcl

ADD target/wdpr-dlp-is-common-dis-delta-cache-manager-*.jar /target/app.jar
ENV JAR_FILE_PATH /target/app.jar
