pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test Execution') {
            steps {
                bat 'mvn test -Pdev'
            }
        }

        stage('Publish TestNG Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'OpenMRS Selenium Automation Extent Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }

        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }

    post {

        always {
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'OpenMRS Selenium Automation Pipeline completed successfully.'
        }

        failure {
            echo 'OpenMRS Selenium Automation Pipeline failed. Check reports for details.'
        }
    }
}