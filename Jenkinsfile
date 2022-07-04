pipeline {
    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('Build') {
            steps {
                
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/AK9773/spring-boot-demo2.git'

              

               
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

          
        }
        
         stage('Deploy') {
            steps {
               deploy adapters: [tomcat8(credentialsId: 'tomcat-credential', path: '', url: 'http://localhost:9999/')], contextPath: null, onFailure: false, war: '**/*.war'
            }

          
        }
    }
}