-- �������� ������������� ���� ������ BookStore
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'BookStore')
BEGIN
    CREATE DATABASE BookStore;
    PRINT '���� ������ BookStore �������.';
END
ELSE
BEGIN
    PRINT '���� ������ BookStore ��� ����������.';
END;
GO

-- ������������� ���� ������ BookStore
USE BookStore;
GO

-- �������� ������������� ������� Author
IF OBJECT_ID(N'dbo.Author', N'U') IS NULL
BEGIN
    CREATE TABLE Author (
        id INT PRIMARY KEY IDENTITY(1,1), -- IDENTITY(1,1) ������������� ����������� �������� ID
        name NVARCHAR(100) NOT NULL, -- ��� ������, ������������ ����
        birth_date DATE NULL -- ���� �������� ������, ����� ���� NULL
    );
    PRINT '������� Author �������.';
END
ELSE
BEGIN
    PRINT '������� Author ��� ����������.';
END;
GO

-- �������� ������������� ������� Book
IF OBJECT_ID(N'dbo.Book', N'U') IS NULL
BEGIN
    CREATE TABLE Book (
        id INT PRIMARY KEY IDENTITY(1,1), -- IDENTITY(1,1) ������������� ����������� �������� ID
        title NVARCHAR(200) NOT NULL, -- �������� �����, ������������ ����
        publication_year INT NOT NULL, -- ��� ���������� �����, ������������ ����
        author_id INT NOT NULL, -- ������� ���� ��� ����� � �������� Author
        CONSTRAINT FK_Book_Author FOREIGN KEY (author_id) REFERENCES Author(id) -- �������� �������� �����
    );
    PRINT '������� Book �������.';
END
ELSE
BEGIN
    PRINT '������� Book ��� ����������.';
END;
GO
