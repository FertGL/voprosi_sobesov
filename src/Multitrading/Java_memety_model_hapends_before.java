package Multitrading;

public class Java_memety_model_hapends_before {
    /*
    Java Memory Model(JMM) - описывает поведение потоков в среде исполнения Java

    Happens before - ключевое понятие в JMM, которое определяет гарантии видимости
    изменений памяти между потоками.

    ЕСЛИ СОБИТИЕ А HAPPENS BEFORE СОБЫТИ В, ТО ВСЕ ИЗМЕННИЯ ПАМЯТИ, СДЕЛАНЫЕ
    В А, ГАРАНТИРОВАННО ВИДНЫ ДЛЯ В, КОГДА В ВЫПОЛНЯЕТСЯ.

    Правила

    1) порядок в рамках одного потока(Program Order Rule)

    В рамках одного потока, все действия happens-before(видны) любым действиям, которые
    идут после них в программном порядке.
     */

    int x= 1;//(1)
    int y= 2;//(2) гарантированно видит х=1

    /*
    2) Монитор (lock/synchronized)
        Освобождение монитора(unlock) happens-before последующий захват того же монитора(lock)


    // Поток 1
    synchronized(lock) {
        sharedVar = 42; // (1)
    } // unlock happens здесь

    // Поток 2
    synchronized(lock) { // lock happens здесь (гарантированно после unlock потока 1)
        System.out.println(sharedVar); // Гарантированно увидит 42
    }

    3)Volatile переменные
    Запись в volatile переменную happens-before, последующее чтение той же volatile переменной

    // Поток 1
    volatile boolean flag = false;
    String nonVolatileData = "hello"; // (1)
    flag = true; // (2) volatile write

    // Поток 2
    if (flag) { // (3) volatile read (гарантированно видит запись (2))
        // Гарантированно увидит и nonVolatileData = "hello" из (1)!
        // Потому что (1) happens-before (2) по правилу 1,
        // (2) happens-before (3) по правилу volatile,
        // значит (1) happens-before (3) по транзитивности.
        System.out.println(nonVolatileData);
    }

  */
}
