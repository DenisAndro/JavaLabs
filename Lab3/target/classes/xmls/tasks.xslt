<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    background-color: #E6F7FF;
                    color: #333;
                    margin: 0;
                    padding: 20px;
                    }
                    h1 {
                    color: #0077B6;
                    text-align: center;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                    background-color: #FFFFFF;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    }
                    th, td {
                    padding: 12px;
                    text-align: left;
                    border-bottom: 1px solid #ddd;
                    }
                    th {
                    background-color: #0077B6;
                    color: white;
                    }
                    tr:hover {
                    background-color: #f1f1f1;
                    }
                    .no-data {
                    text-align: center;
                    color: #777;
                    padding: 20px;
                    }
                </style>
            </head>
            <body>
                <h1>Задачи</h1>
                <xsl:choose>
                    <xsl:when test="tasks/task">
                        <table>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Заголовок</th>
                                    <th>Описание</th>
                                    <th>Статус</th>
                                    <th>ID Проекта</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="tasks/task">
                                    <tr>
                                        <td><xsl:value-of select="@id"/></td>
                                        <td><xsl:value-of select="@title"/></td>
                                        <td><xsl:value-of select="@description"/></td>
                                        <td><xsl:value-of select="@status"/></td>
                                        <td><xsl:value-of select="@projectID"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </table>
                    </xsl:when>
                    <xsl:otherwise>
                        <div class="no-data">Нет данных о задачах.</div>
                    </xsl:otherwise>
                </xsl:choose>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>