# Requirements
eclipse
jdk version 17 or above
python 3.8.12 or above
docker

# Description
This project is a simple implementation of mqtt publisher subscriber application.
The publisher file is python program that sends "Hello livello" every 5 seconds to the topic "/livello"
The subscriber grabs all the massages to the topic "/livello" and display it in the console

# How to run

## Run publisher
```
cd publisher
pip install -r requirements.txt
python3 publisher.py
```

## Run subscriber
Open the project in eclipse and run add the jar file in the lib directory to the project.
Run the Subscriber class after starting the publisher and you should see messages in the console.