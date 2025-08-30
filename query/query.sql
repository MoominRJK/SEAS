select username, * from users;
select * from organizator;
select username, grade, * from participant order by grade;

select * from authority

select * from user_authorities;

select name, start_date, end_date, * from event;

select * from participants_in_events where participant_id = 5

select * from participants_prize

select * from prize where year = 2023

select * from participants_in_events as pie inner join event as e on e.

select * from event inner join 
participants_in_events as pie on pie.event_id = event.id
where id in (1,112,111,52,110,102,113,103)

UPDATE event set end_date = end_date + interval '3 months'
