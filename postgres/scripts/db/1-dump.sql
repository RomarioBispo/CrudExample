-- CreateTable
CREATE TABLE IF NOT EXISTS person (
                                     "id" TEXT NOT NULL,
                                     "name" TEXT NOT NULL,
                                     "birth_date" DATE NOT NULL,
                                     "cpf" TEXT NOT NULL,
                                     "email" TEXT,
                                     PRIMARY KEY ("id")
    );


-- CreateTable
CREATE TABLE IF NOT EXISTS idempotency_keys (
                                                "key" TEXT NOT NULL,
                                                "endpoint" TEXT NOT NULL,
                                                "created_at" DATE NOT NULL,
                                                "request_hash" TEXT NOT NULL
);