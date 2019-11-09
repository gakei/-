create table question
(
    id int auto_increment,
    title varchar(50),
    description TEXT,
    gmt_create BIGINT,
    comment_count int default 0,
    creator int,
    gmt_modified bigint,
    view_count int default 0,
    like_count int default 0,
    tag varchar(256),
    constraint question_pk
        primary key (id)
);

