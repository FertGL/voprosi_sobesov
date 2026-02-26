package Patterns.MS_Patterns;

public class Outbox {
    /*
    Outbox в Java — это шаблон проектирования (часто называемый Transactional Outbox),
    который решает проблему атомарности между операциями в базе данных и
    отправкой событий/сообщений.

    Суть проблемы:
    Когда приложение делает две вещи в рамках одного запроса:
    1. Сохраняет данные в БД (SQL)
    2. Отправляет сообщение в Kafka

    Если отправка сообщения падает, а БД закоммитилась — данные есть,
    но уведомления нет (системы рассинхронизированы).

    Outbox решает это: отправка не делается напрямую, вместо этого сообщение кладётся
    в ту же транзакцию БД в отдельную таблицу.

    ---

    Как это работает

    1. Таблица outbox в БД (id, aggregate_id, event_type, payload, status, created_at)
    2. В рамках бизнес-транзакции:
       · сохраняются основные данные
       · в той же транзакции в outbox пишется запись о событии
    3. COMMIT
    4. Отдельный компонент (Outbox Publisher) читает таблицу и отправляет сообщения в брокер
    5. После успешной отправки помечает как отправленное/удаляет

    Плюсы

    · ✅ Гарантия доставки (at-least-once)
    · ✅ Атомарность изменения состояния и отправки события
    · ✅ Возможность повтора упавших сообщений

    Минусы

    · ❌ Дополнительная таблица в БД
    · ❌ Задержка между записью и отправкой
    · ❌ Идемпотентность нужна на стороне получателя



        1. Сущность Outbox
    @Entity
    public class OutboxEvent {
        @Id
        private UUID id;
        private String aggregateId;
        private String eventType;
        private String payload; // JSON
        private Instant createdAt;
        @Enumerated(EnumType.STRING)
        private OutboxStatus status;
    }

    2. Сервис с Transactional Outbox
    @Service
    @Transactional
    public class OrderService {

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private OutboxRepository outboxRepository;

        public void createOrder(OrderDto dto) {
            // 1. Бизнес-логика
            Order order = new Order(dto);
            orderRepository.save(order);

            // 2. Публикация события через outbox
            OutboxEvent event = OutboxEvent.builder()
                .id(UUID.randomUUID())
                .aggregateId(order.getId())
                .eventType("ORDER_CREATED")
                .payload(toJson(order))
                .createdAt(Instant.now())
                .status(OutboxStatus.PENDING)
                .build();

            outboxRepository.save(event);
            // Транзакция закоммитится только после выхода из метода
        }
    }

    3. Публикатор (отдельный поток)
    @Component
    public class OutboxPublisher {

        @Scheduled(fixedDelay = 5000)
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        public void publishPendingEvents() {
            List<OutboxEvent> events = outboxRepository
                .findTop100ByStatusOrderByCreatedAt(OutboxStatus.PENDING);

            for (OutboxEvent event : events) {
                try {
                    kafkaTemplate.send(event.getEventType(), event.getPayload());
                    outboxRepository.delete(event); // или update статуса
                } catch (Exception e) {
                    // логируем, оставляем для retry
                }
            }
        }
    }



     */
}
