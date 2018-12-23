pipeline {
  agent {
    kubernetes {
      //label 'sample-app'
      //defaultContainer 'jnlp'
	}
  }
  environment {
    mvnHome = tool name: 'M3', type: 'maven'        
  }
  stages {
   stage('Preparation') { 
		steps {
			git branch: '${branch}', url: 'https://github.com/Asher-Shoshan/webapp.git'										
		}
   }
   stage('Build') { 
		steps {
   			sh "'${mvnHome}/bin/mvn' clean package -Dmaven.test.skip=true"					
            //sh 'sleep 1'   			
		}
   }
   stage('Docker Build-Push') {
       steps {
	        container('maven') {
                sh 'mvn dockerfile:build dockerfile:push'
            }
            container('docker') {
        		//get image digest
                sh 'docker inspect --format="{{index .RepoDigests 0}}" `cat target/docker/image-id` > target/docker/image-digest'                
                //sh 'docker rmi `cat target/docker/image-id`'  
                //sh 'sleep 120'
                sh 'chown -R 10000:10000 target/test*'
            }
		}
	}
   stage('Deploy') {
       steps {
            container('kubectl') {
                //sh 'echo ${branch}'
                sh "kubectl set image deployment/${deployment}-${branch} ${deployment}-${branch}=`cat target/docker/image-digest`"
            }
       }
   }
   stage('Tests') {
      steps {
        sh "'${mvnHome}/bin/mvn' test -Dmaven.test.failure.ignore"
      }
   }
   stage('Results') {
		steps {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml'		
		}
   }
 }
}