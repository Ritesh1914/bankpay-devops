FROM jenkins/jenkins:lts-jdk17

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
ENV JENKINS_OPTS="--httpPort=8080"

USER root

# Install Maven, Docker, Curl
RUN apt-get update && \
    apt-get install -y \
      maven \
      docker.io \
      curl \
      apt-transport-https \
      ca-certificates \
      gnupg && \
    rm -rf /var/lib/apt/lists/*

# Install kubectl
RUN curl -LO \
  "https://dl.k8s.io/release/$(curl -L -s \
  https://dl.k8s.io/release/stable.txt)\
/bin/linux/amd64/kubectl" && \
    install -o root -g root -m 0755 \
    kubectl /usr/local/bin/kubectl && \
    rm kubectl

# Install Helm
RUN curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash

# Verify all tools
RUN echo "Maven:" && mvn --version && \
    echo "Docker:" && docker --version && \
    echo "Kubectl:" && kubectl version --client && \
    echo "Helm:" && helm version

USER jenkins

# Install plugins - sonarqube-scanner removed (install via UI)
RUN jenkins-plugin-cli --plugins \
    kubernetes \
    workflow-aggregator \
    git \
    docker-workflow \
    slack \
    credentials-binding \
    timestamper \
    ws-cleanup \
    build-timeout \
    github \
    pipeline-utility-steps \
    role-strategy \
    configuration-as-code \
    jacoco