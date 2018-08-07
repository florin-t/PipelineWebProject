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
                   sh 'tree'
                      emailext body: '${FILE, path="groovy-html.template"}',
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
