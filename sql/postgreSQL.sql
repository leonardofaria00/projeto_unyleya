-- Database: banco_unyleya

-- DROP DATABASE banco_unyleya;

CREATE DATABASE banco_unyleya
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

------------------------------------

 -- Table: public.pessoa

-- DROP TABLE public.pessoa;

CREATE TABLE public.pessoa
(
  id integer NOT NULL,
  endereco character varying(255),
  idade integer,
  nome character varying(255),
  status integer,
  CONSTRAINT pessoa_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.pessoa
  OWNER TO postgres;