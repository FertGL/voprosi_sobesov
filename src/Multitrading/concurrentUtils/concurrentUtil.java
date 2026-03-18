package Multitrading.concurrentUtils;

public class concurrentUtil {
    /*
    java.util.concurrent — это фреймворк для многопоточного программирования в Java,
    который предоставляет высокоуровневые инструменты вместо низкоуровневых
    примитивов (wait(), notify(), synchronized). Главные преимущества: безопасность,
    производительность и удобство.

    Ключевые компоненты

    1. Атомарные классы (AtomicInteger, AtomicReference, etc.)
    AtomicInteger counter = new AtomicInteger(0);
    counter.incrementAndGet(); // Атомарная операция без synchronized

    · Основаны на CAS (Compare-And-Swap) операции
    · Нет блокировок (non-blocking)

    2. Коллекции

    · ConcurrentHashMap — сегментированная блокировка
    · CopyOnWriteArrayList — копирование при записи
    · ConcurrentLinkedQueue — non-blocking очередь

    3. Примитивы синхронизации

    · CountDownLatch — ожидание завершения операций
    · CyclicBarrier — точка синхронизации для потоков
    · Semaphore — ограничение доступа к ресурсам
    · Phaser — гибкий барьер (Java 7+)
    · Exchanger — обмен данными между потоками

    4. Пулы потоков (ExecutorService)
    ExecutorService executor = Executors.newFixedThreadPool(4);
    executor.submit(() -> System.out.println("Task"));

    · ThreadPoolExecutor — настраиваемый пул
    · ForkJoinPool — для рекурсивных задач (Java 7+)

    5. Future и CompletableFuture
    CompletableFuture.supplyAsync(() -> "result")
        .thenApply(String::toUpperCase)
        .thenAccept(System.out::println);

    · Асинхронные вычисления
    · Цепочки вызовов (Java 8+)

    6. Блокирующие очереди

    · ArrayBlockingQueue — очередь фиксированного размера
    · LinkedBlockingQueue — неограниченная или ограниченная
    · PriorityBlockingQueue — с приоритетами
    · SynchronousQueue — передача между потоками

    7. Мьютексы и локаторы

    · ReentrantLock — альтернатива synchronized с дополнительными функциями
    · ReentrantReadWriteLock — разделение на чтение/запись
    · StampedLock — оптимистичные блокировки (Java 8)

    Важные концепции

    CAS (Compare-And-Swap)

    · Основа атомарных операций
    · Unsafe.compareAndSwapInt() под капотом
    · Избегаем блокировок

    Happens-before

    · Гарантии памяти при работе с volatile, synchronized, concurrent-классами

    Паттерны

    · Producer-Consumer (очереди)
    · Fork-Join (ForkJoinPool)
    · Пул потоков

    Примеры использования
    // CountDownLatch - ожидание завершения
    CountDownLatch latch = new CountDownLatch(3);
    // потоки вызывают latch.countDown()
    latch.await(); // main ждёт завершения

    // ConcurrentHashMap
    Map<String, String> map = new ConcurrentHashMap<>();
    map.computeIfAbsent("key", k -> "value");

    // CompletableFuture - комбинирование
    CompletableFuture<Void> all = CompletableFuture.allOf(
        future1, future2, future3
    );

    Практические советы

        1. Выбор инструмента:
       · ConcurrentHashMap вместо Collections.synchronizedMap()
       · ExecutorService вместо ручного создания потоков
       · CompletableFuture для асинхронных цепочек
    2. Избегайте:
       · Взаимных блокировок (deadlock)
       · Активного ожидания (busy waiting)
       · Гонок за ресурсами (race conditions)
    3. Производительность:
       · Чтение > запись → ReadWriteLock
       · Много потоков → non-blocking алгоритмы (CAS)
       · Кратковременные задачи → пул потоков
         */
}
