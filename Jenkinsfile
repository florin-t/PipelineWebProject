node {
    deleteDir()
    def workspace = pwd()
    try {
       stage('Mail') {
                   sh 'pwd'
                   sh 'tree'
                   println ${workspace}
                      emailext body: '''${SCRIPT, template="${workspace}/groovy-html.template"}''',
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
