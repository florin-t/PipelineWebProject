pipeline {
    agent any
    stages {
        stage('Sys Info') {
            steps {
                sh 'echo "..."'
                sh '''
                    echo "Info about the system:"
                '''
                sh 'uname -a'
            }
        }
        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }
	    stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Sanity check') {
            steps {
                input "Does the staging environment look ok?"
            }
        }
    }

    post {
        always {
                echo 'This will always run'
        }
        success {
                echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }

}