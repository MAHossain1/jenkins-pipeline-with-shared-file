// #!/usr/bin/env groovy

// @library('jenkins-shared-library')

def gv

pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('initialize') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "test the application..."
                }
            }
        }

        stage('checkout') {
            steps {
                script {
                    gv.checkout()
                }
            }
        }

    

        stage('build') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                  gv.buildImage()
                }
            }
        }

         
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}

