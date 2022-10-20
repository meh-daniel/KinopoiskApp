# KinopoiskApp
Сделанное тестовое задание по след ТЗ:

https://www.figma.com/file/8FvAWXCD2oD9oSDHx9xFfU/
%D0%A2%D0%B5%D1%81%D1%82%D0%BE%D0%B2%D0%BE%D0%B5-
%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-Android?node-
id=0%3A1

Что надо сделать:
+ Главный экран приложения доставки еды, дизайн по ссылке выше
+ В баннеры можно захардкодить любые фото
+ Основная задача - сделать идентичную планку с категориями и блок
меню(Подсказка. Для реализации можно использовать
CollapsingToolbarLayout)
+ Планка с категориями при скролле должна прилипать к верхнему
бару(для примера можно посмотреть приложение Додо Пицца).
+ В качестве API использовать любой открытый источник подходящий под
текущие нужды
Опционально:
+ Offline-режим: т.е. в случае, если нет доступа к сети, показывать
последние загруженные данные(и ленту, и детали).

Ограничения на стек технологий:
+ MVVM
+ Clean Architecture
+ Остальное на ваше усмотрение

API used in the application:
[https://breakingbadapi.com/](https://kinopoiskapiunofficial.tech/documentation/api/)

# Application design

* Presentation
    * SingleActivity
    * ModelUI
    * Screens
        * Fragments
        * ViewModels
        * Adapters
        * ViewStates
        * ViewActions
* Domain
    * Repository
    * Model
* Data
    * Mappers
    * RepositoryImpl
    * NW
        * Api
        * ModelNW
    * DB
        * Dao
        * DataBase
        * ModelSW
* Di
    * NetworkModule
    * ComponentModule
* Core
    * BaseFragment
    * BaseViewModel
* App


| | | |
|:-------------------------:|:-------------------------:|:-------------------------:|
|<img width="1604"  src="https://github.com/meh-daniel/KinopoiskApp/blob/dev/githubphoto/KinopoiskPhoto1.jpg"> |  <img width="1604" src="https://github.com/meh-daniel/KinopoiskApp/blob/dev/githubphoto/KinopoiskPhoto2.jpg">|<img width="1604" src="https://github.com/meh-daniel/KinopoiskApp/blob/dev/githubphoto/KinopoiskPhoto3.jpg">|


### Use case:
+ Просмотр рекламы
+ Получение списка категорий и поиск фильмов по ним
+ Получение списка фильмов



# Анализ Данной работы и некоторые обьяснения
+ ТЗ задания я полностью выполнил.
+ Ограничение на стек технологий соблюдал.
+ Так как в тз было сказано что айпи не важен, я использовал айпи от кинопоиска, потому что суть задания было сделать выборку по категориям и в зависимости от того какая категория- отображать соответствующие данные. Надеюсь то что в айпи не еда- не критично:)
+ Я не стал делать ничего лишнего по ТЗ, так как считаю что нужно делать согласну ТЗ, и не добавлять ничего лишнего, так как бизнесу приходиться платить за то что бизнес не хотел видеть. Поэтому нет реализации другим экранам,и экрану с детальной информацией.
+ Присутствует баг, когда перемещаешься на другой экран, и возвращаешься на экран menu, то тулбар menu пропадает.
+ Задание сделал до окончания срока выполнения и потратил на него 21 час.
