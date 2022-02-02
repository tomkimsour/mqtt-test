# Import package
import paho.mqtt.client as mqtt
import time

# global variables for client configuration
MQTT_ID = "Hello world Sender"
MQTT_HOST = "broker.hivemq.com"
MQTT_PORT = 1883
MQTT_KEEPALIVE_INTERVAL = 45
MQTT_TOPIC = "/livello"
MQTT_MSG = "Hello Livello"

def main():
    mqttc = mqtt.Client(MQTT_ID)
    mqttc.connect(MQTT_HOST,MQTT_PORT,MQTT_KEEPALIVE_INTERVAL)
    try:
        while True:
            mqttc.publish(MQTT_TOPIC,MQTT_MSG)
            print("Message sent")
            time.sleep(5)
    except Exception as e:
        mqttc.disconnect()
        print("Could not publish")
        raise e

if __name__ == "__main__":
    try:
        main()
    except Exception as e:
        print("Could not connect")
        raise e
