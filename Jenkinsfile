pipeline {
  agent any
  stages {
    stage('Maven Build') {
      steps {
        sh 'mvn clean install -f pom.xml'
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