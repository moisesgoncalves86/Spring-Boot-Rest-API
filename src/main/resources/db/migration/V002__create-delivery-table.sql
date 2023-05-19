create table delivery(
	id bigint not null auto_increment,
    customer_id bigint not null,
    delivery_fee decimal(10,2) not null,
    status varchar(20) not null,
    request_date datetime,
    checkout_date datetime,
    
    recipient_name varchar(60) not null,
    recipient_street varchar(255) not null,
    recipient_number varchar(30) not null,
    recipient_floor varchar(60),
    recipient_city varchar(30) not null,
    
    primary key (id)
    
);

alter table delivery add constraint customer_delivery_fk foreign key (customer_id) references customer (id);