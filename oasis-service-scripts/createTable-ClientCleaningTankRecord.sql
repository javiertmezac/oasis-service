SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClientCleaningTankRecord](
	[id] [int] IDENTITY(1,1) NOT NULL,
    [clientId] [int] NOT NULL,
    [tankCleaningDate] [date] NOT NULL,
	[comments] [varchar](250) NULL,
	[status] [bit] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ClientCleaningTankRecord] ADD CONSTRAINT [PK_ClientCleaningTankRecord] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ClientCleaningTankRecord]  WITH CHECK ADD  CONSTRAINT [FK_ClientCleaningTankRecord_Client] FOREIGN KEY([clientId])
REFERENCES [dbo].[Empresa] ([id])
GO
ALTER TABLE [dbo].[ClientCleaningTankRecord] CHECK CONSTRAINT [FK_ClientCleaningTankRecord_Client]
GO
