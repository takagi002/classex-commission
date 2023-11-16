pipeline {
    agent any

    tools {
        jdk '19'
        gradle 'Gradle 8.4'
    }

    stages {
        stage('Build'){
            echo 'Building code'
            sh './gradlew build'
        }
        stage('Test') {
            steps {
                echo 'Running JUnit tests'
                sh './gradlew test'
            }
            post {
                always {
                    junit 'build/test-results/test/**/*.xml'
                }
            }
        }
    }

    }
}