def buildApp() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'jenkins', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t aeramzy9/java-maven-app:latest .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        # sh 'docker push aeramzy9/java-maven-app:latest'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
