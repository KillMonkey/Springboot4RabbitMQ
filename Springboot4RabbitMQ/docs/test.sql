create table if not exists t_order(
	id varchar(128) not null,
	name varchar(128),
	message_id varchar(128) not null,
	primary key (id)
) Engine=InnoDB default charset=utf8;

create table if not exists broker_message_log(
	message_id varchar(128) not null,
	message varchar(4000) default null,
	try_count int(4) default 0,
	status varchar(10) default '',
	next_retry timestamp not null default '0000-00-00 00:00:00',
	create_time timestamp not null default '0000-00-00 00:00:00',
	update_time timestamp not null default '0000-00-00 00:00:00',
	primary key (message_id)
) Engine=InnoDB default charset=utf8;