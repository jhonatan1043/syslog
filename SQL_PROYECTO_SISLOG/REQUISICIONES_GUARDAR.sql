GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,....>
-- Create date: <Create Date,.....,>
-- Description:	<Description,...................,>
-- =============================================
CREATE PROCEDURE dbo.spRequisionesGuardar

 @emp_requisicion Int, 
 @cc_requisicion Nvarchar(4),  
 @fecha_requisicion Date, 
 @tipo_requisicion char(1), 
 @estado_requisicion char(1), 
 @obs_requisicion Nvarchar(250), 
 @fecha_ap Date, 
 @user_ap Nvarchar(20), 
 @clase_requisicion Nvarchar(5), 
 @user_rq Nvarchar(20), 
 @interno_requisicion Nvarchar(10)

AS
BEGIN
   DECLARE @prefijo NVARCHAR(10);
   DECLARE @consecutivo NVARCHAR(20);
   DECLARE @num_requisicion Nvarchar(9);

   SET NOCOUNT ON;

	SET  @consecutivo = (SELECT req_cc FROM centroscosto WHERE cod_cc= @cc_requisicion AND emp_cc = @emp_requisicion);

	SET @prefijo = '0000' + @consecutivo

	SET @num_requisicion = TRIM(@cc_requisicion) + '-' + SUBSTRING(@prefijo, LEN(@prefijo - 4), 4)

	-- txtNumero.Text = Trim(txtCodigoCC.Text) + "-" + ConsecutivoReal.Substring(Len(ConsecutivoReal) - 4, 4)

	INSERT INTO requisicion(emp_requisicion, 
	                        cc_requisicion, 
							num_requisicion, 
							fecha_requisicion, 
							tipo_requisicion, 
							estado_requisicion, 
							obs_requisicion, 
							fecha_ap, user_ap, 
							clase_requisicion, 
							user_rq, 
							interno_requisicion) VALUES(@emp_requisicion,
							                            @cc_requisicion,
														@num_requisicion,
														@fecha_requisicion,
														@tipo_requisicion,
														@estado_requisicion,
							                            @obs_requisicion,
														@fecha_ap,
														@user_ap,
														@clase_requisicion,
														@user_rq ,
														@interno_requisicion)


	 UPDATE centroscosto SET req_cc = req_cc + 1 
	 WHERE cod_cc = @cc_requisicion
	 AND emp_cc= @emp_requisicion


END
GO
