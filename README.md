# Reference project for the CROC Java school
### CROC Coder
Онлайн-система решения и проверки задач (на языке Java).

#### Описание проекта
В рамках системы преподаватель регистрируют курсы, каждый из которых состоит из задач, которые предлагается решить ученикам. Преподаватель описывает условия задач курса, а ученики сабмитят их решения (тексты/архивы программ на языке Java). Присланные решения автоматически проверяются системой на наборе тестов, заданном преподавателем и в случае успешного прохождения задача помечается для ученика как решенная и он получает доступ к “эталонному решению”, предоставленному преподавателем. В процессе прохождения курса ученикам доступна статистика по решениям и рейтинг участников курса.

В системе предусматриваются две роли: преподаватель (автор) и ученик (или участник). Преподаватель управляет задачами и их ограничениями, а ученик решает задачи. Регистрация в системе открытая, каждый новый зарегистрированный пользователь получает роль ученика, которая впоследствии может быть изменена на роль преподавателя другим преподавателем.
#### Задачи и курсы
Все задачи в системе группируются по курсам. Курс может быть либо открытым (доступным всем ученикам), либо закрытым. Доступностью закрытых курсов ученикам управляют преподаватели.

Курс состоит из набора задач. Для каждой задачи преподаватель задает: 
* текстовое описание условия в произвольной форме (возможность использовать форматирование и добавлять изображения будет плюсом);
* уровень сложности: низкий, средний или высокий;
* один или несколько примеров входных и выходных данных;
* шаблон Java-класса, который должен быть реализован в решении;
* набор тестовых кейсов (не доступных в процессе решения);
* ограничения (см. ниже;
* “эталонное” решение.

#### Ограничения задачи.
* Интервал доступности задачи (опционально). Решения принимаются только в указанный временной период. До даты начала задача недоступна и не видна участнику, после даты окончания - доступна только для просмотра без возможности сдачи решения.
* Максимальное время исполнения для каждого теста. Если решение не завершается за отведенный временной интервал, попытка считается неуспешной.
* Максимальный размер оперативной памяти, которое может использовать решение.
* Максимальный размер дискового пространства, которое может использовать решение.
#### Отправка решений
Ученик может отправить решение двумя способами. Если решение состоит из одного Java-класса, для его отправки предусматривается форма на странице задачи. Если решение состоит из нескольких классов, ученик может загрузить архив, содержащий все классы решения. После загрузки система отображает статус проверки (ожидание, компиляция, проверка тестов и проч.) и финальный результат.

Механизм автоматической проверки включает следующие шаги.

Решение проверяется на соответствие шаблону Java-класса, указанного в описании задачи. Среди всех файлов решения должен быть публичный класс с требуемым названием, содержащий публичный метод требуемой сигнатуры. Этот класс используется как точка входа для всех тестов.

Затем файлы компилируются.

В случае успешной компиляции запускаются тесты.

Если все тесты пройдены с учетом заданных ограничений задачи, решение помечается как успешное и ученику начисляются рейтинговые баллы по формуле

**_баллы = max (50, 100 - 10 * количество неуспешных попыток)_**

При возникновении ошибки на любом из указанных шагов, решение помечается как неуспешное и для него инкрементируется счетчик неуспешных попыток. В случае непрохождения тестов участнику показывается количество пройденных и непройденных тестов а также входные данные первого не пройденного по порядку теста.
#### Бонусный функционал
Рейтинг участников курсов по суммарному количеству баллов.

Возможность оставлять комментарии к решению (вопросы от учеников и код-ревью со стороны преподавателей).

Режим отладки: проверка решения на тестовых данных ученика.


#### Checkpoints
- [x] Аутентификация
- [x] Регистрация пользователя
- [ ] (*) Импорт задач из файла (csv, json, xml)
- [x] Создание курса (доступно только для учителя)
- [x] Создание задачи (доступно только для учителя)
- [x] Получение списка задач курса
- [x] Добавление участника на курс (enroll)
- [ ] Сабмит задачи
- [ ] Получение статистики по решениям для ученика
- [ ] Получение сводной статистики по курсу (доступно учителю)

#### Other things
- [ ] Transfer working with dto to controller layer

## Understanding API
2 Roles: 
- AUTHOR
- STUDENT
### AUTHOR
- create course
- create problem
- authentication
- make other students authors
- see summarizing statistics for the courses

### STUDENT
- see open courses
- apply to a course (via invitation or freely to the open course) enroll
- see a course and problems to the applied courses
- submit solution to the problem (check constraints)
- see some statistics
- registering
