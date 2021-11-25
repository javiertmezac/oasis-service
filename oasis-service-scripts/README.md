
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