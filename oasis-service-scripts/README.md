### version 1.7.0
ADDED new SP PaidNotesListV2
This SP performs a like operation on 'clientName', 'orderId (idPedido)', 'note(noNota)'
it also includes offset and fetch_first rows (pagination)

script:  [PaidNotesListV2](./stored-procedures/PaidNotesListV2.sql)

### version 1.6.0
ADDED REPORTS
created SP to fetch clients that have not set and order within the las 30 days

script: reports/not-order-in-30-days.sql

### version 1.5.0
ADDED NEW TABLE "CLIENT CLEANING TANK RECORD" to track every time a 
new date for next cleaning is assigned.

Script: createTable-ClientCleaningTankRecord

ADDED nextCleaningComments COLUMN to EMPRESAS

`alter table Empresa
add nextCleaningComments varchar(250) null`

### version 1.3.3
ADDED NEW SP PaidNotesList

This SP is going to list all the notes that are already paid.

There is something particular in the way the having in this statement works, that it cannot be done 
through Mybatis DynamisSql.

take a look at the [PaidNotesLis](./stored-procedures/PaidNotesLis.sql)

### version 1.3.2
UPDATED BLOQUE

increased "letra" from nchar(3) to varchar(10)
note: this column is part of a PK constraint

follow steps from alter-column.sql file section: 
- alter a column that is part of a PK constraint

UPDATED NOTA

`alter table Nota alter column noNota varchar(20) not null`

UPDATED SERIE-ERROR

`alter table SerieError alter column noNota varchar(20) not null`
 
### version 1.1.0
updated Trabajador
increased name lenght
- changed column
  - nombre nvarchar(40)

### version 1.0.1
updated Empresa DB
it looks like not null values are ignored (pending for verification)
- changed columns
  - calle varchar(35)
  - noInt varchar(10)
  - noExt varchar(10)
  - cPostal varchar(10)
  - sigLavado date 

Sql example:
```
  alter TABLE Empresa
   alter COLUMN sigLavado date;
```