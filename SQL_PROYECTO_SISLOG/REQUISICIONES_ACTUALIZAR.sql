
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,..........>
-- Create date: <Create Date,........,>
-- Description:	<Description,............,>
-- =============================================
CREATE PROCEDURE [dbo].[spRequisionesActualizar]

 @emp_requisicion Int, 
 @cc_requisicion Nvarchar(4),  
 @fecha_requisicion Date, 
 @tipo_requisicion char(1), 
 @obs_requisicion Nvarchar(250), 
 @clase_requisicion Nvarchar(5), 
 @interno_requisicion Nvarchar(10),
 @num_requisicion Nvarchar(9)

AS
BEGIN

    SET NOCOUNT ON;

	UPDATE  requisicion SET obs_requisicion     = @obs_requisicion,
	                        tipo_requisicion    = @tipo_requisicion, 
							fecha_requisicion   = @fecha_requisicion,
							clase_requisicion   = @clase_requisicion, 
							interno_requisicion = @interno_requisicion
    WHERE   (emp_requisicion = @emp_requisicion) AND (num_requisicion = @num_requisicion) AND (cc_requisicion= @cc_requisicion)

END

