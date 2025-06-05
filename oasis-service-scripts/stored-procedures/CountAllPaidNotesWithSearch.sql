SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[CountAllPaidNotesWithSearch]
    @search VARCHAR(35)
AS
BEGIN

SELECT COUNT(*) AS total_count
FROM (
    SELECT n.id
    FROM Nota AS n
    LEFT OUTER JOIN Pedido AS p ON n.idPedido = p.id
    LEFT OUTER JOIN Empresa AS e ON p.idEmpresa = e.id
    LEFT OUTER JOIN Trabajador AS t ON n.idChofer = t.id
    LEFT OUTER JOIN view_Abono AS a ON n.id = a.idNota
    WHERE n.status = 1 and (n.noNota like '%' + @search + '%' or e.nombre like '%' + @search + '%')
    GROUP BY n.id, n.noNota, n.idPedido, e.nombre, t.nombre, n.fechaRegistro, n.litros, n.creditoContado, n.total
    HAVING n.total - ISNULL(SUM(a.cantidad), 0) = 0
) AS subquery;

	RETURN
END

GO
