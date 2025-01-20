-- Проверка существования базы данных BookStore
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'BookStore')
BEGIN
    CREATE DATABASE BookStore;
    PRINT 'База данных BookStore создана.';
END
ELSE
BEGIN
    PRINT 'База данных BookStore уже существует.';
END;
GO

-- Использование базы данных BookStore
USE BookStore;
GO

-- Проверка существования таблицы Author
IF OBJECT_ID(N'dbo.Author', N'U') IS NULL
BEGIN
    CREATE TABLE Author (
        id INT PRIMARY KEY IDENTITY(1,1), -- IDENTITY(1,1) автоматически увеличивает значение ID
        name NVARCHAR(100) NOT NULL, -- Имя автора, обязательное поле
        birth_date DATE NULL -- Дата рождения автора, может быть NULL
    );
    PRINT 'Таблица Author создана.';
END
ELSE
BEGIN
    PRINT 'Таблица Author уже существует.';
END;
GO

-- Проверка существования таблицы Book
IF OBJECT_ID(N'dbo.Book', N'U') IS NULL
BEGIN
    CREATE TABLE Book (
        id INT PRIMARY KEY IDENTITY(1,1), -- IDENTITY(1,1) автоматически увеличивает значение ID
        title NVARCHAR(200) NOT NULL, -- Название книги, обязательное поле
        publication_year INT NOT NULL, -- Год публикации книги, обязательное поле
        author_id INT NOT NULL, -- Внешний ключ для связи с таблицей Author
        CONSTRAINT FK_Book_Author FOREIGN KEY (author_id) REFERENCES Author(id) -- Указание внешнего ключа
    );
    PRINT 'Таблица Book создана.';
END
ELSE
BEGIN
    PRINT 'Таблица Book уже существует.';
END;
GO
