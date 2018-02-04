From jenkins/jnlp-slave:3.10-1
USER root
RUN apt-get update -y \
    && apt-get install -y libltdl7-dev \
    && rm -rf /var/lib/apt/lists/*
USER jenkins
