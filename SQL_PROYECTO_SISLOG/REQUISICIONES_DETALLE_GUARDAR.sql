USE [SISlog]
GO
/****** Object:  StoredProcedure [dbo].[spRequisionesGuardar]    Script Date: 18/01/2021 4:15:21 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,....>
-- Create date: <Create Date,.....,>
-- Description:	<Description,...................,>
-- =============================================
CREATE PROCEDURE [dbo].[spRequisioneDetalleGuardar]

 @emp_requisicion Int, 
 @cc_requisicion Nvarchar(4),  
 @num_requisicion Nvarchar(9),
 @mat_detrequi Nvarchar(8), 
 @cant_detrequi decimal(18,2), 
 @apro_detrequi decimal(18,2), 
 @obs_requisicion Nvarchar(250)

AS
BEGIN


   SET NOCOUNT ON;

	INSERT INTO requisicion_detalle (emp_detrequi, 
	                                 cc_detrequi,
									 num_detrequi,
									 mat_detrequi, 
									 cant_detrequi, 
									 apro_detrequi, 
									 obs_detrequi)
    VALUES (@emp_requisicion,
	        @cc_requisicion,
			@num_requisicion,@mat_detrequi,@cant_detrequi,@apro_detrequi,@obs_requisicion) 


END
