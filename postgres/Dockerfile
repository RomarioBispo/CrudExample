FROM postgres:alpine

ADD /postgres/scripts/db/1-dump.sql /docker-entrypoint-initdb.d
ADD /postgres/scripts/db/2-data.sql /docker-entrypoint-initdb.d

RUN chmod a+r /docker-entrypoint-initdb.d/*