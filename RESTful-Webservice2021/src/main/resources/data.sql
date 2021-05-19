insert into JpaUser values(1001, sysdate(), 'Adam');
insert into JpaUser values(1002, sysdate(), 'Jack');
insert into JpaUser values(1003, sysdate(), 'Jill');
insert into JpaUser values(1004, sysdate(), 'Henry');

insert into Post values(1111, 'My First Post-Adam', 1001);
insert into Post values(2222, 'My Second Post-Adam', 1001);
insert into Post values(3333, 'My First Post-Jill', 1003);
insert into Post values(4444, 'My First Post-Henry', 1004);