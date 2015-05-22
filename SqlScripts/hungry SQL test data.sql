use dmaa0914_2Sem_1 
DECLARE @PersonID INT;
DECLARE @EmployeePersonID INT;
DECLARE @RestaurantID INT;
DECLARE @ProductID INT;
DECLARE @OrderID INT;
DECLARE @stepBagerID INT;
DECLARE @stepPizzaIOvnID INT;
DECLARE @stepPizzaHentet INT;
DECLARE @stepPizzaAfleveres INT;
DECLARE @stepPizzaErPåVej INT;
DECLARE @stepPizzaErAfleveret INT;

INSERT INTO [Town] (zip, name) VALUES(9400, 'Nørresundby');
INSERT INTO [Town] (zip, name) VALUES(9000, 'Aalborg');

INSERT INTO [Person] (name, zip, street, phone) VALUES('Jens Henrik', 9400, 'Møllevej 4, 1', '+45 25363897');
SET @PersonID = scope_identity();
INSERT INTO [Person] (name, zip, street, phone) VALUES('Per Jensen', 9000, 'vesterbro 2', '+45 54545555');
SET @EmployeePersonID = scope_identity();

INSERT INTO [Customer] (person_id, email) VALUES(@PersonID, 'kim@jenshenrik.dk');


INSERT INTO [Restaurant] (name, street, zip, phone, email, website) VALUES('Jørgen Pizaa A/S', 'vesterbro 55', 9000, '+45 22222222', 'kontakt@joergen.dk', 'http://www.joergenpizza.dk');
SET @RestaurantID = scope_identity();

INSERT INTO Employee (person_id, position, rest_id, employee_no) VALUES(@EmployeePersonID, 'Pizza-bager', @RestaurantID, 1);

INSERT INTO [Product] (name, price, rest_id) VALUES('Pizza', '55.0', @RestaurantID);
SET @ProductID = scope_identity();

INSERT INTO [Order] ([date], rest_id, customer_id) VALUES(GETDATE(), @RestaurantID, @PersonID);
SET @OrderID = scope_identity();

INSERT INTO [PartOrder] (amount, product_id, order_id) VALUES('2', @ProductID, @OrderID);

INSERT INTO [Step] (name, description, rest_id, is_last_step) VALUES('Bager pizza', 'Laver pizza til ovnen', @RestaurantID, 'false');
SET @stepBagerID = scope_identity();
INSERT INTO [Step] (name, description, rest_id, is_last_step) VALUES('Pizza i ovnen', 'Pizza er i ovnen', @RestaurantID, 'false');
SET @stepPizzaIOvnID = scope_identity();

INSERT INTO [StepRelation] (step_id, nextstep_id) VALUES(@stepBagerID, @stepPizzaIOvnID);

INSERT INTO [Step] (name, description, rest_id, is_last_step) VALUES('Pizza skal hentet', 'pizza skal hentet', @RestaurantID, 'false');
SET @stepPizzaHentet = scope_identity();

INSERT INTO [StepRelation] (step_id, nextstep_id) VALUES(@stepPizzaIOvnID, @stepPizzaHentet);

INSERT INTO [Step] (name, description, rest_id, is_last_step) VALUES('Pizza skal afleveres', 'Pizza skal afleveres', @RestaurantID, 'false');
SET @stepPizzaAfleveres = scope_identity();

INSERT INTO [StepRelation] (step_id, nextstep_id) VALUES(@stepPizzaIOvnID, @stepPizzaAfleveres);

INSERT INTO [Step] (name, description, rest_id, is_last_step) VALUES('Pizza er på vej', 'Pizza er afleveret', @RestaurantID, 'false');
SET @stepPizzaErPåVej = scope_identity();

INSERT INTO [StepRelation] (step_id, nextstep_id) VALUES(@stepPizzaAfleveres, @stepPizzaErPåVej);

INSERT INTO [Step] (name, description, rest_id, is_last_step) VALUES('Pizza er afleveret eller hentet', 'Pizza er afleveret eller hentet', @RestaurantID, 'false');
SET @stepPizzaErAfleveret = scope_identity();

INSERT INTO [StepRelation] (step_id, nextstep_id) VALUES(@stepPizzaErPåVej, @stepPizzaErAfleveret);
INSERT INTO [StepRelation] (step_id, nextstep_id) VALUES(@stepPizzaHentet, @stepPizzaErAfleveret);
