From jenkins/jnlp-slave:3.16-1
USER root

ENV DRAFT_LATEST_VERSION="v0.7.0"

RUN apt-get update && apt-get install -y \
    curl

RUN apt-get update -y \
	&& apt-get install -y libltdl7-dev \
	&& rm -rf /var/lib/apt/lists/* 

RUN curl https://raw.githubusercontent.com/kubernetes/helm/master/scripts/get > get_helm.sh \
	&& chmod 700 get_helm.sh \
	&& ./get_helm.sh

RUN curl -LO \  
    https://github.com/Azure/draft/releases/download/${DRAFT_LATEST_VERSION}/draft-${DRAFT_LATEST_VERSION}-linux-amd64.tar.gz
RUN tar -xvf draft-${DRAFT_LATEST_VERSION}-linux-amd64.tar.gz
RUN mv linux-amd64/draft /usr/local/bin 


