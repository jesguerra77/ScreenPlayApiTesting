#!groovy​
pipeline {
    agent {
        docker {
            image 'maven:3.8.1-jdk-8'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Initialize'){
            def dockerHome = tool 'myDocker'
            env.PATH = "${dockerHome}/bin:${env.PATH}"
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}