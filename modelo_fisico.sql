CREATE DATABASE bookcheck;
USE bookcheck;
CREATE TABLE Usuario (
    ID_Usuario INT AUTO_INCREMENT PRIMARY KEY,
    ADM BOOLEAN DEFAULT 0,
    Nome_Usuario VARCHAR(255) UNIQUE NOT NULL,
    Senha VARCHAR(50) NOT NULL,
    Genero VARCHAR(20) NULL,
    Idade VARCHAR(3) NOT NULL
);

CREATE TABLE Livro (
    ID_Livro INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255) UNIQUE NOT NULL,
    Nome_Genero VARCHAR(50) NOT NULL,
    Nota_Media FLOAT DEFAULT NULL,
    Nome_Autor VARCHAR(45) NOT NULL
);

CREATE TABLE Avaliacao (
    ID_Avaliacao INT AUTO_INCREMENT PRIMARY KEY,
    Nota FLOAT NOT NULL,
    ID_Usuario INT NOT NULL,
    ID_Livro INT NOT NULL,
    FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro),
    FOREIGN KEY (ID_Usuario) REFERENCES usuario(ID_Usuario),
    UNIQUE KEY unique_avaliacao (ID_Usuario, ID_Livro)
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
    WHERE ID_Livro = NEW.ID_Livro;
    
    UPDATE Livro
    SET Nota_Media = media
    WHERE ID_Livro = NEW.ID_Livro;
END //

DELIMITER ;


