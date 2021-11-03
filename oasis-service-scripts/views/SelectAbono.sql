-- view_Abono
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[View_Abono] as
Select * from Abono
where status = 1

GO
