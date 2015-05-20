USE [dmaa0914_2Sem_1]
GO

/****** Object:  StoredProcedure [dbo].[FindOrder]    Script Date: 20-05-2015 22:05:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[FindOrder]
	-- Add the parameters for the stored procedure here
	@orderid int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT O.id AS Order_ID, O.date AS Order_Date, R.id AS Restaurant_ID, R.name AS Restaurant_name, R.email AS Restaurant_Email, R.website AS Restaurant_Website, R.phone AS Restaurant_Phone, R.street AS Restaurant_Street, RT.zip AS Restaurant_zip, RT.name AS Restaurant_Town_Name, P.id AS Customer_ID, P.name AS Customer_Name, C.email AS Customer_email , P.zip AS Customer_zip, 
	CT.name AS Customer_Town_Name, P.street AS Customer_Street, p.phone AS Customer_Phone, PS.id as PartStep_ID, PS.startDate AS Partstep_startdate, S.id AS Step_ID, S.name AS Step_Name, S.description AS Step_Description, S.is_last_step AS Step_Is_Last,
	EOP.employee_no, E.person_id AS Employee_Person_ID, E.position AS Employee_Position, E.employee_no AS Employee_no, EP.name AS Employee_Name, EPT.zip AS Employee_zip, EPT.name AS Employee_Town_Name, EP.street AS Employee_Street, EP.phone as Employee_Phone
	FROM [Order] AS O 
	INNER JOIN Restaurant AS R ON O.rest_id = R.id 
	INNER JOIN Town AS RT ON R.zip = RT.zip
	INNER JOIN Person AS P ON O.customer_id = P.id 
	INNER JOIN Customer AS C ON O.customer_id = C.person_id
	INNER JOIN Town AS CT ON P.zip = CT.zip 
	INNER JOIN PartStep AS PS ON PS.order_id = O.id
	INNER JOIN Step AS S ON PS.step_id = S.id
	LEFT JOIN EmployeesOnPartStep AS EOP ON PS.id = EOP.partstep_id
	FULL OUTER JOIN Employee AS E ON E.employee_no = EOP.employee_no
	FULL OUTER JOIN Person AS EP ON EP.id = E.person_id
	FULL OUTER JOIN Town AS EPT ON EP.zip = EPT.zip
	WHERE O.id = @orderid
	ORDER BY Partstep_startdate
END

GO


