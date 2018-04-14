-- Ricardo
drop database vendas_des;
create database vendas_des;

use vendas_des;

create table tb_adm_pessoa(codigo_pessoa    bigint primary key
      ,nome             varchar(100) not null
      ,data_nascimento  date null
      ,reporta_se_a     bigint null
 );
alter table tb_adm_pessoa add foreign key (reporta_se_a) references tb_adm_pessoa (codigo_pessoa);

create table tb_adm_produto(codigo_produto bigint primary key
      ,codigo_barras varchar(50)            
      ,nome_produto varchar(200)           
      ,preco_custo float                  
      ,preco_venda float                  
      ,qtd_minima int  
      ,qtd_maxima int                    
      ,qtd_estoque int                    
      ,codigo_produto_pai bigint 
      ,ativo varchar(01)            
 );
alter table tb_adm_produto add foreign key (codigo_produto_pai) references tb_adm_produto (codigo_produto);


create table tb_adm_tipo_endereco
  (
     codigo_tipo_endereco  bigint primary key
    ,nome                  varchar(100) not null
    ,ativo                varchar(1)
  );

create table tb_adm_localidade
  (
      codigo_localidade        bigint primary key
     ,descricao_localidade     varchar(100)
     ,codigo_pai               bigint
     ,ativo                    varchar(1)
  );

alter table tb_adm_localidade add foreign key (codigo_pai) references tb_adm_localidade (codigo_localidade);

-- até aqui


create table tb_adm_pessoa_endereco
  (
      codigo_pessoa bigint          not null
     ,codigo_tipo_endereco          bigint not null
     ,nome_rua                      varchar(100)
     ,numero                        varchar(10)
     ,compl                         varchar(50)
     ,codigo_localidade_bairro      bigint
     ,codigo_localidade_cidade      bigint
     ,codigo_localidade_pais        bigint
     ,codigo_cep                    varchar(50)
  );

alter table tb_adm_pessoa_endereco add primary key (codigo_pessoa, codigo_tipo_endereco);

create table tb_adm_usuario (
      codigo_usuario      bigint
     ,codigo_pessoa       bigint
     ,alias_usuario       varchar(50) not null
     ,senha               varchar(50)
     ,ativo               varchar(1)
);

create table tb_adm_empresa
 (
      codigo_empresa             int primary key
     ,descricao_empresa          varchar(100)
     ,ativo                      varchar(1)
 );

create table tb_adm_perfil
   (
      codigo_perfil           bigint primary key
     ,nome_perfil                    varchar(200)
     ,fg_sistemas                    varchar(01)
     ,fg_administrador               varchar(01)
    );


create table tb_adm_fase (
    codigo_fase        bigint not null
   ,nome_fase          varchar(200)
   ,ativo              varchar(01)
   ,codigo_fase_pai    bigint not null
);
alter table tb_adm_fase add primary key (codigo_fase, codigo_fase_pai);
 
create table tb_adm_movimento
   (
     codigo_movimento      bigint
    ,codigo_fase           bigint
    ,sequencial            bigint
    ,codigo_produto        bigint
    ,codigo_barras         varchar(50)
    ,nome_produto          varchar(200)
    ,preco_custo           float
    ,preco_venda           float
    ,qtd_estoque           int
    ,fg_cancelado          varchar(1)
   );

