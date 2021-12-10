--    alter a column that is part of a PK constraint
--drop constraint
alter TABLE Bloque drop CONSTRAINT [PK_Bloques]
--alter column
alter table Bloque alter column letra varchar(10) not null
--create the constraint
ALTER TABLE [dbo].[Bloque] ADD  CONSTRAINT [PK_Bloques] PRIMARY KEY CLUSTERED
(
	[letra] ASC,
	[numInicial] ASC,
	[numFinal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]