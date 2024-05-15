## Beispielkommandos für das System

### Publisher
- publish --- (topic, message)

### Subscriber
- subscribe --- (topic)
- unsubscribe --- (topic)
- aknowledge --- (messageId)
- getMessages --- (topic)

### Admin-Client
- createTopic --- (topic)
- deleteTopic --- (topic)
- modifyTopic --- (topic, messageId, value)
- listTopics --- ()
- listSubscribers --- (topic)
- listPublishers --- (topic)
- listMessages --- (topic, subscriber)
- getClientStatus --- (clientId)
- monitorConnections --- (clientId)
- monitorTopics --- (topicId)
- configure --- (setting, value)