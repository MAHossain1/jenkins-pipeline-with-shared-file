def checkout() {
    checkout scmGit(
        branches: [[name: '*/main']], // Change if needed
        userRemoteConfigs: [[url: 'https://github.com/MAHossain1/jenkins-pipeline-with-shared-file.git']]
    )
}

def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'my-dockerhub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t arman04/java-maven-app:jma-3.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push arman04/java-maven-app:jma-3.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this