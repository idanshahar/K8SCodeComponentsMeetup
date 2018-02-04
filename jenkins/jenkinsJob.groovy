
node {
    withCredentials([
      [$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS'],
    ]) {
        stage('login') {
           
            sh """
                docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
            """
        }
        stage('Preparation') {
          git 'https://github.com/idanshahar/K8SCodeComponentsMeetup.git'
        }
        stage('Build') {
        app = docker.build("idanshahar/node-example","-f ./node/Dockerfile ./node")
        }
        stage('Push') {
            withDockerRegistry([credentialsId: 'docker-hub-credentials']) {
                app.push("${BUILD_NUMBER}")
                app.push("latest")
            }
        }
        stage('Deploy') {
            sh """
                helm
            """
        }
    }
}
