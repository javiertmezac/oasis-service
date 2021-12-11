
### version 1.3.3
ADDED NEW SP PaidNotesList

This SP is going to list all the notes that are already paid.

There is something particular in the way the having in this statement works, that it cannot be done 
through Mybatis DynamisSql.

take a look at the ./stored-procedures/PaidNotesLis.sql

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