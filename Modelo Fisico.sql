-- Tabela Usuário
CREATE TABLE Usuario (
    ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
    ADM BOOLEAN DEFAULT FALSE,
    Email VARCHAR(255) NOT NULL,
    Telefone VARCHAR(255) NOT NULL,
    Nome_Usuario VARCHAR(255) NOT NULL,
    UNIQUE (Nome_Usuario)
);

-- Tabela Genero
CREATE TABLE Genero (
    Nome VARCHAR(255) PRIMARY KEY
);

-- Tabela Autor
CREATE TABLE Autor (
    ID_Autor INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    Data_Nascimento DATE,
    Data_Falecimento DATE
);

-- Tabela Editora
CREATE TABLE Editora (
    ID_Editora INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    Data_Abertura DATE,
    Data_Fechamento DATE
);

-- Tabela Avaliacao
CREATE TABLE Avaliacao (
    ID_Avaliacao INT PRIMARY KEY AUTO_INCREMENT,
    Nota DOUBLE NOT NULL,
    ID_Livro INT NOT NULL,
    ID_Usuario INT NOT NULL,
    FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Tabela Livro
CREATE TABLE Livro (
    ID_Livro INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    Data_Lancamento DATE,
    Nota_Media DOUBLE,
    ID_Autor INT,
    ID_Editora INT,
    ID_Genero VARCHAR(255),
    FOREIGN KEY (ID_Autor) REFERENCES Autor(ID_Autor),
    FOREIGN KEY (ID_Editora) REFERENCES Editora(ID_Editora),
    FOREIGN KEY (ID_Genero) REFERENCES Genero(Nome)
);
