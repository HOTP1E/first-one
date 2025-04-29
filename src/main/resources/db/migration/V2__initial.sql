create table airplanes
(
    id          bigserial primary key ,
    family      varchar,
    type        varchar,
    year        int,
    seats       int,
    CrewAmount  int
)
