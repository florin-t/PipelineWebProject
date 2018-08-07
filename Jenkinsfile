node {
    deleteDir()
    def workspace = pwd()
    try {

       stage("Getcode"){
            checkout scm


       }
       stage('Mail') {
                   sh 'pwd'
                   sh 'tree'
                   sh " echo -e ${workspace}"
                   sh "cd ${workspace}"
                   sh 'ls -alh'
                   sh 'echo $BUILD_URL'
                   sh 'echo $NODE_NAME'
                   sh 'echo $JOB_NAME'
                   sh 'echo $BUILD_TAG'
                   sh 'echo $EXECUTOR_NUMBER'
                   sh 'echo $JAVA_HOME'
                   sh 'echo $WORKSPACE'
                   sh 'echo $GIT_COMMIT'
                   sh 'echo $GIT_URL'
                   sh 'echo $GIT_BRANCH'
                   
                   sh 'tree'
                      emailext body: '${SCRIPT, template="groovy-html.template"}',
                              mimeType: 'text/html',
                              subject: "[Jenkins] ${currentBuild.fullDisplayName}",
                              to: "${env.MAIL_LIST}",
                              replyTo: "${env.MAIL_LIST}",
                              recipientProviders: [[$class: 'CulpritsRecipientProvider']]
              }
    } catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    } finally {

    }
}
