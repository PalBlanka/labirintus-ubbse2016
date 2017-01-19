
 drop table Felhasznalo;

CREATE TABLE Felhasznalo(
	Nev VARCHAR(30) PRIMARY KEy,
	Jelszo VARCHAR(15),
	Szint VARCHAR(10) CHECK (Szint in ('beginner', 'advanced', 'professional'))
)

drop table Mail;
CREATE TABLE Mail(
	Cim VARCHAR(50) PRIMARY KEY
)
drop table Maile;
 CREATE TABLE Maile(
	Nev VARCHAR(30) FOREIGN KEY REFERENCES Felhasznalo(Nev),
	Cim VARCHAR(50) FOREIGN KEY REFERENCES Mail(Cim),
 )

 