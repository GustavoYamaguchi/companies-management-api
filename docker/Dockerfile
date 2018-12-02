FROM openjdk:8

RUN \
  apt-get update -y && \
  apt-get upgrade -y && \
  apt-get install -y build-essential && \
  apt-get install -y software-properties-common && \
  apt-get install -y byobu curl git man unzip vim wget && \
  rm -rf /var/lib/apt/lists/*

RUN \
  git clone https://github.com/GustavoYamaguchi/companies-management-api.git

WORKDIR /companies-management-api

CMD ./gradlew bootRun || tail -f /dev/null