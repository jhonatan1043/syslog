USE [SISlog]
GO
/****** Object:  StoredProcedure [dbo].[spRequisioneDetalleGuardar]    Script Date: 18/01/2021 4:28:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,....>
-- Create date: <Create Date,.....,>
-- Description:	<Description,...................,>
-- =============================================
CREATE PROCEDURE [dbo].[spRequisioneDetalleActualizar]

 @emp_requisicion Int, 
 @cc_requisicion Nvarchar(4),  
 @num_requisicion Nvarchar(9),
 @mat_detrequi Nvarchar(8), 
 @cant_detrequi decimal(18,2), 
 @obs_requisicion Nvarchar(250)

AS
BEGIN


   SET NOCOUNT ON;

              UPDATE  requisicion_detalle SET cant_detrequi = @cant_detrequi,
			                                  obs_detrequi =  @obs_requisicion
				WHERE   (emp_detrequi = @emp_requisicion)
				   AND  (num_detrequi = @num_requisicion) 
				   AND  (cc_detrequi  = @cc_requisicion) 
				   AND  (mat_detrequi = @mat_detrequi) 

END
