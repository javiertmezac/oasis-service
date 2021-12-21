SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[View_Not_Order_In_30_days]
AS
BEGIN

select *
from Empresa as e
where e.status = 1
and e.id not in (
    select idEmpresa
    from Pedido as p
    join (
        select MAX(fechaRegistro) as maxDate
        from Pedido
        GROUP BY idEmpresa
    ) as t on t.maxDate = p.fechaRegistro
    where p.[status] = 1 and DATEDIFF(day, fechaRegistro, SYSDATETIME()) < 30
)
	RETURN
END

GO
