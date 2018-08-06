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
                sh 'make check || true'
                junit 'build/test-results/test/*.xml'
            }
        }
        stage('Mail') {
             steps {
                sh 'pwd > workspace'
                def workspace = readfile('workspace').trim;
                emailext body: '''${SCRIPT, template="${workspace}/groovy-html.template"}''',
                        mimeType: 'text/html',
                        subject: "[Jenkins] ${currentBuild.fullDisplayName}",
                        to: "${env.MAIL_LIST}",
                        replyTo: "${env.MAIL_LIST}",
                        recipientProviders: [[$class: 'CulpritsRecipientProvider']]
            }
        }

    }

    post {
        always {
                archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
                junit 'build/test-results/test/*.xml'
                //mail to: "${env.MAIL_LIST}", subject: "Rrr", body: "Teh content", mimeType: "text/html"



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
