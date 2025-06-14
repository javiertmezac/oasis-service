SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[PaidNotesListV2]
	@offset_rows INT,
    @select_rows INT,
    @search VARCHAR(35)
AS
BEGIN


SELECT n.id as 'noteId',
		n.noNota as 'note',
		n.idPedido as 'orderId',
		e.nombre as  'clientName',
		t.nombre as 'employeeName',
		n.fechaRegistro as 'registration',
		n.litros as 'liters',
		n.creditoContado as 'credit' ,
		n.total as 'total',
		n.total - ISNULL(sum(a.cantidad),0) as 'debt'
	FROM Nota as n
	left outer join Pedido as p on n.idPedido = p.id
	left outer join Empresa as e on p.idEmpresa = e.id
	left outer join Trabajador as t on n.idChofer = t.id
	left outer join view_Abono as a on n.id = a.idNota
    WHERE n.status = 1 and (n.noNota like '%' + @search + '%' or e.nombre like '%' + @search + '%')
	group by n.id, n.noNota,n.idPedido, e.nombre,t.nombre, n.fechaRegistro, n.litros, n.creditoContado, n.total
    having n.total - ISNULL(sum(a.cantidad),0) = 0
    order by n.fechaRegistro desc
    OFFSET @offset_rows ROWS
    FETCH FIRST @select_rows ROWS ONLY
	RETURN
END

GO
