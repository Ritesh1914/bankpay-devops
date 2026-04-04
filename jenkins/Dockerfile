FROM jenkins/jenkins:2.492.1-lts-jdk17

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
ENV JENKINS_OPTS="--httpPort=8080"

RUN jenkins-plugin-cli --plugins \
    kubernetes \
    workflow-aggregator \
    git \
    docker-workflow \
    slack \
    jacoco \
    credentials-binding \
    timestamper \
    ws-cleanup \
    build-timeout \
    github \
    pipeline-utility-steps \
    role-strategy \
    configuration-as-code