use requerimientos;

insert into gerencia (descripcionGerencia) Value ('Comercial');
insert into gerencia (descripcionGerencia) Value ('Operaciones');
insert into gerencia (descripcionGerencia) Value ('Contabilidad');
insert into gerencia (descripcionGerencia) Value ('Soporte');


insert into departamento (descripcionDepartamento, gerenciaId) Value ('Compras',1);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Marketing',1);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Recepcion',2);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Despacho',2);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Gestion Merma',2);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Existencia',3);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Operaciones de Inventario',3);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Contabilidad',3);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Soporte Tecnico',4);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Soporte Operacional',4);
insert into departamento (descripcionDepartamento, gerenciaId) Value ('Desarrollo App',4);


insert into areaResolutora (descripcionArea) Value ('Abastecimiento');
insert into areaResolutora (descripcionArea) Value ('Soporte');


insert into resolutor (nombreResolutor, areaResolutorId) Value ('Mantencion Maquina',1);
insert into resolutor (nombreResolutor, areaResolutorId) Value ('Aseo',1);
insert into resolutor (nombreResolutor, areaResolutorId) Value ('Mantenimiento Moviliario',1);
insert into resolutor (nombreResolutor, areaResolutorId) Value ('Soporte Tecnico',2);
insert into resolutor (nombreResolutor, areaResolutorId) Value ('Soporte Operacional',2);
insert into resolutor (nombreResolutor, areaResolutorId) Value ('Desarrollo App',2);

insert into usuario ( usuario, contraseña ) Value ('aherrera',123456);
insert into usuario (usuario, contraseña) Value ('drodriguez',234567);
insert into usuario (usuario, contraseña) Value ('jcatalan',345678);
