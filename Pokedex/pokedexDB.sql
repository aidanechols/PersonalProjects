CREATE TABLE pokedex (
 pnpk int NOT NULL,
 pokedex_number	int NOT NULL,
 name varchar(50) NOT NULL,
 form varchar(50),
 Species varchar(50),
 generation	int,
 status	varchar(50),
 type_1	varchar(50) NOT NULL,
 type_2	varchar(50),
 height_m float,
 weight_kg float,
 ability_1 varchar(50),
 ability_2 varchar(50),
 ability_hidden	varchar(50),
 total_points int,
 hp int,
 attack int,
 defense int,
 sp_attack int,
 sp_defense int,
 speed int,
 FRLG int,
 LGPE int,
 HGSS int,
 ORAS int, 
 Platinum int,
 B2W2 int,
 XY_Central int,
 XY_Coastal int,
 XY_Mountain int,
 USUM int,
 Melemele int,
 Akala int,
 Ulaula int,
 Poni int,
 SWSH int, 
 IOA int, 
 CT int,
 LA	int,
 SV int
 PRIMARY KEY (pnpk)
);

BULK INSERT pokedex
    FROM 'C:\Documents\pokedex.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ',',  --CSV field delimiter
    ROWTERMINATOR = '\n',   --Use to shift the control to next row
    ERRORFILE = 'C:\Documents\PokemonErrorRows.csv',
    TABLOCK
    )
