pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
<<<<<<< HEAD
    gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
=======
    gradle 'Gradle5.0_Centos' //Preinstalada en la Configuración del Master
>>>>>>> e5e5b103b19de522e097271e7bd1a23702a3cd77
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
            $class: 'GitSCM', 
            branches: [[name: '*/master']], 
            doGenerateSubmoduleConfigurations: false, 
            extensions: [], 
            gitTool: 'Default', 
            submoduleCfg: [], 
            userRemoteConfigs: [[
            credentialsId: 'GitHub_sergio921214', 
            url:'https://github.com/sergio921214/autorentingADN.git'
            ]]
            ])

      }
    }
    
    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
<<<<<<< HEAD
        sh 'gradle --b ./build.gradle clean'
        sh 'gradle --b ./build.gradle test'
        sh 'gradle --b ./build.gradle jacocoTestReport'
<<<<<<<< HEAD:Jenkinsfile
        echo "------------>Unit Tests Finished<------------"
========
>>>>>>>> e5e5b103b19de522e097271e7bd1a23702a3cd77:java-arquitectura-hexagonal/Jenkinsfile
=======
        sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle clean'
        sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle test'
        sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle jacocoTestReport'
        echo "------------>Unit Tests Finished<------------"
>>>>>>> e5e5b103b19de522e097271e7bd1a23702a3cd77
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
<<<<<<< HEAD
        sh 'gradle --b ./build.gradle build -x test'
<<<<<<<< HEAD:Jenkinsfile
        echo "------------>Build Finished<------------"
========
>>>>>>>> e5e5b103b19de522e097271e7bd1a23702a3cd77:java-arquitectura-hexagonal/Jenkinsfile
=======
        sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle build -x test'
        echo "------------>Build Finished<------------"
>>>>>>> e5e5b103b19de522e097271e7bd1a23702a3cd77
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
