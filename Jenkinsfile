#!/usr/bin/env groovy

@library('jenkins-shared-library')

def gv

pipeline {
    agent none

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

        stage('build') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                   buildImage()
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

