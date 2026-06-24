package Разное;

public class RestControllerAdvice {
    /*
    @RestControllerAdvice — это специализированная аннотация Spring, которая объединяет в себе:

    @ControllerAdvice — позволяет создавать глобальные обработчики исключений, которые применяются
    ко всем контроллерам в приложении.
    @ResponseBody — автоматически сериализует возвращаемые объекты в JSON (или другой формат,
    настроенный через HttpMessageConverter).

    То есть @RestControllerAdvice нужен для того, чтобы обрабатывать ошибки и формировать ответы для REST API
    централизованно, без дублирования кода в каждом контроллере.

        Цель глобального обработчика ошибок:

    Централизованная обработка ошибок
    Не нужно писать одинаковый try-catch в каждом методе контроллера. Один класс GlobalExceptionHandler решает это за вас.
    Унифицированный формат ответа
    Все ошибки API имеют одинаковую структуру, что упрощает клиентскую обработку.
    Сокрытие деталей реализации
    Вы можете возвращать только нужную информацию клиенту, не раскрывая стек-трейсы или внутренние детали сервера.
    Легкость поддержки
    Изменить логику обработки ошибок достаточно в одном месте.

    @RestControllerAdvice работает с механизмом ExceptionHandler в Spring MVC.
    Когда Spring обрабатывает запрос к контроллеру, если выбрасывается исключение:
    Сначала ищется метод @ExceptionHandler внутри самого контроллера.
    Если не найден — Spring ищет глобальный @ControllerAdvice/@RestControllerAdvice.
    Это позволяет гибко комбинировать локальную и глобальную обработку ошибок.

    Можно комбинировать, используя атрибут basePackages или assignableTypes у @RestControllerAdvice,
    чтобы ограничить область действия.

    Пример ограничения действия:

    @RestControllerAdvice(basePackages = "com.example.api")
    public class ApiExceptionHandler { ... }

    Для отловки ошибок разные инструменты
    Controller     → @ExceptionHandler
    Global MVC     → @RestControllerAdvice
    Spring Core    → HandlerExceptionResolver
    Filter layer   → Filter / OncePerRequestFilter
    Security       → AuthenticationEntryPoint
    Service layer  → AOP

    Пример RestControllerAdvice

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(
                            ex.getMessage(),
                            "USER_NOT_FOUND",
                            404
                    ));
        }
     */
}
