#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        // Reference the Maven tool from Global Tool Configuration
        maven 'maven'  // Use the name you specified in Global Tool Configuration
    }    
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
            }
    stages {
        stage("init") {
            steps {
                script {
                   gv = load "Jenkins/script.groovy"
                }
            }
        }      
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    env.ENV = input message: "Select the environment to deploy to", ok: "Done", parameters: [choice(name: 'ONE', choices: ['dev', 'staging', 'prod'], description: '')]
                    gv.buildImage()
                    echo "Deploying to ${ENV}"
                }
            }
        }
    }
}
