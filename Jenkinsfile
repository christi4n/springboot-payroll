pipeline {
  agent any

  environment {
    // Tomcat9 URL to deploy
    DEPLOY_URL = 'http://tomcat-url:8181'
    // Stored credentials id in Jenkins
    DEPLOY_CREDENTIALS = '456abc789-1ab2-1234-1234-12345678910'
  }

  stages {
    stage('Maven Build') {
      steps {
        sh 'mvn clean install -f pom.xml'
      }
    }
    stage('Unit Tests') {
      steps {
        sh 'mvn test -f pom.xml'
      }
    }
    stage('Integration Tests') {
      steps {
        sh 'mvn integration-test -f pom.xml'
      }
    }
    stage ('Deploy to staging or production') {
      steps {
        script {
          deploy adapters: [tomcat9(credentialsId: '${DEPLOY_CREDENTIALS}', path: '', url: '${DEPLOY_URL}')], contextPath: '/pipeline', onFailure: false, war: 'webapp/target/*.war' 
        }
      }
    }
  }
  tools {
    maven 'Maven3'
  }
  post {
    always {
      step([
            $class           : 'JacocoPublisher',
            execPattern      : 'build/jacoco/jacoco.exec',
            classPattern     : 'build/classes/main',
            sourcePattern    : 'src/main/java',
            exclusionPattern : '**/*Test.class'
        ])
    }

  }
  triggers {
    pollSCM('H/2 * * * *')
  }
}