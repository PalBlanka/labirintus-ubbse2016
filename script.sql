CREATE TABLE Felhasznalo(
	ID INT PRIMARY KEY,
	Name VARCHAR(30),
	PassW VARCHAR(15),
	Level VARCHAR(10) CHECK (Level in ('beginner', 'advanced', 'professional'))
)

CREATE TABLE Statisztika(
	S_ID INT PRIMARY KEY,
	ID INT REFERENCES Felhasznalo(ID),
	BestTime TIME
)
