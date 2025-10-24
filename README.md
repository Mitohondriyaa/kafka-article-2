# Kafka Event-Driven Microservices Platform

Пример из статьи ["Kafka для начинающих: работа с брокером сообщений на практике"](https://habr.com/ru/articles/958450/) на Хабре

## Состав
- `order-service` - продюсер
- `inventory-service` — продюсер и консьюмер
- `notification-service` — консьюмер
- `analytics-service` — дополнительный консьюмер
- `docker-compose.yml` — кластер Kafka из трёх брокеров + Kafka-UI

## Как запустить

1. Клонировать репозиторий
```bash
git clone https://github.com/Mitohondriyaa/kafka-article-2
cd kafka-article-2
```
2. Запустить Kafka-кластер
```bash
docker-compose up -d
```
3. Запустить микросервисы (при желании можно запускать консьюмеров в нескольких инстансах)
```bash
cd order-service
./mvnw spring-boot:run

cd inventory-service
./mvnw spring-boot:run

cd notification-service
./mvnw spring-boot:run -Dserver.port=8081

cd analytics-service
./mvnw spring-boot:run -Dserver.port=8082
```
4. Открыть Kafka-UI по адресу http://localhost:8086/
5. Работать с отправкой сообщений
