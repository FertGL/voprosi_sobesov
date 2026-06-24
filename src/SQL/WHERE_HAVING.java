package SQL;

public class WHERE_HAVING {
    /*
    разница
    в having - можно использовать агрегаторы(например avg)
    SELECT department, AVG(salary) AS avg_salary
    FROM employees
    GROUP BY department
    HAVING avg_salary > 6500;

    WHERE — фильтрует строки до группировки
    HAVING — фильтрует группы после GROUP BY

    - HAVING → после GROUP BY для фильтрации агрегатов по группам
    - WHERE + подзапрос → для сравнения с агрегатом по всей таблице

    Порядок выполнения запроса
    FROM → JOIN → WHERE → GROUP BY → HAVING → SELECT → ORDER BY
     */
}
