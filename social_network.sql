-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Авг 10 2021 г., 10:08
-- Версия сервера: 10.4.18-MariaDB
-- Версия PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `social_network`
--

-- --------------------------------------------------------

--
-- Структура таблицы `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `post_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `comments`
--

INSERT INTO `comments` (`id`, `comment`, `post_id`, `user_id`, `date`) VALUES
(1, 'qwer', 1, 2, '2021-08-08 09:12:49'),
(2, 'h', 2, 2, '2021-08-08 09:46:09'),
(3, 'нннн', 3, 2, '2021-08-08 09:46:13'),
(5, 'tttt', 1, 2, '2021-08-08 04:45:37'),
(6, 'ГО', 13, 1, '2021-08-08 05:56:48'),
(7, 'БРООО', 1, 1, '2021-08-08 06:40:33');

-- --------------------------------------------------------

--
-- Структура таблицы `followers`
--

CREATE TABLE `followers` (
  `id` int(11) NOT NULL,
  `id_follower` int(11) NOT NULL,
  `id_subscriber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `followers`
--

INSERT INTO `followers` (`id`, `id_follower`, `id_subscriber`) VALUES
(10, 1, 2),
(11, 1, 3),
(12, 2, 1),
(13, 1, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `like_post`
--

CREATE TABLE `like_post` (
  `id` int(11) NOT NULL,
  `id_post` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `do_like` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `like_post`
--

INSERT INTO `like_post` (`id`, `id_post`, `id_user`, `do_like`) VALUES
(1, 1, 2, 1),
(2, 2, 2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `post_text` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `user_id` int(11) NOT NULL,
  `count_like` int(11) NOT NULL,
  `for_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `posts`
--

INSERT INTO `posts` (`id`, `post_text`, `date`, `user_id`, `count_like`, `for_user`) VALUES
(1, 'йцук', '2021-08-08 11:45:37', 2, 5, 2),
(2, 'ПОСТ', '2021-08-08 11:45:28', 2, 1, 2),
(3, 'НИЧЕГО', '2021-08-08 11:45:32', 2, 0, 2),
(13, 'Го знакомиться!', '2021-08-08 11:45:34', 2, 0, 1),
(14, 'Я ТУТ!', '2021-08-08 06:35:00', 1, 0, 1),
(15, 'Я ДУРАЧОК!', '2021-08-08 23:04:25', 3, 0, 3),
(16, 'здарова', '2021-08-09 07:12:39', 2, 0, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `u_name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `university` varchar(255) NOT NULL,
  `about` varchar(255) NOT NULL,
  `birthdate` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `followers_count` int(11) NOT NULL,
  `subscribers_count` int(11) NOT NULL,
  `post_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `u_name`, `surname`, `password`, `email`, `university`, `about`, `birthdate`, `gender`, `city`, `phone`, `image_path`, `followers_count`, `subscribers_count`, `post_count`) VALUES
(1, 'MIke', 'Kartashyan', '123', 'c@mail.ru', 'Ак ПРЕСТИЖ', 'Я ТАКОЙ! AFASFАФЫА ФЫА ФЫА ФЫ  ФЫОА ФЛЫАО ЛФДЫО АДЛФЫО АДЛФОЫ ДАЛФО ДФЫДЛА ОФДЛЫО АДЛФ', '5 Сен 1995', 'Мужской', 'Алматы', 78887878, 'https://memepedia.ru/wp-content/uploads/2020/06/super-sus-memy-360x270.jpg', 0, 0, 0),
(2, 'serj', 'serj', '123', 'se@mail.ru', 'Не указано', 'Не указано', '20 Ноя 1993', 'Мужской', 'Не указано', 0, 'https://cdn.fishki.net/upload/post/2019/09/26/3097770/cdyhgvihgho.jpg', 0, 0, 0),
(3, 'durak', 'durachek', '123', 'd@mail.ru', 'Не указано', 'Не указано', '16 Сен 2005', 'Мужской', 'Не указано', 0, 'https://thumbs.dreamstime.com/b/пользователь-сми-вектора-значка-профиля-аватары-по-умолчанию-176256935.jpg', 0, 0, 0),
(4, 'qwer', 'qwer', '123', 'qwer@mail.ru', 'Не указано', 'Не указано', 'День Месяц Год', 'Женский', 'Не указано', 0, '/image/avatarDefault.jpg', 0, 0, 0);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `post_id` (`post_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Индексы таблицы `followers`
--
ALTER TABLE `followers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_follower` (`id_follower`),
  ADD KEY `id_subscriber` (`id_subscriber`);

--
-- Индексы таблицы `like_post`
--
ALTER TABLE `like_post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_post` (`id_post`),
  ADD KEY `id_user` (`id_user`);

--
-- Индексы таблицы `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `for_user` (`for_user`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `followers`
--
ALTER TABLE `followers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT для таблицы `like_post`
--
ALTER TABLE `like_post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `followers`
--
ALTER TABLE `followers`
  ADD CONSTRAINT `followers_ibfk_1` FOREIGN KEY (`id_follower`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `followers_ibfk_2` FOREIGN KEY (`id_subscriber`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `like_post`
--
ALTER TABLE `like_post`
  ADD CONSTRAINT `like_post_ibfk_1` FOREIGN KEY (`id_post`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `like_post_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`for_user`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
