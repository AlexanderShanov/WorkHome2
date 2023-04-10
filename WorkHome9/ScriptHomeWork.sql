delete OtusHomeWork9;


create table QuestionsTest (
Id serial primary key,
Question text 
);

create table OptionsTest(
Id serial primary key,
QuestionId integer references QuestionsTest(Id),
OptionTest text,
Correct boolean
);


insert into QuestionsTest(Question)
values
('Сколько букв сейчас в русском алфавите?'),
('Сколько дней в январе?'),
('Последний свет в радуге');


select * from QuestionsTest;

insert into OptionsTest(QuestionId, OptionTest, Correct)
values
(1, '30', false),
(1, '32', false),
(1, '33', true),
(2, '29', false),
(2, '30', false),
(2, '31', true),
(3, 'Белый', false),
(3, 'Фиолетовый', true),
(3, 'Синий', false);


select q.*, o.* from QuestionsTest as q
join OptionsTest as o on q.Id = o.QuestionId;