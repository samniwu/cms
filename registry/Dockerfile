FROM java:8-jre
ADD registry.zip /home/server/registry
RUN chmod 775 /home/server/registry/bin/startup.sh
WORKDIR /home/server/registry
ENTRYPOINT nohup ./home/server/registry/bin/startup.sh