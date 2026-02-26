package Patterns.Spring_Patterns.Пораждающие;

public class Singleton {
    /*
    Порождающий паттерн проектирования, который гарантирует, что у класса есть только один
    экземпляр, и предоставляет к нему глобальную точку доступа.

    Конструктор помечается как private, а для создания нового объекта Singleton использует
    специальный метод getInstance(). Он либо создаёт объект, либо отдаёт существующий объект,
    если он уже был создан.

    private static Singleton instance;

    public static Singleton getInstance() {
       if (instance == null) {
           instance = new Singleton();
                }
       return instance;
    }
    +: можно не создавать множество объектов для ресурсоемких задач, а пользоваться одним
    -: нарушает принцип единой ответственности, так как его могут использовать множество объектов

    Почему считается антипаттерном?
    -Нельзя тестировать с помощью mock, но можно использовать powerMock.
    -Нарушает принцип единой ответственности
    -Нарушает Open/Close принцип, его нельзя расширить

    Можно ли его синхронизировать без synchronized у метода?
    -Можно сделать его Enum (eager). Это статический final класс с константами.
    JVM загружает final и static классы на этапе компиляции, а значит несколько потоков не
    могут создать несколько инстансов.
    -C помощью double checked locking (lazy). Synchronized внутри метода:

    private static volatile Singleton instance;

    public static Singleton getInstance() {
                    Singleton localInstance = instance;
                    if (localInstance == null) {                       // first check
                            synchronized (Singleton.class) {
                                    localInstance = instance;
                                    if (localInstance == null) {       // second check
                                            instance = localInstance = new Singleton();
                                    }
                            }
                    }
                    return localInstance;
            }
     */
}
