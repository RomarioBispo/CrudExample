-- CreateTable
CREATE TABLE IF NOT EXISTS person (
                                     "id" TEXT NOT NULL,
                                     "name" TEXT NOT NULL,
                                     "birthdate" DATE NOT NULL,
                                     "cpf" TEXT NOT NULL,
                                     "email" TEXT,
                                     PRIMARY KEY ("id")
    );