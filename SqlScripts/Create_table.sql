use dmaa0914_2Sem_1 

create table Town(
	zip		int not null primary key,
	name	nvarchar(max) not null
);

create table Restaurant(
	id		int		not null primary key identity(1,1),
	name	nvarchar(max) not null,
	street	nvarchar(max) not null,
	zip		int not null,
	phone	nvarchar(max) not null,
	email	nvarchar(max) not null,
	website	nvarchar(max)
	foreign key(zip) references Town(zip)
); 

create table Product(
	id		int		not null primary key identity(1,1),
	name	nvarchar(max) not null,
	price	decimal(2) not null,
	rest_id	int		not null
	foreign key(rest_id) references Restaurant(id)
);

create table Person(
	id		int		not null primary key identity(1,1),
	name	nvarchar(max) not null,
	zip		int not null,
	street	nvarchar(max) not null,
	phone	nvarchar(max) not null
	foreign key(zip) references Town(zip)
);

create table Employee(
	person_id	int	not null,
	position	nvarchar(max) not null,
	rest_id		int not null,
	employee_no	int not null,
	primary key(rest_id, employee_no), 
	foreign key(person_id) references Person(id),
	foreign key(rest_id) references Restaurant(id)
);

create table Customer(
	person_id	int not null,
	email		nvarchar(max) not null
	foreign key(person_id) references Person(id)
);

create table [Order](
	id		int		not null primary key identity(1,1),
	[date]	datetime default(getDate()) not null,
	rest_id	int		not null,
	customer_id	int not null
	foreign key(rest_id) references Restaurant(id),
	foreign key(customer_id) references Person(id)
);

create table PartOrder(
	id			int		not null	primary key identity(1,1),
	amount		int		not null,
	product_id	int		not null,
	order_id	int		not null
	foreign key(product_id) references Product(id),
	foreign key(order_id) references [Order](id)
);

create table Step(
	id				int		not null	primary key identity(1,1),
	name			nvarchar(max) not null,
	[description]	nvarchar(max) not null,
	rest_id			int		not null,
	is_last_step	bit not null
	foreign key(rest_id) references Restaurant(id)
);

create table PartStep(
	id			int		not null	primary key identity(1,1),
	startDate	datetime default(getDate()) not null,
	step_id		int		not null,
	order_id	int		not null,
	foreign key(step_id) references Step(id),
	foreign key(order_id) references [Order](id)
);

create table StepRelation(
	step_id		int		not null	primary key,
	nextstep_id	int		not null	primary key
	foreign key(step_id)	references Step(id),
	foreign key(nextstep_id) references Step(id)
);

create table PartStepEmployee(
	partstep_id		int not null,
	employee_no		int	not null,
	primary key(partstep_id, employee_no),
	foreign key(partstep_id) references Partstep(id),
	foreign key(employee_no) references Person(id)
);