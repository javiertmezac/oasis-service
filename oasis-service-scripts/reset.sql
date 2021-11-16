
DELETE from Abono;
delete from Bloque;
delete from Nota;
delete from Pedido;
delete from SerieError;
delete from Trabajador;

DBCC CHECKIDENT ('Abono', RESEED, 0);
DBCC CHECKIDENT ('Bloque', RESEED, 0);
DBCC CHECKIDENT ('Nota', RESEED, 0);
DBCC CHECKIDENT ('Pedido', RESEED, 0);
DBCC CHECKIDENT ('SerieError', RESEED, 0);
DBCC CHECKIDENT ('Trabajador', RESEED, 0);