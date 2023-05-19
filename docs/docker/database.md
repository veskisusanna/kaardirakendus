# Postgres database on Docker

## psql commands
```postgresql
psql -U [username]; -- Access the PostgreSQL server from psql with a specific user
\c database_name; -- Connect to a specific database
\q -- Quit the psql
\l -- List all databases
\dn -- List all schemas
\dt -- List all tables in the current database
\du -- List all uses with roles
\d+ 'avalikud_tegelased'; -- More information about specific table (same as DESCRIBE TABLE) 
--
show search_path; -- Show all schemas
SET search_path TO [desired_schema]; -- Change schema
--
SELECT
    table_name,
    column_name,
    data_type
FROM
    information_schema.columns
WHERE
    table_name = 'avalikud_tegelased';
-- List all the information about table_name, column_name and data_type

SELECT * FROM information_schema.columns 
    WHERE table_name = 'avalikud_tegelased';
-- Lists all the possible information attributes about the table
```