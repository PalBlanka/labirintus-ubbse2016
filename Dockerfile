FROM ubuntu:latest

RUN apt-get update -y
RUN apt-get install -y x11-apps xauth
RUN apt-get install -y openjdk-8-jre

RUN mkdir /pr
COPY ./bin /pr

CMD xauth add $DISPLAY . $DISPLAY_HEX && xauth add $DISPLAY . $DISPLAY_HEX && cd /pr && java main
