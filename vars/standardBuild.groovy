def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Main') {
            sh config.mainScript
        }
        stage('Post') {
            sh config.postScript
        }
    }
}
