-- Asignaturas
insert into asignaturas (id, nombre, descripcion, curso)
 select 1, 'Matematicas', 'Aqui aprenderemos a sumar y restar', 1 from dual where not exists (select 1 from asignaturas where id = 1);
 
insert into asignaturas (id, nombre, descripcion, curso)
 select 2, 'Biologia', 'Aqui estudiaremos cómo se forma la vida', 3 from dual where not exists (select 1 from asignaturas where id = 2);
 
insert into asignaturas (id, nombre, descripcion, curso)
 select 3, 'Educacion fisica', 'Aqui aprenderemos a correr', 1 from dual where not exists (select 1 from asignaturas where id = 3);
 
-- Roles
insert into roles (id, rol)
 select 1, 'ADMIN' from dual where not exists (select 1 from roles where id = 1);

insert into roles (id, rol)
 select 2, 'CONSULTA' from dual where not exists (select 1 from roles where id = 2);

 -- Usuarios
insert into usuario (username, nombre, password, rol_id)
 select 'admin', 'Admin Manuel', '$2a$10$5xOe75pbLcAjp0TbVWaluunrSshgYdH82YNwGd.b0Os4hAWbIEkry', 1 from dual where not exists (select 1 from usuario where username = 'admin');

insert into usuario (username, nombre, password, rol_id)
 select 'user', 'Alumno Jose', '$2a$10$5xOe75pbLcAjp0TbVWaluunrSshgYdH82YNwGd.b0Os4hAWbIEkry', 2 from dual where not exists (select 1 from usuario where username = 'user');
 