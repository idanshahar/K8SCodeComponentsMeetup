From jenkins/jnlp-slave:3.16-1
USER root
RUN apt-get update -y \
	&& apt-get install -y libltdl7-dev \
	&& rm -rf /var/lib/apt/lists/* \
	&& curl https://raw.githubusercontent.com/kubernetes/helm/master/scripts/get > get_helm.sh \
	&& chmod 700 get_helm.sh \
	&& ./get_helm.sh




