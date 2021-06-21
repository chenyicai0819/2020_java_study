/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021-06-15 20:48:42                          */
/*==============================================================*/

use test2;

drop table if exists tb_role;

drop table if exists tb_role_permission;

drop table if exists tb_tree;

drop table if exists tb_user;

drop table if exists tb_user_role;

/*==============================================================*/
/* Table: tb_role                                               */
/*==============================================================*/
create table tb_role
(
   RoleId               varchar(100) not null,
   RoleName             varchar(50),
   RoleDesc             varchar(100),
   primary key (RoleId)
);

/*==============================================================*/
/* Table: tb_role_permission                                    */
/*==============================================================*/
create table tb_role_permission
(
   RoleId               varchar(100) not null,
   TreeId               varchar(100) not null,
   primary key (RoleId, TreeId)
);

/*==============================================================*/
/* Table: tb_tree                                               */
/*==============================================================*/
create table tb_tree
(
   TreeId               varchar(100) not null,
   ParentId             varchar(100),
   Title                varchar(100),
   MenuDesc             varchar(100),
   Url                  varchar(100),
   primary key (TreeId)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   UserId               varchar(100) not null,
   UserName             varchar(40),
   Password             varchar(100),
   RealName             varchar(30),
   Email                varchar(100),
   State                varchar(4),
   CreateTime           date,
   primary key (UserId)
);

/*==============================================================*/
/* Table: tb_user_role                                          */
/*==============================================================*/
create table tb_user_role
(
   UserId               varchar(100) not null,
   RoleId               varchar(100) not null,
   primary key (UserId, RoleId)
);

alter table tb_role_permission add constraint FK_Reference_3 foreign key (RoleId)
      references tb_role (RoleId) on delete restrict on update restrict;

alter table tb_role_permission add constraint FK_Reference_4 foreign key (TreeId)
      references tb_tree (TreeId) on delete restrict on update restrict;

alter table tb_tree add constraint FK_Reference_5 foreign key (ParentId)
      references tb_tree (TreeId) on delete restrict on update restrict;

alter table tb_user_role add constraint FK_Reference_1 foreign key (UserId)
      references tb_user (UserId) on delete restrict on update restrict;

alter table tb_user_role add constraint FK_Reference_2 foreign key (RoleId)
      references tb_role (RoleId) on delete restrict on update restrict;

