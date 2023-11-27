CREATE TABLE Usuario (
    ID_Usuario INT AUTO_INCREMENT PRIMARY KEY,
    ADM BIT DEFAULT 0,
    Nome_Usuario VARCHAR(255) PRIMARY KEY,
    Senha VARCHAR(50) NOT NULL,
    Telefone FLOAT DEFAULT NULL
    Email VARCHAR(45) NOT NULL,
);

CREATE TABLE Livro (
    Nome VARCHAR(255) PRIMARY KEY,
    Nome_Genero VARCHAR(50) NOT NULL,
    Nota_Media FLOAT DEFAULT NULL
    Nome_Autor VARCHAR(45) NOT NULL,
);

CREATE TABLE Avaliacao (
    ID_Avaliacao INT AUTO_INCREMENT PRIMARY KEY,
    Nota FLOAT NOT NULL,
    ID_Usuario INT NOT NULL,
    Nome_Livro VARCHAR(255) NOT NULL,
    FOREIGN KEY (Nome_Livro) REFERENCES Livro(Nome),
    FOREIGN KEY (ID_Usuario) REFERENCES usuario(ID_Usuario)
);

DELIMITER //

CREATE TRIGGER atualizar_media_nota
AFTER INSERT ON Avaliacao
FOR EACH ROW
BEGIN
    DECLARE media FLOAT;
    
    SELECT AVG(Nota)
    INTO media
    FROM Avaliacao
    WHERE Nome_Livro = NEW.Nome_Livro;
    
    UPDATE Livro
    SET Nota_Media = media
    WHERE Nome = NEW.Nome_Livro;
END //

DELIMITER ;