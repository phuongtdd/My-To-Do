pipeline {
  agent { docker { image 'maven:3.9-openjdk-17' } }

  environment {
    RENDER_API_KEY = credentials('render-api-key')
    RENDER_SERVICE_ID = credentials('render-service-id') // or put literal if you prefer
  }

  options {
    ansiColor('xterm')
    timeout(time: 30, unit: 'MINUTES')
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build') {
      steps {
        sh 'mvn -B clean package -DskipTests'
      }
    }

    stage('Archive Jar') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Deploy to Render') {
      when { branch 'main' }
      steps {
        script {
          // Trigger Render deploy via API (service must be linked to this repo on Render)
          sh """
            curl -X POST "https://api.render.com/v1/services/${RENDER_SERVICE_ID}/deploys" \
              -H "Authorization: Bearer ${RENDER_API_KEY}" \
              -H "Content-Type: application/json" \
              -d '{"clearCache":true}'
          """
        }
      }
    }
  }
  post {
    success { echo "BE build & deploy triggered" }
    failure { echo "BE pipeline failed" }
  }
}
