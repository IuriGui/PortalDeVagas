

CREATE TABLE "usuario" (
                            "uuid" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                            "email" varchar(100) NOT NULL UNIQUE,
                            "matricula" varchar(8) NOT NULL UNIQUE,
                            "nome" varchar(50) NOT NULL,
                            "endereco" int,
                            "senha" varchar(255) NOT NULL,
                            "role" varchar(50) NOT NULL
                                check ( "role" IN ('ADMIN', 'INSTITUICAO', 'EMPRESA', 'ESTUDANTE', 'OUTRO', 'DESEMPREGADO') ),
                            "uf" char(2) NOT NULL,
                            "cidade" varchar(100) NOT NULL,
                            "bairro" varchar(100) NOT NULL,
                            "rua" varchar(100) NOT NULL,
                            "cep" varchar(15) NOT NULL,
                            "numero" varchar(20) NOT NULL,
                            "complemento" varchar(100) NOT NULL,
                            "latitude" decimal(9,6),
                            "longitude" decimal(9,6),
                            "telefone" varchar(20) NOT NULL
);

CREATE TABLE "instituicao" (
                               "uuid" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                               "instituicao" varchar(150) NOT NULL,
                               "cnpj" char(14) UNIQUE,
                               "cpf" char(11) UNIQUE,
                               "uf" char(2) NOT NULL,
                               "cidade" varchar(100) NOT NULL,
                               "bairro" varchar(100) NOT NULL,
                               "rua" varchar(100) NOT NULL,
                               "numero" varchar(20) NOT NULL,
                               "complemento" varchar(100) NOT NULL,
                               "latitude" decimal(9,6),
                               "longitude" decimal(9,6)
);

CREATE TABLE "oportunidade" (
                                "id" SERIAL PRIMARY KEY,
                                "id_instituicao" UUID NOT NULL,
                                "titulo" varchar(150) NOT NULL,
                                "descricao" varchar(255) NOT NULL,
                                "remoto" boolean NOT NULL,
                                "valor" numeric(12,2),
                                "tipo" varchar(20) NOT NULL
                                    CHECK ("tipo" IN ('bolsa', 'estagio', 'trabalho', 'pesquisa')),
                                "data_inicio" timestamp NOT NULL,
                                "data_fim" timestamp NOT NULL,
                                "turno" varchar(12) NOT NULL,
                                    CHECK ( "turno" IN ('integral','manha', 'tarde', 'noite') ),
                                "excluida" boolean NOT NULL DEFAULT false,
                                CONSTRAINT fk_instituicao FOREIGN KEY ("id_instituicao") REFERENCES "instituicao" ("uuid")
);

CREATE TABLE "inscricao" (
                             "uuid" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                             "id_inscrito" UUID NOT NULL,
                             "id_oportunidade" INT NOT NULL,
                             "data_inscricao" timestamp,
                             "status" varchar(50) not null check ( "status" IN ('pendente', 'aceita', 'recusada', 'cancelada') ) default 'pendente',
                             CONSTRAINT fk_inscrito FOREIGN KEY ("id_inscrito") REFERENCES "usuario" ("uuid"),
                             CONSTRAINT fk_oportunidade FOREIGN KEY ("id_oportunidade") REFERENCES "oportunidade" ("id")
);
