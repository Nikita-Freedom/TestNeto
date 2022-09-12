# Loader

Loader - мини Android приложение, которое по HHTP запросу получает список курсов, преподаваемых у нас в Netologia!

<img src="[relative/path/in/repository/to/image.svg](https://user-images.githubusercontent.com/44145716/189740059-4c7f5865-61b0-4fce-8a1d-6f25d73ee1c9.png)" width="128" height 128/>

### Для чего?
Для осведомленности будущего ученика о программах, преподаваемых в Netologia. 

## Из чего строили  приложение?

### Стек технологий:

* MVI
    * MVI -  один из шаблонов проектирования Android приложения. На мой взгляд это самый эффективный и простой шаблон. Почему? 
    У многих Android разработчиков идет тенденция к реактивному программированию. Для чего и зачем? Для нашего любиого пользователя. Чем быстрее его приложение откликнится на его действия(нажатие кнопки, переход на другой экран и т.д), тем довольнее он будет. 
    Как добиться в Android приложении максимально быстрого реагирования на действия пользователя? 
    Конечно же использовать необходимые для этого инструменты. 
    MVI - model, view, intent. Где:
    1. model - модель данных. Например это может быть обычный data class c описанием какой-то сущности, например User.
    2. view - представление. То, что видит пользователь. Обычный UI
    3. inent - описание операции, которое хочет сделать пользователь. Иным словом - намерение. Как правило, это действия пользователя (нажатие кнопки, переход на другой экран и т.д).
* Dagger2
    * Для внедрения зависимостей. Dependency Injection (инъекция или внедрение зависимости) — это зависимость одного класса от другого. т.е. для полноценной работы одного класса нужна инициализация другого(их) класса. Dagger это библиотека которая помогает реализовать «внедрение зависимости. Dagger2 значительно упрощает жизнь разработчикам, помогая им как можно меньше писать шаблонного кода.
    * вложенный элемент 2.2
* Coroutines
Вот вы хотите посмотреть список наших прекрасных курсов с нашего моб. приложения. Заходите в приложение, видите лоадер, а затем приложение вылетает. Что вы сделаете? Правильно, пойдете покупать курс на дерьмоСкиллБоксе или на гикпукБрейнс. Вот как так?  Мы только что потеряли клиента из-за кривого приложения, которое его выбесило и расстроило. Почему же это произошло? Может потому что разработчик решил делать HTTP запрос на список в UI потоке? Может это нарушило асинхронную работу приложения? Да не, бред какой-то. А хотя...
    * Kotlin coroutines - блоки кода, которые могут выполняться параллельно с остальным кодом и работать асинхронно друг с другом. В результате программа выполняет несколько функций одновременно.
* Retrofit + Moshi
    * Retrofit самая популярная и удобная библиотека для работы с сетью. С ее помощью можно очень удобно парсить json'ы, отправлять HTTP запросы и получать ответы. 
    Библиотекой удобно пользоваться для запроса к различным веб-сервисам с командами GET, POST, PUT, DELETE. Может работать в асинхронном режиме, что избавляет от лишнего кода.
    Почему Moshi, а не Gson? Причин много, одна из них - кто-то засунул цвета в json, а их надо как-то удобно обработать, в чем помогает @HexColor, а также @ToJson и @FromJson аннотации для адаптеров.
* Compose
Почему compose? Переходить с xml на compose то же самое, что с Android на iPhone. Назад возвращаться не захочется)) Мало того, что compose очень педалируется гуглом, так он еще и очень удобный и неприхотливый. По моему опыту работы с ним, он способен на многое)) Даже на кастомные сложные UI элементы. 
Например вместо убогого написания recycler view, адаптера для него и прочего, можно просто использовать LazyColumn от compose, который внутри себя и содержит тот самый recycler и не знать горя. 
* Подобие многомодульности. 
Почему подобие? Потому что модуль у меня один, так как не вижу смысла делать многомодульность в проекте состоящим из одной фичи. Поэтому я решил сосредоточить все в одном модуле, выделив отдельным пакетом главную фичу-courses. Про многомодульность и почему это нужно рассказывать не буду, думаю вы и так знаете, а если нет, дайте знать-расскажу!)


### Что можно было бы доработать в данном приложении?

1. Во первых добавить многомодульность если приложение бы расширялось. Прежде всего для инверсии зависимостей.
2. Добавить Swipe refresh. 
3. Добавить обработку ошибок как от сервера так и на стороне юзера.
4. Дизайн))
5. Добавить сортировку по группам и направлениям.
6. Добавить больше абстракции в код для гибкости. Имею в виду больше классов оберток для корутин(реактивные модели и тд) и прочее.


### Опасные места в коде.

1. Во первых, я исопльзую общие модели для data и iu слоев, так делать нежелательно, так как нарушается один из принципов SOLID.
2. Не везде есть обработка ошибок от сервера. Я добавил обработчик ошибки на цвет, но в связи со спекой(которой нет) я не сделал обработку к примеру пустых или некорректных полей из json.


