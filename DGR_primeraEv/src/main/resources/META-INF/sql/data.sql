insert into fincas (nombre) values ("Garcia");
insert into fincas (nombre) values ("Rodil");
insert into fincas (nombre) values ("Sanz");
insert into tratamientos (producto, dosis) values ("paracetamol", 10);
insert into tratamientos (producto, dosis) values ("aferalgan", 7);
insert into tratamientos (producto, dosis) values ("timina", 15);
insert into fincastratamientos (idFinca, idTratamiento, fecha) values (1,1, current_date);
insert into fincastratamientos (idFinca, idTratamiento, fecha) values (2,2, current_date);
insert into fincastratamientos (idFinca, idTratamiento, fecha) values (3,3, current_date);