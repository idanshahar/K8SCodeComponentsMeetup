Kubernetes Code Components Meetup
=================================

Prerequisites
------------
1. A Running Kubernetes Cluster
2. Helm - [Installation Instructions](https://github.com/kubernetes/helm/blob/master/docs/install.md)
3. Draft - [Installation Instructions](https://github.com/Azure/draft/blob/master/docs/install.md)
4. kubectl - [Installation Instructions](https://kubernetes.io/docs/tasks/tools/install-kubectl/)



Nodeless Jenkins on Kubernetes
------------------------------
### Set up Jenkins using helm

```
# if this is the first time you are using helm, please uncomment the line below.
# helm init
helm install --name jenkins stable/jenkins
```
### Get Jenkins admin password
```
printf $(kubectl get secret --namespace default jenkins-jenkins -o jsonpath="{.data.jenkins-admin-password}" | base64 --decode);echo
```
### Build a Docker Image for Jenkins Slave on your own
```
docker build . --tag ${YOUR_DOCKER_REGISTRY}:${TAG}
```

### Jenkins Configuration
Go to "Manage Jenkins" -> "Configure System"

1. Under Container Template, change the Docker Image to: idanshahar/jenkins-slave:latest
2. Add the following host path volumes: /var/run/docker.sock, /usr/bin/docker 
3. Create a new Pipeline job and select the jenkins file from git
4. Change kubernetes url to 10.0.0.1

Go to "Credentials" -> "System" -> "Global credentials"
1. Add your Dockerhub credentials
2. Insert 'docker-hub-credentials' as the credentialls ID 

Containerize applications using Draft
-------------------------------------
```
draft init #initialize draft

draft create 

draft up
```

Monitoring
----------
[Official Kubernetes Metrics Project](https://github.com/kubernetes/metrics)

#### Implementations
1. [Heapster](https://github.com/kubernetes/heapster)
2. [Metrics Server](https://github.com/kubernetes-incubator/metrics-server)
3. [Prometheus Adapter](https://github.com/directxman12/k8s-prometheus-adapter)
4. [Google Stackdriver](https://github.com/GoogleCloudPlatform/k8s-stackdriver) (coming soon)


